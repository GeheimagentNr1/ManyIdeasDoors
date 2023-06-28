package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.spruce;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorSpruce extends DoorWooden {
	
	
	protected DoorSpruce() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.PODZOL ), BlockSetType.SPRUCE );
	}
}
