package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;


public class BigDoorTerrace extends BigDoor {
	
	
	public static final String registry_name = "big_door_terrace";
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	private static final VoxelShapeMemory LEFT_DOORS_OPEN_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 7, 0, 0, 16, 16, 3 )
	);
	
	private static final VoxelShapeMemory RIGHT_DOORS_OPEN_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 9, 16, 3 )
	);
	
	public BigDoorTerrace() {
		
		super(
			Properties.create( Material.IRON ).hardnessAndResistance( 5.0F ).sound( SoundType.METAL ),
			registry_name,
			OpenedBy.BOTH,
			false
		);
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		BlockState state,
		@Nonnull IBlockReader worldIn,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction facing = state.get( BlockStateProperties.HORIZONTAL_FACING );
		int z = state.get( Z_SIZE );
		
		if( state.get( BlockStateProperties.OPEN ) ) {
			if( state.get( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
				switch( z ) {
					case 0:
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
					case 1:
						return LEFT_DOORS_OPEN_SHAPES.getShapeFromHorizontalFacing( facing );
				}
			} else {
				switch( z ) {
					case 1:
						return RIGHT_DOORS_OPEN_SHAPES.getShapeFromHorizontalFacing( facing );
					case 2:
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
				}
			}
		} else {
			return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
		}
		return VoxelShapes.empty();
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
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_TERRACE, properties, registry_name );
	}
}
