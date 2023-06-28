package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.doors.DoorsHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
	
	@SuppressWarnings( "deprecation" )
	@NotNull
	@Override
	public InteractionResult use(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Player player,
		@NotNull InteractionHand hand,
		@NotNull BlockHitResult hitResult ) {
		
		if( state.getValue( X_SIZE ) != 0 || state.getValue( Y_SIZE ) == 2 || state.getValue( Z_SIZE ) == 2 ||
			state.getValue( Z_SIZE ) != 1 ) {
			return InteractionResult.PASS;
		}
		boolean open = !state.getValue( BlockStateProperties.OPEN );
		runForBlocks(
			level,
			getZeroPos( state, pos ),
			state.getValue( BlockStateProperties.HORIZONTAL_FACING ),
			( x, y, z, blockPos ) -> level.setBlock(
				blockPos,
				level.getBlockState( blockPos ).setValue( BlockStateProperties.OPEN, open ),
				3
			),
			true
		);
		DoorsHelper.playDoorSound( level, pos, type, player, open );
		return InteractionResult.SUCCESS;
	}
	
	@SuppressWarnings( "deprecation" )
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
	
	@SuppressWarnings( "deprecation" )
	@Deprecated
	@Override
	public boolean isPathfindable(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull PathComputationType type ) {
		
		return false;
	}
	
	@Override
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN, BlockStateProperties.POWERED );
	}
}
