package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorAcaciaBlank extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_acacia_blank";
	
	public DoorAcaciaBlank() {
		
		super(
			Block.Properties.create( Material.WOOD ).hardnessAndResistance( 3.0F ).sound( SoundType.WOOD ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.DOOR_ACACIA_BLANK, properties, registry_name );
	}
}
