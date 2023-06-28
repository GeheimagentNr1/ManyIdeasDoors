package de.geheimagentnr1.manyideas_doors.elements.blocks.doors;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;


public abstract class DoorWooden extends DoubleDoorBlock {
	
	
	protected DoorWooden( @NotNull BlockBehaviour.Properties _properties, @NotNull BlockSetType _type ) {
		
		super( _properties.strength( 3.0F ).sound( SoundType.WOOD ), _type, OpenedBy.BOTH );
	}
}
