package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;


public class DoorIronStoneBrick extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_iron_stone_brick";
	
	public DoorIronStoneBrick() {
		
		super(
			AbstractBlock.Properties.of( Material.METAL ).strength( 5.0F )
				.harvestTool( ToolType.PICKAXE )
				.harvestLevel( 0 )
				.sound( SoundType.METAL ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_IRON_STONE_BRICK, _properties, registry_name );
	}
}
