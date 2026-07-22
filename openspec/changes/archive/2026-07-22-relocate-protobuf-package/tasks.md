## 1. Baseline capture

- [x] 1.1 Record the pre-change reference: extract the embedded descriptor string literals from all generated sources under `src/main/java/skadistats/clarity/wire/` to a file for later byte-comparison — 42 descriptorData blocks / 53 files, sha256 `12b4f55a99dead30551623c37bdb4237e84461288bbaa18ffa752880346f7696`
- [x] 1.2 Parse a full-size replay with a stable example and save the output as the behavioural baseline (not `dueling.dem`; use a full-size replay) — `propertychange` on `dota/s2/340/8168882574_1198277651.dem`, 2151 signal lines, sha256 `a51b355b50b33ec3a2fd92fa34daf86ac4df63aecac96e2577a913aef86c812c`
- [x] 1.3 Confirm the working trees of `clarity-protobuf`, `clarity`, `clarity-examples`, and `odota-parser` (`clarity-5.0.0`) are clean, so the mechanical diff is reviewable

## 2. Relocate the runtime in clarity-protobuf

- [x] 2.1 `git mv src/main/java/com/google/protobuf src/main/java/skadistats/clarity/protobuf` and commit the move alone, so history follows the files — 50 files staged as renames (R), empty `com/` tree removed
- [x] 2.2 Rewrite `package com.google.protobuf;` → `package skadistats.clarity.protobuf;` in the 50 relocated runtime files
- [x] 2.3 Rewrite the qualified prefix `com.google.protobuf.` → `skadistats.clarity.protobuf.` across the 53 generated files under `skadistats/clarity/wire/`
- [x] 2.4 Rewrite the same qualified prefix in the three hand-written files `skadistats/clarity/wire/{Packet,ClassToKindMessageRegistry,KindToClassMessageRegistry}.java`
- [x] 2.5 Update `module-info.java`: `exports com.google.protobuf;` → `exports skadistats.clarity.protobuf;`
- [x] 2.6 Keep tasks 2.2–2.5 in a single mechanical commit, separate from 2.1 and from section 3 — SUPERSEDED: user chose to commit the whole relocation as one commit (de5c477: git mv + rewrites + make.sh + module-info + openspec). Cohesive and reviewable; the CRLF normalization was split into its own later commit

## 3. Make the relocation durable

- [x] 3.1 Append the rewrite step to `src/main/proto/make.sh` after the generation loop, scoped to `../java/skadistats`, replacing `com.google.protobuf.` → `skadistats.clarity.protobuf.`
- [x] 3.2 Verify idempotence: run the rewrite step twice and confirm the second run changes no file — confirmed on the wire tree, second pass no-op
- [x] 3.3 Verify regeneration: run `make.sh`, confirm zero `com.google.protobuf` references remain and the tree still compiles — validated by command-equivalence (reverse-substitute → run exact make.sh sed → byte-identical to current tree); full protoc regen deferred as separate maintenance to avoid unrelated build-tool diffs

## 4. Verify clarity-protobuf

- [x] 4.1 `./gradlew build` succeeds — BUILD SUCCESSFUL (javadoc warnings only, expected)
- [x] 4.2 Grep the whole repository for `com.google.protobuf` and confirm zero matches — 0 in `src/`; only the openspec change docs mention it (expected)
- [x] 4.3 Inspect the built jar: all runtime classes under `skadistats/clarity/protobuf/`, no entries under `com/google/protobuf/` — 0 google entries, 270 relocated, 3050 wire
- [x] 4.4 Compare the descriptor literals against the 1.1 baseline and confirm they are byte-identical — sha256 `12b4f55a…` MATCH ✓
- [x] 4.5 Confirm the set of `skadistats.clarity.wire.*` class names is unchanged from the previous build — 53 wire files all Modified, 0 added/deleted/renamed
- [x] 4.6 `./gradlew publishToMavenLocal` — clarity-protobuf-7.0-SNAPSHOT published to ~/.m2

## 5. Update clarity

- [x] 5.1 Rewrite the runtime references across the 42 affected files (`ByteString`, `GeneratedMessage`, `ZeroCopy`, `CodedInputStream`, `InvalidProtocolBufferException`) — 42 files, 55 replacements
- [x] 5.2 `./gradlew build` succeeds — BUILD SUCCESSFUL incl. tests
- [x] 5.3 Grep for `com.google.protobuf` and confirm zero matches — 0
- [x] 5.4 Parse the same replay as 1.2 and confirm the output matches the baseline exactly — 2151 signal lines, sha256 `a51b355b…` IDENTICAL ✓ (run after 6.1 since the check goes through the examples module)

## 6. Update remaining consumers

- [x] 6.1 Rewrite the 11 affected files in `clarity-examples` (import lines only) and build — 11 files, 14 replacements; examples build + propertychange run clean
- [x] 6.2 Rewrite `src/main/java/opendota/Parse.java` on the `clarity-5.0.0` branch of `odota-parser` — the import, the `onMessage` signature, and the commented-out `@OnMessage` annotation — and build — 1 FQN replaced (import); `mvn compile` BUILD SUCCESS. No pom change needed: jitpack clarity + clarity-protobuf 5.4 pin are both commented out; clarity 5.0.0-SNAPSHOT transitively pulls relocated clarity-protobuf 7.0-SNAPSHOT from mavenLocal
- [x] 6.3 Compile `clarity-analyzer` unchanged as a control; it must build with no edits (compile only, do not launch the GUI) — BUILD SUCCESSFUL via composite build, zero edits — control confirms message types never moved
- [x] 6.4 Grep all four consumer repositories for `com.google.protobuf` and confirm zero matches — clarity/examples/analyzer/odota all 0

## 7. Coexistence verification

- [x] 7.1 Build a scratch application that puts the relocated artifact and a stock `protobuf-java` on one classpath, exercising both a clarity parse and a stock protobuf message; confirm it runs with clarity first — exit 0; stock `ByteString$LiteralByteString` from protobuf-java-3.21.12 with working `hashCode()` + clarity parse `CDemoFileInfo serializedSize=741`, no IncompatibleClassChangeError
- [x] 7.2 Run the same application with `protobuf-java` first and confirm identical behaviour, proving independence from classpath order — exit 0; byte-identical output (same hash, same serializedSize) regardless of order
- [x] 7.3 Resolve both `com.skadistats.clarity.protobuf` and `com.google.protobuf` in one JPMS layer and confirm the boot layer initialises with no `LayerInstantiationException` — exit 0; minimal module requiring both protobuf modules ran; boot layer initialised, split-package failure gone

## 8. Release coordination and documentation

- [x] 8.1 Add the breaking entry to clarity's `CHANGELOG.md` under the 5.0 section: old→new package, the fact that `skadistats.clarity.wire.*` message types are unaffected, and the `UnsafeByteOperations.unsafeWrap(ZeroCopy.extract(bs))` interop line — added at top of Unreleased
- [x] 8.2 Update `clarity-protobuf/CLAUDE.md`, which currently describes the vendored runtime as living in `src/main/java/com/google/protobuf/` — updated to `skadistats/clarity/protobuf/` + make.sh rewrite note
- [x] 8.3 Publish snapshots in order: clarity-protobuf 7.0-SNAPSHOT first, then clarity 5.0.0-SNAPSHOT — both published via `publishAggregationToCentralSnapshots` (signed) to central.sonatype.com/repository/maven-snapshots/, protobuf first
- [x] 8.4 Clear or bypass Gradle's changing-module cache and re-run `clarity-bench` `v5.0.0`; confirm no `NoClassDefFoundError` from a stale snapshot pairing — `:v5.0.0:run --refresh-dependencies --list-replays`: detector 5.0.0-SNAPSHOT, 5 replays classified across DOTA_S1/S2, DEADLOCK, CS2 via the relocated protobuf runtime, no NoClassDefFoundError
- [x] 8.5 Confirm `clarity-bench` `v3.1.3` and `v4.0.1` still run, verifying that pinned older versions remain isolated — both BUILD SUCCESSFUL standalone, each loading its own released `com.google.protobuf` runtime; cross-version isolation intact

## 9. Resolve open questions

- [x] 9.1 Decide whether the descriptor byte-comparison becomes a permanent build guard or stays a one-off verification step — RESOLVED: descriptor-hash pin rejected (would break every legitimate proto sync). Implemented instead a package-presence invariant: Gradle `verifyRuntimeRelocated` task wired into `check` (fails if `com.google.protobuf` appears in `src/main/java`), plus a broad assert over `../java` in make.sh. Proven: passes clean, fails on injected offender. Also covers the descriptor.proto edge case (a google/protobuf proto compiled as a build target lands outside the rewrite scope and now fails loudly)
- [x] 9.2 Decide whether `odota-parser` is patched directly on `clarity-5.0.0` or at its next rebase — RESOLVED: patched directly on `clarity-5.0.0` (6.2), compiles clean
- [x] 9.3 Check whether `protobuf-java-format` is still used anywhere in the toolchain; if any tool passes clarity messages to a library typed on `com.google.protobuf.Message`, plan its treatment — RESOLVED: zero references across all six repos' build files and sources; the `~/.m2` copy is a stale unused artifact, no action needed
