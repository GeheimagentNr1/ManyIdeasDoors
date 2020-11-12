package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.IEndBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;


public class DoorSpecialEndTile extends TileEntity {
	
	
	public DoorSpecialEndTile() {
		
		super( ModBlocks.DOOR_SPECIAL_END_TILE );
	}
	
	//package-private
	boolean shouldRender() {
		
		if( world != null ) {
			return !world.getBlockState( pos ).get( BlockStateProperties.OPEN );
		}
		return true;
	}
	
	//package-private
	@SuppressWarnings( "deprecation" )
	boolean shouldRender( Direction direction ) {
		
		if( world == null ) {
			return true;
		}
		BlockPos direction_pos = pos.offset( direction );
		BlockState direction_state = world.getBlockState( direction_pos );
		if( direction_state.getRenderType() == BlockRenderType.INVISIBLE ) {
			return true;
		}
		if( direction_state.getBlock() instanceof IEndBlock ) {
			return false;
		}
		if( direction_state.getBlock().getRenderLayer() == BlockRenderLayer.SOLID ) {
			return !Block.hasSolidSide( direction_state, world, direction_pos, direction.getOpposite() );
		} else {
			return !direction_state.getBlock().isSolid( direction_state );
		}
	}
}
