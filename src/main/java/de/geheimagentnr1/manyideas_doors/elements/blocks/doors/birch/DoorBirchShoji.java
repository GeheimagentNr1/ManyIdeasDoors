package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorBirchShoji extends DoorBirch {
	
	
	public static final String registry_name = "door_birch_shoji";
	
	public DoorBirchShoji() {
		
		super( BlockSetType.BIRCH );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_BIRCH_SHOJI, _properties, registry_name );
	}
}
