package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;


public class BigDoorShiro extends BigDoor {
	
	
	public static final String registry_name = "big_door_shiro";
	
	public BigDoorShiro() {
		
		super(
			AbstractBlock.Properties.of( Material.WOOD )
				.strength( 3.0F )
				.harvestTool( ToolType.AXE )
				.sound( SoundType.WOOD ),
			registry_name,
			OpenedBy.BOTH,
			true
		);
	}
	
	@Override
	protected int getXSize() {
		
		return 2;
	}
	
	@Override
	protected int getYSize() {
		
		return 4;
	}
	
	@Override
	protected int getZSize() {
		
		return 2;
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_SHIRO, _properties, registry_name );
	}
}
