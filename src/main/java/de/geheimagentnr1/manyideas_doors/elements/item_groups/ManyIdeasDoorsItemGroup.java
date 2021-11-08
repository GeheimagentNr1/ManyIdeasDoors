package de.geheimagentnr1.manyideas_doors.elements.item_groups;


import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;


public class ManyIdeasDoorsItemGroup extends CreativeModeTab {
	
	
	public ManyIdeasDoorsItemGroup() {
		
		super( ManyIdeasDoors.MODID );
	}
	
	@Nonnull
	@Override
	public ItemStack makeIcon() {
		
		return new ItemStack( ModBlocks.DOOR_OAK_ORIGIN );
	}
}
