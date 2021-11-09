package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
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


public class DoorSpecialEnd extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_special_end";
	
	public DoorSpecialEnd() {
		
		super(
			Block.Properties.create( Material.ROCK ).hardnessAndResistance( 50.0F, 1200.0F ).sound( SoundType.GLASS ),
			registry_name
		);
	}
	
	@Override
	public boolean hasTileEntity( BlockState state ) {
		
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity( BlockState state, IBlockReader world ) {
		
		return new DoorSpecialEndTile();
	}
	
	@Deprecated
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public BlockRenderType getRenderType( BlockState state ) {
		
		if( state.get( OPEN ) ) {
			return BlockRenderType.MODEL;
		}
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		BlockState state,
		@Nonnull IBlockReader worldIn,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		if( state.get( OPEN ) ) {
			return super.getShape( state, worldIn, pos, context );
		}
		return VoxelShapes.fullCube();
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_END, properties, registry_name );
	}
}
