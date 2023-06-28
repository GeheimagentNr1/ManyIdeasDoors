package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BigDoorShiro extends BigDoorWooden {
	
	
	@NotNull
	public static final String registry_name = "big_door_shiro";
	
	public BigDoorShiro() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.TERRACOTTA_RED ), BlockSetType.CHERRY );
	}
	
	@Override
	protected int getXSize() {
		
		return 2;
	}
	
	@Override
	protected int getYSize() {
		
		return 4;
	}
	
	@Override
	protected int getZSize() {
		
		return 2;
	}
}
