package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorCrimsonOrigin extends DoorCrimson {
	
	
	public static final String registry_name = "door_crimson_origin";
	
	public DoorCrimsonOrigin() {
		
		super( BlockSetType.CRIMSON );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_CRIMSON_ORIGIN, _properties, registry_name );
	}
}
