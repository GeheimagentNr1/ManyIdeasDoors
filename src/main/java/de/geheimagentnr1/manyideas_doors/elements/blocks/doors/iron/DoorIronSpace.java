package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.iron;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class DoorIronSpace extends DoorMetal {
	
	
	@NotNull
	public static final String registry_name = "door_iron_space";
	
	public DoorIronSpace() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.METAL ) );
	}
}
