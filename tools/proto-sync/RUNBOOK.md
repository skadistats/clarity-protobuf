# Proto Sync Runbook

Instructions for updating the Clarity protobufs against SteamDatabase/Protobufs upstream.

## Prerequisites

- Local checkout of `clarity-protobuf`
- Python 3 installed
- `gh` CLI for the GitHub API (to read Issue #58)
- Upstream clone at `/tmp/SteamDatabase-Protobufs` (or it will be cloned automatically)

## Overview

```
┌──────────────────────────────────────────────────────────────────┐
│  1. Generate report (tool)                                       │
│  2. Review report                                                │
│  3. Add new enum values to message_id.proto                      │
│  4. Add new fields to existing messages                          │
│  5. Add nested messages (only if referenced by new fields)       │
│  6. Update EmbeddedPackets.java / DemoPackets.java               │
│  7. Check Issue #58 — activate reported IDs                      │
│  8. Compile protos (make.sh)                                     │
│ 9. Update _last_synced_commit in mapping.json                    │
│ 10. Test with replays                                            │
└──────────────────────────────────────────────────────────────────┘
```

## Ground rules

### Additive, never subtractive
If Valve removes a field, message, or enum value, we do **NOT** remove it on our side. Old replays may still contain these fields. The report marks such cases with `REMOVED upstream, RETAIN`.

**Exception: rename with `_deprecated`.** If upstream renames a field to `foo_deprecated` and adds a new field with the old name (but a different field number or type), the old field on our side must also be renamed to `_deprecated` (protobuf does not allow duplicate field names within a message). Example: `pre_damage = 2` → `pre_damage_deprecated = 2`, new `pre_damage = 27` as a float.

### Only update what we already have
- **Existing messages**: add new fields — yes
- **Existing enums**: add new values — yes
- **New messages/enums**: only add if referenced by a new field (e.g. nested messages like `CUserMsg_ParticleManager.AddFan`)
- **New top-level messages**: only add if needed for a replay mapping (see steps 6–7)

### Don't touch Source 1
The S1 files (`dota/s1/`, `csgo/s1/`, `shared/s1/`) are no longer updated. They're for old replays, and current upstream targets Source 2.

### Common vs. S2 directories
The `common/` folders (e.g. `dota/common/`) are compiled for both S1 and S2. **New S2-only content must NOT be placed in `common/`.** New messages/enums relevant only to S2 replays belong in the `s2/` folder (e.g. `dota/s2/`).

Proto compilation (`build.json`) defines the include paths:
- `dota/common` has no access to `dota/s2`
- `dota/s2` has access to `dota/common` and `shared/*`
- If a new S2 message references a type from `s2/`, the message itself must also live in `s2/`

When necessary, create a new `.proto` file in `s2/` (e.g. `dota/s2/dota_usermessages_s2.proto`). Proto files get:
- `option java_package = "skadistats.clarity.wire.<game>.s2.proto";`
- `option java_outer_classname = "<MeaningfulName>";`

**No message definitions in enum-only files** (e.g. not in `dota_shared_enums.proto` — only enums and the types they require belong there).

### GC messages: only update existing ones
Game Coordinator messages (`*gcmessages*`, `base_gcmessages`) don't get new messages. Only existing messages get new fields. These messages aren't part of the replay wire format; they're used for `infoForFile()` and metadata.

---

## Step 1: Generate report

```bash
cd /home/spheenik/projects/clarity/clarity-protobuf

# Clone upstream (one-time, or when stale)
git clone https://github.com/SteamDatabase/Protobufs.git /tmp/SteamDatabase-Protobufs
# Or update:
git -C /tmp/SteamDatabase-Protobufs pull

# Create baseline worktree (previous sync point for comparison)
LAST_COMMIT=$(python3 -c "import json; print(json.load(open('tools/proto-sync/mapping.json'))['_last_synced_commit'])")
git -C /tmp/SteamDatabase-Protobufs worktree add --detach /tmp/proto-sync-baseline $LAST_COMMIT

# Generate report
python3 tools/proto-sync/proto_sync.py \
  --upstream-dir /tmp/SteamDatabase-Protobufs \
  --baseline-dir /tmp/proto-sync-baseline \
  --output /tmp/proto-sync-report.txt

# Clean up
git -C /tmp/SteamDatabase-Protobufs worktree remove /tmp/proto-sync-baseline
```

### Report structure

The report has three sections:

1. **UPSTREAM STRUCTURAL CHANGES** — new/removed .proto files at Valve. For info only; usually no action needed.

2. **File Diffs** — per Clarity file:
   - `ENUM ... — new values:` → add to the Clarity file
   - `MESSAGE ... — new fields:` → add to the Clarity file
   - `MESSAGE ... — new nested message:` → add to the Clarity file (only if referenced by a new field)
   - `REMOVED upstream (KEEP!)` → don't touch, info only

3. **USER MESSAGE DEFINITIONS FOR NEW MESSAGE IDs** — for each new message ID, the full message definition from upstream. Reference material for steps 6–7.

---

## Step 2: Review report

Read the report and sanity-check it:
- Do the changes make sense?
- Are there conflicts with existing fields (same field number)?
- Do new fields reference types we don't have? (e.g. `optional .ETimerAlertType timer_alert_type` — if `ETimerAlertType` isn't defined on our side, either add it or adjust the field)
- **Check type resolution**: which types exist on which compilation path? (see `build.json` for the include structure). Look up missing types upstream and insert them in the right place.
- **Field-name conflicts**: if upstream renamed a field (e.g. `foo` → `foo_deprecated`) and added a new field with the old name, our old field must be renamed too.

---

## Step 3: Add new enum values to message_id.proto

Affects these files:
- `src/main/proto/dota/s2/message_id.proto`
- `src/main/proto/csgo/s2/message_id.proto`
- `src/main/proto/deadlock/message_id.proto`

Append new enum values at the end of the respective enum:

```protobuf
// Example: dota/s2/message_id.proto
enum EDotaUserMessages {
  // ... existing values ...
  DOTA_UM_RoshanTimer = 626;
  // NEW:
  DOTA_UM_NeutralCraftAvailable = 627;
  DOTA_UM_TimerAlert = 628;
  // ...
}
```

Also for `SVC_Messages`, `EBaseUserMessages`, etc. if new values show up there.

---

## Step 4: Add new fields to existing messages

For each `MESSAGE ... — new fields:` line in the report, add the new field to the corresponding Clarity file. Fields go at the end of the message, sorted by field number.

Watch out for fields referencing external types:
- `.CMsgVector` → lives in `shared/common/networkbasetypes-common.proto`, should already be imported
- Game-specific types (e.g. `.ETimerAlertType`) → check that the import exists and that the type is reachable on the compilation path. Options:
  1. Pull the missing enum/message from upstream and insert it **in the right place** (s2/ if S2-only!)
  2. Insert it as a generic type (`optional int32`) if we don't want to define the enum on our side

---

## Step 5: Add nested messages

When the report shows `new nested message:`, insert it inside the parent message. These are only shown when referenced by a new field.

Example: `CUserMsg_ParticleManager.AddFan` gets inserted as a nested message inside `CUserMsg_ParticleManager`.

---

## Step 6: Update EmbeddedPackets.java / DemoPackets.java

### EmbeddedPackets.java (embedded messages)

For **every new message ID**, add a **commented-out** line to the matching `EmbeddedPackets.java`.

**Important: keep the ordering!** New entries must be inserted in the correct numerical order, not appended at the end. Entries are sorted by message-ID number within their respective blocks (SVC with SVC, UM with UM, GE with GE). Slot new IDs in between existing ones.

```java
// New IDs — commented out until we've verified they appear in replays:
// /* 348 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_BossDamaged_VALUE, CitadelUserMessages.CCitadelUserMsg_BossDamaged.class);
// /* 349 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MidBossSpawned_VALUE, CitadelUserMessages.CCitadelUserMsg_MidBossSpawned.class);
```

Files:
- `src/main/java/skadistats/clarity/wire/dota/s2/EmbeddedPackets.java`
- `src/main/java/skadistats/clarity/wire/csgo/s2/EmbeddedPackets.java`
- `src/main/java/skadistats/clarity/wire/deadlock/proto/EmbeddedPackets.java`

### DemoPackets.java (top-level demo messages)

New `EDemoCommands` values (e.g. `DEM_Recovery`) also require updating:
- `src/main/java/skadistats/clarity/wire/shared/demo/DemoPackets.java`

The registry size in the constructor (`new KindToClassMessageRegistry(N)`) must match the current `DEM_Max` value. Activate new entries directly (not commented out) — demo commands always appear in the replay.

### Naming conventions for derived class names

| Enum prefix | Message prefix | Java class in |
|---|---|---|
| `DOTA_UM_Foo` | `CDOTAUserMsg_Foo` | `DOTAUserMessages.CDOTAUserMsg_Foo` |
| `DOTA_EM_Foo` | `CDOTAEntityMsg_Foo` | `DOTAUserMessages.CDOTAEntityMsg_Foo` |
| `CS_UM_Foo` | `CCSUsrMsg_Foo` | `CSGOCommonUserMessages.CCSUsrMsg_Foo` |
| `k_EUserMsg_Foo` | `CCitadelUserMsg_Foo` | `CitadelUserMessages.CCitadelUserMsg_Foo` |
| `k_EEntityMsg_Foo` | `CCitadelEntityMsg_Foo` | `CitadelUserMessages.CCitadelEntityMsg_Foo` |
| `UM_Foo` | `CUserMessage_Foo` | `S2UserMessages.CUserMessage_Foo` |
| `EM_Foo` | `CEntityMessage_Foo` | `S2UserMessages.CEntityMessage_Foo` |
| `svc_Foo` | `CSVCMsg_Foo` | `CommonNetMessages.CSVCMsg_Foo` |
| `DEM_Foo` | `CDemoFoo` | `Demo.CDemoFoo` |

**Watch out:** if new S2-only messages were placed in their own `.proto` file under `s2/` (e.g. `dota_usermessages_s2.proto` → `DOTAS2UserMessages`), then the EmbeddedPackets class references the corresponding Java outer-classname, **not** the `common` class.

### When no message definition is found upstream
Some IDs have no proto definition (internal events and similar). These get `null`:
```java
// /* 355 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MeleeHit_VALUE, null);
```

---

## Step 7: Check Issue #58 — activate reported IDs

GitHub Issue: https://github.com/skadistats/clarity/issues/58

Users report unknown message types there in the format:
```
unknown embedded message of kind DOTA_S2/635
unknown top level message of kind CSGO_S2/18
```

For every ID reported there:

1. **Enum value** must exist in `message_id.proto` (should be the case after Step 3)
2. **Activate the EmbeddedPackets.java line** (remove the comment) — for embedded messages
3. **Add the DemoPackets.java line** — for top-level messages (`unknown top level message`)
4. **Add the proto message**: take the message definition from the report section "USER MESSAGE DEFINITIONS" and insert it into the appropriate `.proto` file (in the right place: common vs. s2!)
5. If the message is mapped to `null` (no proto needed), just activate the EmbeddedPackets line with `null`

---

## Step 8: Compile protos

```bash
cd src/main/proto
./make.sh
```

This generates the Java classes from the .proto files. Afterward, check that the build passes:

```bash
cd /home/spheenik/projects/clarity/clarity-protobuf
./gradlew build
```

---

## Step 9: Update _last_synced_commit

Write the current HEAD commit of SteamDatabase/Protobufs into `mapping.json`:

```bash
NEW_COMMIT=$(git -C /tmp/SteamDatabase-Protobufs rev-parse HEAD)
# In mapping.json, set the value of _last_synced_commit to $NEW_COMMIT
```

---

## Step 10: Test

Test with several replays (from `clarity-examples`):
```bash
./gradlew allchatRun --args "/home/spheenik/projects/replays/deadlock/newer/<replay>.dem" 2>&1 | grep -i "unknown"
./gradlew allchatRun --args "/home/spheenik/projects/replays/dota/client/<replay>.dem" 2>&1 | grep -i "unknown"
./gradlew allchatRun --args "/home/spheenik/projects/replays/cs2/350/<replay>.dem" 2>&1 | grep -i "unknown"
```

Expectation: no more `unknown message` warnings for the IDs we just added.

If new `unknown embedded message` warnings appear for IDs we just added commented-out → uncomment (activate), rebuild, test again.

**Important:** don't use `replays/dueling.dem` — it's a special replay. Use full match replays.

---

## Troubleshooting

### Type reference doesn't resolve
If a new field references a type we don't define (e.g. `optional .ETimerAlertType foo = 1`), there are two options:
1. Insert the type as `optional int32 foo = 1` (loses enum semantics but works)
2. Pull the missing enum from upstream and add it — **in the right place** (common only if S1+S2-relevant, otherwise s2/)

### Type not on the compilation path
If `make.sh` reports `"Foo" is not defined`, check:
- Does the referenced type live in a directory listed in the compiling file's `build.json` include path?
- `dota/common` CANNOT access `dota/s2` — types from `s2/` cannot be referenced in `common/`
- Fix: move the referencing message to `s2/` as well, or move the type definition to `common/` (only if S1-compatible)

### Field-name conflict (duplicate name)
Protobuf does not allow two fields with the same name in a message. Happens when upstream renames a field and adds a new one under the old name. Fix: also rename the old field on our side (e.g. `foo` → `foo_deprecated`), and add the new field under the original name.

### Field-number conflict
Shouldn't happen — if it does, it's a sign that the mapping is wrong. Check the report and mapping.

### Report shows no changes
- Check that `_last_synced_commit` in `mapping.json` is correct
- Check that the upstream clone is up to date (`git pull`)
- Run with `--no-baseline` to see all differences
