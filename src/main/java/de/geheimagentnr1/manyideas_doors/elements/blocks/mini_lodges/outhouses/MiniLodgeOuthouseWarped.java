package de.geheimagentnr1.manyideas_doors.elements.blocks.mini_lodges.outhouses;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class MiniLodgeOuthouseWarped extends MiniLodgeOuthouse {
	
	
	@NotNull
	public static final String registry_name = "mini_lodge_outhouse_warped";
	
	public MiniLodgeOuthouseWarped() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WARPED_HYPHAE ), BlockSetType.WARPED );
	}
}
