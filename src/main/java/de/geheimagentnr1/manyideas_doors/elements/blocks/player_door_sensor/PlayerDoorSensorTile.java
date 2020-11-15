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
		
		if( Objects.requireNonNull( world ).isRemote ) {
			return;
		}
		update_timer--;
		if( update_timer > 0 ) {
			return;
		}
		update_timer = 5;
		BlockState state = world.getBlockState( getPos() );
		Block block = state.getBlock();
		
		if( !( block instanceof PlayerDoorSensor ) ) {
			return;
		}
		PlayerDoorSensor playerDoorSensor = (PlayerDoorSensor)block;
		Direction facing = state.get( BlockStateProperties.HORIZONTAL_FACING );
		AxisAlignedBB toCheckArea;
		switch( facing ) {
			case NORTH:
				toCheckArea = new AxisAlignedBB( getPos(), getPos()
					.offset( Direction.DOWN, state.get( PlayerDoorSensor.SENSOR_RANGE ) )
					.offset( facing.getOpposite(), 2 ).offset( facing.rotateY() ) );
				break;
			case EAST:
				toCheckArea = new AxisAlignedBB( getPos().offset( facing ), getPos()
					.offset( Direction.DOWN, state.get( PlayerDoorSensor.SENSOR_RANGE ) )
					.offset( facing.getOpposite() ).offset( facing.rotateY() ) );
				break;
			case SOUTH:
				toCheckArea = new AxisAlignedBB( getPos().offset( facing ), getPos()
					.offset( Direction.DOWN, state.get( PlayerDoorSensor.SENSOR_RANGE ) )
					.offset( facing.getOpposite() ).offset( facing.rotateYCCW() ) );
				break;
			case WEST:
				toCheckArea = new AxisAlignedBB( getPos(), getPos()
					.offset( Direction.DOWN, state.get( PlayerDoorSensor.SENSOR_RANGE ) )
					.offset( facing.getOpposite(), 2 ).offset( facing.rotateYCCW() ) );
				break;
			default:
				return;
		}
		
		List<PlayerEntity> foundEntities = world.getEntitiesWithinAABB( PlayerEntity.class, toCheckArea );
		
		if( foundEntities.isEmpty() ) {
			world.setBlockState( pos, state.with( BlockStateProperties.POWERED, false ), 3 );
			playerDoorSensor.notifyNeighbors( world, pos, block, facing );
		} else {
			world.setBlockState( pos, state.with( BlockStateProperties.POWERED, true ), 3 );
			playerDoorSensor.notifyNeighbors( world, pos, block, facing );
			update_timer = 15;
		}
	}
}
