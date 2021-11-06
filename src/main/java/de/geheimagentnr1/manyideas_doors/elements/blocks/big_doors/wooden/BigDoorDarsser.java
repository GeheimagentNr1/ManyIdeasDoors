package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public class BigDoorDarsser extends BigDoor {
	
	
	public static final String registry_name = "big_door_darsser";
	
	private static final VoxelShapeMemory DOORS_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 16, 3 )
	);
	
	public BigDoorDarsser() {
		
		super(
			AbstractBlock.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			registry_name,
			OpenedBy.BOTH,
			false
		);
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.translucent();
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		if( state.getValue( BlockStateProperties.OPEN ) && state.getValue( Z_SIZE ) == 1 &&
			state.getValue( Y_SIZE ) != 2 ) {
			if( state.getValue( BlockStateProperties.DOOR_HINGE ) == DoorHingeSide.LEFT ) {
				return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
			} else {
				return DOORS_SHAPES.getShapeFromHorizontalFacing( facing.getCounterClockWise() );
			}
		}
		return DOORS_SHAPES.getShapeFromHorizontalFacing( facing );
	}
	
	@Nonnull
	@Override
	public ActionResultType use(
		@Nonnull BlockState state,
		@Nonnull World level,
		@Nonnull BlockPos pos,
		@Nonnull PlayerEntity player,
		@Nonnull Hand hand,
		@Nonnull BlockRayTraceResult hitResult ) {
		
		if( state.getValue( Z_SIZE ) == 1 && state.getValue( Y_SIZE ) != 2 ) {
			return super.use( state, level, pos, player, hand, hitResult );
		}
		return ActionResultType.PASS;
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
		
		return createBlockItem( ModBlocks.BIG_DOOR_DARSSER, _properties, registry_name );
	}
}
