package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;


public class DoorSpecialPortcullis extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_special_portcullis";
	
	private static final VoxelShapeMemory TOP_CLOSED = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 14, 5.5, 16, 16, 10.5 ),
		VoxelShapeVector.create( 0, 0, 6.5, 16, 14, 9.5 )
	);
	
	private static final VoxelShapeMemory BOTTOM_CLOSED = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 6.5, 16, 16, 9.5 )
	);
	
	private static final VoxelShapeMemory TOP_OPEN = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 14, 5.5, 16, 16, 10.5 ),
		VoxelShapeVector.create( 0, 11.5, 6.5, 16, 14, 9.5 )
	);
	
	public DoorSpecialPortcullis() {
		
		super(
			AbstractBlock.Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.harvestTool( ToolType.PICKAXE )
				.harvestLevel( 0 )
				.sound( SoundType.METAL ),
			registry_name,
			OpenedBy.REDSTONE
		);
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction.Axis axis = state.getValue( FACING ).getAxis();
		if( state.getValue( OPEN ) ) {
			switch( state.getValue( HALF ) ) {
				case UPPER:
					return TOP_OPEN.getShapeFromHorizontalAxis( axis );
				case LOWER:
					return VoxelShapes.empty();
			}
		} else {
			switch( state.getValue( HALF ) ) {
				case UPPER:
					return TOP_CLOSED.getShapeFromHorizontalAxis( axis );
				case LOWER:
					return BOTTOM_CLOSED.getShapeFromHorizontalAxis( axis );
			}
		}
		return VoxelShapes.block();
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public VoxelShape getCollisionShape(
		@Nonnull BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		if( state.getValue( OPEN ) ) {
			return VoxelShapes.empty();
		} else {
			return super.getCollisionShape( state, level, pos, context );
		}
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_PORTCULLIS, _properties, registry_name );
	}
}
