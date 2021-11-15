package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;


public class DoorCopperSteampunk extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_copper_steampunk";
	
	public DoorCopperSteampunk() {
		
		super(
			Properties.of( Material.METAL ).strength( 5.0F ).requiresCorrectToolForDrops().sound( SoundType.METAL ),
			registry_name
		);
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.translucent();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_STEAMPUNK, _properties, registry_name );
	}
}
