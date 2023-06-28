package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class BigDoorDarsser extends BigDoorWooden {
	
	
	@NotNull
	public static final String registry_name = "big_door_darsser";
	
	@NotNull
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	public BigDoorDarsser() {
		
		super(
			BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_GREEN ).sound( SoundType.WOOD ),
			BlockSetType.OAK,
			false
		);
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
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
	
	@NotNull
	@Override
	public InteractionResult use(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Player player,
		@NotNull InteractionHand hand,
		@NotNull BlockHitResult hitResult ) {
		
		if( state.getValue( Z_SIZE ) == 1 && state.getValue( Y_SIZE ) != 2 ) {
			return super.use( state, level, pos, player, hand, hitResult );
		}
		return InteractionResult.PASS;
	}
	
	@SuppressWarnings( "deprecation" )
	@Deprecated
	@Override
	public boolean isPathfindable(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull PathComputationType type ) {
		
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
}
