package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;


public class BigDoorPipe extends BigDoor {
	
	
	public static final String registry_name = "big_door_pipe";
	
	private static final VoxelShapeVector LEFT_SHAPE = VoxelShapeVector.create( 9.5, 0, 0, 16, 16, 16 );
	
	private static final VoxelShapeVector RIGHT_SHAPE = VoxelShapeVector.create( 0, 0, 0, 6.5, 16, 16 );
	
	private static final VoxelShapeVector TOP_SHAPE = VoxelShapeVector.create( 0, 9, 0, 16, 16, 16 );
	
	private static final VoxelShapeVector DOOR_SHAPE = VoxelShapeVector.create( 0, 0, 6.5, 16, 16, 9.5 );
	
	private static final VoxelShapeMemory TOP_LEFT_CLOSED = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE,
		LEFT_SHAPE,
		DOOR_SHAPE
	);
	
	private static final VoxelShapeMemory TOP_CLOSED = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE,
		DOOR_SHAPE
	);
	
	private static final VoxelShapeMemory TOP_RIGHT_CLOSED = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE,
		RIGHT_SHAPE,
		DOOR_SHAPE
	);
	
	private static final VoxelShapeMemory LEFT_CLOSED = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		LEFT_SHAPE,
		DOOR_SHAPE
	);
	
	private static final VoxelShapeMemory RIGHT_CLOSED = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		RIGHT_SHAPE,
		DOOR_SHAPE
	);
	
	private static final VoxelShapeMemory TOP_LEFT_OPEN = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE,
		LEFT_SHAPE
	);
	
	private static final VoxelShapeMemory TOP_OPEN = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE
	);
	
	private static final VoxelShapeMemory TOP_RIGHT_OPEN = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		TOP_SHAPE,
		RIGHT_SHAPE
	);
	
	private static final VoxelShapeMemory LEFT_OPEN = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		LEFT_SHAPE
	);
	
	private static final VoxelShapeMemory RIGHT_OPEN = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		RIGHT_SHAPE
	);
	
	private static final VoxelShapeMemory DOOR = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		DOOR_SHAPE
	);
	
	public BigDoorPipe() {
		
		super(
			Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			OpenedBy.BOTH,
			false
		);
	}
	
	@Override
	public int getLightEmission( BlockState state, BlockGetter world, BlockPos pos ) {
		
		return state.getValue( Y_SIZE ) == 2 && state.getValue( Z_SIZE ) == 1 ? 15 : 0;
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		int y = state.getValue( Y_SIZE );
		int z = state.getValue( Z_SIZE );
		
		if( state.getValue( BlockStateProperties.OPEN ) ) {
			return switch( y ) {
				case 0, 1 -> switch( z ) {
					case 0 -> LEFT_OPEN.getShapeFromHorizontalFacing( facing );
					case 1 -> Shapes.empty();
					case 2 -> RIGHT_OPEN.getShapeFromHorizontalFacing( facing );
					default -> Shapes.block();
				};
				case 2 -> switch( z ) {
					case 0 -> TOP_LEFT_OPEN.getShapeFromHorizontalFacing( facing );
					case 1 -> TOP_OPEN.getShapeFromHorizontalFacing( facing );
					case 2 -> TOP_RIGHT_OPEN.getShapeFromHorizontalFacing( facing );
					default -> Shapes.block();
				};
				default -> Shapes.block();
			};
		} else {
			return switch( y ) {
				case 0, 1 -> switch( z ) {
					case 0 -> LEFT_CLOSED.getShapeFromHorizontalFacing( facing );
					case 1 -> DOOR.getShapeFromHorizontalFacing( facing );
					case 2 -> RIGHT_CLOSED.getShapeFromHorizontalFacing( facing );
					default -> Shapes.block();
				};
				case 2 -> switch( z ) {
					case 0 -> TOP_LEFT_CLOSED.getShapeFromHorizontalFacing( facing );
					case 1 -> TOP_CLOSED.getShapeFromHorizontalFacing( facing );
					case 2 -> TOP_RIGHT_CLOSED.getShapeFromHorizontalFacing( facing );
					default -> Shapes.block();
				};
				default -> Shapes.block();
			};
		}
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
		
		return createBlockItem( ModBlocks.BIG_DOOR_PIPE, _properties, registry_name );
	}
}
