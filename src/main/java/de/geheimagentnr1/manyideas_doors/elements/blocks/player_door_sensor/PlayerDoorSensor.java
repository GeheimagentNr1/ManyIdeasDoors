package de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor;

import com.mojang.serialization.MapCodec;
import de.geheimagentnr1.manyideas_core.ManyIdeasCore;
import de.geheimagentnr1.manyideas_core.elements.block_state_properties.BlockSide;
import de.geheimagentnr1.manyideas_core.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.elements.items.tools.redstone_key.interfaces.RedstoneKeyable;
import de.geheimagentnr1.manyideas_core.elements.items.tools.redstone_key.models.Option;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.minecraft_forge_api.util.TranslationKeyHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class PlayerDoorSensor extends BaseEntityBlock implements BlockItemInterface, RedstoneKeyable {
	
	
	@NotNull
	public static final String registry_name = "player_door_sensor";
	
	@NotNull
	public static final MapCodec<PlayerDoorSensor> CODEC = simpleCodec( properties -> new PlayerDoorSensor() );
	
	@NotNull
	static final IntegerProperty SENSOR_RANGE = IntegerProperty.create( "sensor_range", 1, 3 );
	
	@NotNull
	private static final Component SENSOR_RANGE_CONTAINER_TITLE =
		TranslationKeyHelper.generateMessageTranslationTextComponent( ManyIdeasDoors.MODID, "sensor_range" );
	
	@NotNull
	private static final ResourceLocation ICON_TEXTURES = new ResourceLocation(
		ManyIdeasCore.MODID,
		"textures/gui/redstone_key/icons/icons_numbers.png"
	);
	
	@NotNull
	private static final VoxelShapeMemory SINGLE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 3, 0, 0, 13, 1.5, 1.5 )
	);
	
	@NotNull
	private static final VoxelShapeMemory LEFT = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 11, 0, 0, 16, 1.5, 1.5 )
	);
	
	@NotNull
	private static final VoxelShapeMemory MIDDLE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 16, 1.5, 1.5 )
	);
	
	@NotNull
	private static final VoxelShapeMemory RIGHT = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 5, 1.5, 1.5 )
	);
	
	public PlayerDoorSensor() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.NONE )
				.strength( 5 )
				.requiresCorrectToolForDrops()
				.noOcclusion()
				.isViewBlocking( ( state, level, pos ) -> false )
				.sound( SoundType.METAL )
		);
		registerDefaultState( defaultBlockState().setValue( BlockStateProperties.POWERED, false )
			.setValue( SENSOR_RANGE, 1 ) );
	}
	
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		
		return CODEC;
	}
	
	@NotNull
	@Override
	public RenderShape getRenderShape( @NotNull BlockState state ) {
		
		return RenderShape.MODEL;
	}
	
	@SuppressWarnings( "deprecation" )
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		return switch( state.getValue( ModBlockStateProperties.BLOCK_SIDE ) ) {
			case SINGLE -> SINGLE.getShapeFromHorizontalFacing( facing );
			case LEFT -> LEFT.getShapeFromHorizontalFacing( facing );
			case MIDDLE -> MIDDLE.getShapeFromHorizontalFacing( facing );
			case RIGHT -> RIGHT.getShapeFromHorizontalFacing( facing );
		};
	}
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity( @NotNull BlockPos pos, @NotNull BlockState state ) {
		
		return new PlayerDoorSensorEntity( pos, state );
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
		@NotNull Level level,
		@NotNull BlockState state,
		@NotNull BlockEntityType<T> blockEntityType ) {
		
		return level.isClientSide ? null : createTickerHelper(
			blockEntityType,
			ModBlocksRegisterFactory.PLAYER_DOOR_SENSOR_ENTITY,
			PlayerDoorSensorEntity::tick
		);
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public int getDirectSignal(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull Direction side ) {
		
		return getSignal( state, level, pos, side );
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public int getSignal(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull Direction side ) {
		
		return state.getValue( BlockStateProperties.POWERED ) ? 15 : 0;
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		return setProperties( defaultBlockState().setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection()
		), context.getLevel(), context.getClickedPos() );
	}
	
	@SuppressWarnings( "deprecation" )
	@NotNull
	@Override
	public BlockState updateShape(
		@NotNull BlockState state,
		@NotNull Direction facing,
		@NotNull BlockState facingState,
		@NotNull LevelAccessor level,
		@NotNull BlockPos currentPos,
		@NotNull BlockPos facingPos ) {
		
		BlockState newState = setProperties( state, level, currentPos );
		if( facingState.getBlock() == this ) {
			return newState.setValue( SENSOR_RANGE, facingState.getValue( SENSOR_RANGE ) );
		} else {
			return newState;
		}
	}
	
	private BlockState setProperties( BlockState stateIn, LevelAccessor level, BlockPos currentPos ) {
		
		Direction direction = stateIn.getValue( BlockStateProperties.HORIZONTAL_FACING );
		BlockState leftState = level.getBlockState( currentPos.relative( direction.getCounterClockWise() ) );
		BlockState rightState = level.getBlockState( currentPos.relative( direction.getClockWise() ) );
		boolean leftBlockIsPlayerDoorSensor = leftState.getBlock() == ModBlocksRegisterFactory.PLAYER_DOOR_SENSOR &&
			leftState.getValue( BlockStateProperties.HORIZONTAL_FACING ) == direction;
		boolean rightBlockIsPlayerDoorSensor = rightState.getBlock() == ModBlocksRegisterFactory.PLAYER_DOOR_SENSOR &&
			rightState.getValue( BlockStateProperties.HORIZONTAL_FACING ) == direction;
		
		if( leftBlockIsPlayerDoorSensor ) {
			if( rightBlockIsPlayerDoorSensor ) {
				return stateIn.setValue( ModBlockStateProperties.BLOCK_SIDE, BlockSide.MIDDLE )
					.setValue( SENSOR_RANGE, leftState.getValue( SENSOR_RANGE ) );
			} else {
				return stateIn.setValue( ModBlockStateProperties.BLOCK_SIDE, BlockSide.RIGHT )
					.setValue( SENSOR_RANGE, leftState.getValue( SENSOR_RANGE ) );
			}
		} else {
			if( rightBlockIsPlayerDoorSensor ) {
				return stateIn.setValue( ModBlockStateProperties.BLOCK_SIDE, BlockSide.LEFT )
					.setValue( SENSOR_RANGE, rightState.getValue( SENSOR_RANGE ) );
			} else {
				return stateIn.setValue( ModBlockStateProperties.BLOCK_SIDE, BlockSide.SINGLE );
			}
		}
	}
	
	@SuppressWarnings( "deprecation" )
	@Override
	public void onRemove(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull BlockState newState,
		boolean isMoving ) {
		
		super.onRemove( state, level, pos, newState, isMoving );
		notifyNeighbors( level, pos, this, state.getValue( BlockStateProperties.HORIZONTAL_FACING ) );
	}
	
	@Override
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add(
			BlockStateProperties.HORIZONTAL_FACING,
			BlockStateProperties.POWERED,
			ModBlockStateProperties.BLOCK_SIDE,
			SENSOR_RANGE
		);
	}
	
	//package-private
	void notifyNeighbors(
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Block block,
		@NotNull Direction facing ) {
		
		level.updateNeighborsAt( pos, block );
		level.updateNeighborsAt( pos.relative( facing ), block );
	}
	
	@NotNull
	@Override
	public Component getTitle() {
		
		return SENSOR_RANGE_CONTAINER_TITLE;
	}
	
	@NotNull
	@Override
	public ResourceLocation getIconTextures() {
		
		return ICON_TEXTURES;
	}
	
	@NotNull
	@Override
	public List<Option> getOptions() {
		
		ArrayList<Option> options = new ArrayList<>();
		for( Integer range : SENSOR_RANGE.getPossibleValues() ) {
			options.add( new Option(
				TranslationKeyHelper.generateMessageTranslationKey( ManyIdeasDoors.MODID, range + ".title" ),
				TranslationKeyHelper.generateMessageTranslationKey( ManyIdeasDoors.MODID, range + ".description" )
			) );
		}
		return options;
	}
	
	@Override
	public int getStateIndex( @NotNull BlockState state ) {
		
		return state.getValue( SENSOR_RANGE ) - 1;
	}
	
	@Override
	public void setBlockStateValue(
		@NotNull Level level,
		@NotNull BlockState state,
		@NotNull BlockPos pos,
		int stateIndex,
		@NotNull Player player ) {
		
		level.setBlock( pos, state.setValue( SENSOR_RANGE, stateIndex + 1 ), 3 );
	}
}
