package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.EndBlockTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;


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
	boolean shouldRender( Direction direction ) {
		
		return EndBlockTile.shouldRender( world, pos, direction );
	}
}
