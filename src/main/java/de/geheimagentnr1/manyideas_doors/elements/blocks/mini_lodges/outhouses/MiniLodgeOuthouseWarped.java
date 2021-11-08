package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;


public class MiniLodgeOuthouseWarped extends MiniLodgeOuthouse {
	
	
	public static final String registry_name = "mini_lodge_outhouse_warped";
	
	public MiniLodgeOuthouseWarped() {
		
		super( registry_name );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_OUTHOUSE_WARPED, _properties, registry_name );
	}
}
