package de.geheimagentnr1.manyideas_doors.elements.blocks;

import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.BigDoorLaboratory;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.BigDoorFactory;
import de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.BigDoorSpruce;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialCarbonite;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialPoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialSpace;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.DoorSpecialRedstone;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce.*;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.MiniLodgePoliceBox;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import net.minecraft.block.AbstractBlock;
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
		//Doors: Special
		//new DoorSpecialCarbonite(),//BCPFINRLT//TODO: Entfernen
		//new DoorSpecialRedstone(),//BCPFINRLT//TODO: Entfernen
		new DoorSpecialSpace(),//BCPFINRLT
	};
	
	//Doors: Special
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialCarbonite.registry_name )
	public static DoorSpecialCarbonite DOOR_SPECIAL_CARBONITE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialRedstone.registry_name )
	public static DoorSpecialRedstone DOOR_SPECIAL_REDSTONE;
	
	@ObjectHolder( ManyIdeasDoors.MODID + ":" + DoorSpecialSpace.registry_name )
	public static DoorSpecialSpace DOOR_SPECIAL_SPACE;
}
