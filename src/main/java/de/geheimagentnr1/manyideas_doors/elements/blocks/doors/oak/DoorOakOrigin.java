package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class DoorOakOrigin extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_oak_origin";
	
	public DoorOakOrigin() {
		
		super(
			Block.Properties.create( Material.WOOD ).hardnessAndResistance( 3.0F ).sound( SoundType.WOOD ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.DOOR_OAK_ORIGIN, properties, registry_name );
	}
}
