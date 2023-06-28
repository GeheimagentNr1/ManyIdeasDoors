package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BigDoorSafe extends BigDoorMetal {
	
	
	@NotNull
	public static final String registry_name = "big_door_safe";
	
	public BigDoorSafe() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.METAL ), true );
	}
	
	@Override
	protected int getXSize() {
		
		return 3;
	}
	
	@Override
	protected int getYSize() {
		
		return 3;
	}
	
	@Override
	protected int getZSize() {
		
		return 3;
	}
}
