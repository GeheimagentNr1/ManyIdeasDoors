package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;


public abstract class BigDoorWooden extends BigDoor {
	
	
	protected BigDoorWooden( @NotNull BlockBehaviour.Properties _properties, @NotNull BlockSetType _type ) {
		
		this(
			_properties.sound( SoundType.WOOD ),
			_type,
			true
		);
	}
	
	protected BigDoorWooden(
		@NotNull BlockBehaviour.Properties _properties,
		@NotNull BlockSetType _type,
		boolean _doubleDoorActive ) {
		
		super(
			_properties.strength( 3.0F ),
			_type,
			OpenedBy.BOTH,
			_doubleDoorActive
		);
	}
}
