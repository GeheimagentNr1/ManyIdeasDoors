package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;


public class DoorCrimsonBookshelf extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_crimson_bookshelf";
	
	public DoorCrimsonBookshelf() {
		
		super(
			BlockBehaviour.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			SoundEvents.WOODEN_DOOR_CLOSE,
			SoundEvents.WOODEN_DOOR_OPEN
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_CRIMSON_BOOKSHELF, _properties, registry_name );
	}
}
