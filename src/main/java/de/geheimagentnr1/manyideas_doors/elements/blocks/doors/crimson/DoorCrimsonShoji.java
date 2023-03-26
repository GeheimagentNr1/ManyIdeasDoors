package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;


public class DoorCrimsonShoji extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_crimson_shoji";
	
	public DoorCrimsonShoji() {
		
		super(
			BlockBehaviour.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			BlockSetType.CRIMSON
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_CRIMSON_SHOJI, _properties, registry_name );
	}
}
