package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.dark_oak;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorDarkOak extends DoorWooden {
	
	
	protected DoorDarkOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_BROWN ), BlockSetType.DARK_OAK );
	}
}
