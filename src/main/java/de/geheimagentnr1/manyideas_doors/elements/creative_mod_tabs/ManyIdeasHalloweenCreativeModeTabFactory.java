package de.geheimagentnr1.manyideas_doors.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;


public class ManyIdeasHalloweenCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@Override
	public String getModId() {
		
		return ManyIdeasDoors.MODID;
	}
	
	@Override
	public String getRegistryName() {
		
		return ManyIdeasDoors.MODID;
	}
	
	@Override
	public Item getDisplayItem() {
		
		return ModBlocks.DOOR_OAK_ORIGIN.asItem();
	}
	
	@Override
	public List<ItemStack> getDisplayItems() {
		
		return ModBlocks.BLOCKS.stream()
			.filter( registryEntry -> registryEntry.getValue() instanceof BlockItemInterface )
			.map( registryEntry -> new ItemStack( registryEntry.getValue() ) )
			.toList();
	}
}
