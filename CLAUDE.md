# CLAUDE.md - ManyIdeas Doors

Über 125 Türen: große Mehrblock-Türen (Holz und Metall), normal große Holz-/Metall-/Spezial-Türen (u. a. End-Tür mit End-Portal-Renderer, Polizeibox, Fallgitter), Mini-Häuschen (Plumpsklos, Polizeibox) und ein Spieler-Tür-Sensor. Mod-ID `manyideas_doors`, Package `de.geheimagentnr1.manyideas_doors`, Client+Server. Baut vollständig auf ManyIdeasCore auf.

Diese Datei ist auf allen `develop_*`-Branches identisch; Quelle: `../Docs/mod-claude/ManyIdeasDoors.md` (Änderungen dort, dann `Docs/tools/sync_mod_claude_md.sh`). Versionsstand: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md).

## Versionen

- Jars, Branches, Ranges und Tags: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md). NeoForge ab `develop_1.21.1`, Forge bis `develop_1.21` plus `develop_1.21.1_forge`.
- Jede Doors-Version braucht das **passende Core-Jar**: `custom.gradle` bindet `ManyIdeasCore-<mc>:${mic_version}` (`implementation`) und `RecipesLibrary-<mc>:${rl_version}` (nur `runtimeOnly`) aus `ModdingMavenRepositories`. Bis 1.21.1 (auch Forge) ist `<mc>` = `${minecraft_version}`, ab 1.21.2 `${mic_minecraft_version}` bzw. `${rl_minecraft_version}` - bewusst getrennt von `minecraft_version`: ein Doors-Jar wird gegen das Core-Jar der niedrigsten Version kompiliert und kann mehrere Core-Jars abdecken (z. B. ein Doors-Jar 1.21.5 - 1.21.8 auf Core 1.21.5 und 1.21.6); `bincheck.ps1` setzt die Variable für Zwischenversionen.
- Die 1.21.1-Releases bis 2.0.1 hatten Range bis 1.21.10, laden wegen Core aber nur auf 1.21.1.
- CurseForge-Projekt `433643`, Modrinth `B4U5vxjd`.

## Abhängigkeiten

- **ManyIdeasCore** (`manyideas_core`, required) - Framework, Tür-Templates, Tischsägen-Rezepttypen.
- **RecipesLibrary** (`recipes_lib`, required) - nur JSON: Ingredient `recipes_lib:components` in einigen Rezepten (gefärbte Dielen mit `manyideas_core:color` als Zutat).
- Forge 1.20 - 1.21.1-Forge zusätzlich MinecraftForgeAPI, siehe [`../Docs/forge/README.md`](../Docs/forge/README.md).

## Architektur

- `ManyIdeasDoors` erweitert Core-`AbstractMod` (NeoForge: aus Core; Forge 1.20+: aus MinecraftForgeAPI) und registriert `ModBlocksRegisterFactory` + `ModCreativeModeTabRegisterFactory`.
- `elements/blocks/big_doors/{wooden,metal}/` - große Türen, erweitern Core-`BigDoor` (`MultiBlock`, `RedstoneKeyable`).
- `elements/blocks/doors/<holzart|iron|copper|special>/` - normal große Türen auf Basis von `DoorWooden`/`DoorMetal` bzw. Core-`DoubleDoorBlock`; `special/end/` mit BlockEntity und End-Portal-Renderer.
- `elements/blocks/mini_lodges/` - Mini-Häuschen (Core-`MultiBlock`), `player_door_sensor/` - Sensor mit BlockEntity (`PlayerDoorSensorEntity`), gibt Redstone aus, wenn Spieler im Erfassungsbereich (Blockstate `SENSOR_RANGE`) stehen.
- `elements/creative_mod_tabs/` (Factory-Klasse heißt historisch `ManyIdeasHalloweenCreativeModeTabFactory`); `getDisplayItems()` bleibt leer, Blöcke kommen über `getDisplayBlocks()`.
- Ressourcen: viele Rezepte vom Typ `manyideas_core:table_sawing_stone`/`_diamond`; `Entfernt/` enthält alte, nicht kompilierte Dateien.

## Funktionen, Befehle, Konfiguration

Keine Befehle, keine Config. Türen öffnen per Hand, Redstone oder beides - umschaltbar mit dem Redstone-Schlüssel aus Core.

## Fallstricke

- **Registrierung ab 1.21.2:** Einträge nur als `RegistryEntry.create( name, () -> new X() )`; die ID setzen die Core-Templates. Eine Doors-Änderung setzt oft eine Core-Änderung voraus - dann Core zuerst bauen/veröffentlichen.
- **Loot:** große Türen droppen nur am Ursprungsblock (`x=0,y=0,z=0`); ab 26.3 Loot-Tabellen in beiden Formaten (`block_state_property`/`conditions` und `match_block`/`condition`). Behutsamkeit (große Birkentür) nur im Prädikat-Format `"predicates": { "minecraft:enchantments": [..] }`.
- **Modelle:** UVs nur 0 - 16 (ab 26.1 sonst verworfen, große Fallgitter-Tür), keine Flächen mit `#missing`. Fehler stehen nur im Client-Log.
- **Klick-Ergebnisse** ab 1.21.2 und Wasser/Eimer an Mehrblöcken regelt Core (siehe Core-CLAUDE.md); Doors-Fehler in diesen Bereichen meist dort beheben.
- 26.3: `isViewBlocking`-Lambda mit 4 Parametern, kein Block-`codec()`.
- Rezept-JSON ab 1.21.2: Custom-Ingredients über `"neoforge:ingredient_type"`, Vanilla-Ingredients als String ([`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 3).

## Testen

- Allgemein: [`../Docs/testing/README.md`](../Docs/testing/README.md). Doors immer mit dem passenden Core- und RecipesLibrary-Jar in Server-Pack und Client-Instanz.
- Prüfpunkte: große Tür setzen/öffnen/abbauen (ein Drop), Explosion, Redstone-Schlüssel, End-Tür-Renderer, Spieler-Sensor, Tischsägen-Rezepte und JEI, Rezepte mit `recipes_lib:components` (gefärbte Dielen).
- Server-Smoke `Docs/testing/tools/neoforge_smoke_all.sh` setzt eine `big_door_acacia` und prüft, dass Wasser sie nicht entfernt; RCON-Loot-Test: `setblock` + `loot spawn .. mine ..` (Nicht-Ursprungsteil → 0 Drops, Ursprung → 1).

## Links

- Wiki: https://github.com/GeheimagentNr1/ManyIdeasDoors/wiki
- CurseForge: https://www.curseforge.com/minecraft/mc-mods/many-ideas-doors, Modrinth: https://modrinth.com/mod/B4U5vxjd
- [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md), [`../Docs/migrations/BREAKING_CHANGES.md`](../Docs/migrations/BREAKING_CHANGES.md)
