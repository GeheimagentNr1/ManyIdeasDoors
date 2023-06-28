package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.copper;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.DoorMetal;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class DoorCopperSmoothSandstone extends DoorMetal {
	
	
	@NotNull
	public static final String registry_name = "door_copper_smooth_sandstone";
	
	public DoorCopperSmoothSandstone() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.SAND ) );
	}
}
