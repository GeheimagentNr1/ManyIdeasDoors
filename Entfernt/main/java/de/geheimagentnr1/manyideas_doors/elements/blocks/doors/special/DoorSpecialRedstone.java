package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorSpecialRedstone extends DoubleDoorBlock implements BlockItemInterface {
	
	
	public static final String registry_name = "door_special_redstone";
	
	public DoorSpecialRedstone() {
		
		super( Properties.create( Material.ROCK ).hardnessAndResistance( 4.0F ).sound( SoundType.STONE ),
			registry_name, false );
	}
}
