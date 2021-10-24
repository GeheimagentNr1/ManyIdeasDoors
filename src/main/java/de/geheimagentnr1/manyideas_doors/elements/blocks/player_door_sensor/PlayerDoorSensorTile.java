package de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;
import java.util.Objects;


public class PlayerDoorSensorTile extends TileEntity implements ITickableTileEntity {
	
	
	private int update_timer = 0;
	
	public PlayerDoorSensorTile() {
		
		super( ModBlocks.PLAYER_DOOR_SENSOR_TILE );
	}
	
	@Override
	public void tick() {
		
		if( Objects.requireNonNull( level ).isClientSide ) {
			return;
		}
		update_timer--;
		if( update_timer > 0 ) {
			return;
		}
		update_timer = 5;
		BlockState state = level.getBlockState( getBlockPos() );
		Block block = state.getBlock();
		
		if( !( block instanceof PlayerDoorSensor ) ) {
			return;
		}
		PlayerDoorSensor playerDoorSensor = (PlayerDoorSensor)block;
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		AxisAlignedBB toCheckArea;
		switch( facing ) {
			case NORTH:
				toCheckArea = new AxisAlignedBB(
					getBlockPos(),
					getBlockPos().relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite(), 2 )
						.relative( facing.getClockWise() )
				);
				break;
			case EAST:
				toCheckArea = new AxisAlignedBB(
					getBlockPos().relative( facing ),
					getBlockPos().relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite() )
						.relative( facing.getClockWise() )
				);
				break;
			case SOUTH:
				toCheckArea = new AxisAlignedBB(
					getBlockPos().relative( facing ),
					getBlockPos().relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite() )
						.relative( facing.getCounterClockWise() )
				);
				break;
			case WEST:
				toCheckArea = new AxisAlignedBB(
					getBlockPos(),
					getBlockPos().relative( Direction.DOWN, state.getValue( PlayerDoorSensor.SENSOR_RANGE ) )
						.relative( facing.getOpposite(), 2 )
						.relative( facing.getCounterClockWise() )
				);
				break;
			default:
				return;
		}
		
		List<PlayerEntity> foundEntities = level.getEntitiesOfClass( PlayerEntity.class, toCheckArea );
		
		if( foundEntities.isEmpty() ) {
			level.setBlock( getBlockPos(), state.setValue( BlockStateProperties.POWERED, false ), 3 );
			playerDoorSensor.notifyNeighbors( level, getBlockPos(), block, facing );
		} else {
			level.setBlock( getBlockPos(), state.setValue( BlockStateProperties.POWERED, true ), 3 );
			playerDoorSensor.notifyNeighbors( level, getBlockPos(), block, facing );
			update_timer = 15;
		}
	}
}
