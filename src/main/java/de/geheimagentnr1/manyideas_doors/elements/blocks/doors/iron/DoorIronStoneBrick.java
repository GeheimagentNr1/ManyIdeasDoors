package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class DoorIronStoneBrick extends DoorMetal {
	
	
	public static final String registry_name = "door_iron_stone_brick";
	
	public DoorIronStoneBrick() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.STONE ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_IRON_STONE_BRICK, _properties, registry_name );
	}
}
