package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;


public class DoorDarkOakShoji extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_dark_oak_shoji";
	
	public DoorDarkOakShoji() {
		
		super(
			BlockBehaviour.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			SoundEvents.WOODEN_DOOR_CLOSE,
			SoundEvents.WOODEN_DOOR_OPEN
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_DARK_OAK_SHOJI, _properties, registry_name );
	}
}
