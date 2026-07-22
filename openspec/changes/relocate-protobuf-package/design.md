## Context

`clarity-protobuf` vendors a copy of the protobuf 2.6.1 Java runtime under `com.google.protobuf`. Because that package name is also owned by the official `protobuf-java` artifact, the two cannot be used together:

- **Classpath**: the class sets only partially intersect. `ByteString` and `GeneratedMessage` exist in both jars; `LiteralByteString` and `BoundedByteString` are top-level in ours but nested inside `ByteString` in 3.x. So whichever `ByteString` loads first wins, while our top-level `LiteralByteString` always loads — and it declares an override of `peekCachedHashCode()`, which is `final` in modern `ByteString`. The result is `IncompatibleClassChangeError`. No classpath ordering fixes this: reversing it merely breaks the other side.
- **Module path**: JPMS rejects a package present in two modules in the same layer regardless of whether it is exported. Verified on JDK 21 with two modules that both *conceal* the shared package: `LayerInstantiationException: Package p in both module a and module b`. Encapsulation controls access, not identity, so hiding the package cannot help.

The vendored runtime was diffed against the official `protobuf-java-2.6.1-sources.jar`. Whitespace-insensitively, every non-comment difference is a javadoc fix for doclint (`<tt>`→`<code>`, `</br>`→`<br>`, malformed `@link`, an inverted `<ul>`/`<li>` in `TextFormat`). `DescriptorProtos` differs only in how the embedded descriptor literal is wrapped across source lines. There are **no functional patches**. The sole addition is `ZeroCopy.java`, 20 lines needing package-private access to the `LiteralByteString(byte[])` constructor, its `bytes` field, and `BoundedByteString(byte[],int,int)`.

Clarity 5.0 / clarity-protobuf 7.0 are in development on `next` and already carry breaking changes, including a package rename (`CSGO_S2`) and the `Entities` stream-API migration.

## Goals / Non-Goals

**Goals:**

- Free the `com.google.protobuf` namespace so clarity coexists with stock `protobuf-java` on both classpath and module path.
- Keep the change behaviour-preserving — Java package identity only.
- Land it inside the 5.0 / 7.0 breaking window so it costs consumers one migration, not two.
- Make the relocation durable against future proto regeneration.

**Non-Goals:**

- Migrating to a modern protobuf-java runtime. Out of scope; see Decisions.
- Changing the location of generated message classes. They stay in `skadistats.clarity.wire.*`.
- Changing proto sources, the build graph in `build.json`, or the proto-sync workflow.
- Providing a compatibility shim under the old package name.

## Decisions

### Relocate to `skadistats.clarity.protobuf`

Mirrors the JPMS module name `com.skadistats.clarity.protobuf` minus the `com.` prefix — the relationship clarity already uses (module `com.skadistats.clarity` ↔ packages `skadistats.clarity.*`). It sits as a sibling of `skadistats.clarity.wire`, giving the artifact a clean split: `wire` holds Valve's message definitions, `protobuf` holds the runtime they are built on.

Verified collision-free: clarity's module owns eleven subpackages under `skadistats.clarity` (`engine`, `event`, `io`, `logger`, `model`, `platform`, `processor`, `source`, `state`, `util`) plus `skadistats.clarity` itself, and none is named `protobuf` or `wire`. Sharing a package *prefix* across modules is legal — only exact package names collide — which is why `skadistats.clarity.wire` already coexists today.

*Alternatives considered.* `skadistats.clarity.wire.protobuf` nests the runtime under a name that currently means "Valve's wire-format definitions", mixing two concerns. `skadistats.protobuf` is shorter but diverges from both the module name and the artifact id. Names containing `internal`, `shaded`, or `repackaged` — the usual convention for vendored dependencies — were rejected because the package is genuinely exported API: `ByteString` appears in `StringTable.getValueByIndex`, `GeneratedMessage` in the `PacketInstance` and `EngineType` generics. Labelling it internal would misdescribe it and discourage the usage it requires. A version suffix such as `protobuf2` was rejected as self-obsoleting.

### Rename at source level, not via a shade relocation

The runtime is vendored as checked-in source, so it is renamed for real rather than rewritten at packaging time.

A shade relocation would leave the published **sources jar and javadoc** still saying `com.google.protobuf`, which is precisely misleading for the people debugging this class of problem, and would break IDE navigation. It would also add a plugin to solve a problem a rename solves outright. Since protoc's output must be post-processed regardless (below), shading buys nothing.

### Keep the protobuf 2.6.1 runtime; do not migrate to protobuf 3

Migration is feasible but is a separate project with its own risk profile, and coupling it here would turn a mechanical change into a benchmarked one.

Notably, proto2 is *not* the blocker: modern protoc fully supports `syntax = "proto2"`, so the pinned 2.6.1 **runtime** and the proto2 **syntax** are independent concerns that have been conflated. On the wrap side, `UnsafeByteOperations.unsafeWrap(byte[])` and `unsafeWrap(byte[],int,int)` are public in 3.x and are exact drop-ins for `ZeroCopy.wrap`/`wrapBounded`, covering most call sites. The real gap is the extract side: there is no public unwrap. Most `ZeroCopy.extract` sites have clean equivalents (`getData().newCodedInput()`, `asReadOnlyByteBuffer()`, Snappy's ByteBuffer overloads), but `BitStream.createBitStream` hands a raw `byte[]` to `ClarityPlatform.createBitStream`, and the only public route there is `toByteArray()`, which copies — on the hottest path in the parser.

Relocating first makes that migration easier later, not harder: once the runtime sits in our namespace, what backs it can change without moving anyone's imports again.

### Rewrite generated output in `make.sh`

protoc 2.x hardcodes the runtime package in its output and has no flag to redirect it — `java_package` sets the generated code's own package, not the runtime's. Without a post-generation step, the next proto sync would silently revert the relocation.

The step is appended after the generation loop in `src/main/proto/make.sh`, scoped to `../java/skadistats`, since the runtime tree is hand-vendored and not produced by protoc. It is idempotent by construction: after the first pass nothing matches, so re-running is a no-op.

### Rewrite by literal replace, anchored on the full package name

Generated code makes this unusually safe. protoc 2.x emits **no import statements at all** — every reference is fully qualified (1842 occurrences in `Demo.java` alone). So there is no import block to reorder and no ambiguity between simple and qualified names.

Two rules are needed. The recurring one, in `make.sh`, replaces the qualified prefix `com.google.protobuf.` (with trailing dot). The one-time migration additionally rewrites the bare `package com.google.protobuf;` declarations in the 50 runtime files.

Anchoring on `com.google.protobuf` cannot touch descriptor content: descriptor string literals use the *proto* package `google.protobuf`, without the `com.` prefix, and a search confirmed **zero** occurrences of `com.google.protobuf` inside any string literal in the tree.

### Verify by grep, descriptor comparison, and a parse smoke test

Three layers, cheapest first: a repo-wide grep expecting zero hits; a byte-comparison of the embedded descriptor literals before and after, which is the strongest available check that no wire-facing content moved; and a full-size replay parse compared against pre-change output. The descriptor comparison exists specifically because the "no behaviour change" claim otherwise rests on a grep.

## Risks / Trade-offs

- **Snapshot skew in `clarity-bench`** → `clarity-bench` needs no source edits but does not use the composite build: its `v5.0.0` subproject resolves `com.skadistats:clarity:5.0.0-SNAPSHOT` from `mavenLocal()` and the Sonatype snapshots repo with `isChanging = true`. A stale cache pairing a rebuilt clarity with a pre-rename clarity-protobuf surfaces as `NoClassDefFoundError: com/google/protobuf/ByteString`, easily misread as a bug in the rename. Mitigation: publish clarity-protobuf first, then clarity, and expire or bypass Gradle's changing-module cache before benchmarking.

- **A future proto sync silently reverts the relocation** → mitigated by the `make.sh` step plus the spec requirement asserting zero `com.google.protobuf` references after regeneration.

- **Over-broad rewrite corrupts descriptors** → mitigated by anchoring on the full package name, by the verified absence of the string in any literal, and by the descriptor byte-comparison in verification.

- **Large mechanical diff obscures review and pollutes blame** → mitigated by using `git mv` for the directory move and keeping the mechanical rewrite in its own commit, separate from the `make.sh` and `module-info` edits.

- **Downstream breakage for third parties** → real but narrow, and compiler-detected. The `@OnMessage`-with-generated-types majority is unaffected since message classes do not move; clarity-analyzer references the runtime zero times. Mitigation: migration notes covering the old→new package, the fact that `skadistats.clarity.wire.*` is unchanged, and the interop line `UnsafeByteOperations.unsafeWrap(ZeroCopy.extract(bs))` for bridging to stock protobuf.

- **No deprecation period is possible** → a package cannot be relocated gradually, and shipping a shim under `com.google.protobuf` would reintroduce the split package this change exists to remove. Accepted: the break is taken cleanly inside the 5.0 window.

## Migration Plan

1. Relocate in `clarity-protobuf`: `git mv` the runtime directory, apply both rewrite rules, update `module-info.java`, update the three hand-written `skadistats/clarity/wire/` files, add the `make.sh` step. Build.
2. Verify: grep for zero hits, compare descriptor literals against the pre-change tree, `publishToMavenLocal`.
3. Update `clarity` (42 files), build, parse a full-size replay, diff output against a pre-change run.
4. Update `clarity-examples` (11 files) and the `clarity-5.0.0` branch of `odota-parser` (1 file). Compile `clarity-analyzer` unchanged as a control.
5. Record the break in clarity's CHANGELOG under the 5.0 breaking section, alongside the existing `Entities` and `CSGO_S2` entries.
6. Republish snapshots in order — clarity-protobuf, then clarity — and re-run `clarity-bench` with a cleared changing-module cache.

**Rollback**: nothing is released, only snapshots. Reverting the mechanical commits in each repo restores the previous state; the `git mv` keeps history intact.

## Open Questions

- Should the descriptor byte-comparison be a one-off verification step or a permanent guard in the build? A permanent check would also catch accidental descriptor drift from future proto syncs, which is a broader benefit than this change needs.
- Does the `clarity-5.0.0` branch of `odota-parser` get the edit directly, or does it wait until that branch is next rebased on clarity 5.0?
- Is `protobuf-java-format` (seen in the local Maven repository) still used anywhere in the toolchain? If any tool feeds clarity messages to a third-party library typed on `com.google.protobuf.Message`, that library needs the same treatment.
