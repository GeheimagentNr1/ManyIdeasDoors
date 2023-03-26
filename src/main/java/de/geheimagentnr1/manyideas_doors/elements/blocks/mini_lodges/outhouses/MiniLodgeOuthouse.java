package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.MiniLodge;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;


public abstract class MiniLodgeOuthouse extends MiniLodge {
	
	
	private static final VoxelShapeMemory CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 12, 0, 12, 16, 16, 16 )
	);
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	private static final VoxelShapeMemory HIGH_ROOF_CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 0, 7.5, 0, 5, 12, 6 ),
		VoxelShapeVector.create( 0, 0, 0, 4, 7.5, 4 )
	);
	
	private static final VoxelShapeMemory LOW_ROOF_CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 0, 0, 0, 5, 3, 5 )
	);
	
	private static final VoxelShapeMemory HIGH_ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 7.5, 0, 16, 12, 6 ),
		VoxelShapeVector.create( 0, 0, 0, 16, 7.5, 3 )
	);
	
	private static final VoxelShapeMemory LEFT_MID_ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 0, 6, 0, 5, 10, 4 ),
		VoxelShapeVector.create( 0, 0, 0, 3, 6, 4 ),
		VoxelShapeVector.create( 0, 4, 4, 5, 8, 8 ),
		VoxelShapeVector.create( 0, 0, 4, 3, 4, 8 ),
		VoxelShapeVector.create( 0, 2.5, 8, 5, 6.5, 12 ),
		VoxelShapeVector.create( 0, 0, 8, 3, 2.5, 12 ),
		VoxelShapeVector.create( 0, 1, 12, 5, 5, 16 ),
		VoxelShapeVector.create( 0, 0, 12, 3, 1, 16 )
	);
	
	private static final VoxelShapeMemory RIGHT_MID_ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 0, 1, 0, 5, 5, 4 ),
		VoxelShapeVector.create( 0, 0, 0, 3, 1, 4 ),
		VoxelShapeVector.create( 0, 2.5, 4, 5, 6.5, 8 ),
		VoxelShapeVector.create( 0, 0, 4, 3, 2.5, 18 ),
		VoxelShapeVector.create( 0, 4, 8, 5, 8, 12 ),
		VoxelShapeVector.create( 0, 0, 8, 3, 4, 12 ),
		VoxelShapeVector.create( 0, 6, 12, 5, 10, 16 ),
		VoxelShapeVector.create( 0, 0, 12, 3, 6, 16 )
	);
	
	private static final VoxelShapeMemory LOW_ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 3, 5 )
	);
	
	private static final VoxelShapeMemory ROOF_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 6, 0, 16, 10, 4 ),
		VoxelShapeVector.create( 0, 4, 4, 16, 8, 8 ),
		VoxelShapeVector.create( 0, 2.5, 8, 16, 6.5, 12 ),
		VoxelShapeVector.create( 0, 1, 12, 16, 5, 16 )
	);
	
	//package-private
	MiniLodgeOuthouse( String registry_name, BlockSetType type ) {
		
		super( BlockBehaviour.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ), type );
	}
	
	@Override
	protected boolean[][][] hasBlockStatesAtPos() {
		
		return new boolean[][][] {
			{ { true, true, true }, { true, true, true }, { true, true, true } },
			{ { true, false, true }, { true, true, true }, { true, true, true } },
			{ { true, true, true }, { true, true, true }, { true, true, true } },
		};
	}
	
	@SuppressWarnings( { "deprecation", "NestedSwitchStatement" } )
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		int x = state.getValue( X_SIZE );
		int y = state.getValue( Y_SIZE );
		int z = state.getValue( Z_SIZE );
		
		switch( y ) {
			case 0: //fall through
			case 1:
				switch( x ) {
					case 0:
						switch( z ) {
							case 0:
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
							case 1:
								if( state.getValue( BlockStateProperties.OPEN ) ) {
									if( state.getValue( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
										return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
									} else {
										return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
									}
								} else {
									return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
								}
							case 2:
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 1:
						switch( z ) {
							case 0:
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							case 1:
								return Shapes.empty();
							case 2:
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 2:
						switch( z ) {
							case 0:
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							case 1:
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							case 2:
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
						}
						break;
				}
				break;
			case 2:
				switch( x ) {
					case 0:
						switch( z ) {
							case 0:
								return HIGH_ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
							case 1:
								return HIGH_ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing );
							case 2:
								return HIGH_ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 1:
						switch( z ) {
							case 0:
								return LEFT_MID_ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							case 1:
								return ROOF_SHAPES.getShapeFromFacing( facing );
							case 2:
								return RIGHT_MID_ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 2:
						switch( z ) {
							case 0:
								return LOW_ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
							case 1:
								return LOW_ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							case 2:
								return LOW_ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
						}
						break;
				}
				break;
		}
		return Shapes.block();
	}
}
