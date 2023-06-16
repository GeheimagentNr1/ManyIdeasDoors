package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorDarkOakOrigin extends DoorDarkOak {
	
	
	public static final String registry_name = "door_dark_oak_origin";
	
	public DoorDarkOakOrigin() {
		
		super( BlockSetType.DARK_OAK );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_DARK_OAK_ORIGIN, _properties, registry_name );
	}
}
