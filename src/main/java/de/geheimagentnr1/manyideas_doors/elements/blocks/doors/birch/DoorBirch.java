package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.birch;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorBirch extends DoorWooden {
	
	
	protected DoorBirch() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.SAND ), BlockSetType.BIRCH );
	}
}
