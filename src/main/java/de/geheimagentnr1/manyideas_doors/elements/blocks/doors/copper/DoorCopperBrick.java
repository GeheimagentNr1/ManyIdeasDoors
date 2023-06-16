package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class DoorCopperBrick extends DoorMetal {
	
	
	public static final String registry_name = "door_copper_brick";
	
	public DoorCopperBrick() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_RED ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_BRICK, _properties, registry_name );
	}
}
