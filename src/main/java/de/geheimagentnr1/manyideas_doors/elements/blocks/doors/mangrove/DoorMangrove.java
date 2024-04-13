package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.mangrove;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorMangrove extends DoorWooden {
	
	
	protected DoorMangrove() {
		
		super( Properties.of().mapColor( MapColor.COLOR_RED ).sound( SoundType.WOOD ), BlockSetType.MANGROVE );
	}
}
