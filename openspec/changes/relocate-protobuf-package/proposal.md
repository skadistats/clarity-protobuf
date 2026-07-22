## Why

`clarity-protobuf` ships its vendored protobuf runtime under `com.google.protobuf`, so any application that also uses stock `protobuf-java` cannot run: on the classpath the two jars silently interleave, and on the module path the JVM refuses to start. Clarity 5.0 / clarity-protobuf 7.0 are in development and already breaking, which makes this the last cheap opportunity to reclaim the namespace — deferring it spends a future major version on a mechanical rename.

The namespace was never ours to occupy, and there is nothing to defend by keeping it: the vendored runtime was diffed against the official `protobuf-java-2.6.1-sources.jar` and contains **zero functional patches**. Every non-comment difference is a javadoc fix for doclint. The only added file is `ZeroCopy.java` — 20 lines that exist solely to reach three package-private members of `ByteString`.

## What Changes

- **BREAKING** — the vendored protobuf runtime moves from `com.google.protobuf` to `skadistats.clarity.protobuf`. All 50 files, including `ZeroCopy`.
- **BREAKING** — `module-info.java` exports `skadistats.clarity.protobuf` instead of `com.google.protobuf`, removing the split package that makes clarity unusable on the module path.
- Generated message classes **do not move**. They stay in `skadistats.clarity.wire.*`; only their fully-qualified references to the runtime are rewritten.
- `src/main/proto/make.sh` gains a post-generation rewrite pass. protoc 2.x hardcodes the runtime package in its output and offers no flag to redirect it (`java_package` controls the generated code's own package, not the runtime's), so without this step every proto sync would silently revert the move.
- Consumers of `clarity` are updated in lockstep: `clarity`, `clarity-examples`, and the `clarity-5.0.0` branch of `odota-parser` rewrite their references.
- **Out of scope**: migrating to a modern protobuf-java runtime. That is a separate, larger effort gated on replacing `ZeroCopy.extract` on the `BitStream` hot path, where no public API avoids a copy. This change deliberately keeps the 2.6.1 runtime and only renames it.

## Capabilities

### New Capabilities

- `protobuf-runtime-packaging`: where the vendored protobuf runtime lives, which package the artifact claims and exports, the guarantee that it coexists with stock `protobuf-java` on both classpath and module path, and the invariant that regeneration preserves this.

### Modified Capabilities

None. This repository has no existing specs — `openspec/` was initialized as part of this change.

## Impact

**Behaviour**: none. A package rename over a runtime that is byte-identical to stock 2.6.1 changes no semantics. The `google.protobuf` names embedded in descriptor string literals are wire identity, not Java identity, and are untouched — verified that no string literal anywhere in the tree contains `com.google.protobuf`.

**Affected code**

| Repo | Scope |
|---|---|
| `clarity-protobuf` | 50 runtime files (package declarations), 53 generated files (qualified references), 3 hand-written `skadistats/clarity/wire/` files, `module-info.java`, `make.sh` |
| `clarity` | 42 files; 5 distinct symbols (`ByteString` ×27, `GeneratedMessage` ×16, `ZeroCopy` ×10, `CodedInputStream`, `InvalidProtocolBufferException`) |
| `clarity-examples` | 11 files, import lines only |
| `odota-parser` (`clarity-5.0.0` branch) | 1 file — `src/main/java/opendota/Parse.java`, 3 lines: the import, the `onMessage` signature, and a commented-out `@OnMessage` annotation |
| `clarity-analyzer` | none — verified zero references, both as imports and as bare identifiers, and zero calls to clarity APIs returning runtime types |
| `clarity-bench` | no source changes — 55 files, zero runtime references; consumes clarity only at the entity/state level. Affected by release ordering only (see below) |

**Downstream consumers**: the common shape — `@OnMessage` handlers with generated message types in the signature — is unaffected, because those types do not move. Breakage is limited to code touching the runtime directly: `StringTable.getValueByIndex`, the string-table entry callbacks, `BitStream.createBitStream`, `LZSS.unpack`, and the `PacketInstance` / `EngineType` generics. All are compiler-detected and fixed by rewriting an import. clarity-analyzer scoring zero suggests this population is small.

**Interop**: consumers bridging clarity bytes into stock protobuf 3.x use `UnsafeByteOperations.unsafeWrap(ZeroCopy.extract(bs))` — still zero-copy, and needed only at the boundary.

**Release coordination**: `clarity-protobuf` 7.0 and `clarity` 5.0 must ship together; clarity already pins `7.0-SNAPSHOT`. The rename belongs in the 5.0 migration notes alongside the existing `Entities` stream-API and `CSGO_S2` package renames, which already require consumers to edit imports.

`clarity-bench` needs no code edits but does not use the composite build — its `v5.0.0` subproject resolves `com.skadistats:clarity:5.0.0-SNAPSHOT` from `mavenLocal()` and the Sonatype snapshots repository with `isChanging = true`. Both artifacts must therefore be republished (clarity-protobuf first), and Gradle's changing-module cache has to be bypassed or expired. A stale cache pairing a rebuilt clarity with the pre-rename clarity-protobuf surfaces as `NoClassDefFoundError: com/google/protobuf/ByteString`, which is easy to misdiagnose as a bug in the rename itself. The `v3.1.3` and `v4.0.1` subprojects pin released versions, keep their own classpaths, and are unaffected — cross-version benchmarking continues to work because each version is isolated in its own Gradle subproject.

**Risk**: low and mechanical. The rewrite is a literal replace anchored on `com.google.protobuf`, idempotent by construction. Verification is a repo-wide grep expecting zero hits, a compile of all three repos plus clarity-analyzer, and a parse smoke test on a full-size replay.
