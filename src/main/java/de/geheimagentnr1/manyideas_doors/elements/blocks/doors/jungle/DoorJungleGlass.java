package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class DoorJungleGlass extends DoorJungle {
	
	
	public static final String registry_name = "door_jungle_glass";
	
	public DoorJungleGlass() {
		
		super( BlockSetType.JUNGLE );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_JUNGLE_GLASS, _properties, registry_name );
	}
}
