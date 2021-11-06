package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.IEndBlock;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class DoorSpecialEnd extends DoubleDoorBlock implements IEndBlock {
	
	
	public static final String registry_name = "door_special_end";
	
	public DoorSpecialEnd() {
		
		super(
			AbstractBlock.Properties.of( Material.STONE ).strength( 50.0F, 1200.0F ).sound( SoundType.GLASS ),
			registry_name
		);
	}
	
	@Override
	public boolean hasTileEntity( BlockState state ) {
		
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity( BlockState state, IBlockReader level ) {
		
		return new DoorSpecialEndTile();
	}
	
	@Deprecated
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public BlockRenderType getRenderShape( BlockState state ) {
		
		if( state.getValue( OPEN ) ) {
			return BlockRenderType.MODEL;
		}
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		if( state.getValue( OPEN ) ) {
			return super.getShape( state, level, pos, context );
		}
		return VoxelShapes.block();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_END, _properties, registry_name );
	}
}
