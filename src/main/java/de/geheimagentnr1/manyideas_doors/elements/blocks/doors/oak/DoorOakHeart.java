package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorOakHeart extends DoorOak {
	
	
	public static final String registry_name = "door_oak_heart";
	
	public DoorOakHeart() {
		
		super( BlockSetType.OAK );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_OAK_HEART, _properties, registry_name );
	}
}
