package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class BigDoorTerrace extends BigDoorMetal {
	
	
	@NotNull
	public static final String registry_name = "big_door_terrace";
	
	@NotNull
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	@NotNull
	private static final VoxelShapeMemory LEFT_DOORS_OPEN_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 7, 0, 0, 16, 16, 3 )
	);
	
	@NotNull
	private static final VoxelShapeMemory RIGHT_DOORS_OPEN_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 9, 16, 3 )
	);
	
	public BigDoorTerrace() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.METAL ), false );
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		int z = state.getValue( Z_SIZE );
		
		if( state.getValue( BlockStateProperties.OPEN ) ) {
			if( state.getValue( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
				switch( z ) {
					case 0 -> {
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
					}
					case 1 -> {
						return LEFT_DOORS_OPEN_SHAPES.getShapeFromHorizontalFacing( facing );
					}
				}
			} else {
				switch( z ) {
					case 1 -> {
						return RIGHT_DOORS_OPEN_SHAPES.getShapeFromHorizontalFacing( facing );
					}
					case 2 -> {
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
					}
				}
			}
		} else {
			return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
		}
		return Shapes.empty();
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
