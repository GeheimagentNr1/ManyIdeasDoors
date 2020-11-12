package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class BigDoorAcacia extends BigDoor {
	
	
	public static final String registry_name = "big_door_acacia";
	
	public BigDoorAcacia() {
		
		super( Properties.create( Material.WOOD ).hardnessAndResistance( 3.0F ).sound( SoundType.WOOD ), true,
			registry_name );
	}
	
	@Override
	protected int getXSize() {
		
		return 2;
	}
	
	@Override
	protected int getYSize() {
		
		return 4;
	}
	
	@Override
	protected int getZSize() {
		
		return 2;
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_ACACIA, properties, registry_name );
	}
}
