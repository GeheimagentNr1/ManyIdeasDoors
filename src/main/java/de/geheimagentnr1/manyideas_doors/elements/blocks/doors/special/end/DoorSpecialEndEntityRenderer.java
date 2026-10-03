package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.AbstractEndPortalRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.EndPortalRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DoorSpecialEndEntityRenderer
	extends AbstractEndPortalRenderer<DoorSpecialEndEntity, DoorSpecialEndEntityRenderer.RenderState> {
	
	
	public DoorSpecialEndEntityRenderer( @NotNull BlockEntityRendererProvider.Context context ) {
		
	}
	
	@NotNull
	@Override
	public RenderState createRenderState() {
		
		return new RenderState();
	}
	
	@Override
	public void extractRenderState(
		@NotNull DoorSpecialEndEntity blockEntity,
		@NotNull RenderState renderState,
		float partialTick,
		@NotNull Vec3 cameraPos,
		@Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay ) {
		
		super.extractRenderState( blockEntity, renderState, partialTick, cameraPos, crumblingOverlay );
		renderState.shouldRender = blockEntity.shouldRender();
	}
	
	@Override
	public void submit(
		@NotNull RenderState renderState,
		@NotNull PoseStack poseStack,
		@NotNull SubmitNodeCollector submitNodeCollector,
		@NotNull CameraRenderState cameraRenderState ) {
		
		//Full block (vanilla end portal: 0.375 - 0.75)
		if( renderState.shouldRender ) {
			submitCube( renderState.facesToShow, RenderTypes.endPortal(), poseStack, submitNodeCollector );
		}
	}
	
	public static class RenderState extends EndPortalRenderState {
		
		
		private boolean shouldRender;
	}
}
