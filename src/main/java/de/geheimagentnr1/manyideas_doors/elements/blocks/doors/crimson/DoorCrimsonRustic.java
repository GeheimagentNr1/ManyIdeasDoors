package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorCrimsonRustic extends DoorCrimson {
	
	
	public static final String registry_name = "door_crimson_rustic";
	
	public DoorCrimsonRustic() {
		
		super( BlockSetType.CRIMSON );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_CRIMSON_RUSTIC, _properties, registry_name );
	}
}
