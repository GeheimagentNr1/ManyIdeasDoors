package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorSpruceGlass extends DoorSpruce {
	
	
	public static final String registry_name = "door_spruce_glass";
	
	public DoorSpruceGlass() {
		
		super( BlockSetType.SPRUCE );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPRUCE_GLASS, _properties, registry_name );
	}
}
