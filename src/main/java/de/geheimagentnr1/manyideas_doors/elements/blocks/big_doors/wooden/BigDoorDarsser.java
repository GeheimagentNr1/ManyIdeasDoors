package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;


public class BigDoorDarsser extends BigDoor {
	
	
	public static final String registry_name = "big_door_darsser";
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	public BigDoorDarsser() {
		
		super(
			BlockBehaviour.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			OpenedBy.BOTH,
			false
		);
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.translucent();
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		if( state.getValue( BlockStateProperties.OPEN ) && state.getValue( Z_SIZE ) == 1 &&
			state.getValue( Y_SIZE ) != 2 ) {
			if( state.getValue( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
				return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
			} else {
				return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
			}
		}
		return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
	}
	
	@Nonnull
	@Override
	public InteractionResult use(
		@Nonnull BlockState state,
		@Nonnull Level level,
		@Nonnull BlockPos pos,
		@Nonnull Player player,
		@Nonnull InteractionHand hand,
		@Nonnull BlockHitResult hitResult ) {
		
		if( state.getValue( Z_SIZE ) == 1 && state.getValue( Y_SIZE ) != 2 ) {
			return super.use( state, level, pos, player, hand, hitResult );
		}
		return InteractionResult.PASS;
	}
	
	@SuppressWarnings( "deprecation" )
	@Deprecated
	@Override
	public boolean isPathfindable(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull PathComputationType type ) {
		
		return switch( type ) {
			case LAND, AIR -> state.getValue( BlockStateProperties.OPEN ) &&
				state.getValue( Z_SIZE ) == 1 &&
				state.getValue( Y_SIZE ) != 2;
			case WATER -> false;
		};
	}
	
	@Override
	protected int getXSize() {
		
		return 1;
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
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_DARSSER, _properties, registry_name );
	}
}
