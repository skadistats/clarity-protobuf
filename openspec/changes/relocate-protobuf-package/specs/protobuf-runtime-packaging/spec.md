## ADDED Requirements

### Requirement: Vendored runtime package identity

The vendored protobuf runtime SHALL reside in the Java package `skadistats.clarity.protobuf`. No class published by the `clarity-protobuf` artifact SHALL declare or reference the package `com.google.protobuf`.

#### Scenario: No source references the Google package

- **WHEN** the string `com.google.protobuf` is searched for across all sources in the repository
- **THEN** there are zero matches

#### Scenario: Runtime classes carry the new package

- **WHEN** the published jar is inspected
- **THEN** every runtime class appears under `skadistats/clarity/protobuf/`, and no entry exists under `com/google/protobuf/`

### Requirement: Module descriptor exports the relocated package

The module `com.skadistats.clarity.protobuf` SHALL export `skadistats.clarity.protobuf` and SHALL NOT export `com.google.protobuf`.

#### Scenario: Module descriptor is consistent with the relocation

- **WHEN** `module-info.java` is read
- **THEN** it contains `exports skadistats.clarity.protobuf;` and contains no export of `com.google.protobuf`

### Requirement: Coexistence with stock protobuf-java on the classpath

An application SHALL be able to place the `clarity-protobuf` artifact and a stock `protobuf-java` artifact on the same classpath, in either order, without class resolution conflicts.

#### Scenario: Both artifacts load with clarity first

- **WHEN** an application runs with `clarity-protobuf` ahead of `protobuf-java` on the classpath and exercises both a clarity parse and a stock protobuf message
- **THEN** both complete without `IncompatibleClassChangeError`, `NoSuchMethodError`, or `NoClassDefFoundError`

#### Scenario: Both artifacts load with stock protobuf first

- **WHEN** the same application runs with `protobuf-java` ahead of `clarity-protobuf` on the classpath
- **THEN** the result is identical to the previous scenario, and behaviour does not depend on classpath order

### Requirement: Coexistence with stock protobuf-java on the module path

The `clarity-protobuf` module SHALL resolve in the same module layer as a stock `protobuf-java` module.

#### Scenario: Module layer initialises with both modules resolved

- **WHEN** a JPMS application resolves both `com.skadistats.clarity.protobuf` and `com.google.protobuf` in one layer
- **THEN** the boot layer initialises successfully and no `LayerInstantiationException` reporting a split package is raised

### Requirement: Generated message classes keep their existing packages

The relocation SHALL be confined to the runtime. Generated message classes SHALL remain in their current `skadistats.clarity.wire.*` packages, so consumers that reference only message types are unaffected.

#### Scenario: Message type locations are unchanged

- **WHEN** the set of `skadistats.clarity.wire.*` classes in the published jar is compared against the previous release
- **THEN** the set of fully-qualified message class names is unchanged

#### Scenario: A message-only consumer needs no edits

- **WHEN** consumer code declares a handler taking a generated message type and does not name a runtime type
- **THEN** it compiles against the relocated artifact without modification

### Requirement: Zero-copy accessor remains public API

The zero-copy accessor SHALL be available as `skadistats.clarity.protobuf.ZeroCopy` from an exported package. It SHALL NOT be placed in a package named or documented as internal, since it appears in the public API of dependent artifacts.

#### Scenario: Accessor is reachable by external consumers

- **WHEN** code outside the `clarity-protobuf` module calls `ZeroCopy.wrap`, `ZeroCopy.wrapBounded`, or `ZeroCopy.extract`
- **THEN** the call compiles and runs on both classpath and module path

### Requirement: Regeneration preserves the relocation

The proto generation pipeline SHALL rewrite the runtime package in generated output, so that regenerating from `.proto` sources cannot reintroduce `com.google.protobuf`.

#### Scenario: Regeneration leaves no Google package references

- **WHEN** `src/main/proto/make.sh` is run
- **THEN** the regenerated sources contain zero occurrences of `com.google.protobuf`, and the tree compiles

#### Scenario: The rewrite is idempotent

- **WHEN** the rewrite step is applied twice in succession
- **THEN** the second application produces no further changes to any file

### Requirement: Relocation preserves behaviour

The relocation SHALL be behaviour-preserving. It changes Java package identity only, and SHALL NOT alter wire-format handling, descriptor content, or parse results.

#### Scenario: Descriptor content is unchanged

- **WHEN** the embedded descriptor string literals in generated sources are compared before and after the relocation
- **THEN** they are byte-identical, and the `google.protobuf` names they contain are untouched

#### Scenario: Parsing a replay produces identical output

- **WHEN** a full-size replay is parsed by an example before and after the relocation
- **THEN** the emitted output is identical

### Requirement: Dependent repositories build against the relocated runtime

The repositories that consume `clarity-protobuf` SHALL be updated in step, so that no consumer in the project references the old package.

#### Scenario: All consumers compile

- **WHEN** `clarity`, `clarity-examples`, `clarity-analyzer`, and the `clarity-5.0.0` branch of `odota-parser` are built against the relocated artifact
- **THEN** all compile successfully with zero references to `com.google.protobuf`
