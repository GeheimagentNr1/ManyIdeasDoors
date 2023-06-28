package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeHelper;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class MiniLodgePoliceBox extends MiniLodge {
	
	
	@NotNull
	
	public static final String registry_name = "mini_lodge_police_box";
	
	@NotNull
	private static final VoxelShapeMemory ROOF_CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 12.5, 0, 12.5, 16, 4, 16 )
	);
	
	@NotNull
	private static final VoxelShapeMemory ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 4, 3.5 )
	);
	
	@NotNull
	private static final VoxelShape ROOF_SHAPE = VoxelShapeHelper.vectorsToVoxelShape( new VoxelShapeVector[] {
		VoxelShapeVector.create( 0, 0, 0, 16, 4, 16 ),
		VoxelShapeVector.create( 6.5, 4, 6.5, 9.5, 9, 9.5 )
	} );
	
	@NotNull
	private static final VoxelShapeMemory CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 12.5, 0, 12.5, 16, 16, 16 )
	);
	
	@NotNull
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	public MiniLodgePoliceBox() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.LAPIS )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			BlockSetType.IRON
		);
	}
	
	@Override
	protected boolean[][][] hasBlockStatesAtPos() {
		
		return new boolean[][][] {
			{ { true, true, true }, { true, true, true }, { true, true, true } },
			{ { true, false, true }, { true, false, true }, { true, true, true } },
			{ { true, true, true }, { true, true, true }, { true, true, true } },
		};
	}
	
	@Override
	public int getLightEmission( @NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos ) {
		
		return state.getValue( X_SIZE ) == 1 && state.getValue( Z_SIZE ) == 1 ? 7 : 0;
	}
	
	@SuppressWarnings( { "deprecation", "NestedSwitchStatement" } )
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		int x = state.getValue( X_SIZE );
		int y = state.getValue( Y_SIZE );
		int z = state.getValue( Z_SIZE );
		
		switch( y ) { //fall through
			case 0, 1 -> {
				switch( x ) {
					case 0 -> {
						switch( z ) {
							case 0 -> {
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
							}
							case 1 -> {
								if( state.getValue( BlockStateProperties.OPEN ) ) {
									if( state.getValue( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
										return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
									} else {
										return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
									}
								} else {
									return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
								}
							}
							case 2 -> {
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
							}
						}
					}
					case 1 -> {
						switch( z ) {
							case 0 -> {
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							}
							case 1 -> {
								return ROOF_SHAPE;
							}
							case 2 -> {
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
							}
						}
					}
					case 2 -> {
						switch( z ) {
							case 0 -> {
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							}
							case 1 -> {
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							}
							case 2 -> {
								return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							}
						}
					}
				}
			}
			case 2 -> {
				switch( x ) {
					case 0 -> {
						switch( z ) {
							case 0 -> {
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
							}
							case 1 -> {
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing );
							}
							case 2 -> {
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
							}
						}
					}
					case 1 -> {
						switch( z ) {
							case 0 -> {
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							}
							case 1 -> {
								return ROOF_SHAPE;
							}
							case 2 -> {
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
							}
						}
					}
					case 2 -> {
						switch( z ) {
							case 0 -> {
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							}
							case 1 -> {
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							}
							case 2 -> {
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							}
						}
					}
				}
			}
		}
		return Shapes.block();
	}
}
