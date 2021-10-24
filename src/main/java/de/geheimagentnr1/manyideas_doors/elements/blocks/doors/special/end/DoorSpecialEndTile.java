package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.IEndBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;


public class DoorSpecialEndTile extends EndPortalTileEntity {
	
	
	public DoorSpecialEndTile() {
		
		super( ModBlocks.DOOR_SPECIAL_END_TILE );
	}
	
	//package-private
	boolean shouldRender() {
		
		if( level != null ) {
			return !level.getBlockState( worldPosition ).getValue( BlockStateProperties.OPEN );
		}
		return true;
	}
	
	@Override
	public boolean shouldRenderFace( @Nonnull Direction face ) {
		
		if( level == null ) {
			return true;
		}
		BlockPos direction_pos = worldPosition.relative( face );
		BlockState direction_state = level.getBlockState( direction_pos );
		if( direction_state.getRenderShape() == BlockRenderType.INVISIBLE ) {
			return true;
		}
		if( direction_state.getBlock() instanceof IEndBlock ) {
			return direction_state.getValue( BlockStateProperties.OPEN );
		}
		return !Block.isFaceFull( direction_state.getShape( level, direction_pos ), face.getOpposite() );
	}
}
