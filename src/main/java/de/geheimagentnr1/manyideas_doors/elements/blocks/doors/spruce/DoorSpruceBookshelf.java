package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorSpruceBookshelf extends DoorSpruce {
	
	
	public static final String registry_name = "door_spruce_bookshelf";
	
	public DoorSpruceBookshelf() {
		
		super( BlockSetType.SPRUCE );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPRUCE_BOOKSHELF, _properties, registry_name );
	}
}
