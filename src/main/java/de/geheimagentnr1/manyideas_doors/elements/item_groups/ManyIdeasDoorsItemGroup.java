package de.geheimagentnr1.manyideas_doors.elements.item_groups;


import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;


public class ManyIdeasDoorsItemGroup extends ItemGroup {
	
	
	public ManyIdeasDoorsItemGroup() {
		
		super( ManyIdeasDoors.MODID );
	}
	
	@Nonnull
	@Override
	public ItemStack createIcon() {
		
		return new ItemStack( ModBlocks.DOOR_OAK_ORIGIN );
	}
}
