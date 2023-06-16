package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class DoorCopperCorrugated extends DoorMetal {
	
	
	public static final String registry_name = "door_copper_corrugated";
	
	public DoorCopperCorrugated() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_BROWN ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_CORRUGATED, _properties, registry_name );
	}
}
