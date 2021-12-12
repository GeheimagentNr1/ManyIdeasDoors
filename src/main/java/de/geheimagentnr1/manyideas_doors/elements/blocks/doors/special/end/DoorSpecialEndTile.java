package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.EndBlockTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraft.util.Direction;

import javax.annotation.Nonnull;


public class DoorSpecialEndTile extends EndPortalTileEntity {
	
	
	public DoorSpecialEndTile() {
		
		super( ModBlocks.DOOR_SPECIAL_END_TILE );
	}
	
	//package-private
	boolean shouldRender() {
		
		if( level != null ) {
			BlockState state = level.getBlockState( worldPosition );
			return state.getBlock() == ModBlocks.DOOR_SPECIAL_END && !state.getValue( BlockStateProperties.OPEN );
		}
		return true;
	}
	
	@Override
	public boolean shouldRenderFace( @Nonnull Direction face ) {
		
		return EndBlockTile.shouldRender( level, worldPosition, face );
	}
}
