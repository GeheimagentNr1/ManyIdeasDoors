package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.warped;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorWarpedCassette extends DoorWarped {
	
	
	public static final String registry_name = "door_warped_cassette";
	
	public DoorWarpedCassette() {
		
		super( BlockSetType.WARPED );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_WARPED_CASSETTE, _properties, registry_name );
	}
}
