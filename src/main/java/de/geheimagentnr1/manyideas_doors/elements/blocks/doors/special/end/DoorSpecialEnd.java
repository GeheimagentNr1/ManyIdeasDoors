package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;


public class DoorSpecialEnd extends DoubleDoorBlock implements EntityBlock {
	
	
	@NotNull
	public static final String registry_name = "door_special_end";
	
	public DoorSpecialEnd() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.COLOR_BLACK )
				.strength( 50.0F, 1200.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.GLASS ),
			BlockSetType.OAK,
			OpenedBy.BOTH
		);
	}
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity( @NotNull BlockPos pos, @NotNull BlockState state ) {
		
		return new DoorSpecialEndEntity( pos, state );
	}
	
	@SuppressWarnings( "deprecation" )
	@NotNull
	@Override
	public RenderShape getRenderShape( @NotNull BlockState state ) {
		
		if( state.getValue( OPEN ) ) {
			return RenderShape.MODEL;
		}
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		if( state.getValue( OPEN ) ) {
			return super.getShape( state, level, pos, context );
		}
		return Shapes.block();
	}
}
