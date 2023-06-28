package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;
import org.jetbrains.annotations.NotNull;


public class DoorSpecialEndEntityRenderer extends TheEndPortalRenderer<DoorSpecialEndEntity> {
	
	
	public DoorSpecialEndEntityRenderer( @NotNull BlockEntityRendererProvider.Context context ) {
		
		super( context );
	}
	
	@Override
	public void render(
		@NotNull DoorSpecialEndEntity tileEntity,
		float partialTicks,
		@NotNull PoseStack poseStack,
		@NotNull MultiBufferSource buffer,
		int combinedLight,
		int combinedOverlay ) {
		
		if( tileEntity.shouldRender() ) {
			super.render( tileEntity, partialTicks, poseStack, buffer, combinedLight, combinedOverlay );
		}
	}
	
	@Override
	protected float getOffsetUp() {
		
		return 1;
	}
	
	@Override
	protected float getOffsetDown() {
		
		return 0;
	}
}
