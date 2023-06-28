package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class BigDoorPortcullis extends BigDoorMetal {
	
	
	@NotNull
	public static final String registry_name = "big_door_portcullis";
	
	@NotNull
	private static final VoxelShapeMemory TOP = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 12, 2.5, 16, 16, 13.5 ),
		VoxelShapeVector.create( 0, 0, 4.75, 16, 12, 11 )
	);
	
	@NotNull
	private static final VoxelShapeMemory DEFAULT = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 4.75, 16, 16, 11 )
	);
	
	public BigDoorPortcullis() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.DEEPSLATE ), false );
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		Direction.Axis axis = state.getValue( BlockStateProperties.HORIZONTAL_FACING ).getAxis();
		if( state.getValue( Y_SIZE ) == 6 ) {
			return TOP.getShapeFromHorizontalAxis( axis );
		} else {
			if( state.getValue( BlockStateProperties.OPEN ) ) {
				return Shapes.empty();
			} else {
				return DEFAULT.getShapeFromHorizontalAxis( axis );
			}
		}
	}
	
	@Override
	protected int getXSize() {
		
		return 1;
	}
	
	@Override
	protected int getYSize() {
		
		return 7;
	}
	
	@Override
	protected int getZSize() {
		
		return 5;
	}
}
