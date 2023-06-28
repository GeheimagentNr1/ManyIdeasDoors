package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.crimson;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorCrimson extends DoorWooden {
	
	
	protected DoorCrimson() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.CRIMSON_HYPHAE ), BlockSetType.CRIMSON );
	}
}
