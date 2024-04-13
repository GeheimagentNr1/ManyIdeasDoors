package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public class BigDoorMangrove extends BigDoorWooden {
	
	
	public static final String registry_name = "big_door_mangrove";
	
	public BigDoorMangrove() {
		
		super( Properties.of().mapColor( MapColor.COLOR_RED ).sound( SoundType.WOOD ), BlockSetType.MANGROVE );
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
