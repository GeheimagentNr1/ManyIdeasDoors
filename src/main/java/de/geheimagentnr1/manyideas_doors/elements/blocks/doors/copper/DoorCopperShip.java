package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;


public class DoorCopperShip extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_copper_ship";
	
	public DoorCopperShip() {
		
		super(
			BlockBehaviour.Properties.of( Material.METAL )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			BlockSetType.IRON
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_COPPER_SHIP, _properties, registry_name );
	}
}
