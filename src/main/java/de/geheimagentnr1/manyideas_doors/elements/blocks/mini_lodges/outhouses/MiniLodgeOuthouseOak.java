package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public class MiniLodgeOuthouseOak extends MiniLodgeOuthouse {
	
	
	public static final String registry_name = "mini_lodge_outhouse_oak";
	
	public MiniLodgeOuthouseOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WOOD ), BlockSetType.OAK );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.MINI_LODGE_OUTHOUSE_OAK, _properties, registry_name );
	}
}
