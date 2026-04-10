# Proto Sync Runbook

Arbeitsanweisung für das Aktualisieren der Clarity-Protobufs gegen SteamDatabase/Protobufs upstream.

## Voraussetzungen

- Lokaler Checkout von `clarity-protobuf`
- Python 3 installiert
- `gh` CLI für GitHub API (Issue #58 lesen)
- Upstream-Klon unter `/tmp/SteamDatabase-Protobufs` (oder wird automatisch geklont)

## Übersicht

```
┌──────────────────────────────────────────────────────────────────┐
│  1. Report generieren (Tool)                                     │
│  2. Report reviewen                                              │
│  3. Neue Enum-Werte in message_id.proto eintragen                │
│  4. Neue Felder in bestehende Messages einfügen                  │
│  5. Nested Messages hinzufügen (nur wenn von neuen Feldern       │
│     referenziert)                                                │
│  6. EmbeddedPackets.java / DemoPackets.java aktualisieren        │
│  7. Issue #58 prüfen — gemeldete IDs aktivieren                  │
│  8. Proto-Kompilierung (make.sh)                                 │
│  9. _last_synced_commit in mapping.json aktualisieren            │
│ 10. Testen mit Replays                                           │
└──────────────────────────────────────────────────────────────────┘
```

## Grundregeln

### Additiv, nie subtraktiv
Wenn Valve ein Feld, eine Message oder einen Enum-Wert entfernt, wird dieser bei uns **NICHT** entfernt. Alte Replays können diese Felder noch enthalten. Der Report markiert solche Fälle mit `REMOVED upstream, RETAIN`.

**Ausnahme: Umbenennung mit `_deprecated`**. Wenn upstream ein Feld in `foo_deprecated` umbenannt wird und ein neues Feld mit dem alten Namen (aber anderer Feldnummer/Typ) hinzukommt, muss das alte Feld ebenfalls in `_deprecated` umbenannt werden (Protobuf erlaubt keine doppelten Feldnamen in einer Message). Beispiel: `pre_damage = 2` → `pre_damage_deprecated = 2`, neues `pre_damage = 27` als float.

### Nur updaten was wir haben
- **Bestehende Messages**: neue Felder hinzufügen — ja
- **Bestehende Enums**: neue Werte hinzufügen — ja
- **Neue Messages/Enums**: nur hinzufügen wenn sie von einem neuen Feld referenziert werden (z.B. nested Messages wie `CUserMsg_ParticleManager.AddFan`)
- **Neue top-level Messages**: nur hinzufügen wenn sie für ein Replay-Mapping benötigt werden (siehe Schritt 6-7)

### Source 1 nicht anfassen
Die S1-Dateien (`dota/s1/`, `csgo/s1/`, `shared/s1/`) werden nicht mehr aktualisiert. Sie sind für alte Replays und der aktuelle Upstream bezieht sich auf Source 2.

### Common vs. S2 Verzeichnisse
Die `common/`-Ordner (z.B. `dota/common/`) werden sowohl für S1 als auch S2 kompiliert. **Neue S2-only Inhalte dürfen NICHT in `common/` abgelegt werden.** Neue Messages/Enums die nur für S2-Replays relevant sind, gehören in den `s2/`-Ordner (z.B. `dota/s2/`).

Die Proto-Kompilierung (`build.json`) definiert die Include-Pfade:
- `dota/common` hat keinen Zugriff auf `dota/s2`
- `dota/s2` hat Zugriff auf `dota/common` und `shared/*`
- Wenn eine neue S2-Message einen Typ aus `s2/` referenziert, muss die Message selbst auch in `s2/` liegen

Wenn nötig, eine neue `.proto`-Datei in `s2/` erstellen (z.B. `dota/s2/dota_usermessages_s2.proto`). Proto-Dateien bekommen:
- `option java_package = "skadistats.clarity.wire.<game>.s2.proto";`
- `option java_outer_classname = "<SinnvollerName>";`

**Keine Message-Definitionen in Enum-only Dateien** (z.B. nicht in `dota_shared_enums.proto` — dort gehören nur Enums und die Typen die sie brauchen).

### GC-Messages: nur bestehende updaten
Game Coordinator Messages (`*gcmessages*`, `base_gcmessages`) bekommen keine neuen Messages. Nur bestehende Messages bekommen neue Felder. Diese Messages sind nicht im Replay-Wire-Format, sondern werden für `infoForFile()` und Metadata benötigt.

---

## Schritt 1: Report generieren

```bash
cd /home/spheenik/projects/clarity/clarity-protobuf

# Upstream klonen (einmalig oder wenn veraltet)
git clone https://github.com/SteamDatabase/Protobufs.git /tmp/SteamDatabase-Protobufs
# Oder updaten:
git -C /tmp/SteamDatabase-Protobufs pull

# Baseline-Worktree erstellen (alter Stand zum Vergleich)
LAST_COMMIT=$(python3 -c "import json; print(json.load(open('tools/proto-sync/mapping.json'))['_last_synced_commit'])")
git -C /tmp/SteamDatabase-Protobufs worktree add --detach /tmp/proto-sync-baseline $LAST_COMMIT

# Report generieren
python3 tools/proto-sync/proto_sync.py \
  --upstream-dir /tmp/SteamDatabase-Protobufs \
  --baseline-dir /tmp/proto-sync-baseline \
  --output /tmp/proto-sync-report.txt

# Aufräumen
git -C /tmp/SteamDatabase-Protobufs worktree remove /tmp/proto-sync-baseline
```

### Report-Aufbau

Der Report hat drei Abschnitte:

1. **UPSTREAM STRUCTURAL CHANGES** — neue/entfernte .proto Dateien bei Valve. Nur zur Info, normalerweise keine Aktion nötig.

2. **File Diffs** — pro Clarity-Datei:
   - `ENUM ... — new values:` → In die Clarity-Datei eintragen
   - `MESSAGE ... — new fields:` → In die Clarity-Datei eintragen
   - `MESSAGE ... — new nested message:` → In die Clarity-Datei eintragen (nur wenn von neuem Feld referenziert)
   - `REMOVED upstream (KEEP!)` → Nicht anfassen, nur zur Info

3. **USER MESSAGE DEFINITIONS FOR NEW MESSAGE IDs** — Für jede neue Message-ID die vollständige Message-Definition aus upstream. Referenzmaterial für Schritt 6-7.

---

## Schritt 2: Report reviewen

Den Report durchlesen und auf Plausibilität prüfen:
- Sind die Änderungen sinnvoll?
- Gibt es Konflikte mit bestehenden Feldern (gleiche Feldnummer)?
- Referenzieren neue Felder Typen die wir nicht haben? (z.B. `optional .ETimerAlertType timer_alert_type` — wenn `ETimerAlertType` nicht bei uns definiert ist, muss es entweder hinzugefügt oder das Feld angepasst werden)
- **Typ-Auflösung prüfen**: Welche Typen existieren in welchem Kompilierungs-Pfad? (siehe `build.json` für Include-Struktur). Fehlende Typen upstream nachschlagen und an der richtigen Stelle einfügen.
- **Feldnamen-Konflikte**: Wenn upstream ein Feld umbenannt hat (z.B. `foo` → `foo_deprecated`) und ein neues Feld mit dem alten Namen hinzukommt, muss unser altes Feld ebenfalls umbenannt werden.

---

## Schritt 3: Neue Enum-Werte in message_id.proto eintragen

Betrifft die Dateien:
- `src/main/proto/dota/s2/message_id.proto`
- `src/main/proto/csgo/s2/message_id.proto`
- `src/main/proto/deadlock/message_id.proto`

Neue Enum-Werte am Ende des jeweiligen Enums einfügen:

```protobuf
// Beispiel: dota/s2/message_id.proto
enum EDotaUserMessages {
  // ... bestehende Werte ...
  DOTA_UM_RoshanTimer = 626;
  // NEU:
  DOTA_UM_NeutralCraftAvailable = 627;
  DOTA_UM_TimerAlert = 628;
  // ...
}
```

Auch für `SVC_Messages`, `EBaseUserMessages` etc. wenn dort neue Werte stehen.

---

## Schritt 4: Neue Felder in bestehende Messages einfügen

Für jede `MESSAGE ... — new fields:` Zeile im Report das neue Feld in die entsprechende Clarity-Datei einfügen. Die Felder kommen ans Ende der Message, sortiert nach Feldnummer.

Achtung bei Feldern die externe Typen referenzieren:
- `.CMsgVector` → ist in `shared/common/networkbasetypes-common.proto`, sollte schon importiert sein
- Game-spezifische Typen (z.B. `.ETimerAlertType`) → prüfen ob der Import existiert und ob der Typ im Kompilierungs-Pfad erreichbar ist. Optionen:
  1. Den fehlenden Enum/Message aus upstream holen und **am richtigen Ort** einfügen (s2/ wenn S2-only!)
  2. Als generischen Typ (`optional int32`) einfügen wenn der Enum nicht bei uns definiert werden soll

---

## Schritt 5: Nested Messages hinzufügen

Wenn der Report `new nested message:` zeigt, diese innerhalb der Parent-Message einfügen. Diese werden nur gezeigt wenn sie von einem neuen Feld referenziert werden.

Beispiel: `CUserMsg_ParticleManager.AddFan` wird als nested message in `CUserMsg_ParticleManager` eingefügt.

---

## Schritt 6: EmbeddedPackets.java / DemoPackets.java aktualisieren

### EmbeddedPackets.java (embedded messages)

Für **jede neue Message-ID** eine **auskommentierte** Zeile in der passenden `EmbeddedPackets.java` hinzufügen.

**Wichtig: Sortierung einhalten!** Neue Einträge müssen in der richtigen numerischen Reihenfolge eingefügt werden, nicht am Ende angehängt. Die Einträge sind nach Message-ID-Nummer sortiert innerhalb ihrer jeweiligen Blöcke (SVC nach SVC, UM nach UM, GE nach GE). Neue IDs zwischen die bestehenden einsortieren.

```java
// Neue IDs — auskommentiert bis verifiziert dass sie im Replay vorkommen:
// /* 348 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_BossDamaged_VALUE, CitadelUserMessages.CCitadelUserMsg_BossDamaged.class);
// /* 349 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MidBossSpawned_VALUE, CitadelUserMessages.CCitadelUserMsg_MidBossSpawned.class);
```

Die Dateien:
- `src/main/java/skadistats/clarity/wire/dota/s2/EmbeddedPackets.java`
- `src/main/java/skadistats/clarity/wire/csgo/s2/EmbeddedPackets.java`
- `src/main/java/skadistats/clarity/wire/deadlock/proto/EmbeddedPackets.java`

### DemoPackets.java (top-level demo messages)

Für neue `EDemoCommands`-Werte (z.B. `DEM_Recovery`) muss auch die Datei aktualisiert werden:
- `src/main/java/skadistats/clarity/wire/shared/demo/DemoPackets.java`

Die Registry-Größe im Konstruktor (`new KindToClassMessageRegistry(N)`) muss dem aktuellen `DEM_Max`-Wert entsprechen. Neue Einträge direkt aktivieren (nicht auskommentiert), da Demo-Commands immer im Replay vorkommen.

### Namenskonventionen für abgeleitete Klassennamen

| Enum-Prefix | Message-Prefix | Java-Klasse in |
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

**Achtung:** Wenn neue S2-only Messages in eine eigene `.proto`-Datei in `s2/` gelegt wurden (z.B. `dota_usermessages_s2.proto` → `DOTAS2UserMessages`), dann referenziert die EmbeddedPackets-Klasse den entsprechenden Java-Outer-Classname, **nicht** die `common`-Klasse.

### Wenn keine Message-Definition upstream gefunden wird
Manche IDs haben keine Proto-Definition (interne Events o.ä.). Diese bekommen `null`:
```java
// /* 355 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MeleeHit_VALUE, null);
```

---

## Schritt 7: Issue #58 prüfen — gemeldete IDs aktivieren

GitHub Issue: https://github.com/skadistats/clarity/issues/58

Dort melden User unbekannte Message-Typen im Format:
```
unknown embedded message of kind DOTA_S2/635
unknown top level message of kind CSGO_S2/18
```

Für jede dort gemeldete ID:

1. **Enum-Wert** muss in `message_id.proto` stehen (sollte nach Schritt 3 der Fall sein)
2. **EmbeddedPackets.java-Zeile aktivieren** (Kommentar entfernen) — für embedded messages
3. **DemoPackets.java-Zeile hinzufügen** — für top-level messages (`unknown top level message`)
4. **Proto-Message hinzufügen**: Die Message-Definition aus dem Report-Abschnitt "USER MESSAGE DEFINITIONS" in die passende `.proto` Datei einfügen (am richtigen Ort: common vs. s2!)
5. Wenn die Message `null` gemappt wird (kein Proto nötig), nur die EmbeddedPackets-Zeile aktivieren mit `null`

---

## Schritt 8: Proto-Kompilierung

```bash
cd src/main/proto
./make.sh
```

Das generiert die Java-Klassen aus den .proto Dateien. Danach prüfen ob der Build durchgeht:

```bash
cd /home/spheenik/projects/clarity/clarity-protobuf
./gradlew build
```

---

## Schritt 9: _last_synced_commit aktualisieren

Den aktuellen HEAD-Commit von SteamDatabase/Protobufs in `mapping.json` eintragen:

```bash
NEW_COMMIT=$(git -C /tmp/SteamDatabase-Protobufs rev-parse HEAD)
# In mapping.json den Wert von _last_synced_commit auf $NEW_COMMIT setzen
```

---

## Schritt 10: Testen

Mit verschiedenen Replays testen (aus `clarity-examples`):
```bash
./gradlew allchatRun --args "/home/spheenik/projects/replays/deadlock/newer/<replay>.dem" 2>&1 | grep -i "unknown"
./gradlew allchatRun --args "/home/spheenik/projects/replays/dota/client/<replay>.dem" 2>&1 | grep -i "unknown"
./gradlew allchatRun --args "/home/spheenik/projects/replays/cs2/350/<replay>.dem" 2>&1 | grep -i "unknown"
```

Erwartung: keine `unknown message` Warnungen mehr für die gerade hinzugefügten IDs.

Wenn neue `unknown embedded message` auftauchen für IDs die wir gerade auskommentiert hinzugefügt haben → Kommentar entfernen (aktivieren), neu builden, nochmal testen.

**Wichtig**: Nicht `replays/dueling.dem` verwenden — das ist ein spezielles Replay. Volle Match-Replays verwenden.

---

## Troubleshooting

### Typ-Referenz nicht auflösbar
Wenn ein neues Feld einen Typ referenziert der bei uns nicht definiert ist (z.B. `optional .ETimerAlertType foo = 1`), gibt es zwei Optionen:
1. Den Typ als `optional int32 foo = 1` einfügen (verliert Enum-Semantik, aber funktioniert)
2. Den fehlenden Enum aus upstream holen und hinzufügen — **am richtigen Ort** (common nur wenn S1+S2-relevant, sonst s2/)

### Typ nicht im Kompilierungs-Pfad
Wenn `make.sh` meldet `"Foo" is not defined`, prüfen:
- Liegt der referenzierte Typ in einem Verzeichnis das im `build.json`-Include-Pfad der kompilierenden Datei steht?
- `dota/common` kann NICHT auf `dota/s2` zugreifen — Typen aus `s2/` können nicht in `common/` referenziert werden
- Lösung: Die referenzierende Message ebenfalls nach `s2/` verschieben, oder die Typ-Definition nach `common/` (nur wenn S1-kompatibel)

### Feldnamen-Konflikt (doppelter Name)
Protobuf erlaubt keine zwei Felder mit demselben Namen in einer Message. Passiert wenn upstream ein Feld umbenennt und ein neues mit dem alten Namen hinzufügt. Lösung: Altes Feld bei uns ebenfalls umbenennen (z.B. `foo` → `foo_deprecated`), neues Feld mit dem originalen Namen hinzufügen.

### Feldnummer-Konflikt
Sollte nicht vorkommen, wäre aber ein Zeichen dass das Mapping falsch ist. Report und Mapping prüfen.

### Report zeigt keine Änderungen
- Prüfen ob `_last_synced_commit` in `mapping.json` korrekt ist
- Prüfen ob der Upstream-Klon aktuell ist (`git pull`)
- Mit `--no-baseline` laufen lassen um alle Differenzen zu sehen
