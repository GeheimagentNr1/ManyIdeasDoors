package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.acacia;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorAcacia extends DoorWooden {
	
	
	protected DoorAcacia() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_ORANGE ), BlockSetType.ACACIA );
	}
}
