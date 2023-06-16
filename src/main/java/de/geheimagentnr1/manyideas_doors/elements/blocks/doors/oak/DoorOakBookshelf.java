package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorOakBookshelf extends DoorOak {
	
	
	public static final String registry_name = "door_oak_bookshelf";
	
	public DoorOakBookshelf() {
		
		super( BlockSetType.OAK );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_OAK_BOOKSHELF, _properties, registry_name );
	}
}
