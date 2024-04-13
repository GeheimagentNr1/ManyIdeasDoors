package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.mangrove;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;


public class DoorMangroveFrench extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_mangrove_french";
	
	public DoorMangroveFrench() {
		
		super(
			Properties.of( Material.WOOD ).strength( 3.0F ).sound( SoundType.WOOD ),
			BlockSetType.MANGROVE
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_MANGROVE_FRENCH, _properties, registry_name );
	}
}
