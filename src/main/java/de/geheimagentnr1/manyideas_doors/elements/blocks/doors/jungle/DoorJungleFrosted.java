package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorJungleFrosted extends DoorJungle {
	
	
	public static final String registry_name = "door_jungle_frosted";
	
	public DoorJungleFrosted() {
		
		super( BlockSetType.JUNGLE );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_JUNGLE_FROSTED, _properties, registry_name );
	}
}
