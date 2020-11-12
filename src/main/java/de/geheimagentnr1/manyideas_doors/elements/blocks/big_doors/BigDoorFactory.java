package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class BigDoorFactory extends BigDoor {
	
	
	public static final String registry_name = "big_door_factory";
	
	public BigDoorFactory() {
		
		super( Properties.create( Material.IRON ).hardnessAndResistance( 5.0F ).sound( SoundType.METAL ), true,
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
		
		return createBlockItem( ModBlocks.BIG_DOOR_FACTORY, properties, registry_name );
	}
}
