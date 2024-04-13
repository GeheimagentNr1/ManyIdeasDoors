package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public class MiniLodgeOuthouseMangrove extends MiniLodgeOuthouse {
	
	
	public static final String registry_name = "mini_lodge_outhouse_mangrove";
	
	public MiniLodgeOuthouseMangrove() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_RED ), BlockSetType.MANGROVE );
	}
}
