package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class MiniLodgeOuthouseCrimson extends MiniLodgeOuthouse {
	
	
	@NotNull
	public static final String registry_name = "mini_lodge_outhouse_crimson";
	
	public MiniLodgeOuthouseCrimson() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.CRIMSON_HYPHAE ), BlockSetType.CRIMSON );
	}
}
