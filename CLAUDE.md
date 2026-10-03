# CLAUDE.md - ManyIdeas Doors

## Projekt-Übersicht

**ManyIdeas Doors** ist ein NeoForge Minecraft Mod.
- **Mod ID**: `manyideas_doors`
- **Package**: `de.geheimagentnr1.manyideas_doors`
- **Java Version**: 21 (`develop_26.1`/`develop_26.3`: 25, `jdk-25.0.4.7-hotspot`)
- **NeoForge Version**: je Branch, siehe Tabelle

| Branch | MC | Range | NeoForge (kompiliert gegen) | Core-Jar (`mic_minecraft_version`) | Hinweis |
|---|---|---|---|---|---|
| `develop_1.21.1` | 1.21.1 | `[1.21.1,1.21.2)` | `21.1.216` | 1.21.1 | Fix-Release 2.0.2 (Behutsamkeit große Birkentür, Modell-Fixes) |
| `develop_1.21.2` | 1.21.2 - 1.21.3 | `[1.21.2,1.21.4)` | `21.2.1-beta` | 1.21.2 | Blöcke per Supplier registriert, Rezept-JSON, Klick-Ergebnisse, `neighborChanged`/`updateShape` |
| `develop_1.21.4` | 1.21.4 | `[1.21.4,1.21.5)` | `21.4.158` | 1.21.4 | Client-Item-Definitionen, `RenderShape.INVISIBLE` |
| `develop_1.21.5` | 1.21.5 - 1.21.8 | `[1.21.5,1.21.9)` | `21.5.98` | 1.21.5 | Ein Jar auf Core 1.21.5 **und** 1.21.6 (Bytecode identisch); `affectNeighborsAfterRemoval`, End-Portal-Renderer |
| `develop_1.21.9` | 1.21.9 - 1.21.10 | `[1.21.9,1.21.11)` | `21.9.16-beta` | 1.21.9 | Submit-Renderer der End-Tür, `isClientSide()` |
| `develop_1.21.11` | 1.21.11 | `[1.21.11,1.21.12)` | `21.11.45` | 1.21.11 | `Identifier` |
| `develop_26.1` | 26.1 - 26.2 | `[26.1,26.3)` | `26.1.0.19-beta` (Java 25) | 26.1 | 26.x-Tooling, End-Tür `submitCube` |
| `develop_26.3` | 26.3 | `[26.3,27)` | `26.3.0.36-beta` (Java 25) | 26.3 | Loot in beiden Formaten (`condition`/`match_block`), `isViewBlocking` mit 4 Parametern, kein Block-`codec()` |

Alle 2.0.2, released 2026-10-03 (ingame getestet auf 1.21.1 - 26.3), ab 1.21.2 abhängig von ManyIdeasCore `[3.0.2,)`. Die Core-Abhängigkeit hängt an `mic_minecraft_version` statt `minecraft_version`, damit ein Doors-Jar mehrere MC-Versionen abdecken und `bincheck.ps1` andere Versionen setzen kann. Details: [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md).

**Modelle:** UVs müssen in 0 - 16 liegen (ab 26.1 wird ein Modell sonst verworfen, verifiziert an der großen Fallgitter-Tür), keine Flächen mit `#missing`. **Loot:** große Türen droppen nur am Ursprungsblock (`x=0,y=0,z=0`); ab 26.3 zusätzlich als `match_block` im neuen Format.

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
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot"
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

Der triviale GameTest wurde beim 1.21.2-Port entfernt (annotationsbasierte GameTests gibt es ab 1.21.5 nicht mehr).

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

## Referenzen

- [NeoForge Migration Primer](https://docs.neoforged.net/primer/docs/) — Dokumentiert API-Aenderungen zwischen Minecraft/NeoForge-Versionen; nuetzlich fuer die Pruefung von Breaking Changes beim Upgrade auf neue Versionen

---

## Wissensdatenbank

Versionsübergreifende Migrations- und Entwicklungs-Erkenntnisse (Breaking Changes, Fixes, Testumgebungs-Patterns) werden zentral in [`../Docs/`](../Docs/) gepflegt. Bei neuen relevanten Erkenntnissen dort ergänzen, nicht nur hier.
