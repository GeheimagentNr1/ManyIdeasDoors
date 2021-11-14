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
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;


public class BigDoorPortcullis extends BigDoor {
	
	
	public static final String registry_name = "big_door_portcullis";
	
	private static final VoxelShapeMemory TOP = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 12, 2.5, 16, 16, 13.5 ),
		VoxelShapeVector.create( 0, 0, 4.75, 16, 12, 11 )
	);
	
	private static final VoxelShapeMemory DEFAULT = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 4.75, 16, 16, 11 )
	);
	
	public BigDoorPortcullis() {
		
		super(
			AbstractBlock.Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.harvestTool( ToolType.PICKAXE )
				.harvestLevel( 0 )
				.sound( SoundType.METAL ),
			registry_name,
			OpenedBy.BOTH,
			false
		);
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull IBlockReader level,
		@Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction.Axis axis = state.getValue( BlockStateProperties.HORIZONTAL_FACING ).getAxis();
		if( state.getValue( Y_SIZE ) == 6 ) {
			return TOP.getShapeFromHorizontalAxis( axis );
		} else {
			if( state.getValue( BlockStateProperties.OPEN ) ) {
				return VoxelShapes.empty();
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
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_PORTCULLIS, _properties, registry_name );
	}
}
