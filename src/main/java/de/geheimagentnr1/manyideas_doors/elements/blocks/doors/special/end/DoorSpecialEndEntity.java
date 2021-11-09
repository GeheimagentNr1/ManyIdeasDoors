package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.end_block.EndBlockEntity;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nonnull;


public class DoorSpecialEndEntity extends TheEndPortalBlockEntity {
	
	
	public DoorSpecialEndEntity( BlockPos pos, BlockState state ) {
		
		super( ModBlocks.DOOR_SPECIAL_END_ENTITY, pos, state );
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
		
		return EndBlockEntity.shouldRender( level, worldPosition, face );
	}
}
