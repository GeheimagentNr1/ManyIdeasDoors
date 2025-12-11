package de.geheimagentnr1.manyideas_doors.elements.blocks;

import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.mangrove.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialPoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialPortcullis;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntity;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntityRenderer;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.warped.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.MiniLodgePoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorEntity;
import de.geheimagentnr1.manyideas_core.core.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryEntry;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryHelper;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "unused" } )
public class ModBlocksRegisterFactory extends BlocksRegisterFactory {
	
	
	@NotNull
	@Override
	protected String getModId() {
		
		return ManyIdeasDoors.MODID;
	}
	
	//TODO:
	// B - Block Textur fertig
	// C - Cullface korrekt
	// P - Partikel fertig
	// F - Funktion fertig
	// I - Item fertig
	// N - Name und Registierungsname vorhanden und fertig
	// R - Rezept fertig
	// L - Loottable fertig
	// T - Tags fertig
	
	//Big Doors
	
	//Big Doors: Metal
	
	public static BigDoorArt BIG_DOOR_ART;
	
	public static BigDoorDwarf BIG_DOOR_DWARF;
	
	public static BigDoorFactory BIG_DOOR_FACTORY;
	
	public static BigDoorFrench BIG_DOOR_FRENCH;
	
	public static BigDoorGlass BIG_DOOR_GLASS;
	
	public static BigDoorLaboratory BIG_DOOR_LABORATORY;
	
	public static BigDoorPipe BIG_DOOR_PIPE;
	
	public static BigDoorPortcullis BIG_DOOR_PORTCULLIS;
	
	public static BigDoorSafe BIG_DOOR_SAFE;
	
	public static BigDoorTerrace BIG_DOOR_TERRACE;
	
	//Big Doors: Wooden
	
	public static BigDoorAcacia BIG_DOOR_ACACIA;
	
	public static BigDoorBarn BIG_DOOR_BARN;
	
	public static BigDoorBirch BIG_DOOR_BIRCH;
	
	public static BigDoorCrimson BIG_DOOR_CRIMSON;
	
	public static BigDoorDarkOak BIG_DOOR_DARK_OAK;
	
	public static BigDoorDarsser BIG_DOOR_DARSSER;
	
	public static BigDoorFairyTale BIG_DOOR_FAIRY_TALE;
	
	public static BigDoorJungle BIG_DOOR_JUNGLE;
	
	public static BigDoorMangrove BIG_DOOR_MANGROVE;
	
	public static BigDoorOak BIG_DOOR_OAK;
	
	public static BigDoorShip BIG_DOOR_SHIP;
	
	public static BigDoorShiro BIG_DOOR_SHIRO;
	
	public static BigDoorSpruce BIG_DOOR_SPRUCE;
	
	public static BigDoorWarped BIG_DOOR_WARPED;
	
	//Doors: Acacia
	
	public static DoorAcaciaBlank DOOR_ACACIA_BLANK;
	
	public static DoorAcaciaBookshelf DOOR_ACACIA_BOOKSHELF;
	
	public static DoorAcaciaCassette DOOR_ACACIA_CASSETTE;
	
	public static DoorAcaciaFrench DOOR_ACACIA_FRENCH;
	
	public static DoorAcaciaFrosted DOOR_ACACIA_FROSTED;
	
	public static DoorAcaciaGlass DOOR_ACACIA_GLASS;
	
	public static DoorAcaciaHeart DOOR_ACACIA_HEART;
	
	public static DoorAcaciaOrigin DOOR_ACACIA_ORIGIN;
	
	public static DoorAcaciaRustic DOOR_ACACIA_RUSTIC;
	
	public static DoorAcaciaShoji DOOR_ACACIA_SHOJI;
	
	//Doors: Birch
	
	public static DoorBirchBlank DOOR_BIRCH_BLANK;
	
	public static DoorBirchBookshelf DOOR_BIRCH_BOOKSHELF;
	
	public static DoorBirchCassette DOOR_BIRCH_CASSETTE;
	
	public static DoorBirchFrench DOOR_BIRCH_FRENCH;
	
	public static DoorBirchFrosted DOOR_BIRCH_FROSTED;
	
	public static DoorBirchGlass DOOR_BIRCH_GLASS;
	
	public static DoorBirchHeart DOOR_BIRCH_HEART;
	
	public static DoorBirchOrigin DOOR_BIRCH_ORIGIN;
	
	public static DoorBirchRustic DOOR_BIRCH_RUSTIC;
	
	public static DoorBirchShoji DOOR_BIRCH_SHOJI;
	
	//Doors: Crimson
	
	public static DoorCrimsonBlank DOOR_CRIMSON_BLANK;
	
	public static DoorCrimsonBookshelf DOOR_CRIMSON_BOOKSHELF;
	
	public static DoorCrimsonCassette DOOR_CRIMSON_CASSETTE;
	
	public static DoorCrimsonFrench DOOR_CRIMSON_FRENCH;
	
	public static DoorCrimsonFrosted DOOR_CRIMSON_FROSTED;
	
	public static DoorCrimsonGlass DOOR_CRIMSON_GLASS;
	
	public static DoorCrimsonHeart DOOR_CRIMSON_HEART;
	
	public static DoorCrimsonOrigin DOOR_CRIMSON_ORIGIN;
	
	public static DoorCrimsonRustic DOOR_CRIMSON_RUSTIC;
	
	public static DoorCrimsonShoji DOOR_CRIMSON_SHOJI;
	
	//Doors: Copper
	
	public static DoorCopperBar DOOR_COPPER_BAR;
	
	public static DoorCopperBarrel DOOR_COPPER_BARREL;
	
	public static DoorCopperBrick DOOR_COPPER_BRICK;
	
	public static DoorCopperCorrugated DOOR_COPPER_CORRUGATED;
	
	public static DoorCopperFactory DOOR_COPPER_FACTORY;
	
	public static DoorCopperGlass DOOR_COPPER_GLASS;
	
	public static DoorCopperModern DOOR_COPPER_MODERN;
	
	public static DoorCopperSmoothSandstone DOOR_COPPER_SMOOTH_SANDSTONE;
	
	public static DoorCopperShip DOOR_COPPER_SHIP;
	
	public static DoorCopperSteampunk DOOR_COPPER_STEAMPUNK;
	
	//Doors: Dark Oak
	
	public static DoorDarkOakBlank DOOR_DARK_OAK_BLANK;
	
	public static DoorDarkOakBookshelf DOOR_DARK_OAK_BOOKSHELF;
	
	public static DoorDarkOakCassette DOOR_DARK_OAK_CASSETTE;
	
	public static DoorDarkOakFrench DOOR_DARK_OAK_FRENCH;
	
	public static DoorDarkOakFrosted DOOR_DARK_OAK_FROSTED;
	
	public static DoorDarkOakGlass DOOR_DARK_OAK_GLASS;
	
	public static DoorDarkOakHeart DOOR_DARK_OAK_HEART;
	
	public static DoorDarkOakOrigin DOOR_DARK_OAK_ORIGIN;
	
	public static DoorDarkOakRustic DOOR_DARK_OAK_RUSTIC;
	
	public static DoorDarkOakShoji DOOR_DARK_OAK_SHOJI;
	
	//Doors: Iron
	
	public static DoorIronBookshelf DOOR_IRON_BOOKSHELF;
	
	public static DoorIronDwarf DOOR_IRON_DWARF;
	
	public static DoorIronFantasy DOOR_IRON_FANTASY;
	
	public static DoorIronGlass DOOR_IRON_GLASS;
	
	public static DoorIronLaboratory DOOR_IRON_LABORATORY;
	
	public static DoorIronRusted DOOR_IRON_RUSTED;
	
	public static DoorIronSafe DOOR_IRON_SAFE;
	
	public static DoorIronShip DOOR_IRON_SHIP;
	
	public static DoorIronSpace DOOR_IRON_SPACE;
	
	public static DoorIronStoneBrick DOOR_IRON_STONE_BRICK;
	
	//Doors: Jungle
	
	public static DoorJungleBlank DOOR_JUNGLE_BLANK;
	
	public static DoorJungleBookshelf DOOR_JUNGLE_BOOKSHELF;
	
	public static DoorJungleCassette DOOR_JUNGLE_CASSETTE;
	
	public static DoorJungleFrench DOOR_JUNGLE_FRENCH;
	
	public static DoorJungleFrosted DOOR_JUNGLE_FROSTED;
	
	public static DoorJungleGlass DOOR_JUNGLE_GLASS;
	
	public static DoorJungleHeart DOOR_JUNGLE_HEART;
	
	public static DoorJungleOrigin DOOR_JUNGLE_ORIGIN;
	
	public static DoorJungleRustic DOOR_JUNGLE_RUSTIC;
	
	public static DoorJungleShoji DOOR_JUNGLE_SHOJI;
	
	//Doors: Mangrove
	
	public static DoorMangroveBlank DOOR_MANGROVE_BLANK;
	
	public static DoorMangroveBookshelf DOOR_MANGROVE_BOOKSHELF;
	
	public static DoorMangroveCassette DOOR_MANGROVE_CASSETTE;
	
	public static DoorMangroveFrench DOOR_MANGROVE_FRENCH;
	
	public static DoorMangroveFrosted DOOR_MANGROVE_FROSTED;
	
	public static DoorMangroveGlass DOOR_MANGROVE_GLASS;
	
	public static DoorMangroveHeart DOOR_MANGROVE_HEART;
	
	public static DoorMangroveOrigin DOOR_MANGROVE_ORIGIN;
	
	public static DoorMangroveRustic DOOR_MANGROVE_RUSTIC;
	
	public static DoorMangroveShoji DOOR_MANGROVE_SHOJI;
	
	//Doors: Oak
	
	public static DoorOakBlank DOOR_OAK_BLANK;
	
	public static DoorOakBookshelf DOOR_OAK_BOOKSHELF;
	
	public static DoorOakCassette DOOR_OAK_CASSETTE;
	
	public static DoorOakFrench DOOR_OAK_FRENCH;
	
	public static DoorOakFrosted DOOR_OAK_FROSTED;
	
	public static DoorOakGlass DOOR_OAK_GLASS;
	
	public static DoorOakHeart DOOR_OAK_HEART;
	
	public static DoorOakOrigin DOOR_OAK_ORIGIN;
	
	public static DoorOakRustic DOOR_OAK_RUSTIC;
	
	public static DoorOakShoji DOOR_OAK_SHOJI;
	
	//Doors: Special
	
	public static DoorSpecialPoliceBox DOOR_SPECIAL_POLICE_BOX;
	
	public static DoorSpecialPortcullis DOOR_SPECIAL_PORTCULLIS;
	
	//Special: End Door
	
	public static DoorSpecialEnd DOOR_SPECIAL_END;
	
	public static BlockEntityType<DoorSpecialEndEntity> DOOR_SPECIAL_END_ENTITY;
	
	//Doors: Spruce
	
	public static DoorSpruceBlank DOOR_SPRUCE_BLANK;
	
	public static DoorSpruceBookshelf DOOR_SPRUCE_BOOKSHELF;
	
	public static DoorSpruceCassette DOOR_SPRUCE_CASSETTE;
	
	public static DoorSpruceFrench DOOR_SPRUCE_FRENCH;
	
	public static DoorSpruceFrosted DOOR_SPRUCE_FROSTED;
	
	public static DoorSpruceGlass DOOR_SPRUCE_GLASS;
	
	public static DoorSpruceHeart DOOR_SPRUCE_HEART;
	
	public static DoorSpruceOrigin DOOR_SPRUCE_ORIGIN;
	
	public static DoorSpruceRustic DOOR_SPRUCE_RUSTIC;
	
	public static DoorSpruceShoji DOOR_SPRUCE_SHOJI;
	
	//Doors: Warped
	
	public static DoorWarpedBlank DOOR_WARPED_BLANK;
	
	public static DoorWarpedBookshelf DOOR_WARPED_BOOKSHELF;
	
	public static DoorWarpedCassette DOOR_WARPED_CASSETTE;
	
	public static DoorWarpedFrench DOOR_WARPED_FRENCH;
	
	public static DoorWarpedFrosted DOOR_WARPED_FROSTED;
	
	public static DoorWarpedGlass DOOR_WARPED_GLASS;
	
	public static DoorWarpedHeart DOOR_WARPED_HEART;
	
	public static DoorWarpedOrigin DOOR_WARPED_ORIGIN;
	
	public static DoorWarpedRustic DOOR_WARPED_RUSTIC;
	
	public static DoorWarpedShoji DOOR_WARPED_SHOJI;
	
	//Mini Lodges
	
	public static MiniLodgePoliceBox MINI_LODGE_POLICE_BOX;
	
	//Mini Lodges: Outhouses
	
	public static MiniLodgeOuthouseAcacia MINI_LODGE_OUTHOUSE_ACACIA;
	
	public static MiniLodgeOuthouseBirch MINI_LODGE_OUTHOUSE_BIRCH;
	
	public static MiniLodgeOuthouseCrimson MINI_LODGE_OUTHOUSE_CRIMSON;
	
	public static MiniLodgeOuthouseDarkOak MINI_LODGE_OUTHOUSE_DARK_OAK;
	
	public static MiniLodgeOuthouseJungle MINI_LODGE_OUTHOUSE_JUNGLE;
	
	public static MiniLodgeOuthouseMangrove MINI_LODGE_OUTHOUSE_MANGROVE;
	
	public static MiniLodgeOuthouseOak MINI_LODGE_OUTHOUSE_OAK;
	
	public static MiniLodgeOuthouseSpruce MINI_LODGE_OUTHOUSE_SPRUCE;
	
	public static MiniLodgeOuthouseWarped MINI_LODGE_OUTHOUSE_WARPED;
	
	//Player Door Sensor
	
	public static PlayerDoorSensor PLAYER_DOOR_SENSOR;
	
	public static BlockEntityType<PlayerDoorSensorEntity> PLAYER_DOOR_SENSOR_ENTITY;
	
	@NotNull
	@Override
	protected List<RegistryEntry<Block>> blocks() {
		
		return List.<RegistryEntry<Block>> of(//BCPFINRLT
			//Big Doors: Metal
			RegistryEntry.create( BigDoorArt.registry_name, new BigDoorArt() ),//BCPFINRLT
			RegistryEntry.create( BigDoorDwarf.registry_name, new BigDoorDwarf() ),//BCPFINRLT
			RegistryEntry.create( BigDoorFactory.registry_name, new BigDoorFactory() ),//BCPFINRLT
			RegistryEntry.create( BigDoorFrench.registry_name, new BigDoorFrench() ),//BCPFINRLT
			RegistryEntry.create( BigDoorGlass.registry_name, new BigDoorGlass() ),//BCPFINRLT
			RegistryEntry.create( BigDoorLaboratory.registry_name, new BigDoorLaboratory() ),//BCPFINRLT
			RegistryEntry.create( BigDoorPipe.registry_name, new BigDoorPipe() ),//BCPFINRLT
			RegistryEntry.create( BigDoorPortcullis.registry_name, new BigDoorPortcullis() ),//BCPFINRLT
			RegistryEntry.create( BigDoorSafe.registry_name, new BigDoorSafe() ),//BCPFINRLT
			RegistryEntry.create( BigDoorTerrace.registry_name, new BigDoorTerrace() ),//BCPFINRLT
			//Big Doors: Wooden
			RegistryEntry.create( BigDoorAcacia.registry_name, new BigDoorAcacia() ),//BCPFINRL
			RegistryEntry.create( BigDoorBarn.registry_name, new BigDoorBarn() ),//BCPFINRLT
			RegistryEntry.create( BigDoorBirch.registry_name, new BigDoorBirch() ),//BCPFINRLT
			RegistryEntry.create( BigDoorCrimson.registry_name, new BigDoorCrimson() ),//BCPFINRLT
			RegistryEntry.create( BigDoorDarkOak.registry_name, new BigDoorDarkOak() ),//BCPFINRLT
			RegistryEntry.create( BigDoorDarsser.registry_name, new BigDoorDarsser() ),//BCPFINRL
			RegistryEntry.create( BigDoorFairyTale.registry_name, new BigDoorFairyTale() ),//BCPFINRLT
			RegistryEntry.create( BigDoorJungle.registry_name, new BigDoorJungle() ),//BCPFINRLT
			RegistryEntry.create( BigDoorMangrove.registry_name, new BigDoorMangrove() ),//BCPFINRLT
			RegistryEntry.create( BigDoorOak.registry_name, new BigDoorOak() ),//BCPFINRLT
			RegistryEntry.create( BigDoorShip.registry_name, new BigDoorShip() ),//BCPFINRLT
			RegistryEntry.create( BigDoorShiro.registry_name, new BigDoorShiro() ),//BCPFINRL
			RegistryEntry.create( BigDoorSpruce.registry_name, new BigDoorSpruce() ),//BCPFINRLT
			RegistryEntry.create( BigDoorWarped.registry_name, new BigDoorWarped() ),//BCPFINRLT
			//Doors: Acacia
			RegistryEntry.create( DoorAcaciaBlank.registry_name, new DoorAcaciaBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaBookshelf.registry_name, new DoorAcaciaBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaCassette.registry_name, new DoorAcaciaCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaFrench.registry_name, new DoorAcaciaFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaFrosted.registry_name, new DoorAcaciaFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaGlass.registry_name, new DoorAcaciaGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaHeart.registry_name, new DoorAcaciaHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaOrigin.registry_name, new DoorAcaciaOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaRustic.registry_name, new DoorAcaciaRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorAcaciaShoji.registry_name, new DoorAcaciaShoji() ),//BCPFINRLT
			//Doors: Birch
			RegistryEntry.create( DoorBirchBlank.registry_name, new DoorBirchBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchBookshelf.registry_name, new DoorBirchBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchCassette.registry_name, new DoorBirchCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchFrench.registry_name, new DoorBirchFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchFrosted.registry_name, new DoorBirchFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchGlass.registry_name, new DoorBirchGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchHeart.registry_name, new DoorBirchHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchOrigin.registry_name, new DoorBirchOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchRustic.registry_name, new DoorBirchRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorBirchShoji.registry_name, new DoorBirchShoji() ),//BCPFINRLT
			//Doors: Copper
			RegistryEntry.create( DoorCopperBar.registry_name, new DoorCopperBar() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperBarrel.registry_name, new DoorCopperBarrel() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperBrick.registry_name, new DoorCopperBrick() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperCorrugated.registry_name, new DoorCopperCorrugated() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperFactory.registry_name, new DoorCopperFactory() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperGlass.registry_name, new DoorCopperGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperModern.registry_name, new DoorCopperModern() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperSmoothSandstone.registry_name, new DoorCopperSmoothSandstone() ),
			//BCPFINRLT
			RegistryEntry.create( DoorCopperShip.registry_name, new DoorCopperShip() ),//BCPFINRLT
			RegistryEntry.create( DoorCopperSteampunk.registry_name, new DoorCopperSteampunk() ),//BCPFINRLT
			//Doors: Crimson
			RegistryEntry.create( DoorCrimsonBlank.registry_name, new DoorCrimsonBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonBookshelf.registry_name, new DoorCrimsonBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonCassette.registry_name, new DoorCrimsonCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonFrench.registry_name, new DoorCrimsonFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonFrosted.registry_name, new DoorCrimsonFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonGlass.registry_name, new DoorCrimsonGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonHeart.registry_name, new DoorCrimsonHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonOrigin.registry_name, new DoorCrimsonOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonRustic.registry_name, new DoorCrimsonRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorCrimsonShoji.registry_name, new DoorCrimsonShoji() ),//BCPFINRLT
			//Doors: Dark Oak
			RegistryEntry.create( DoorDarkOakBlank.registry_name, new DoorDarkOakBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakBookshelf.registry_name, new DoorDarkOakBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakCassette.registry_name, new DoorDarkOakCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakFrench.registry_name, new DoorDarkOakFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakFrosted.registry_name, new DoorDarkOakFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakGlass.registry_name, new DoorDarkOakGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakHeart.registry_name, new DoorDarkOakHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakOrigin.registry_name, new DoorDarkOakOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakRustic.registry_name, new DoorDarkOakRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorDarkOakShoji.registry_name, new DoorDarkOakShoji() ),//BCPFINRLT
			//Doors: Iron
			RegistryEntry.create( DoorIronBookshelf.registry_name, new DoorIronBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorIronDwarf.registry_name, new DoorIronDwarf() ),//BCPFINRLT
			RegistryEntry.create( DoorIronFantasy.registry_name, new DoorIronFantasy() ),//BCPFINRLT
			RegistryEntry.create( DoorIronGlass.registry_name, new DoorIronGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorIronLaboratory.registry_name, new DoorIronLaboratory() ),//BCPFINRLT
			RegistryEntry.create( DoorIronRusted.registry_name, new DoorIronRusted() ),//BCPFINRLT
			RegistryEntry.create( DoorIronSafe.registry_name, new DoorIronSafe() ),//BCPFINRLT
			RegistryEntry.create( DoorIronShip.registry_name, new DoorIronShip() ),//BCPFINRLT
			RegistryEntry.create( DoorIronSpace.registry_name, new DoorIronSpace() ),//BCPFINRLT
			RegistryEntry.create( DoorIronStoneBrick.registry_name, new DoorIronStoneBrick() ),//BCPFINRLT
			//Doors: Jungle
			RegistryEntry.create( DoorJungleBlank.registry_name, new DoorJungleBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleBookshelf.registry_name, new DoorJungleBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleCassette.registry_name, new DoorJungleCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleFrench.registry_name, new DoorJungleFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleFrosted.registry_name, new DoorJungleFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleGlass.registry_name, new DoorJungleGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleHeart.registry_name, new DoorJungleHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleOrigin.registry_name, new DoorJungleOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleRustic.registry_name, new DoorJungleRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorJungleShoji.registry_name, new DoorJungleShoji() ),//BCPFINRLT
			//Doors: Mangrove
			RegistryEntry.create( DoorMangroveBlank.registry_name, new DoorMangroveBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveBookshelf.registry_name, new DoorMangroveBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveCassette.registry_name, new DoorMangroveCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveFrench.registry_name, new DoorMangroveFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveFrosted.registry_name, new DoorMangroveFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveGlass.registry_name, new DoorMangroveGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveHeart.registry_name, new DoorMangroveHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveOrigin.registry_name, new DoorMangroveOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveRustic.registry_name, new DoorMangroveRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorMangroveShoji.registry_name, new DoorMangroveShoji() ),//BCPFINRLT
			//Doors: Oak
			RegistryEntry.create( DoorOakBlank.registry_name, new DoorOakBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorOakBookshelf.registry_name, new DoorOakBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorOakCassette.registry_name, new DoorOakCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorOakFrench.registry_name, new DoorOakFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorOakFrosted.registry_name, new DoorOakFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorOakGlass.registry_name, new DoorOakGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorOakHeart.registry_name, new DoorOakHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorOakOrigin.registry_name, DOOR_OAK_ORIGIN = new DoorOakOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorOakRustic.registry_name, new DoorOakRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorOakShoji.registry_name, new DoorOakShoji() ),//BCPFINRLT
			//Doors: Special
			RegistryEntry.create( DoorSpecialPoliceBox.registry_name, new DoorSpecialPoliceBox() ),//BCPFINRLT
			RegistryEntry.create( DoorSpecialPortcullis.registry_name, new DoorSpecialPortcullis() ),//BCPFINRLT
			//Doors: Special: End Door
			RegistryEntry.create( DoorSpecialEnd.registry_name, DOOR_SPECIAL_END = new DoorSpecialEnd() ),//BCPFINRLT
			//Doors: Spruce
			RegistryEntry.create( DoorSpruceBlank.registry_name, new DoorSpruceBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceBookshelf.registry_name, new DoorSpruceBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceCassette.registry_name, new DoorSpruceCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceFrench.registry_name, new DoorSpruceFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceFrosted.registry_name, new DoorSpruceFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceGlass.registry_name, new DoorSpruceGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceHeart.registry_name, new DoorSpruceHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceOrigin.registry_name, new DoorSpruceOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceRustic.registry_name, new DoorSpruceRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorSpruceShoji.registry_name, new DoorSpruceShoji() ),//BCPFINRLT
			//Doors: Warped
			RegistryEntry.create( DoorWarpedBlank.registry_name, new DoorWarpedBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedBookshelf.registry_name, new DoorWarpedBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedCassette.registry_name, new DoorWarpedCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedFrench.registry_name, new DoorWarpedFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedFrosted.registry_name, new DoorWarpedFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedGlass.registry_name, new DoorWarpedGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedHeart.registry_name, new DoorWarpedHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedOrigin.registry_name, new DoorWarpedOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedRustic.registry_name, new DoorWarpedRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorWarpedShoji.registry_name, new DoorWarpedShoji() ),//BCPFINRLT
			//Mini Lodges
			RegistryEntry.create( MiniLodgePoliceBox.registry_name, new MiniLodgePoliceBox() ),//BCPFINRLT
			//Mini Lodges: Outhouses
			RegistryEntry.create( MiniLodgeOuthouseAcacia.registry_name, new MiniLodgeOuthouseAcacia() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseBirch.registry_name, new MiniLodgeOuthouseBirch() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseCrimson.registry_name, new MiniLodgeOuthouseCrimson() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseDarkOak.registry_name, new MiniLodgeOuthouseDarkOak() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseJungle.registry_name, new MiniLodgeOuthouseJungle() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseMangrove.registry_name, new MiniLodgeOuthouseMangrove() ),
			//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseOak.registry_name, new MiniLodgeOuthouseOak() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseSpruce.registry_name, new MiniLodgeOuthouseSpruce() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseWarped.registry_name, new MiniLodgeOuthouseWarped() ),//BCPFINRLT
			//Player Door Sensor
			RegistryEntry.create( PlayerDoorSensor.registry_name, PLAYER_DOOR_SENSOR = new PlayerDoorSensor() )//BCPFINRLT
		);
	}
	
	@NotNull
	@Override
	protected List<RegistryEntry<BlockEntityType<?>>> blockEntityTypes() {
		
		DOOR_SPECIAL_END_ENTITY = RegistryHelper.buildBlockEntity(
			DoorSpecialEnd.registry_name,
			DoorSpecialEndEntity::new,
			DOOR_SPECIAL_END
		);
		PLAYER_DOOR_SENSOR_ENTITY = RegistryHelper.buildBlockEntity(
			PlayerDoorSensor.registry_name,
			PlayerDoorSensorEntity::new,
			PLAYER_DOOR_SENSOR
		);
		return List.of(
			RegistryEntry.create( DoorSpecialEnd.registry_name, DOOR_SPECIAL_END_ENTITY ),
			RegistryEntry.create( PlayerDoorSensor.registry_name, PLAYER_DOOR_SENSOR_ENTITY )
		);
	}
	
	@SubscribeEvent
	public void handleRegisterEvent( @NotNull RegisterEvent event ) {
		
		doRegisterEvent( event );
	}
	
	@SubscribeEvent
	@Override
	public void handleFMLClientSetupEvent( @NotNull FMLClientSetupEvent event ) {
		
		BlockEntityRenderers.register( DOOR_SPECIAL_END_ENTITY, DoorSpecialEndEntityRenderer::new );
	}
}
