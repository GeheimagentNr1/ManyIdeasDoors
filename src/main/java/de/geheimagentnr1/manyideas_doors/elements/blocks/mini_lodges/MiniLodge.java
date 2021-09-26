package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public abstract class MiniLodge extends MultiBlock {
	
	
	protected MiniLodge( Block.Properties properties, String registry_name ) {
		
		super( properties, registry_name );
		setDefaultState( getDefaultState().with( BlockStateProperties.OPEN, false )
			.with( BlockStateProperties.POWERED, false ) );
	}
	
	/**
	 * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
	 * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
	 */
	@Nonnull
	@Override
	public BlockRenderLayer getRenderLayer() {
		
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	protected int getXSize() {
		
		return 3;
	}
	
	@Override
	protected int getYSize() {
		
		return 3;
	}
	
	@Override
	protected int getZSize() {
		
		return 3;
	}
	
	@Override
	protected BlockState getDefaultState( boolean left_sided ) {
		
		return getDefaultState().with(
			BlockStateProperties.DOOR_HINGE,
			left_sided ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT
		);
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public boolean onBlockActivated(
		@Nonnull BlockState state,
		@Nonnull World worldIn,
		@Nonnull BlockPos pos,
		@Nonnull PlayerEntity player,
		@Nonnull Hand handIn,
		@Nonnull BlockRayTraceResult hit ) {
		
		if( state.get( X_SIZE ) != 0 || state.get( Z_SIZE ) != 1 ) {
			return false;
		}
		boolean open = !state.get( BlockStateProperties.OPEN );
		runForBlocks(
			worldIn,
			getZeroPos( state, pos ),
			state.get( BlockStateProperties.HORIZONTAL_FACING ),
			( x, y, z, blockPos ) -> worldIn.setBlockState(
				blockPos,
				worldIn.getBlockState( blockPos ).with( BlockStateProperties.OPEN, open ),
				3
			),
			true
		);
		playDoorSound( player, worldIn, pos, open );
		return true;
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public void neighborChanged(
		@Nonnull BlockState state,
		@Nonnull World worldIn,
		@Nonnull BlockPos pos,
		@Nonnull Block blockIn,
		@Nonnull BlockPos fromPos,
		boolean isMoving ) {
		
		if( blockIn == this ) {
			return;
		}
		BlockPos zeroPos = getZeroPos( state, pos );
		Direction facing = state.get( BlockStateProperties.HORIZONTAL_FACING );
		boolean isPowered = isPowered( worldIn, zeroPos, facing );
		if( isPowered != state.get( BlockStateProperties.POWERED ) ) {
			runForBlocks(
				worldIn,
				zeroPos,
				facing,
				( x, y, z, blockPos ) -> worldIn.setBlockState(
					blockPos,
					worldIn.getBlockState( blockPos )
						.with( BlockStateProperties.POWERED, isPowered )
						.with( BlockStateProperties.OPEN, isPowered ),
					3
				),
				true
			);
			playDoorSound( null, worldIn, pos, isPowered );
		}
	}
	
	private void playDoorSound( PlayerEntity player, World world, BlockPos pos, boolean open ) {
		
		world.playSound(
			player,
			pos,
			open ? getOpenDoorSound() : getCloseDoorSound(),
			SoundCategory.BLOCKS,
			1.0F,
			1.0F
		);
	}
	
	private SoundEvent getCloseDoorSound() {
		
		return material == Material.IRON ? SoundEvents.BLOCK_IRON_DOOR_OPEN : SoundEvents.BLOCK_WOODEN_DOOR_OPEN;
	}
	
	private SoundEvent getOpenDoorSound() {
		
		return material == Material.IRON ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_WOODEN_DOOR_CLOSE;
	}
	
	@Override
	protected void fillStateContainer( StateContainer.Builder<Block, BlockState> builder ) {
		
		super.fillStateContainer( builder );
		builder.add( BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN, BlockStateProperties.POWERED );
	}
}
