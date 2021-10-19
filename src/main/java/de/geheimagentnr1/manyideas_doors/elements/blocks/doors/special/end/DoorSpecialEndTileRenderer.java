package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.EndPortalTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

import javax.annotation.Nonnull;


public class DoorSpecialEndTileRenderer extends EndPortalTileEntityRenderer<DoorSpecialEndTile> {
	
	
	public DoorSpecialEndTileRenderer( TileEntityRendererDispatcher rendererDispatcherIn ) {
		
		super( rendererDispatcherIn );
	}
	
	@Override
	public void render(
		DoorSpecialEndTile tileEntityIn,
		float partialTicks,
		@Nonnull MatrixStack matrixStackIn,
		@Nonnull IRenderTypeBuffer bufferIn,
		int combinedLightIn,
		int combinedOverlayIn ) {
		
		if( tileEntityIn.shouldRender() ) {
			super.render( tileEntityIn, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn );
		}
	}
	
	@Override
	protected float getOffset() {
		
		return 1.0F;
	}
}
