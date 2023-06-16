package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.warped;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorWooden;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public abstract class DoorWarped extends DoorWooden {
	
	
	protected DoorWarped( BlockSetType _type ) {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WARPED_HYPHAE ), _type );
	}
}
