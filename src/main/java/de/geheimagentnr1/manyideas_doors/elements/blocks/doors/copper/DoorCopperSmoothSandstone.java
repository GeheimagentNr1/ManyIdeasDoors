package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class DoorCopperSmoothSandstone extends DoorMetal {
	
	
	public static final String registry_name = "door_copper_smooth_sandstone";
	
	public DoorCopperSmoothSandstone() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.SAND ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_SMOOTH_SANDSTONE, _properties, registry_name );
	}
}
