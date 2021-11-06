package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.EndPortalTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

import javax.annotation.Nonnull;


public class DoorSpecialEndTileRenderer extends EndPortalTileEntityRenderer<DoorSpecialEndTile> {
	
	
	public DoorSpecialEndTileRenderer( TileEntityRendererDispatcher rendererDispatcher ) {
		
		super( rendererDispatcher );
	}
	
	@Override
	public void render(
		DoorSpecialEndTile tileEntity,
		float partialTicks,
		@Nonnull MatrixStack matrixStack,
		@Nonnull IRenderTypeBuffer buffer,
		int combinedLight,
		int combinedOverlay ) {
		
		if( tileEntity.shouldRender() ) {
			super.render( tileEntity, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay );
		}
	}
	
	@Override
	protected float getOffset() {
		
		return 1.0F;
	}
}
