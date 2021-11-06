package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorSpruceOrigin extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_spruce_origin";
	
	public DoorSpruceOrigin() {
		
		super(
			AbstractBlock.Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPRUCE_ORIGIN, _properties, registry_name );
	}
}
