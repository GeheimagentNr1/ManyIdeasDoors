package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;


public class BigDoorJungle extends BigDoor {
	
	
	public static final String registry_name = "big_door_jungle";
	
	public BigDoorJungle() {
		
		super(
			Properties.create( Material.WOOD )
				.hardnessAndResistance( 3.0F )
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
	
	@Nonnull
	@Override
	public BlockRenderLayer getRenderLayer() {
		
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_JUNGLE, properties, registry_name );
	}
}
