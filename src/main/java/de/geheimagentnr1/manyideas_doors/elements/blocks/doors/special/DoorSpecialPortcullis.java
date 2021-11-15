package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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
			BlockBehaviour.Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			registry_name,
			OpenedBy.REDSTONE
		);
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		Direction.Axis axis = state.getValue( FACING ).getAxis();
		if( state.getValue( OPEN ) ) {
			return switch( state.getValue( HALF ) ) {
				case UPPER -> TOP_OPEN.getShapeFromHorizontalAxis( axis );
				case LOWER -> Shapes.empty();
			};
		} else {
			return switch( state.getValue( HALF ) ) {
				case UPPER -> TOP_CLOSED.getShapeFromHorizontalAxis( axis );
				case LOWER -> BOTTOM_CLOSED.getShapeFromHorizontalAxis( axis );
			};
		}
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public VoxelShape getCollisionShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		if( state.getValue( OPEN ) ) {
			return Shapes.empty();
		} else {
			return super.getCollisionShape( state, level, pos, context );
		}
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_PORTCULLIS, _properties, registry_name );
	}
}
