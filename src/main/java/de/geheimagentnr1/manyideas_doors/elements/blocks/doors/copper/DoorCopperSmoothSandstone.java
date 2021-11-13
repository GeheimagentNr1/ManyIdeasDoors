package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;


public class DoorCopperSmoothSandstone extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_copper_smooth_sandstone";
	
	public DoorCopperSmoothSandstone() {
		
		super(
			Properties.of( Material.METAL ).strength( 5.0F ).sound( SoundType.METAL ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_SMOOTH_SANDSTONE, _properties, registry_name );
	}
}
