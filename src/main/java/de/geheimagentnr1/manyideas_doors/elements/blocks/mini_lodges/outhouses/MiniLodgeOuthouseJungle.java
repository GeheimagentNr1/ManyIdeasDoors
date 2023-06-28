package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class MiniLodgeOuthouseJungle extends MiniLodgeOuthouse {
	
	
	@NotNull
	public static final String registry_name = "mini_lodge_outhouse_jungle";
	
	public MiniLodgeOuthouseJungle() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.DIRT ), BlockSetType.JUNGLE );
	}
}
