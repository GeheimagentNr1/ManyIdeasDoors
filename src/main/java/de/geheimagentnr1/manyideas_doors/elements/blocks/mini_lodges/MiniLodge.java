package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.doors.DoorsHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;


public abstract class MiniLodge extends MultiBlock {
	
	
	@NotNull
	private final BlockSetType type;
	
	protected MiniLodge( @NotNull BlockBehaviour.Properties _properties, @NotNull BlockSetType _type ) {
		
		super( _properties.noOcclusion().isViewBlocking( ( state, level, pos ) -> false ) );
		registerDefaultState( defaultBlockState().setValue( BlockStateProperties.OPEN, false )
			.setValue( BlockStateProperties.POWERED, false ) );
		type = _type;
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
	
	@NotNull
	@Override
	protected BlockState getDefaultState( boolean left_sided ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.DOOR_HINGE,
			left_sided ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT
		);
	}
	
	@NotNull
	@Override
	protected InteractionResult useWithoutItem(
		@NotNull BlockState pState,
		@NotNull Level pLevel,
		@NotNull BlockPos pPos,
		@NotNull Player pPlayer,
		@NotNull BlockHitResult pHitResult ) {
		
		if( pState.getValue( X_SIZE ) != 0 || pState.getValue( Y_SIZE ) == 2 || pState.getValue( Z_SIZE ) == 2 ||
			pState.getValue( Z_SIZE ) != 1 ) {
			return InteractionResult.PASS;
		}
		boolean open = !pState.getValue( BlockStateProperties.OPEN );
		runForBlocks(
			pLevel,
			getZeroPos( pState, pPos ),
			pState.getValue( BlockStateProperties.HORIZONTAL_FACING ),
			( x, y, z, blockPos ) -> pLevel.setBlock(
				blockPos,
				pLevel.getBlockState( blockPos ).setValue( BlockStateProperties.OPEN, open ),
				3
			),
			true
		);
		DoorsHelper.playDoorSound( pLevel, pPos, type, pPlayer, open );
		return InteractionResult.SUCCESS;
	}
	
	@Override
	public void neighborChanged(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Block block,
		@NotNull BlockPos fromPos,
		boolean isMoving ) {
		
		if( block == this ) {
			return;
		}
		BlockPos zeroPos = getZeroPos( state, pos );
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		boolean isPowered = isPowered( level, zeroPos, facing );
		if( isPowered != state.getValue( BlockStateProperties.POWERED ) ) {
			runForBlocks(
				level,
				zeroPos,
				facing,
				( x, y, z, blockPos ) -> level.setBlock(
					blockPos,
					level.getBlockState( blockPos )
						.setValue( BlockStateProperties.POWERED, isPowered )
						.setValue( BlockStateProperties.OPEN, isPowered ),
					3
				),
				true
			);
			DoorsHelper.playDoorSound( level, pos, type, null, isPowered );
		}
	}
	
	@Override
	protected boolean isPathfindable( @NotNull BlockState pState, @NotNull PathComputationType pPathComputationType ) {
		
		return false;
	}
	
	@Override
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN, BlockStateProperties.POWERED );
	}
}
