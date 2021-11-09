package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public abstract class MiniLodge extends MultiBlock implements BlockRenderTypeInterface {
	
	
	protected MiniLodge( AbstractBlock.Properties _properties, String registry_name ) {
		
		super(
			_properties.noOcclusion().isViewBlocking( ( state, level, pos ) -> false ),
			registry_name
		);
		registerDefaultState( defaultBlockState().setValue( BlockStateProperties.OPEN, false )
			.setValue( BlockStateProperties.POWERED, false ) );
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
	public ActionResultType use(
		@Nonnull BlockState state,
		@Nonnull World level,
		@Nonnull BlockPos pos,
		@Nonnull PlayerEntity player,
		@Nonnull Hand hand,
		@Nonnull BlockRayTraceResult hitResult ) {
		
		if( state.getValue( X_SIZE ) != 0 || state.getValue( Y_SIZE ) == 2 || state.get( Z_SIZE ) != 1 ) {
			return ActionResultType.PASS;
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
		playDoorSound( player, level, pos, open );
		return ActionResultType.SUCCESS;
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public void neighborChanged(
		@Nonnull BlockState state,
		@Nonnull World level,
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
			playDoorSound( null, level, pos, isPowered );
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
	
	private SoundEvent getOpenDoorSound() {
		
		return material == Material.METAL ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.WOODEN_DOOR_OPEN;
	}
	
	private SoundEvent getCloseDoorSound() {
		
		return material == Material.METAL ? SoundEvents.IRON_DOOR_CLOSE : SoundEvents.WOODEN_DOOR_CLOSE;
	}
	
	@Override
	protected void createBlockStateDefinition( StateContainer.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN, BlockStateProperties.POWERED );
	}
}
