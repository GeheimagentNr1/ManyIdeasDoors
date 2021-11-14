package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class DoorSpecialEnd extends DoubleDoorBlock implements EntityBlock {
	
	
	public static final String registry_name = "door_special_end";
	
	public DoorSpecialEnd() {
		
		super(
			BlockBehaviour.Properties.of( Material.STONE )
				.strength( 50.0F, 1200.0F )
				.requiresCorrectToolForDrops()
				.harvestTool( ToolType.PICKAXE )
				.harvestLevel( 3 )
				.sound( SoundType.GLASS ),
			registry_name
		);
	}
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity( @Nonnull BlockPos pos, @Nonnull BlockState state ) {
		
		return new DoorSpecialEndEntity( pos, state );
	}
	
	@SuppressWarnings( "deprecation" )
	@Nonnull
	@Override
	public RenderShape getRenderShape( BlockState state ) {
		
		if( state.getValue( OPEN ) ) {
			return RenderShape.MODEL;
		}
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}
	
	@Nonnull
	@Override
	public VoxelShape getShape(
		@Nonnull BlockState state,
		@Nonnull BlockGetter level,
		@Nonnull BlockPos pos,
		@Nonnull CollisionContext context ) {
		
		if( state.getValue( OPEN ) ) {
			return super.getShape( state, level, pos, context );
		}
		return Shapes.block();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_END, _properties, registry_name );
	}
}
