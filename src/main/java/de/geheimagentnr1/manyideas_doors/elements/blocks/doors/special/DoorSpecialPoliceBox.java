package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.OpenedBy;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class DoorSpecialPoliceBox extends DoubleDoorBlock {
	
	
	@NotNull
	public static final String registry_name = "door_special_police_box";
	
	public DoorSpecialPoliceBox() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.LAPIS )
				.strength( 5.0F )
				.requiresCorrectToolForDrops()
				.sound( SoundType.METAL ),
			BlockSetType.IRON,
			OpenedBy.BOTH
		);
	}
}
