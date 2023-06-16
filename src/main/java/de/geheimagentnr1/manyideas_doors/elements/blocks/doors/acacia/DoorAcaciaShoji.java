package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorAcaciaShoji extends DoorAcacia {
	
	
	public static final String registry_name = "door_acacia_shoji";
	
	public DoorAcaciaShoji() {
		
		super( BlockSetType.ACACIA );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_ACACIA_SHOJI, _properties, registry_name );
	}
}
