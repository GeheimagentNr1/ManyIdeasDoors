package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.item.Item;


public class MiniLodgeOuthouseJungle extends MiniLodgeOuthouse {
	
	
	public static final String registry_name = "mini_lodge_outhouse_jungle";
	
	public MiniLodgeOuthouseJungle() {
		
		super( registry_name );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_OUTHOUSE_JUNGLE, _properties, registry_name );
	}
}
