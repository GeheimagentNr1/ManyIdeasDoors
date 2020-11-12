package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorSpecialSpace extends DoubleDoorBlock implements BlockItemInterface {
	
	
	public static final String registry_name = "door_special_space";
	
	public DoorSpecialSpace() {
		
		super( Block.Properties.create( Material.ROCK ).hardnessAndResistance( 4.0F ).sound( SoundType.STONE ),
			registry_name );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.DOOR_SPECIAL_SPACE, properties, registry_name );
	}
}
