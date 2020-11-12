package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorSpecialCarbonite extends DoubleDoorBlock implements BlockItemInterface {
	
	
	public static final String registry_name = "door_special_carbonite";
	
	public DoorSpecialCarbonite() {
		
		super( Block.Properties.create( Material.IRON ).hardnessAndResistance( 5.0F ).sound( SoundType.METAL ),
			registry_name );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_CARBONITE, properties, registry_name );
	}
}
