package de.geheimagentnr1.manyideas_doors.elements.blocks.doors.oak;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.DoubleDoorBlock;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;


public class DoorOakBlank extends DoubleDoorBlock {
	
	
	public static final String registry_name = "door_oak_blank";
	
	public DoorOakBlank() {
		
		super(
			BlockBehaviour.Properties.of( Material.WOOD )
				.strength( 3.0F )
				.harvestTool( ToolType.AXE )
				.sound( SoundType.WOOD ),
			registry_name
		);
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.DOOR_OAK_BLANK, _properties, registry_name );
	}
}
