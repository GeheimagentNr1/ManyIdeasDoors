package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.metal;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public abstract class BigDoorMetal extends BigDoor {
	
	
	protected BigDoorMetal( BlockBehaviour.Properties _properties, boolean _doubleDoorActive ) {
		
		this( _properties, BlockSetType.IRON, _doubleDoorActive );
	}
	
	protected BigDoorMetal(
		BlockBehaviour.Properties _properties,
		BlockSetType _type,
		boolean _doubleDoorActive ) {
		
		super(
			_properties
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			_type,
			OpenedBy.BOTH,
			_doubleDoorActive
		);
	}
}
