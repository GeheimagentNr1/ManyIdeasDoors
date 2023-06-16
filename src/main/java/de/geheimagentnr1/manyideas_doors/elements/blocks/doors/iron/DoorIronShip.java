package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class DoorIronShip extends DoorMetal {
	
	
	public static final String registry_name = "door_iron_ship";
	
	public DoorIronShip() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.METAL ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_IRON_SHIP, _properties, registry_name );
	}
}
