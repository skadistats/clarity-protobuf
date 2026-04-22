# CLAUDE.md — clarity-protobuf

Wire-protocol definitions consumed by `clarity`. Published to Maven
Central as `com.skadistats:clarity-protobuf`.

## Build
```bash
./gradlew build
./gradlew publishToMavenLocal
```

Java **21** toolchain. Only runtime dep: `fastutil-core`.

## What's in here
- `src/main/proto/`   — proto sources, hand-maintained (see Proto sync below)
- `src/main/java/`    — **generated** Java classes, **checked in**.
  Regenerate via `src/main/proto/make.sh`.
- `src/main/java/com/google/protobuf/` — vendored protobuf-2.x runtime,
  also checked in. Not a typo: we're deliberately on proto2, invoked
  through `/opt/protobuf2/bin/protoc`, because Valve's wire format
  relies on proto2 semantics.
- `tools/proto-sync/` — Python tool + RUNBOOK.md for syncing against
  SteamDatabase/Protobufs upstream.

## Proto layout
Build graph declared in `src/main/proto/build.json`:
```
shared/common  ← everything
shared/demo    ← shared/common
shared/s1      ← shared/common
shared/s2      ← shared/common + shared/demo
{csgo,dota}/common ← shared/{common,demo}
{csgo,dota}/s1     ← shared/{common,demo,s1} + game/common
{csgo,dota}/s2     ← shared/{common,demo,s2} + game/common
deadlock           ← shared/{common,demo,s2}
```
Source-1-only content under `s1/`, Source-2-only under `s2/`. Don't
cross the streams.

## Sync / update discipline
See `tools/proto-sync/RUNBOOK.md` for the full flow. Core
rules that bite if ignored:

- **Additive, never subtractive.** When upstream removes a field,
  message, or enum value, we keep it — old replays still reference it.
  Reports mark these `REMOVED upstream, RETAIN`.
- **Exception: `_deprecated` rename.** If upstream renames `foo` →
  `foo_deprecated` and adds a new `foo` with a different number/type,
  mirror the rename here — proto2 forbids duplicate field names.
- **Only update what we already have.** New messages/enums only land
  if they're referenced by a newly added field we care about.
- `EmbeddedPackets.java` / `DemoPackets.java` entries kept numerically
  sorted.

## OpenSpec
If an OpenSpec change touches this repo, its artifacts belong here — not
in `clarity` or `clarity-examples`. Create or initialize `openspec/` here
if needed.

## Upstream
Consumer: `/home/spheenik/projects/clarity/clarity`. Any proto change
here needs a rebuild + smoke test there before publishing.
