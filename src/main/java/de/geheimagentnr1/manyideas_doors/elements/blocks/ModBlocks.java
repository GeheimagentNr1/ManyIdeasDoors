package de.geheimagentnr1.manyideas_doors.elements.blocks;

import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialPoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialPortcullis;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.warped.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.MiniLodgePoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorTile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "PublicStaticArrayField", "unused" } )
public class ModBlocks {
	
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
	
	public static final Block[] BLOCKS = new Block[] {//BCPFINRLT
		//Big Doors : Metal
		new BigDoorDwarf(),//BCPFINRLT
		new BigDoorFactory(),//BCPFINRLT
		new BigDoorLaboratory(),//BCPFINRLT
		new BigDoorPortcullis(),//BCPFINRLT
		new BigDoorSafe(),//BCPFINRLT
		new BigDoorTerrace(),//BCPFINRLT
		//Big Doors : Wooden
		new BigDoorAcacia(),//BCPFINRL
		new BigDoorBarn(),//BCPFINRLT
		new BigDoorBirch(),//BCPFINRLT
		new BigDoorCrimson(),//BCPFINRLT
		new BigDoorDarkOak(),//BCPFINRLT
		new BigDoorDarsser(),//BCPFINRL
		new BigDoorJungle(),//BCPFINRLT
		new BigDoorOak(),//BCPFINRLT
		new BigDoorShiro(),//BCPFINRL
		new BigDoorSpruce(),//BCPFINRLT
		new BigDoorWarped(),//BCPFINRLT
		//Doors: Acacia
		new DoorAcaciaBlank(),//BCPFINRLT
		new DoorAcaciaBookshelf(),//BCPFINRLT
		new DoorAcaciaCassette(),//BCPFINRLT
		new DoorAcaciaFrench(),//BCPFINRLT
		new DoorAcaciaFrosted(),//BCPFINRLT
		new DoorAcaciaGlass(),//BCPFINRLT
		new DoorAcaciaHeart(),//BCPFINRLT
		new DoorAcaciaOrigin(),//BCPFINRLT
		new DoorAcaciaRustic(),//BCPFINRLT
		new DoorAcaciaShoji(),//BCPFINRLT
		//Doors: Birch
		new DoorBirchBlank(),//BCPFINRLT
		new DoorBirchBookshelf(),//BCPFINRLT
		new DoorBirchCassette(),//BCPFINRLT
		new DoorBirchFrench(),//BCPFINRLT
		new DoorBirchFrosted(),//BCPFINRLT
		new DoorBirchGlass(),//BCPFINRLT
		new DoorBirchHeart(),//BCPFINRLT
		new DoorBirchOrigin(),//BCPFINRLT
		new DoorBirchRustic(),//BCPFINRLT
		new DoorBirchShoji(),//BCPFINRLT
		//Doors: Crimson
		new DoorCrimsonBlank(),//BCPFINRLT
		new DoorCrimsonBookshelf(),//BCPFINRLT
		new DoorCrimsonCassette(),//BCPFINRLT
		new DoorCrimsonFrench(),//BCPFINRLT
		new DoorCrimsonFrosted(),//BCPFINRLT
		new DoorCrimsonGlass(),//BCPFINRLT
		new DoorCrimsonHeart(),//BCPFINRLT
		new DoorCrimsonOrigin(),//BCPFINRLT
		new DoorCrimsonRustic(),//BCPFINRLT
		new DoorCrimsonShoji(),//BCPFINRLT
		//Doors: Dark Oak
		new DoorDarkOakBlank(),//BCPFINRLT
		new DoorDarkOakBookshelf(),//BCPFINRLT
		new DoorDarkOakCassette(),//BCPFINRLT
		new DoorDarkOakFrench(),//BCPFINRLT
		new DoorDarkOakFrosted(),//BCPFINRLT
		new DoorDarkOakGlass(),//BCPFINRLT
		new DoorDarkOakHeart(),//BCPFINRLT
		new DoorDarkOakOrigin(),//BCPFINRLT
		new DoorDarkOakRustic(),//BCPFINRLT
		new DoorDarkOakShoji(),//BCPFINRLT
		//Doors: Iron
		new DoorIronBookshelf(),//BCPFINRLT
		new DoorIronDwarf(),//BCPFINRLT
		new DoorIronFantasy(),//BCPFINRLT
		new DoorIronGlass(),//BCPFINRLT
		new DoorIronLaboratory(),//BCPFINRLT
		new DoorIronRusted(),//BCPFINRLT
		new DoorIronSafe(),//BCPFINRLT
		new DoorIronShip(),//BCPFINRLT
		new DoorIronSpace(),//BCPFINRLT
		new DoorIronStoneBrick(),//BCPFINRLT
		//Doors: Jungle
		new DoorJungleBlank(),//BCPFINRLT
		new DoorJungleBookshelf(),//BCPFINRLT
		new DoorJungleCassette(),//BCPFINRLT
		new DoorJungleFrench(),//BCPFINRLT
		new DoorJungleFrosted(),//BCPFINRLT
		new DoorJungleGlass(),//BCPFINRLT
		new DoorJungleHeart(),//BCPFINRLT
		new DoorJungleOrigin(),//BCPFINRLT
		new DoorJungleRustic(),//BCPFINRLT
		new DoorJungleShoji(),//BCPFINRLT
		//Doors: Oak
		new DoorOakBlank(),//BCPFINRLT
		new DoorOakBookshelf(),//BCPFINRLT
		new DoorOakCassette(),//BCPFINRLT
		new DoorOakFrench(),//BCPFINRLT
		new DoorOakFrosted(),//BCPFINRLT
		new DoorOakGlass(),//BCPFINRLT
		new DoorOakHeart(),//BCPFINRLT
		new DoorOakOrigin(),//BCPFINRLT
		new DoorOakRustic(),//BCPFINRLT
		new DoorOakShoji(),//BCPFINRLT
		//Doors: Special
		new DoorSpecialPoliceBox(),//BCPFINRLT
		new DoorSpecialPortcullis(),//BCPFINRLT
		//Doors: Special: End Door
		new DoorSpecialEnd(),//BCPFINRLT
		//Doors: Spruce
		new DoorSpruceBlank(),//BCPFINRLT
		new DoorSpruceBookshelf(),//BCPFINRLT
		new DoorSpruceCassette(),//BCPFINRLT
		new DoorSpruceFrench(),//BCPFINRLT
		new DoorSpruceFrosted(),//BCPFINRLT
		new DoorSpruceGlass(),//BCPFINRLT
		new DoorSpruceHeart(),//BCPFINRLT
		new DoorSpruceOrigin(),//BCPFINRLT
		new DoorSpruceRustic(),//BCPFINRLT
		new DoorSpruceShoji(),//BCPFINRLT
		//Doors: Warped
		new DoorWarpedBlank(),//BCPFINRLT
		new DoorWarpedBookshelf(),//BCPFINRLT
		new DoorWarpedCassette(),//BCPFINRLT
		new DoorWarpedFrench(),//BCPFINRLT
		new DoorWarpedFrosted(),//BCPFINRLT
		new DoorWarpedGlass(),//BCPFINRLT
		new DoorWarpedHeart(),//BCPFINRLT
		new DoorWarpedOrigin(),//BCPFINRLT
		new DoorWarpedRustic(),//BCPFINRLT
		new DoorWarpedShoji(),//BCPFINRLT
		//Mini Lodges
		new MiniLodgePoliceBox(),//BCPFINRLT
		//Mini Lodges: Outhouses
		new MiniLodgeOuthouseAcacia(),//BCPFINRLT
		new MiniLodgeOuthouseBirch(),//BCPFINRLT
		new MiniLodgeOuthouseDarkOak(),//BCPFINRLT
		new MiniLodgeOuthouseJungle(),//BCPFINRLT
		new MiniLodgeOuthouseOak(),//BCPFINRLT
		new MiniLodgeOuthouseSpruce(),//BCPFINRLT
		//Player Door Sensor
		new PlayerDoorSensor(),//BCPFINRLT
	};
	
	//Big Doors
	
	//Big Doors: Metal
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorDwarf.registry_name )
	public static BigDoorDwarf BIG_DOOR_DWARF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorFactory.registry_name )
	public static BigDoorFactory BIG_DOOR_FACTORY;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorLaboratory.registry_name )
	public static BigDoorLaboratory BIG_DOOR_LABORATORY;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorPortcullis.registry_name )
	public static BigDoorPortcullis BIG_DOOR_PORTCULLIS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorSafe.registry_name )
	public static BigDoorSafe BIG_DOOR_SAFE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorTerrace.registry_name )
	public static BigDoorTerrace BIG_DOOR_TERRACE;
	
	//Big Doors: Wooden
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorAcacia.registry_name )
	public static BigDoorAcacia BIG_DOOR_ACACIA;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorBarn.registry_name )
	public static BigDoorBarn BIG_DOOR_BARN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorBirch.registry_name )
	public static BigDoorBirch BIG_DOOR_BIRCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorCrimson.registry_name )
	public static BigDoorCrimson BIG_DOOR_CRIMSON;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorDarkOak.registry_name )
	public static BigDoorDarkOak BIG_DOOR_DARK_OAK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorDarsser.registry_name )
	public static BigDoorDarsser BIG_DOOR_DARSSER;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorJungle.registry_name )
	public static BigDoorJungle BIG_DOOR_JUNGLE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorOak.registry_name )
	public static BigDoorOak BIG_DOOR_OAK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorShiro.registry_name )
	public static BigDoorShiro BIG_DOOR_SHIRO;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorSpruce.registry_name )
	public static BigDoorSpruce BIG_DOOR_SPRUCE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + BigDoorWarped.registry_name )
	public static BigDoorWarped BIG_DOOR_WARPED;
	
	//Doors: Acacia
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaBlank.registry_name )
	public static DoorAcaciaBlank DOOR_ACACIA_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaBookshelf.registry_name )
	public static DoorAcaciaBookshelf DOOR_ACACIA_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaCassette.registry_name )
	public static DoorAcaciaCassette DOOR_ACACIA_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaFrench.registry_name )
	public static DoorAcaciaFrench DOOR_ACACIA_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaFrosted.registry_name )
	public static DoorAcaciaFrosted DOOR_ACACIA_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaGlass.registry_name )
	public static DoorAcaciaGlass DOOR_ACACIA_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaHeart.registry_name )
	public static DoorAcaciaHeart DOOR_ACACIA_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaOrigin.registry_name )
	public static DoorAcaciaOrigin DOOR_ACACIA_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaRustic.registry_name )
	public static DoorAcaciaRustic DOOR_ACACIA_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorAcaciaShoji.registry_name )
	public static DoorAcaciaShoji DOOR_ACACIA_SHOJI;
	
	//Doors: Birch
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchBlank.registry_name )
	public static DoorBirchBlank DOOR_BIRCH_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchBookshelf.registry_name )
	public static DoorBirchBookshelf DOOR_BIRCH_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchCassette.registry_name )
	public static DoorBirchCassette DOOR_BIRCH_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchFrench.registry_name )
	public static DoorBirchFrench DOOR_BIRCH_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchFrosted.registry_name )
	public static DoorBirchFrosted DOOR_BIRCH_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchGlass.registry_name )
	public static DoorBirchGlass DOOR_BIRCH_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchHeart.registry_name )
	public static DoorBirchHeart DOOR_BIRCH_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchOrigin.registry_name )
	public static DoorBirchOrigin DOOR_BIRCH_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchRustic.registry_name )
	public static DoorBirchRustic DOOR_BIRCH_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorBirchShoji.registry_name )
	public static DoorBirchShoji DOOR_BIRCH_SHOJI;
	
	//Doors: Crimson
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonBlank.registry_name )
	public static DoorCrimsonBlank DOOR_CRIMSON_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonBookshelf.registry_name )
	public static DoorCrimsonBookshelf DOOR_CRIMSON_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonCassette.registry_name )
	public static DoorCrimsonCassette DOOR_CRIMSON_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonFrench.registry_name )
	public static DoorCrimsonFrench DOOR_CRIMSON_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonFrosted.registry_name )
	public static DoorCrimsonFrosted DOOR_CRIMSON_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonGlass.registry_name )
	public static DoorCrimsonGlass DOOR_CRIMSON_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonHeart.registry_name )
	public static DoorCrimsonHeart DOOR_CRIMSON_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonOrigin.registry_name )
	public static DoorCrimsonOrigin DOOR_CRIMSON_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonRustic.registry_name )
	public static DoorCrimsonRustic DOOR_CRIMSON_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorCrimsonShoji.registry_name )
	public static DoorCrimsonShoji DOOR_CRIMSON_SHOJI;
	
	//Doors: Dark Oak
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakBlank.registry_name )
	public static DoorDarkOakBlank DOOR_DARK_OAK_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakBookshelf.registry_name )
	public static DoorDarkOakBookshelf DOOR_DARK_OAK_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakCassette.registry_name )
	public static DoorDarkOakCassette DOOR_DARK_OAK_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakFrench.registry_name )
	public static DoorDarkOakFrench DOOR_DARK_OAK_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakFrosted.registry_name )
	public static DoorDarkOakFrosted DOOR_DARK_OAK_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakGlass.registry_name )
	public static DoorDarkOakGlass DOOR_DARK_OAK_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakHeart.registry_name )
	public static DoorDarkOakHeart DOOR_DARK_OAK_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakOrigin.registry_name )
	public static DoorDarkOakOrigin DOOR_DARK_OAK_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakRustic.registry_name )
	public static DoorDarkOakRustic DOOR_DARK_OAK_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorDarkOakShoji.registry_name )
	public static DoorDarkOakShoji DOOR_DARK_OAK_SHOJI;
	
	//Doors: Iron
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronBookshelf.registry_name )
	public static DoorIronBookshelf DOOR_IRON_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronDwarf.registry_name )
	public static DoorIronDwarf DOOR_IRON_DWARF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronFantasy.registry_name )
	public static DoorIronFantasy DOOR_IRON_FANTASY;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronGlass.registry_name )
	public static DoorIronGlass DOOR_IRON_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronLaboratory.registry_name )
	public static DoorIronLaboratory DOOR_IRON_LABORATORY;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronRusted.registry_name )
	public static DoorIronRusted DOOR_IRON_RUSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronSafe.registry_name )
	public static DoorIronSafe DOOR_IRON_SAFE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronShip.registry_name )
	public static DoorIronShip DOOR_IRON_SHIP;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronSpace.registry_name )
	public static DoorIronSpace DOOR_IRON_SPACE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorIronStoneBrick.registry_name )
	public static DoorIronStoneBrick DOOR_IRON_STONE_BRICK;
	
	//Doors: Jungle
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleBlank.registry_name )
	public static DoorJungleBlank DOOR_JUNGLE_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleBookshelf.registry_name )
	public static DoorJungleBookshelf DOOR_JUNGLE_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleCassette.registry_name )
	public static DoorJungleCassette DOOR_JUNGLE_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleFrench.registry_name )
	public static DoorJungleFrench DOOR_JUNGLE_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleFrosted.registry_name )
	public static DoorJungleFrosted DOOR_JUNGLE_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleGlass.registry_name )
	public static DoorJungleGlass DOOR_JUNGLE_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleHeart.registry_name )
	public static DoorJungleHeart DOOR_JUNGLE_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleOrigin.registry_name )
	public static DoorJungleOrigin DOOR_JUNGLE_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleRustic.registry_name )
	public static DoorJungleRustic DOOR_JUNGLE_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorJungleShoji.registry_name )
	public static DoorJungleShoji DOOR_JUNGLE_SHOJI;
	
	//Doors: Oak
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakBlank.registry_name )
	public static DoorOakBlank DOOR_OAK_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakBookshelf.registry_name )
	public static DoorOakBookshelf DOOR_OAK_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakCassette.registry_name )
	public static DoorOakCassette DOOR_OAK_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakFrench.registry_name )
	public static DoorOakFrench DOOR_OAK_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakFrosted.registry_name )
	public static DoorOakFrosted DOOR_OAK_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakGlass.registry_name )
	public static DoorOakGlass DOOR_OAK_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakHeart.registry_name )
	public static DoorOakHeart DOOR_OAK_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakOrigin.registry_name )
	public static DoorOakOrigin DOOR_OAK_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakRustic.registry_name )
	public static DoorOakRustic DOOR_OAK_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorOakShoji.registry_name )
	public static DoorOakShoji DOOR_OAK_SHOJI;
	
	//Doors: Special
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialPoliceBox.registry_name )
	public static DoorSpecialPoliceBox DOOR_SPECIAL_POLICE_BOX;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialPortcullis.registry_name )
	public static DoorSpecialPortcullis DOOR_SPECIAL_PORTCULLIS;
	
	//Special: End Door
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialEnd.registry_name )
	public static DoorSpecialEnd DOOR_SPECIAL_END;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialEnd.registry_name )
	public static TileEntityType<DoorSpecialEndTile> DOOR_SPECIAL_END_TILE;
	
	//Doors: Spruce
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceBlank.registry_name )
	public static DoorSpruceBlank DOOR_SPRUCE_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceBookshelf.registry_name )
	public static DoorSpruceBookshelf DOOR_SPRUCE_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceCassette.registry_name )
	public static DoorSpruceCassette DOOR_SPRUCE_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceFrench.registry_name )
	public static DoorSpruceFrench DOOR_SPRUCE_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceFrosted.registry_name )
	public static DoorSpruceFrosted DOOR_SPRUCE_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceGlass.registry_name )
	public static DoorSpruceGlass DOOR_SPRUCE_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceHeart.registry_name )
	public static DoorSpruceHeart DOOR_SPRUCE_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceOrigin.registry_name )
	public static DoorSpruceOrigin DOOR_SPRUCE_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceRustic.registry_name )
	public static DoorSpruceRustic DOOR_SPRUCE_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpruceShoji.registry_name )
	public static DoorSpruceShoji DOOR_SPRUCE_SHOJI;
	
	//Doors: Warped
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedBlank.registry_name )
	public static DoorWarpedBlank DOOR_WARPED_BLANK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedBookshelf.registry_name )
	public static DoorWarpedBookshelf DOOR_WARPED_BOOKSHELF;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedCassette.registry_name )
	public static DoorWarpedCassette DOOR_WARPED_CASSETTE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedFrench.registry_name )
	public static DoorWarpedFrench DOOR_WARPED_FRENCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedFrosted.registry_name )
	public static DoorWarpedFrosted DOOR_WARPED_FROSTED;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedGlass.registry_name )
	public static DoorWarpedGlass DOOR_WARPED_GLASS;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedHeart.registry_name )
	public static DoorWarpedHeart DOOR_WARPED_HEART;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedOrigin.registry_name )
	public static DoorWarpedOrigin DOOR_WARPED_ORIGIN;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedRustic.registry_name )
	public static DoorWarpedRustic DOOR_WARPED_RUSTIC;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorWarpedShoji.registry_name )
	public static DoorWarpedShoji DOOR_WARPED_SHOJI;
	
	//Mini Lodges
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgePoliceBox.registry_name )
	public static MiniLodgePoliceBox MINI_LODGE_POLICE_BOX;
	
	//Mini Lodges: Outhouses
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseAcacia.registry_name )
	public static MiniLodgeOuthouseAcacia MINI_LODGE_OUTHOUSE_ACACIA;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseBirch.registry_name )
	public static MiniLodgeOuthouseBirch MINI_LODGE_OUTHOUSE_BIRCH;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseDarkOak.registry_name )
	public static MiniLodgeOuthouseDarkOak MINI_LODGE_OUTHOUSE_DARK_OAK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseJungle.registry_name )
	public static MiniLodgeOuthouseJungle MINI_LODGE_OUTHOUSE_JUNGLE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseOak.registry_name )
	public static MiniLodgeOuthouseOak MINI_LODGE_OUTHOUSE_OAK;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseSpruce.registry_name )
	public static MiniLodgeOuthouseSpruce MINI_LODGE_OUTHOUSE_SPRUCE;
	
	//Player Door Sensor
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + PlayerDoorSensor.registry_name )
	public static PlayerDoorSensor PLAYER_DOOR_SENSOR;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + PlayerDoorSensor.registry_name )
	public static TileEntityType<PlayerDoorSensorTile> PLAYER_DOOR_SENSOR_TILE;
}
