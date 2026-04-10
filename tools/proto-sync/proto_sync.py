#!/usr/bin/env python3
"""
proto_sync.py - Compare upstream SteamDatabase/Protobufs against clarity-protobuf
and generate a structured additive-diff report.

Usage:
    python3 proto_sync.py [--upstream-dir PATH] [--clarity-dir PATH] [--since COMMIT]

If --upstream-dir is not given, clones SteamDatabase/Protobufs to a temp directory.
"""

import argparse
import json
import os
import re
import subprocess
import sys
import tempfile
from dataclasses import dataclass, field
from pathlib import Path
from typing import Optional


# ---------------------------------------------------------------------------
# Proto parser
# ---------------------------------------------------------------------------

@dataclass
class EnumValue:
    name: str
    number: int
    options: str = ""  # raw text after number, e.g. [(default) = true]

@dataclass
class Field:
    label: str        # optional, required, repeated
    type_name: str    # uint32, string, .SomeMessage, etc.
    name: str
    number: int
    options: str = "" # raw text like [default = FOO]
    raw: str = ""     # full original line

@dataclass
class OneOf:
    name: str
    fields: list[Field] = field(default_factory=list)

@dataclass
class Message:
    name: str
    fields: dict[int, Field] = field(default_factory=dict)          # number -> Field
    nested_messages: dict[str, "Message"] = field(default_factory=dict)
    nested_enums: dict[str, "Enum"] = field(default_factory=dict)
    oneofs: dict[str, OneOf] = field(default_factory=dict)
    raw_lines: list[str] = field(default_factory=list)  # for reconstruction

@dataclass
class Enum:
    name: str
    values: dict[int, EnumValue] = field(default_factory=dict)  # number -> EnumValue
    values_by_name: dict[str, EnumValue] = field(default_factory=dict)

@dataclass
class ProtoFile:
    path: str
    options: dict[str, str] = field(default_factory=dict)
    imports: list[str] = field(default_factory=list)
    messages: dict[str, Message] = field(default_factory=dict)
    enums: dict[str, Enum] = field(default_factory=dict)
    raw_text: str = ""


# Regex patterns for proto parsing
RE_OPTION = re.compile(r'^option\s+(\w+)\s*=\s*"([^"]+)"\s*;')
RE_IMPORT = re.compile(r'^import\s+"([^"]+)"\s*;')
RE_ENUM_START = re.compile(r'^enum\s+(\w+)\s*\{')
RE_ENUM_VALUE = re.compile(r'^\s*(\w+)\s*=\s*(-?\d+)\s*(.*?)\s*;')
RE_MSG_START = re.compile(r'^message\s+(\w+)\s*\{')
RE_ONEOF_START = re.compile(r'^\s*oneof\s+(\w+)\s*\{')
RE_FIELD = re.compile(
    r'^\s*(optional|required|repeated)?\s*'   # label (optional in proto3)
    r'([\w.]+)\s+'                             # type
    r'(\w+)\s*=\s*(\d+)\s*'                   # name = number
    r'(.*?)\s*;'                               # rest (options, defaults)
)
RE_MAP_FIELD = re.compile(
    r'^\s*map\s*<\s*([\w.]+)\s*,\s*([\w.]+)\s*>\s+'  # map<K, V>
    r'(\w+)\s*=\s*(\d+)\s*'                            # name = number
    r'(.*?)\s*;'                                        # rest
)
RE_CLOSE_BRACE = re.compile(r'^\s*\}')
RE_COMMENT = re.compile(r'//.*$')
RE_EXTENSIONS = re.compile(r'^\s*extensions\s+')
RE_RESERVED = re.compile(r'^\s*reserved\s+')
RE_EXTEND = re.compile(r'^extend\s+(\w+)\s*\{')


def parse_proto(text: str, path: str = "") -> ProtoFile:
    """Parse a .proto file into structured representation."""
    pf = ProtoFile(path=path, raw_text=text)
    lines = text.split('\n')
    _parse_scope(lines, 0, pf, None)
    return pf


def _parse_scope(lines: list[str], idx: int, pf: ProtoFile, parent_msg: Optional[Message]) -> int:
    """Parse lines within a scope (file-level or message-level). Returns next line index."""
    while idx < len(lines):
        line = lines[idx]
        stripped = RE_COMMENT.sub('', line).strip()

        if not stripped or stripped.startswith('//') or stripped.startswith('/*'):
            # skip block comments simplistically
            if '/*' in stripped and '*/' not in stripped:
                while idx < len(lines) and '*/' not in lines[idx]:
                    idx += 1
            idx += 1
            continue

        # Close brace - end of current scope
        if RE_CLOSE_BRACE.match(stripped):
            return idx + 1

        # Option
        m = RE_OPTION.match(stripped)
        if m:
            pf.options[m.group(1)] = m.group(2)
            idx += 1
            continue

        # Import
        m = RE_IMPORT.match(stripped)
        if m:
            pf.imports.append(m.group(1))
            idx += 1
            continue

        # Enum
        m = RE_ENUM_START.match(stripped)
        if m:
            enum = Enum(name=m.group(1))
            idx = _parse_enum(lines, idx + 1, enum)
            if parent_msg:
                parent_msg.nested_enums[enum.name] = enum
            else:
                pf.enums[enum.name] = enum
            continue

        # Message
        m = RE_MSG_START.match(stripped)
        if m:
            msg = Message(name=m.group(1))
            idx = _parse_scope(lines, idx + 1, pf, msg)
            if parent_msg:
                parent_msg.nested_messages[msg.name] = msg
            else:
                pf.messages[msg.name] = msg
            continue

        # Extend (treat like message for field extraction)
        m = RE_EXTEND.match(stripped)
        if m:
            # skip extend blocks - they modify external types
            depth = 1
            idx += 1
            while idx < len(lines) and depth > 0:
                l = lines[idx]
                depth += l.count('{') - l.count('}')
                idx += 1
            continue

        # Oneof
        m = RE_ONEOF_START.match(stripped)
        if m and parent_msg is not None:
            oo = OneOf(name=m.group(1))
            idx = _parse_oneof(lines, idx + 1, oo)
            parent_msg.oneofs[oo.name] = oo
            for f in oo.fields:
                parent_msg.fields[f.number] = f
            continue

        # Map field
        m = RE_MAP_FIELD.match(stripped)
        if m and parent_msg is not None:
            f = Field(
                label="repeated",
                type_name=f"map<{m.group(1)}, {m.group(2)}>",
                name=m.group(3),
                number=int(m.group(4)),
                options=m.group(5).strip(),
                raw=stripped,
            )
            parent_msg.fields[f.number] = f
            idx += 1
            continue

        # Regular field
        m = RE_FIELD.match(stripped)
        if m and parent_msg is not None:
            f = Field(
                label=m.group(1) or "",
                type_name=m.group(2),
                name=m.group(3),
                number=int(m.group(4)),
                options=m.group(5).strip(),
                raw=stripped,
            )
            parent_msg.fields[f.number] = f
            idx += 1
            continue

        # extensions, reserved, etc. - skip
        if RE_EXTENSIONS.match(stripped) or RE_RESERVED.match(stripped):
            idx += 1
            continue

        idx += 1
    return idx


def _parse_enum(lines: list[str], idx: int, enum: Enum) -> int:
    """Parse enum values until closing brace."""
    while idx < len(lines):
        line = lines[idx]
        stripped = RE_COMMENT.sub('', line).strip()

        if RE_CLOSE_BRACE.match(stripped):
            return idx + 1

        m = RE_ENUM_VALUE.match(stripped)
        if m:
            ev = EnumValue(
                name=m.group(1),
                number=int(m.group(2)),
                options=m.group(3).strip(),
            )
            enum.values[ev.number] = ev
            enum.values_by_name[ev.name] = ev

        idx += 1
    return idx


def _parse_oneof(lines: list[str], idx: int, oo: OneOf) -> int:
    """Parse oneof fields until closing brace."""
    while idx < len(lines):
        line = lines[idx]
        stripped = RE_COMMENT.sub('', line).strip()

        if RE_CLOSE_BRACE.match(stripped):
            return idx + 1

        m = RE_FIELD.match(stripped)
        if m:
            f = Field(
                label="oneof",
                type_name=m.group(2),
                name=m.group(3),
                number=int(m.group(4)),
                options=m.group(5).strip() if m.group(5) else "",
                raw=stripped,
            )
            oo.fields.append(f)

        idx += 1
    return idx


# ---------------------------------------------------------------------------
# Diff engine
# ---------------------------------------------------------------------------

@dataclass
class EnumDiff:
    enum_name: str
    new_values: list[EnumValue] = field(default_factory=list)
    removed_values: list[EnumValue] = field(default_factory=list)

@dataclass
class FieldDiff:
    new_fields: list[Field] = field(default_factory=list)
    removed_fields: list[Field] = field(default_factory=list)

@dataclass
class MessageDiff:
    message_name: str
    field_diff: FieldDiff = field(default_factory=FieldDiff)
    new_nested_enums: list[Enum] = field(default_factory=list)
    new_nested_messages: list[Message] = field(default_factory=list)
    nested_enum_diffs: list[EnumDiff] = field(default_factory=list)
    nested_message_diffs: list["MessageDiff"] = field(default_factory=list)
    removed_fields: list[Field] = field(default_factory=list)

@dataclass
class FileDiff:
    clarity_path: str
    upstream_sources: list[str]
    new_enums: list[Enum] = field(default_factory=list)
    new_messages: list[Message] = field(default_factory=list)
    enum_diffs: list[EnumDiff] = field(default_factory=list)
    message_diffs: list[MessageDiff] = field(default_factory=list)

    @property
    def has_changes(self) -> bool:
        return bool(self.new_enums or self.new_messages or self.enum_diffs or self.message_diffs)


def diff_enums(clarity_enum: Enum, upstream_enum: Enum) -> Optional[EnumDiff]:
    """Find enum values present in upstream but missing in clarity."""
    d = EnumDiff(enum_name=clarity_enum.name)

    for num, ev in upstream_enum.values.items():
        if num not in clarity_enum.values and ev.name not in clarity_enum.values_by_name:
            d.new_values.append(ev)

    for num, ev in clarity_enum.values.items():
        if num not in upstream_enum.values and ev.name not in upstream_enum.values_by_name:
            d.removed_values.append(ev)

    if d.new_values or d.removed_values:
        return d
    return None


def diff_messages(clarity_msg: Message, upstream_msg: Message) -> Optional[MessageDiff]:
    """Find fields/nested types present in upstream but missing in clarity."""
    d = MessageDiff(message_name=clarity_msg.name)
    has_changes = False

    # Field diff
    for num, f in upstream_msg.fields.items():
        if num not in clarity_msg.fields:
            d.field_diff.new_fields.append(f)
            has_changes = True

    for num, f in clarity_msg.fields.items():
        if num not in upstream_msg.fields:
            d.field_diff.removed_fields.append(f)
            has_changes = True

    # Nested enum diff
    for name, ue in upstream_msg.nested_enums.items():
        if name in clarity_msg.nested_enums:
            ed = diff_enums(clarity_msg.nested_enums[name], ue)
            if ed:
                d.nested_enum_diffs.append(ed)
                has_changes = True
        else:
            d.new_nested_enums.append(ue)
            has_changes = True

    # Nested message diff
    for name, um in upstream_msg.nested_messages.items():
        if name in clarity_msg.nested_messages:
            md = diff_messages(clarity_msg.nested_messages[name], um)
            if md:
                d.nested_message_diffs.append(md)
                has_changes = True
        else:
            d.new_nested_messages.append(um)
            has_changes = True

    return d if has_changes else None


def diff_files(clarity_pf: ProtoFile, upstream_pf: ProtoFile) -> FileDiff:
    """Compute additive diff between clarity and upstream proto files."""
    fd = FileDiff(clarity_path=clarity_pf.path, upstream_sources=[upstream_pf.path])

    # Top-level enums
    for name, ue in upstream_pf.enums.items():
        if name in clarity_pf.enums:
            ed = diff_enums(clarity_pf.enums[name], ue)
            if ed:
                fd.enum_diffs.append(ed)
        else:
            fd.new_enums.append(ue)

    # Top-level messages
    for name, um in upstream_pf.messages.items():
        if name in clarity_pf.messages:
            md = diff_messages(clarity_pf.messages[name], um)
            if md:
                fd.message_diffs.append(md)
        else:
            fd.new_messages.append(um)

    return fd


def merge_file_diffs(diffs: list[FileDiff]) -> FileDiff:
    """Merge multiple upstream diffs into one (union for shared files)."""
    if len(diffs) == 1:
        return diffs[0]

    merged = FileDiff(
        clarity_path=diffs[0].clarity_path,
        upstream_sources=[s for d in diffs for s in d.upstream_sources],
    )

    # Collect all new enums by name (union)
    seen_enums = {}
    for d in diffs:
        for e in d.new_enums:
            if e.name not in seen_enums:
                seen_enums[e.name] = e
                merged.new_enums.append(e)

    # Merge enum diffs (union of new values)
    enum_diff_map: dict[str, EnumDiff] = {}
    for d in diffs:
        for ed in d.enum_diffs:
            if ed.enum_name not in enum_diff_map:
                enum_diff_map[ed.enum_name] = EnumDiff(enum_name=ed.enum_name)
            target = enum_diff_map[ed.enum_name]
            seen_nums = {ev.number for ev in target.new_values}
            for ev in ed.new_values:
                if ev.number not in seen_nums:
                    target.new_values.append(ev)
                    seen_nums.add(ev.number)
            # For removed: only mark as removed if ALL upstream sources removed it
            # (simplified: just take from first diff that has removals)
            if not target.removed_values and ed.removed_values:
                target.removed_values = ed.removed_values

    merged.enum_diffs = [ed for ed in enum_diff_map.values() if ed.new_values or ed.removed_values]

    # Collect new messages (union)
    seen_msgs = {}
    for d in diffs:
        for m in d.new_messages:
            if m.name not in seen_msgs:
                seen_msgs[m.name] = m
                merged.new_messages.append(m)

    # Merge message diffs (union of new fields)
    msg_diff_map: dict[str, MessageDiff] = {}
    for d in diffs:
        for md in d.message_diffs:
            if md.message_name not in msg_diff_map:
                msg_diff_map[md.message_name] = MessageDiff(message_name=md.message_name)
            target = msg_diff_map[md.message_name]
            seen_nums = {f.number for f in target.field_diff.new_fields}
            for f in md.field_diff.new_fields:
                if f.number not in seen_nums:
                    target.field_diff.new_fields.append(f)
                    seen_nums.add(f.number)
            # new nested enums
            seen_ne = {e.name for e in target.new_nested_enums}
            for e in md.new_nested_enums:
                if e.name not in seen_ne:
                    target.new_nested_enums.append(e)
                    seen_ne.add(e.name)
            # new nested messages
            seen_nm = {m.name for m in target.new_nested_messages}
            for m in md.new_nested_messages:
                if m.name not in seen_nm:
                    target.new_nested_messages.append(m)
                    seen_nm.add(m.name)
            # nested enum diffs
            for ned in md.nested_enum_diffs:
                existing = next((x for x in target.nested_enum_diffs if x.enum_name == ned.enum_name), None)
                if not existing:
                    target.nested_enum_diffs.append(ned)
                else:
                    seen = {ev.number for ev in existing.new_values}
                    for ev in ned.new_values:
                        if ev.number not in seen:
                            existing.new_values.append(ev)
                            seen.add(ev.number)

    merged.message_diffs = [md for md in msg_diff_map.values()
                            if md.field_diff.new_fields or md.field_diff.removed_fields
                            or md.new_nested_enums or md.new_nested_messages
                            or md.nested_enum_diffs or md.nested_message_diffs]

    return merged


# ---------------------------------------------------------------------------
# Report generator
# ---------------------------------------------------------------------------

def format_enum(enum: Enum, indent: str = "  ") -> str:
    """Format an enum definition for the report."""
    lines = [f"{indent}enum {enum.name} {{"]
    for num in sorted(enum.values.keys()):
        ev = enum.values[num]
        lines.append(f"{indent}  {ev.name} = {ev.number};")
    lines.append(f"{indent}}}")
    return '\n'.join(lines)


def format_message(msg: Message, indent: str = "  ") -> str:
    """Format a message definition for the report."""
    lines = [f"{indent}message {msg.name} {{"]
    for ne in msg.nested_enums.values():
        lines.append(format_enum(ne, indent + "  "))
    for nm in msg.nested_messages.values():
        lines.append(format_message(nm, indent + "  "))
    for num in sorted(msg.fields.keys()):
        f = msg.fields[num]
        label = f"{f.label} " if f.label and f.label != "oneof" else ""
        opts = f" {f.options}" if f.options else ""
        lines.append(f"{indent}  {label}{f.type_name} {f.name} = {f.number}{opts};")
    lines.append(f"{indent}}}")
    return '\n'.join(lines)


def format_field(f: Field, indent: str = "    ") -> str:
    label = f"{f.label} " if f.label and f.label != "oneof" else ""
    opts = f" {f.options}" if f.options else ""
    return f"{indent}{label}{f.type_name} {f.name} = {f.number}{opts};"


def generate_report(diffs: list[FileDiff]) -> str:
    """Generate human-readable report from file diffs."""
    sections = []
    changed = [d for d in diffs if d.has_changes]

    if not changed:
        return "No additive changes found. Clarity protos are up to date with upstream."

    sections.append(f"# Proto Sync Report")
    sections.append(f"# {len(changed)} file(s) with changes\n")

    for fd in sorted(changed, key=lambda d: d.clarity_path):
        lines = []
        lines.append(f"{'='*70}")
        lines.append(f"  {fd.clarity_path}")
        lines.append(f"  Sources: {', '.join(fd.upstream_sources)}")
        lines.append(f"{'='*70}")

        # New enums
        for enum in fd.new_enums:
            lines.append(f"\n  NEW ENUM:")
            lines.append(format_enum(enum))

        # Enum diffs
        for ed in fd.enum_diffs:
            if ed.new_values:
                lines.append(f"\n  ENUM {ed.enum_name} — new values:")
                for ev in sorted(ed.new_values, key=lambda v: v.number):
                    lines.append(f"    + {ev.name} = {ev.number};")
            if ed.removed_values:
                lines.append(f"\n  ENUM {ed.enum_name} — removed upstream (KEEP in clarity!):")
                for ev in sorted(ed.removed_values, key=lambda v: v.number):
                    lines.append(f"    - {ev.name} = {ev.number};  // REMOVED upstream, RETAIN")

        # New messages
        for msg in fd.new_messages:
            lines.append(f"\n  NEW MESSAGE:")
            lines.append(format_message(msg))

        # Message diffs
        for md in fd.message_diffs:
            parts = []
            if md.field_diff.new_fields:
                parts.append(f"\n  MESSAGE {md.message_name} — new fields:")
                for f in sorted(md.field_diff.new_fields, key=lambda x: x.number):
                    parts.append(f"    + {format_field(f, '').strip()}")
            if md.field_diff.removed_fields:
                parts.append(f"\n  MESSAGE {md.message_name} — removed upstream (KEEP!):")
                for f in sorted(md.field_diff.removed_fields, key=lambda x: x.number):
                    parts.append(f"    - {format_field(f, '').strip()}  // REMOVED upstream, RETAIN")
            if md.new_nested_enums:
                for ne in md.new_nested_enums:
                    parts.append(f"\n  MESSAGE {md.message_name} — new nested enum:")
                    parts.append(format_enum(ne, "    "))
            if md.new_nested_messages:
                for nm in md.new_nested_messages:
                    parts.append(f"\n  MESSAGE {md.message_name} — new nested message:")
                    parts.append(format_message(nm, "    "))
            if md.nested_enum_diffs:
                for ned in md.nested_enum_diffs:
                    if ned.new_values:
                        parts.append(f"\n  MESSAGE {md.message_name} > ENUM {ned.enum_name} — new values:")
                        for ev in sorted(ned.new_values, key=lambda v: v.number):
                            parts.append(f"    + {ev.name} = {ev.number};")
            if parts:
                lines.extend(parts)

        lines.append("")
        sections.append('\n'.join(lines))

    return '\n'.join(sections)


# ---------------------------------------------------------------------------
# CLI / Orchestration
# ---------------------------------------------------------------------------

def clone_upstream(repo: str, target_dir: str, commit: Optional[str] = None) -> str:
    """Clone upstream repo. If commit is given, fetch full history to that point."""
    url = f"https://github.com/{repo}.git"
    if commit:
        print(f"Cloning {url} (full, for baseline {commit[:10]})...", file=sys.stderr)
        subprocess.run(["git", "clone", url, target_dir],
                        check=True, capture_output=True)
        subprocess.run(["git", "checkout", commit], cwd=target_dir,
                        check=True, capture_output=True)
    else:
        print(f"Cloning {url} (shallow)...", file=sys.stderr)
        subprocess.run(["git", "clone", "--depth=1", url, target_dir],
                        check=True, capture_output=True)
    return target_dir


def checkout_worktree(repo_dir: str, commit: str, worktree_dir: str) -> str:
    """Create a git worktree at the given commit."""
    subprocess.run(["git", "worktree", "add", "--detach", worktree_dir, commit],
                    cwd=repo_dir, check=True, capture_output=True)
    return worktree_dir


def cleanup_worktree(repo_dir: str, worktree_dir: str):
    """Remove a git worktree."""
    subprocess.run(["git", "worktree", "remove", "--force", worktree_dir],
                    cwd=repo_dir, capture_output=True)


def load_mapping(mapping_path: str) -> tuple[dict, dict]:
    """Load the mapping config."""
    with open(mapping_path) as f:
        data = json.load(f)
    # Filter out metadata keys
    return {k: v for k, v in data.items() if not k.startswith('_')}, data


def resolve_upstream_file(upstream_dir: str, upstream_path: str) -> Optional[str]:
    """Find an upstream proto file. Returns full path or None."""
    full = os.path.join(upstream_dir, upstream_path)
    if os.path.exists(full):
        return full
    return None


def parse_upstream_file(upstream_dir: str, rel_path: str) -> Optional[ProtoFile]:
    """Parse a single upstream proto file, return None if not found."""
    full = resolve_upstream_file(upstream_dir, rel_path)
    if not full:
        return None
    with open(full) as f:
        return parse_proto(f.read(), rel_path)


def filter_new_only(full_diff: FileDiff, baseline_diff: Optional[FileDiff]) -> FileDiff:
    """Filter a full upstream-vs-clarity diff to only include things that are
    genuinely new since the baseline (i.e., not pre-existing upstream items
    that clarity intentionally doesn't track).

    Strategy: something is "new" if it appears in the full diff AND also appears
    in the upstream old→new diff (meaning upstream added it since last sync).
    For things that already existed upstream at baseline time, they were
    intentionally not included in clarity.
    """
    if baseline_diff is None:
        # No baseline available — show everything (first-time mode)
        return full_diff

    # Build sets of what upstream added since baseline
    baseline_new_enum_names = {e.name for e in baseline_diff.new_enums}
    baseline_new_msg_names = {m.name for m in baseline_diff.new_messages}
    baseline_enum_new_values: dict[str, set[int]] = {}
    for ed in baseline_diff.enum_diffs:
        baseline_enum_new_values[ed.enum_name] = {ev.number for ev in ed.new_values}
    baseline_msg_new_fields: dict[str, set[int]] = {}
    baseline_msg_new_nested_enums: dict[str, set[str]] = {}
    baseline_msg_new_nested_msgs: dict[str, set[str]] = {}
    for md in baseline_diff.message_diffs:
        baseline_msg_new_fields[md.message_name] = {f.number for f in md.field_diff.new_fields}
        baseline_msg_new_nested_enums[md.message_name] = {e.name for e in md.new_nested_enums}
        baseline_msg_new_nested_msgs[md.message_name] = {m.name for m in md.new_nested_messages}

    filtered = FileDiff(
        clarity_path=full_diff.clarity_path,
        upstream_sources=full_diff.upstream_sources,
    )

    # Filter new enums: only include if upstream also added them since baseline
    for e in full_diff.new_enums:
        if e.name in baseline_new_enum_names:
            filtered.new_enums.append(e)

    # Filter enum diffs: only new values that upstream added since baseline
    for ed in full_diff.enum_diffs:
        baseline_nums = baseline_enum_new_values.get(ed.enum_name, set())
        filtered_new = [ev for ev in ed.new_values if ev.number in baseline_nums]
        if filtered_new or ed.removed_values:
            filtered.enum_diffs.append(EnumDiff(
                enum_name=ed.enum_name,
                new_values=filtered_new,
                removed_values=ed.removed_values,
            ))

    # Filter new messages: only if upstream added them since baseline
    for m in full_diff.new_messages:
        if m.name in baseline_new_msg_names:
            filtered.new_messages.append(m)

    # Filter message diffs
    for md in full_diff.message_diffs:
        b_fields = baseline_msg_new_fields.get(md.message_name, set())
        b_nested_enums = baseline_msg_new_nested_enums.get(md.message_name, set())
        b_nested_msgs = baseline_msg_new_nested_msgs.get(md.message_name, set())

        new_fields = [f for f in md.field_diff.new_fields if f.number in b_fields]
        new_nested_enums = [e for e in md.new_nested_enums if e.name in b_nested_enums]
        new_nested_msgs = [m for m in md.new_nested_messages if m.name in b_nested_msgs]

        # Nested enum diffs - filter values
        filtered_nested_enum_diffs = []
        for ned in md.nested_enum_diffs:
            # Look for this in baseline's nested enum diffs
            baseline_ned = None
            for bmd in baseline_diff.message_diffs:
                if bmd.message_name == md.message_name:
                    baseline_ned = next((x for x in bmd.nested_enum_diffs if x.enum_name == ned.enum_name), None)
                    break
            if baseline_ned:
                b_vals = {ev.number for ev in baseline_ned.new_values}
                filtered_vals = [ev for ev in ned.new_values if ev.number in b_vals]
                if filtered_vals:
                    filtered_nested_enum_diffs.append(EnumDiff(
                        enum_name=ned.enum_name,
                        new_values=filtered_vals,
                    ))
            # If the nested enum itself is new (in new_nested_enums), it's already handled above

        if (new_fields or md.field_diff.removed_fields or new_nested_enums
                or new_nested_msgs or filtered_nested_enum_diffs):
            filtered.message_diffs.append(MessageDiff(
                message_name=md.message_name,
                field_diff=FieldDiff(
                    new_fields=new_fields,
                    removed_fields=md.field_diff.removed_fields,
                ),
                new_nested_enums=new_nested_enums,
                new_nested_messages=new_nested_msgs,
                nested_enum_diffs=filtered_nested_enum_diffs,
                nested_message_diffs=md.nested_message_diffs,  # pass through for now
            ))

    return filtered


def strip_new_items(fd: FileDiff) -> FileDiff:
    """Remove new top-level messages/enums from a diff, keeping only updates to
    existing ones. However, keep new nested messages/enums that are referenced
    by new fields in their parent message (they're required for the field to work)."""
    stripped = FileDiff(
        clarity_path=fd.clarity_path,
        upstream_sources=fd.upstream_sources,
        new_enums=[],       # drop top-level
        new_messages=[],    # drop top-level
        enum_diffs=fd.enum_diffs,
        message_diffs=[],
    )
    for md in fd.message_diffs:
        if not (md.field_diff.new_fields or md.field_diff.removed_fields
                or md.nested_enum_diffs or md.nested_message_diffs):
            continue

        # Find nested messages/enums referenced by new fields
        referenced_types = set()
        for f in md.field_diff.new_fields:
            # e.g. ".CUserMsg_ParticleManager.AddFan" or "AddFan"
            t = f.type_name.lstrip('.')
            # Could be fully qualified — extract the last component(s)
            parts = t.split('.')
            referenced_types.add(parts[-1])  # short name
            referenced_types.add(t)          # full name

        needed_nested_msgs = [m for m in md.new_nested_messages
                              if m.name in referenced_types]
        needed_nested_enums = [e for e in md.new_nested_enums
                               if e.name in referenced_types]

        stripped.message_diffs.append(MessageDiff(
            message_name=md.message_name,
            field_diff=md.field_diff,
            new_nested_enums=needed_nested_enums,
            new_nested_messages=needed_nested_msgs,
            nested_enum_diffs=md.nested_enum_diffs,
            nested_message_diffs=md.nested_message_diffs,
        ))
    return stripped


def detect_upstream_structural_changes(upstream_dir: str, baseline_dir: Optional[str]) -> str:
    """Detect new/removed proto files upstream since baseline.
    Only checks the game directories relevant to clarity (csgo, dota2, deadlock)."""
    if not baseline_dir:
        return ""

    games = ["csgo", "dota2", "deadlock"]
    new_files = []
    removed_files = []

    for game in games:
        current_dir = os.path.join(upstream_dir, game)
        old_dir = os.path.join(baseline_dir, game)

        current_protos = set()
        old_protos = set()

        if os.path.isdir(current_dir):
            current_protos = {f for f in os.listdir(current_dir) if f.endswith('.proto')}
        if os.path.isdir(old_dir):
            old_protos = {f for f in os.listdir(old_dir) if f.endswith('.proto')}

        for f in sorted(current_protos - old_protos):
            new_files.append(f"{game}/{f}")
        for f in sorted(old_protos - current_protos):
            removed_files.append(f"{game}/{f}")

    if not new_files and not removed_files:
        return ""

    lines = [
        "=" * 70,
        "  UPSTREAM STRUCTURAL CHANGES (new/removed proto files)",
        "=" * 70,
        "",
    ]
    if new_files:
        lines.append("  New proto files upstream:")
        for f in new_files:
            lines.append(f"    + {f}")
        lines.append("")
    if removed_files:
        lines.append("  Removed proto files upstream:")
        for f in removed_files:
            lines.append(f"    - {f}")
        lines.append("")
    return '\n'.join(lines)


# ---------------------------------------------------------------------------
# User message resolution: find message definitions for new message IDs
# ---------------------------------------------------------------------------

# Mapping from enum value name patterns to expected message class name patterns
# These are the naming conventions Valve uses
USERMSG_ENUM_TO_MSG_PREFIX = {
    # Dota: DOTA_UM_Foo -> CDOTAUserMsg_Foo
    "DOTA_UM_": "CDOTAUserMsg_",
    "DOTA_EM_": "CDOTAEntityMsg_",
    # CS:GO: CS_UM_Foo -> CCSUsrMsg_Foo
    "CS_UM_": "CCSUsrMsg_",
    # Deadlock: k_EUserMsg_Foo -> CCitadelUserMsg_Foo
    "k_EUserMsg_": "CCitadelUserMsg_",
    "k_EEntityMsg_": "CCitadelEntityMsg_",
    # Base: UM_Foo -> CUserMessage_Foo or CUserMsg_Foo
    "UM_": "CUserMessage",
    "EM_": "CEntityMessage",
}


def derive_message_name(enum_value_name: str) -> list[str]:
    """Derive possible message class names from an enum value name."""
    candidates = []
    for prefix, msg_prefix in USERMSG_ENUM_TO_MSG_PREFIX.items():
        if enum_value_name.startswith(prefix):
            suffix = enum_value_name[len(prefix):]
            candidates.append(f"{msg_prefix}{suffix}")
            # Some messages use slightly different naming
            if msg_prefix == "CUserMessage":
                candidates.append(f"CUserMessage{suffix}")
                candidates.append(f"CUserMsg_{suffix}")
            break
    return candidates


def find_message_in_upstream(msg_names: list[str], upstream_dir: str,
                             game_dirs: list[str]) -> Optional[tuple[str, Message]]:
    """Search for a message definition in upstream proto files."""
    for game_dir in game_dirs:
        full_dir = os.path.join(upstream_dir, game_dir)
        if not os.path.isdir(full_dir):
            continue
        for fname in os.listdir(full_dir):
            if not fname.endswith('.proto'):
                continue
            fpath = os.path.join(full_dir, fname)
            with open(fpath) as f:
                text = f.read()
            # Quick check before full parse
            if not any(name in text for name in msg_names):
                continue
            pf = parse_proto(text, f"{game_dir}/{fname}")
            for name in msg_names:
                if name in pf.messages:
                    return f"{game_dir}/{fname}", pf.messages[name]
    return None


def resolve_new_user_messages(all_diffs: list[FileDiff], upstream_dir: str) -> str:
    """For each new message ID enum value, find the corresponding message
    definition upstream and format it for the report."""

    # Collect new enum values from message_id files
    message_id_enums = [
        "EDotaUserMessages", "ECstrike15UserMessages",
        "CitadelUserMessageIds", "CitadelEntityMessageIds",
        "EBaseUserMessages", "EBaseEntityMessages",
        "SVC_Messages", "CLC_Messages",
    ]

    # Map game prefixes to search directories
    enum_to_game = {
        "EDotaUserMessages": ["dota2"],
        "ECstrike15UserMessages": ["csgo"],
        "CitadelUserMessageIds": ["deadlock"],
        "CitadelEntityMessageIds": ["deadlock"],
        "EBaseUserMessages": ["dota2", "csgo", "deadlock"],
        "EBaseEntityMessages": ["dota2", "csgo", "deadlock"],
        "SVC_Messages": ["dota2", "csgo", "deadlock"],
    }

    new_ids: list[tuple[str, EnumValue, list[str]]] = []  # (enum_name, value, game_dirs)

    for fd in all_diffs:
        if "message_id" not in fd.clarity_path:
            continue
        for ed in fd.enum_diffs:
            if ed.enum_name in message_id_enums and ed.new_values:
                game_dirs = enum_to_game.get(ed.enum_name, ["dota2", "csgo", "deadlock"])
                for ev in ed.new_values:
                    new_ids.append((ed.enum_name, ev, game_dirs))

    if not new_ids:
        return ""

    lines = [
        "=" * 70,
        "  USER MESSAGE DEFINITIONS FOR NEW MESSAGE IDs",
        "  (add these to the corresponding usermessages .proto and EmbeddedPackets.java)",
        "=" * 70,
        "",
    ]

    for enum_name, ev, game_dirs in sorted(new_ids, key=lambda x: (x[0], x[1].number)):
        candidates = derive_message_name(ev.name)
        if not candidates:
            lines.append(f"  {enum_name}.{ev.name} = {ev.number}")
            lines.append(f"    Could not derive message name")
            lines.append("")
            continue

        result = find_message_in_upstream(candidates, upstream_dir, game_dirs)
        if result:
            source_file, msg = result
            lines.append(f"  {enum_name}.{ev.name} = {ev.number}  (from {source_file})")
            lines.append(format_message(msg))
            lines.append("")
        else:
            lines.append(f"  {enum_name}.{ev.name} = {ev.number}")
            lines.append(f"    Message not found upstream (searched: {', '.join(candidates)})")
            lines.append(f"    → Use null in EmbeddedPackets.java")
            lines.append("")

    return '\n'.join(lines)


def run_sync(clarity_proto_dir: str, upstream_dir: str, mapping_path: str,
             baseline_dir: Optional[str] = None) -> str:
    """Main sync logic. Returns report string.

    If baseline_dir is provided, only reports changes that are genuinely new
    since the baseline (upstream old→new), filtering out pre-existing upstream
    content that clarity intentionally doesn't include.
    """
    mapping, meta = load_mapping(mapping_path)

    all_diffs = []

    for clarity_rel, config in sorted(mapping.items()):
        clarity_path = os.path.join(clarity_proto_dir, clarity_rel)
        if not os.path.exists(clarity_path):
            print(f"  SKIP {clarity_rel} (file not found in clarity)", file=sys.stderr)
            continue

        with open(clarity_path) as f:
            clarity_pf = parse_proto(f.read(), clarity_rel)

        # Parse all upstream sources (current HEAD) and diff against clarity
        file_diffs = []
        baseline_diffs = []
        for upstream_rel in config["upstream"]:
            # Current upstream
            upstream_pf = parse_upstream_file(upstream_dir, upstream_rel)
            if not upstream_pf:
                print(f"  SKIP upstream {upstream_rel} (not found)", file=sys.stderr)
                continue

            fd = diff_files(clarity_pf, upstream_pf)
            file_diffs.append(fd)

            # Baseline: diff old upstream vs new upstream to find what's actually new
            if baseline_dir:
                old_pf = parse_upstream_file(baseline_dir, upstream_rel)
                if old_pf:
                    # What does new upstream have that old upstream didn't?
                    baseline_fd = diff_files(old_pf, upstream_pf)
                    baseline_diffs.append(baseline_fd)

        if file_diffs:
            merged = merge_file_diffs(file_diffs)
            baseline_merged = merge_file_diffs(baseline_diffs) if baseline_diffs else None
            filtered = filter_new_only(merged, baseline_merged)
            # Default: only show updates to existing messages/enums
            # (no new top-level messages/enums unless explicitly opted in)
            if not config.get("include_new_items"):
                filtered = strip_new_items(filtered)
            all_diffs.append(filtered)

    report = generate_report(all_diffs)

    # Append user message resolution section
    usermsg_section = resolve_new_user_messages(all_diffs, upstream_dir)
    if usermsg_section:
        report = report + "\n\n" + usermsg_section

    # Prepend structural changes section
    structural = detect_upstream_structural_changes(upstream_dir, baseline_dir)
    if structural:
        report = structural + "\n\n" + report

    return report


def main():
    parser = argparse.ArgumentParser(description="Proto sync tool for clarity-protobuf")
    parser.add_argument("--clarity-dir", default=None,
                        help="Path to clarity proto dir (default: auto-detect)")
    parser.add_argument("--upstream-dir", default=None,
                        help="Path to local SteamDatabase/Protobufs checkout (HEAD)")
    parser.add_argument("--baseline-dir", default=None,
                        help="Path to old upstream checkout (baseline commit)")
    parser.add_argument("--mapping", default=None,
                        help="Path to mapping.json (default: next to this script)")
    parser.add_argument("--output", "-o", default=None,
                        help="Output file (default: stdout)")
    parser.add_argument("--no-baseline", action="store_true",
                        help="Skip baseline comparison, show all differences")

    args = parser.parse_args()

    # Resolve paths
    script_dir = Path(__file__).parent
    mapping_path = args.mapping or str(script_dir / "mapping.json")
    clarity_dir = args.clarity_dir or str(script_dir.parent.parent / "src" / "main" / "proto")

    if not os.path.isdir(clarity_dir):
        print(f"Error: clarity proto dir not found: {clarity_dir}", file=sys.stderr)
        sys.exit(1)

    _, meta = load_mapping(mapping_path)
    last_synced = meta.get("_last_synced_commit")

    # Clone/resolve upstream HEAD
    if args.upstream_dir:
        upstream_dir = args.upstream_dir
    else:
        tmpdir = tempfile.mkdtemp(prefix="proto-sync-upstream-")
        if last_synced and not args.no_baseline and not args.baseline_dir:
            # Need full clone for baseline worktree
            clone_upstream("SteamDatabase/Protobufs", tmpdir, commit=None)
        else:
            clone_upstream("SteamDatabase/Protobufs", tmpdir)
        upstream_dir = tmpdir

    # Resolve baseline
    baseline_dir = args.baseline_dir
    worktree_dir = None
    if not baseline_dir and last_synced and not args.no_baseline:
        worktree_dir = tempfile.mkdtemp(prefix="proto-sync-baseline-")
        try:
            print(f"Creating baseline worktree at {last_synced[:10]}...", file=sys.stderr)
            checkout_worktree(upstream_dir, last_synced, worktree_dir)
            baseline_dir = worktree_dir
        except subprocess.CalledProcessError:
            print(f"  WARNING: Could not checkout baseline {last_synced}, "
                  f"showing all differences", file=sys.stderr)
            baseline_dir = None
            worktree_dir = None

    print(f"Clarity protos:  {clarity_dir}", file=sys.stderr)
    print(f"Upstream (HEAD): {upstream_dir}", file=sys.stderr)
    if baseline_dir:
        print(f"Baseline (old):  {baseline_dir} ({last_synced[:10]}...)", file=sys.stderr)
    else:
        print(f"Baseline: none (showing all differences)", file=sys.stderr)
    print(file=sys.stderr)

    report = run_sync(clarity_dir, upstream_dir, mapping_path, baseline_dir)

    # Cleanup worktree
    if worktree_dir:
        cleanup_worktree(upstream_dir, worktree_dir)

    if args.output:
        with open(args.output, 'w') as f:
            f.write(report)
        print(f"Report written to {args.output}", file=sys.stderr)
    else:
        print(report)


if __name__ == "__main__":
    main()
