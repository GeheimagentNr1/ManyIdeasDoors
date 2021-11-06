package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;


public class BigDoorLaboratory extends BigDoor {
	
	
	public static final String registry_name = "big_door_laboratory";
	
	private static final VoxelShapeMemory SHAPE_CLOSED = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 6.5, 16, 16, 9.5 )
	);
	
	private static final VoxelShapeMemory SHAPE_OPEN_LEFT = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 6.5, 6, 16, 9.5 )
	);
	
	private static final VoxelShapeMemory SHAPE_OPEN_RIGHT = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 10, 0, 6.5, 16, 16, 9.5 )
	);
	
	public BigDoorLaboratory() {
		
		super(
			AbstractBlock.Properties.of( Material.METAL ).strength( 5.0F ).sound( SoundType.METAL ),
			registry_name,
			OpenedBy.BOTH,
			false
		);
	}
	
	@Override
	protected int getXSize() {
		
		return 1;
	}
	
	@Override
	protected int getYSize() {
		
		return 2;
	}
	
	@Override
	protected int getZSize() {
		
		return 3;
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction direction = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		
		if( state.getValue( BlockStateProperties.OPEN ) ) {
			switch( state.getValue( Z_SIZE ) ) {
				case 0:
					return SHAPE_OPEN_LEFT.getShapeFromHorizontalFacing( direction );
				case 2:
					return SHAPE_OPEN_RIGHT.getShapeFromHorizontalFacing( direction );
			}
		} else {
			return SHAPE_CLOSED.getShapeFromHorizontalAxis( direction.getAxis() );
		}
		return VoxelShapes.empty();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_LABORATORY, _properties, registry_name );
	}
}
