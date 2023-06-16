package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorBirchBookshelf extends DoorBirch {
	
	
	public static final String registry_name = "door_birch_bookshelf";
	
	public DoorBirchBookshelf() {
		
		super( BlockSetType.BIRCH );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_BIRCH_BOOKSHELF, _properties, registry_name );
	}
}
