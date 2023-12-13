package de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocksRegisterFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;


public class PlayerDoorSensorEntity extends BlockEntity {
	
	
	private int update_timer = 0;
	
	public PlayerDoorSensorEntity( @NotNull BlockPos pos, @NotNull BlockState state ) {
		
		super( ModBlocksRegisterFactory.PLAYER_DOOR_SENSOR_ENTITY, pos, state );
	}
	
	@SuppressWarnings( "WeakerAccess" )
	public static void tick(
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull BlockState state,
		@NotNull PlayerDoorSensorEntity entity ) {
		
		if( Objects.requireNonNull( level ).isClientSide ) {
			return;
		}
		entity.update_timer--;
		if( entity.update_timer > 0 ) {
			return;
		}
		entity.update_timer = 5;
		Block block = state.getBlock();
		
		if( !( block instanceof PlayerDoorSensor playerDoorSensor ) ) {
			return;
		}
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		AABB toCheckArea;
		switch( facing ) {
			case NORTH -> toCheckArea = AABB.encapsulatingFullBlocks(
				pos,
				pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
					.relative( facing.getOpposite(), 2 )
					.relative( facing.getClockWise() )
			);
			case EAST -> toCheckArea = AABB.encapsulatingFullBlocks(
				pos.relative( facing ),
				pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
					.relative( facing.getOpposite() )
					.relative( facing.getClockWise() )
			);
			case SOUTH -> toCheckArea = AABB.encapsulatingFullBlocks(
				pos.relative( facing ),
				pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
					.relative( facing.getOpposite() )
					.relative( facing.getCounterClockWise() )
			);
			case WEST -> toCheckArea = AABB.encapsulatingFullBlocks(
				pos,
				pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
					.relative( facing.getOpposite(), 2 )
					.relative( facing.getCounterClockWise() )
			);
			default -> {
				return;
			}
		}
		
		List<Player> foundEntities = level.getEntitiesOfClass( Player.class, toCheckArea );
		
		if( foundEntities.isEmpty() ) {
			level.setBlock( pos, state.setValue( BlockStateProperties.POWERED, false ), 3 );
			playerDoorSensor.notifyNeighbors( level, pos, block, facing );
		} else {
			level.setBlock( pos, state.setValue( BlockStateProperties.POWERED, true ), 3 );
			playerDoorSensor.notifyNeighbors( level, pos, block, facing );
			entity.update_timer = 15;
		}
	}
}
