package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.jungle;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorJungle extends DoorWooden {
	
	
	protected DoorJungle() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.DIRT ), BlockSetType.JUNGLE );
	}
}
