package de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.BlockSide;
import de.geheimagentnr1.manyideas_core.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class PlayerDoorSensor extends Block implements BlockItemInterface {
	
	
	public static final String registry_name = "player_door_sensor";
	
	//package_private
	static final IntegerProperty SENSOR_RANGE = IntegerProperty.create( "sensor_range", 1, 3 );
	
	private static final VoxelShapeMemory SINGLE = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.NORTH,
		VoxelShapeVector.create( 3, 0, 0, 13, 1.5, 1.5 ) );
	
	private static final VoxelShapeMemory LEFT = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.NORTH,
		VoxelShapeVector.create( 11, 0, 0, 16, 1.5, 1.5 ) );
	
	private static final VoxelShapeMemory MIDDLE = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 1.5, 1.5 ) );
	
	private static final VoxelShapeMemory RIGHT = VoxelShapeMemory.createHorizontalVoxelShapes( Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 5, 1.5, 1.5 ) );
	
	public PlayerDoorSensor() {
		
		super( Block.Properties.create( Material.IRON ).hardnessAndResistance( 5 ).sound( SoundType.METAL ) );
		setRegistryName( registry_name );
		setDefaultState( getDefaultState().with( BlockStateProperties.POWERED, false ).with( SENSOR_RANGE, 1 ) );
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public VoxelShape getShape( @Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos,
		@Nonnull ISelectionContext context ) {
		
		Direction facing = state.get( BlockStateProperties.HORIZONTAL_FACING );
		switch( state.get( ModBlockStateProperties.BLOCK_SIDE ) ) {
			case SINGLE:
				return SINGLE.getShapeFromHorizontalFacing( facing );
			case LEFT:
				return LEFT.getShapeFromHorizontalFacing( facing );
			case MIDDLE:
				return MIDDLE.getShapeFromHorizontalFacing( facing );
			case RIGHT:
				return RIGHT.getShapeFromHorizontalFacing( facing );
		}
		return VoxelShapes.empty();
	}
	
	@Override
	public boolean hasTileEntity( BlockState state ) {
		
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity( BlockState state, IBlockReader world ) {
		
		return new PlayerDoorSensorTile();
	}
	
	@SuppressWarnings( "deprecation" )
	public boolean canProvidePower( @Nonnull BlockState state ) {
		
		return true;
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public int getWeakPower( @Nonnull BlockState blockState, @Nonnull IBlockReader blockAccess,
		@Nonnull BlockPos pos, @Nonnull Direction side ) {
		
		return blockState.get( BlockStateProperties.POWERED ) ? 15 : 0;
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public int getStrongPower( @Nonnull BlockState blockState, @Nonnull IBlockReader blockAccess,
		@Nonnull BlockPos pos, @Nonnull Direction side ) {
		
		return blockState.get( BlockStateProperties.POWERED ) ? 15 : 0;
	}
	
	@Nonnull
	@Override
	public BlockRenderLayer getRenderLayer() {
		
		return BlockRenderLayer.CUTOUT;
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( @Nonnull BlockItemUseContext context ) {
		
		return setProperties( getDefaultState().with( BlockStateProperties.HORIZONTAL_FACING,
			context.getPlacementHorizontalFacing() ), context.getWorld(), context.getPos() );
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public BlockState updatePostPlacement( @Nonnull BlockState stateIn, @Nonnull Direction facing,
		@Nonnull BlockState facingState, @Nonnull IWorld worldIn, @Nonnull BlockPos currentPos,
		@Nonnull BlockPos facingPos ) {
		
		return setProperties( stateIn, worldIn.getWorld(), currentPos );
	}
	
	private BlockState setProperties( BlockState stateIn, World worldIn, BlockPos currentPos ) {
		
		Direction direction = stateIn.get( BlockStateProperties.HORIZONTAL_FACING );
		BlockState leftState = worldIn.getBlockState( currentPos.offset( direction.rotateYCCW() ) );
		BlockState rightState = worldIn.getBlockState( currentPos.offset( direction.rotateY() ) );
		boolean leftBlockIsPlayerDoorSensor = leftState.getBlock() == ModBlocks.PLAYER_DOOR_SENSOR
			&& leftState.get( BlockStateProperties.HORIZONTAL_FACING ) == direction;
		boolean rightBlockIsPlayerDoorSensor = rightState.getBlock() == ModBlocks.PLAYER_DOOR_SENSOR
			&& rightState.get( BlockStateProperties.HORIZONTAL_FACING ) == direction;
		
		if( leftBlockIsPlayerDoorSensor ) {
			if( rightBlockIsPlayerDoorSensor ) {
				return stateIn.with( ModBlockStateProperties.BLOCK_SIDE, BlockSide.MIDDLE );
			} else {
				return stateIn.with( ModBlockStateProperties.BLOCK_SIDE, BlockSide.RIGHT );
			}
		} else {
			if( rightBlockIsPlayerDoorSensor ) {
				return stateIn.with( ModBlockStateProperties.BLOCK_SIDE, BlockSide.LEFT );
			} else {
				return stateIn.with( ModBlockStateProperties.BLOCK_SIDE, BlockSide.SINGLE );
			}
		}
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public boolean onBlockActivated( @Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos,
		@Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit ) {
		
		ItemStack stack = player.getHeldItem( handIn );
		
		if( stack.getItem() == Items.REDSTONE_TORCH ) {
			state = state.cycle( SENSOR_RANGE );
			worldIn.setBlockState( pos, state, 3 );
			if( !worldIn.isRemote ) {
				player.sendMessage( new StringTextComponent( "Player Door Sensor has now a range of: " +
					state.get( SENSOR_RANGE ) ) );
			}
			return true;
		}
		return false;
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public void onReplaced( BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos,
		@Nonnull BlockState newState, boolean isMoving ) {
		
		notifyNeighbors( worldIn, pos, this, state.get( BlockStateProperties.HORIZONTAL_FACING ) );
	}
	
	@Override
	protected void fillStateContainer( StateContainer.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.POWERED,
			ModBlockStateProperties.BLOCK_SIDE, SENSOR_RANGE );
	}
	
	//package-private
	void notifyNeighbors( World world, BlockPos pos, Block block, Direction facing ) {
		
		world.notifyNeighborsOfStateChange( pos, block );
		world.notifyNeighborsOfStateChange( pos.offset( facing ), block );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.PLAYER_DOOR_SENSOR, properties, registry_name );
	}
}
