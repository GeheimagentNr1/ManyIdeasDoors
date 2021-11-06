package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.item.Item;


public class MiniLodgeOuthouseDarkOak extends MiniLodgeOuthouse {
	
	
	public static final String registry_name = "mini_lodge_outhouse_dark_oak";
	
	public MiniLodgeOuthouseDarkOak() {
		
		super( registry_name );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_OUTHOUSE_DARK_OAK, _properties, registry_name );
	}
}
