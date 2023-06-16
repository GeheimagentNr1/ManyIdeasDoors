package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorOak extends DoorWooden {
	
	
	protected DoorOak( BlockSetType _type ) {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WOOD ), _type );
	}
}
