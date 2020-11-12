package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
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


public class MiniLodgePoliceBox extends MiniLodge {
	
	
	public static final String registry_name = "mini_lodge_police_box";
	
	private static final VoxelShape ROOF_SHAPE = makeCuboidShape( -3.5, 0, -3.5, 19.5, 9, 19.5 );
	
	private static final VoxelShapeMemory CORNER_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.EAST,
		VoxelShapeVector.create( 12.5, 0, 12.5, 16, 16, 16 ) );
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 ) );
	
	public MiniLodgePoliceBox() {
		
		super( Block.Properties.create( Material.IRON ).hardnessAndResistance( 5.0F ).sound( SoundType.METAL ),
			registry_name );
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public int getLightValue( BlockState state ) {
		
		return state.get( X_SIZE ) == 1 && state.get( Z_SIZE ) == 1 ? 7 : 0;
	}
	
	@SuppressWarnings( { "deprecation", "NestedSwitchStatement" } )
	@Nonnull
	@Override
	public VoxelShape getShape( BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction facing = state.get( BlockStateProperties.HORIZONTAL_FACING );
		int x = state.get( X_SIZE );
		int z = state.get( Z_SIZE );
		switch( x ) {
			case 0:
				switch( z ) {
					case 0:
						return CORNER_SHAPES.getShapeFromHorizontalFacing( facing );
					case 1:
						if( state.get( BlockStateProperties.OPEN ) ) {
							if( state.get( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.rotateYCCW() );
							} else {
								return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.rotateY() );
							}
						} else {
							return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
						}
					case 2:
						return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.rotateYCCW() );
				}
				break;
			case 1:
				switch( z ) {
					case 0:
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.rotateY() );
					case 1:
						return ROOF_SHAPE;
					case 2:
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.rotateYCCW() );
				}
				break;
			case 2:
				switch( z ) {
					case 0:
						return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.rotateY() );
					case 1:
						return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
					case 2:
						return CORNER_SHAPES.getShapeFromHorizontalFacing( facing.getOpposite() );
				}
				break;
		}
		return VoxelShapes.fullCube();
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_POLICE_BOX, properties, registry_name );
	}
}
