package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BigDoorArt extends BigDoorMetal {
	
	
	@NotNull
	public static final String registry_name = "big_door_art";
	
	public BigDoorArt() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_ORANGE ), true );
	}
	
	@Override
	protected int getXSize() {
		
		return 3;
	}
	
	@Override
	protected int getYSize() {
		
		return 4;
	}
	
	@Override
	protected int getZSize() {
		
		return 3;
	}
}
