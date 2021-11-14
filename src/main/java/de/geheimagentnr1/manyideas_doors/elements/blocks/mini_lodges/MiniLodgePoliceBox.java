package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeHelper;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;


public class MiniLodgePoliceBox extends MiniLodge {
	
	
	public static final String registry_name = "mini_lodge_police_box";
	
	private static final VoxelShapeMemory ROOF_CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 12.5, 0, 12.5, 16, 4, 16 )
	);
	
	private static final VoxelShapeMemory ROOF_SIDE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 4, 3.5 )
	);
	
	private static final VoxelShape ROOF_SHAPE = VoxelShapeHelper.vectorsToVoxelShape( new VoxelShapeVector[] {
		VoxelShapeVector.create( 0, 0, 0, 16, 4, 16 ),
		VoxelShapeVector.create( 6.5, 4, 6.5, 9.5, 9, 9.5 )
	} );
	
	private static final VoxelShapeMemory CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.EAST,
		VoxelShapeVector.create( 12.5, 0, 12.5, 16, 16, 16 )
	);
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	public MiniLodgePoliceBox() {
		
		super(
			BlockBehaviour.Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.harvestTool( ToolType.PICKAXE )
				.harvestLevel( 0 )
				.sound( SoundType.METAL ),
			registry_name
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
	public int getLightEmission( BlockState state, BlockGetter world, BlockPos pos ) {
		
		return state.getValue( X_SIZE ) == 1 && state.getValue( Z_SIZE ) == 1 ? 7 : 0;
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
								return ROOF_SHAPE;
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
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
							case 1:
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing );
							case 2:
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 1:
						switch( z ) {
							case 0:
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							case 1:
								return ROOF_SHAPE;
							case 2:
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
						}
						break;
					case 2:
						switch( z ) {
							case 0:
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
							case 1:
								return ROOF_SIDE_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
							case 2:
								return ROOF_CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
						}
						break;
				}
				break;
		}
		return Shapes.block();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_POLICE_BOX, _properties, registry_name );
	}
}
