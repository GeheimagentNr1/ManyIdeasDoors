package de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Objects;


public class PlayerDoorSensorEntity extends BlockEntity {
	
	
	private int update_timer = 0;
	
	public PlayerDoorSensorEntity( BlockPos pos, BlockState state ) {
		
		super( ModBlocks.PLAYER_DOOR_SENSOR_ENTITY, pos, state );
	}
	
	@SuppressWarnings( "WeakerAccess" )
	public static void tick( Level level, BlockPos pos, BlockState state, PlayerDoorSensorEntity entity ) {
		
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
			case NORTH:
				toCheckArea = new AABB(
					pos,
					pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite(), 2 )
						.relative( facing.getClockWise() )
				);
				break;
			case EAST:
				toCheckArea = new AABB(
					pos.relative( facing ),
					pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite() )
						.relative( facing.getClockWise() )
				);
				break;
			case SOUTH:
				toCheckArea = new AABB(
					pos.relative( facing ),
					pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite() )
						.relative( facing.getCounterClockWise() )
				);
				break;
			case WEST:
				toCheckArea = new AABB(
					pos,
					pos.relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite(), 2 )
						.relative( facing.getCounterClockWise() )
				);
				break;
			default:
				return;
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
