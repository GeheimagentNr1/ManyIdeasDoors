package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;


public class DoorOakRustic extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_oak_rustic";
	
	public DoorOakRustic() {
		
		super(
			AbstractBlock.Properties.of( Material.WOOD )
				.strength( 3.0F )
				.harvestTool( ToolType.AXE )
				.sound( SoundType.WOOD ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_OAK_RUSTIC, _properties, registry_name );
	}
}
