package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.doors.DoorsHelper;
import net.minecraft.client.renderer.RenderType;
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

import javax.annotation.Nonnull;


public abstract class MiniLodge extends MultiBlock implements BlockRenderTypeInterface {
	
	
	private final BlockSetType type;
	
	protected MiniLodge( BlockBehaviour.Properties _properties, BlockSetType _type ) {
		
		super( _properties.noOcclusion().isViewBlocking( ( state, level, pos ) -> false ) );
		registerDefaultState( defaultBlockState().setValue( BlockStateProperties.OPEN, false )
			.setValue( BlockStateProperties.POWERED, false ) );
		type = _type;
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
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
		
		return defaultBlockState().setValue(
			BlockStateProperties.DOOR_HINGE,
			left_sided ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT
		);
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public InteractionResult use(
		@Nonnull BlockState state,
		@Nonnull Level level,
		@Nonnull BlockPos pos,
		@Nonnull Player player,
		@Nonnull InteractionHand hand,
		@Nonnull BlockHitResult hitResult ) {
		
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
		@Nonnull BlockState state,
		@Nonnull Level level,
		@Nonnull BlockPos pos,
		@Nonnull Block block,
		@Nonnull BlockPos fromPos,
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
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull PathComputationType type ) {
		
		return false;
	}
	
	@Override
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN, BlockStateProperties.POWERED );
	}
}
