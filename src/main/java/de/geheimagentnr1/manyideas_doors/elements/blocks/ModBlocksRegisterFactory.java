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
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryEntry;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryHelper;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryKeys;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "unused" } )
public class ModBlocksRegisterFactory extends BlocksRegisterFactory {
	
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
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorArt.registry_name )
	public static BigDoorArt BIG_DOOR_ART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + BigDoorDwarf.registry_name )
	public static BigDoorDwarf BIG_DOOR_DWARF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorFactory.registry_name )
	public static BigDoorFactory BIG_DOOR_FACTORY;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorFrench.registry_name )
	public static BigDoorFrench BIG_DOOR_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + BigDoorGlass.registry_name )
	public static BigDoorGlass BIG_DOOR_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorLaboratory.registry_name )
	public static BigDoorLaboratory BIG_DOOR_LABORATORY;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorPipe.registry_name )
	public static BigDoorPipe BIG_DOOR_PIPE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorPortcullis.registry_name )
	public static BigDoorPortcullis BIG_DOOR_PORTCULLIS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorSafe.registry_name )
	public static BigDoorSafe BIG_DOOR_SAFE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorTerrace.registry_name )
	public static BigDoorTerrace BIG_DOOR_TERRACE;
	
	//Big Doors: Wooden
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorAcacia.registry_name )
	public static BigDoorAcacia BIG_DOOR_ACACIA;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorBarn.registry_name )
	public static BigDoorBarn BIG_DOOR_BARN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + BigDoorBirch.registry_name )
	public static BigDoorBirch BIG_DOOR_BIRCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorCrimson.registry_name )
	public static BigDoorCrimson BIG_DOOR_CRIMSON;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorDarkOak.registry_name )
	public static BigDoorDarkOak BIG_DOOR_DARK_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorDarsser.registry_name )
	public static BigDoorDarsser BIG_DOOR_DARSSER;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorFairyTale.registry_name )
	public static BigDoorFairyTale BIG_DOOR_FAIRY_TALE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorJungle.registry_name )
	public static BigDoorJungle BIG_DOOR_JUNGLE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorOak.registry_name )
	public static BigDoorOak BIG_DOOR_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value = ManyIdeasDoors.MODID + ":" + BigDoorShip.registry_name )
	public static BigDoorShip BIG_DOOR_SHIP;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + BigDoorShiro.registry_name )
	public static BigDoorShiro BIG_DOOR_SHIRO;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorSpruce.registry_name )
	public static BigDoorSpruce BIG_DOOR_SPRUCE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + BigDoorWarped.registry_name )
	public static BigDoorWarped BIG_DOOR_WARPED;
	
	//Doors: Acacia
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaBlank.registry_name )
	public static DoorAcaciaBlank DOOR_ACACIA_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaBookshelf.registry_name )
	public static DoorAcaciaBookshelf DOOR_ACACIA_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaCassette.registry_name )
	public static DoorAcaciaCassette DOOR_ACACIA_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaFrench.registry_name )
	public static DoorAcaciaFrench DOOR_ACACIA_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaFrosted.registry_name )
	public static DoorAcaciaFrosted DOOR_ACACIA_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaGlass.registry_name )
	public static DoorAcaciaGlass DOOR_ACACIA_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaHeart.registry_name )
	public static DoorAcaciaHeart DOOR_ACACIA_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaOrigin.registry_name )
	public static DoorAcaciaOrigin DOOR_ACACIA_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaRustic.registry_name )
	public static DoorAcaciaRustic DOOR_ACACIA_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorAcaciaShoji.registry_name )
	public static DoorAcaciaShoji DOOR_ACACIA_SHOJI;
	
	//Doors: Birch
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchBlank.registry_name )
	public static DoorBirchBlank DOOR_BIRCH_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchBookshelf.registry_name )
	public static DoorBirchBookshelf DOOR_BIRCH_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchCassette.registry_name )
	public static DoorBirchCassette DOOR_BIRCH_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchFrench.registry_name )
	public static DoorBirchFrench DOOR_BIRCH_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchFrosted.registry_name )
	public static DoorBirchFrosted DOOR_BIRCH_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchGlass.registry_name )
	public static DoorBirchGlass DOOR_BIRCH_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchHeart.registry_name )
	public static DoorBirchHeart DOOR_BIRCH_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchOrigin.registry_name )
	public static DoorBirchOrigin DOOR_BIRCH_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchRustic.registry_name )
	public static DoorBirchRustic DOOR_BIRCH_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorBirchShoji.registry_name )
	public static DoorBirchShoji DOOR_BIRCH_SHOJI;
	
	//Doors: Crimson
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonBlank.registry_name )
	public static DoorCrimsonBlank DOOR_CRIMSON_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonBookshelf.registry_name )
	public static DoorCrimsonBookshelf DOOR_CRIMSON_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonCassette.registry_name )
	public static DoorCrimsonCassette DOOR_CRIMSON_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonFrench.registry_name )
	public static DoorCrimsonFrench DOOR_CRIMSON_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonFrosted.registry_name )
	public static DoorCrimsonFrosted DOOR_CRIMSON_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonGlass.registry_name )
	public static DoorCrimsonGlass DOOR_CRIMSON_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonHeart.registry_name )
	public static DoorCrimsonHeart DOOR_CRIMSON_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonOrigin.registry_name )
	public static DoorCrimsonOrigin DOOR_CRIMSON_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonRustic.registry_name )
	public static DoorCrimsonRustic DOOR_CRIMSON_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCrimsonShoji.registry_name )
	public static DoorCrimsonShoji DOOR_CRIMSON_SHOJI;
	
	//Doors: Copper
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperBar.registry_name )
	public static DoorCopperBar DOOR_COPPER_BAR;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperBarrel.registry_name )
	public static DoorCopperBarrel DOOR_COPPER_BARREL;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperBrick.registry_name )
	public static DoorCopperBrick DOOR_COPPER_BRICK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperCorrugated.registry_name )
	public static DoorCopperCorrugated DOOR_COPPER_CORRUGATED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperFactory.registry_name )
	public static DoorCopperFactory DOOR_COPPER_FACTORY;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperGlass.registry_name )
	public static DoorCopperGlass DOOR_COPPER_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperModern.registry_name )
	public static DoorCopperModern DOOR_COPPER_MODERN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperSmoothSandstone.registry_name )
	public static DoorCopperSmoothSandstone DOOR_COPPER_SMOOTH_SANDSTONE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperShip.registry_name )
	public static DoorCopperShip DOOR_COPPER_SHIP;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorCopperSteampunk.registry_name )
	public static DoorCopperSteampunk DOOR_COPPER_STEAMPUNK;
	
	//Doors: Dark Oak
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakBlank.registry_name )
	public static DoorDarkOakBlank DOOR_DARK_OAK_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakBookshelf.registry_name )
	public static DoorDarkOakBookshelf DOOR_DARK_OAK_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakCassette.registry_name )
	public static DoorDarkOakCassette DOOR_DARK_OAK_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakFrench.registry_name )
	public static DoorDarkOakFrench DOOR_DARK_OAK_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakFrosted.registry_name )
	public static DoorDarkOakFrosted DOOR_DARK_OAK_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakGlass.registry_name )
	public static DoorDarkOakGlass DOOR_DARK_OAK_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakHeart.registry_name )
	public static DoorDarkOakHeart DOOR_DARK_OAK_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakOrigin.registry_name )
	public static DoorDarkOakOrigin DOOR_DARK_OAK_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakRustic.registry_name )
	public static DoorDarkOakRustic DOOR_DARK_OAK_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorDarkOakShoji.registry_name )
	public static DoorDarkOakShoji DOOR_DARK_OAK_SHOJI;
	
	//Doors: Iron
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronBookshelf.registry_name )
	public static DoorIronBookshelf DOOR_IRON_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronDwarf.registry_name )
	public static DoorIronDwarf DOOR_IRON_DWARF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronFantasy.registry_name )
	public static DoorIronFantasy DOOR_IRON_FANTASY;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronGlass.registry_name )
	public static DoorIronGlass DOOR_IRON_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronLaboratory.registry_name )
	public static DoorIronLaboratory DOOR_IRON_LABORATORY;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronRusted.registry_name )
	public static DoorIronRusted DOOR_IRON_RUSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorIronSafe.registry_name )
	public static DoorIronSafe DOOR_IRON_SAFE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorIronShip.registry_name )
	public static DoorIronShip DOOR_IRON_SHIP;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronSpace.registry_name )
	public static DoorIronSpace DOOR_IRON_SPACE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorIronStoneBrick.registry_name )
	public static DoorIronStoneBrick DOOR_IRON_STONE_BRICK;
	
	//Doors: Jungle
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleBlank.registry_name )
	public static DoorJungleBlank DOOR_JUNGLE_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleBookshelf.registry_name )
	public static DoorJungleBookshelf DOOR_JUNGLE_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleCassette.registry_name )
	public static DoorJungleCassette DOOR_JUNGLE_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleFrench.registry_name )
	public static DoorJungleFrench DOOR_JUNGLE_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleFrosted.registry_name )
	public static DoorJungleFrosted DOOR_JUNGLE_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleGlass.registry_name )
	public static DoorJungleGlass DOOR_JUNGLE_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleHeart.registry_name )
	public static DoorJungleHeart DOOR_JUNGLE_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleOrigin.registry_name )
	public static DoorJungleOrigin DOOR_JUNGLE_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleRustic.registry_name )
	public static DoorJungleRustic DOOR_JUNGLE_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorJungleShoji.registry_name )
	public static DoorJungleShoji DOOR_JUNGLE_SHOJI;
	
	//Doors: Oak
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorOakBlank.registry_name )
	public static DoorOakBlank DOOR_OAK_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakBookshelf.registry_name )
	public static DoorOakBookshelf DOOR_OAK_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakCassette.registry_name )
	public static DoorOakCassette DOOR_OAK_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakFrench.registry_name )
	public static DoorOakFrench DOOR_OAK_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakFrosted.registry_name )
	public static DoorOakFrosted DOOR_OAK_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorOakGlass.registry_name )
	public static DoorOakGlass DOOR_OAK_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorOakHeart.registry_name )
	public static DoorOakHeart DOOR_OAK_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakOrigin.registry_name )
	public static DoorOakOrigin DOOR_OAK_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorOakRustic.registry_name )
	public static DoorOakRustic DOOR_OAK_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS, value =
		ManyIdeasDoors.MODID + ":" + DoorOakShoji.registry_name )
	public static DoorOakShoji DOOR_OAK_SHOJI;
	
	//Doors: Special
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpecialPoliceBox.registry_name )
	public static DoorSpecialPoliceBox DOOR_SPECIAL_POLICE_BOX;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpecialPortcullis.registry_name )
	public static DoorSpecialPortcullis DOOR_SPECIAL_PORTCULLIS;
	
	//Special: End Door
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpecialEnd.registry_name )
	public static DoorSpecialEnd DOOR_SPECIAL_END;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCK_ENTITY_TYPES,
		value = ManyIdeasDoors.MODID + ":" + DoorSpecialEnd.registry_name )
	public static BlockEntityType<DoorSpecialEndEntity> DOOR_SPECIAL_END_ENTITY;
	
	//Doors: Spruce
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceBlank.registry_name )
	public static DoorSpruceBlank DOOR_SPRUCE_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceBookshelf.registry_name )
	public static DoorSpruceBookshelf DOOR_SPRUCE_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceCassette.registry_name )
	public static DoorSpruceCassette DOOR_SPRUCE_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceFrench.registry_name )
	public static DoorSpruceFrench DOOR_SPRUCE_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceFrosted.registry_name )
	public static DoorSpruceFrosted DOOR_SPRUCE_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceGlass.registry_name )
	public static DoorSpruceGlass DOOR_SPRUCE_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceHeart.registry_name )
	public static DoorSpruceHeart DOOR_SPRUCE_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceOrigin.registry_name )
	public static DoorSpruceOrigin DOOR_SPRUCE_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceRustic.registry_name )
	public static DoorSpruceRustic DOOR_SPRUCE_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorSpruceShoji.registry_name )
	public static DoorSpruceShoji DOOR_SPRUCE_SHOJI;
	
	//Doors: Warped
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedBlank.registry_name )
	public static DoorWarpedBlank DOOR_WARPED_BLANK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedBookshelf.registry_name )
	public static DoorWarpedBookshelf DOOR_WARPED_BOOKSHELF;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedCassette.registry_name )
	public static DoorWarpedCassette DOOR_WARPED_CASSETTE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedFrench.registry_name )
	public static DoorWarpedFrench DOOR_WARPED_FRENCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedFrosted.registry_name )
	public static DoorWarpedFrosted DOOR_WARPED_FROSTED;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedGlass.registry_name )
	public static DoorWarpedGlass DOOR_WARPED_GLASS;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedHeart.registry_name )
	public static DoorWarpedHeart DOOR_WARPED_HEART;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedOrigin.registry_name )
	public static DoorWarpedOrigin DOOR_WARPED_ORIGIN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedRustic.registry_name )
	public static DoorWarpedRustic DOOR_WARPED_RUSTIC;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + DoorWarpedShoji.registry_name )
	public static DoorWarpedShoji DOOR_WARPED_SHOJI;
	
	//Mini Lodges
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgePoliceBox.registry_name )
	public static MiniLodgePoliceBox MINI_LODGE_POLICE_BOX;
	
	//Mini Lodges: Outhouses
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseAcacia.registry_name )
	public static MiniLodgeOuthouseAcacia MINI_LODGE_OUTHOUSE_ACACIA;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseBirch.registry_name )
	public static MiniLodgeOuthouseBirch MINI_LODGE_OUTHOUSE_BIRCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseCrimson.registry_name )
	public static MiniLodgeOuthouseCrimson MINI_LODGE_OUTHOUSE_CRIMSON;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseDarkOak.registry_name )
	public static MiniLodgeOuthouseDarkOak MINI_LODGE_OUTHOUSE_DARK_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseJungle.registry_name )
	public static MiniLodgeOuthouseJungle MINI_LODGE_OUTHOUSE_JUNGLE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseOak.registry_name )
	public static MiniLodgeOuthouseOak MINI_LODGE_OUTHOUSE_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseSpruce.registry_name )
	public static MiniLodgeOuthouseSpruce MINI_LODGE_OUTHOUSE_SPRUCE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + MiniLodgeOuthouseWarped.registry_name )
	public static MiniLodgeOuthouseWarped MINI_LODGE_OUTHOUSE_WARPED;
	
	//Player Door Sensor
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasDoors.MODID + ":" + PlayerDoorSensor.registry_name )
	public static PlayerDoorSensor PLAYER_DOOR_SENSOR;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCK_ENTITY_TYPES,
		value = ManyIdeasDoors.MODID + ":" + PlayerDoorSensor.registry_name )
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
			//Doors: Oak
			RegistryEntry.create( DoorOakBlank.registry_name, new DoorOakBlank() ),//BCPFINRLT
			RegistryEntry.create( DoorOakBookshelf.registry_name, new DoorOakBookshelf() ),//BCPFINRLT
			RegistryEntry.create( DoorOakCassette.registry_name, new DoorOakCassette() ),//BCPFINRLT
			RegistryEntry.create( DoorOakFrench.registry_name, new DoorOakFrench() ),//BCPFINRLT
			RegistryEntry.create( DoorOakFrosted.registry_name, new DoorOakFrosted() ),//BCPFINRLT
			RegistryEntry.create( DoorOakGlass.registry_name, new DoorOakGlass() ),//BCPFINRLT
			RegistryEntry.create( DoorOakHeart.registry_name, new DoorOakHeart() ),//BCPFINRLT
			RegistryEntry.create( DoorOakOrigin.registry_name, new DoorOakOrigin() ),//BCPFINRLT
			RegistryEntry.create( DoorOakRustic.registry_name, new DoorOakRustic() ),//BCPFINRLT
			RegistryEntry.create( DoorOakShoji.registry_name, new DoorOakShoji() ),//BCPFINRLT
			//Doors: Special
			RegistryEntry.create( DoorSpecialPoliceBox.registry_name, new DoorSpecialPoliceBox() ),//BCPFINRLT
			RegistryEntry.create( DoorSpecialPortcullis.registry_name, new DoorSpecialPortcullis() ),//BCPFINRLT
			//Doors: Special: End Door
			RegistryEntry.create( DoorSpecialEnd.registry_name, new DoorSpecialEnd() ),//BCPFINRLT
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
			RegistryEntry.create( MiniLodgeOuthouseOak.registry_name, new MiniLodgeOuthouseOak() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseSpruce.registry_name, new MiniLodgeOuthouseSpruce() ),//BCPFINRLT
			RegistryEntry.create( MiniLodgeOuthouseWarped.registry_name, new MiniLodgeOuthouseWarped() ),//BCPFINRLT
			//Player Door Sensor
			RegistryEntry.create( PlayerDoorSensor.registry_name, new PlayerDoorSensor() )//BCPFINRLT
		);
	}
	
	@NotNull
	@Override
	protected List<RegistryEntry<BlockEntityType<?>>> blockEntityTypes() {
		
		return List.of(
			RegistryEntry.create(
				DoorSpecialEnd.registry_name,
				RegistryHelper.buildBlockEntity(
					DoorSpecialEnd.registry_name,
					DoorSpecialEndEntity::new,
					DOOR_SPECIAL_END
				)
			),
			RegistryEntry.create(
				PlayerDoorSensor.registry_name,
				RegistryHelper.buildBlockEntity(
					PlayerDoorSensor.registry_name,
					PlayerDoorSensorEntity::new,
					PLAYER_DOOR_SENSOR
				)
			)
		);
	}
	
	@SubscribeEvent
	@Override
	public void handleFMLClientSetupEvent( @NotNull FMLClientSetupEvent event ) {
		
		BlockEntityRenderers.register( DOOR_SPECIAL_END_ENTITY, DoorSpecialEndEntityRenderer::new );
	}
}
