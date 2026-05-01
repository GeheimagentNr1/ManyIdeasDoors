# CLAUDE.md - ManyIdeas Doors

## Projekt-Übersicht

**ManyIdeas Doors** ist ein NeoForge Minecraft Mod für Minecraft 1.21.1.
- **Mod ID**: `manyideas_doors`
- **Package**: `de.geheimagentnr1.manyideas_doors`
- **Java Version**: 21
- **NeoForge Version**: 21.1.x

Bietet über 125 große Multiblock-Türen und normal große Türen.

## Abhängigkeiten

- **ManyIdeas Core** (`manyideas_core`) - Required
- **Recipes Library** (`recipes_lib`) - Required

## Projektstruktur

```
src/main/java/de/geheimagentnr1/manyideas_doors/
├── ManyIdeasDoors.java                    # Haupt-Mod-Klasse (erweitert AbstractMod)
└── elements/
    ├── blocks/                            # Block-Definitionen
    │   ├── ModBlocksRegisterFactory.java  # Block-Registry
    │   ├── big_doors/                     # Große Multiblock-Türen
    │   ├── mini_lodges/                   # Mini-Häuschen (Outhouses, Police Box)
    │   └── player_door_sensor/            # Spieler-Tür-Sensor mit BlockEntity
    └── creative_mod_tabs/                 # Creative-Tab Registration
```

## Architektur

Dieser Mod erweitert `AbstractMod` aus ManyIdeas Core und nutzt dessen Registry-System:
```java
@Mod( ManyIdeasDoors.MODID )
public class ManyIdeasDoors extends AbstractMod {
    @Override
    protected void initMod() {
        ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
        registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
    }
}
```

## Code-Stil

- **Annotations**: `@NotNull` aus `org.jetbrains.annotations`
- **Lombok**: Projekt nutzt Lombok
- **Formatierung**: Leerzeichen nach `(` und vor `)` bei Methodenaufrufen
- **Imports**: Keine Wildcard-Imports

## Build & Test

```bash
./gradlew build
./gradlew runClient
./gradlew runServer
./gradlew runData
```

## Deployment

- **CurseForge**: `./gradlew curseforge`
- **Modrinth**: `./gradlew modrinth`

## Wichtige Hinweise

1. **Abhängig von ManyIdeas Core**: Nutzt `AbstractMod` und Registry-Patterns aus dem Core-Mod
2. **Multiblock-Türen**: Große Türen bestehen aus mehreren Blöcken
3. **BlockEntities**: `PlayerDoorSensor` hat eine zugehörige `PlayerDoorSensorEntity`

## Testing

### Java-Versionen

Verschiedene Java-Versionen sind unter `C:\Program Files\Eclipse Adoptium` installiert. Für einen Gradle-Build muss die passende Java-Version gewählt werden:

```powershell
# Java 21 für MC 1.20.5+ (NeoForge)
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot"
./gradlew build
```

### Unit Tests (JUnit 5)

Für reine Logik-Tests ohne Minecraft-Abhängigkeiten:

```bash
./gradlew test
```

Tests liegen unter `src/test/java/`. Ergebnisse: `build/reports/tests/test/index.html`

### NeoForge GameTest Framework

Für Integration Tests in einer echten Minecraft-Umgebung:

```bash
./gradlew runGameTestServer
```

GameTest-Klassen werden mit `@GameTestHolder` annotiert und liegen unter `src/main/java/.../elements/gametests/`.

### CI/CD (GitHub Actions)

Der Workflow `.github/workflows/build-and-test.yml` führt automatisch aus:
1. **Build**: Kompiliert den Mod
2. **Unit Tests**: Führt JUnit Tests aus
3. **GameTests**: Startet GameTestServer (optional)

### Was kann automatisiert getestet werden?

| Aspekt | Automatisiert? | Methode |
|--------|----------------|---------|
| Utility-Klassen | ✅ | JUnit |
| Config-Parsing | ✅ | JUnit |
| Commands | ✅ | GameTest |
| Block/Item-Verhalten | ✅ | GameTest |
| Multi-MC-Version | ⚠️ Pro Branch | CI Matrix |
