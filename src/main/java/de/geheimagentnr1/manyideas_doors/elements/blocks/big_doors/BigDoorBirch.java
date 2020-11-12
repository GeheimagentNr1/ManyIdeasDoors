package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors;

import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.doors.BigDoor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class BigDoorBirch extends BigDoor {
	
	
	public static final String registry_name = "big_door_birch";
	
	public BigDoorBirch() {
		
		super( Properties.create( Material.GLASS ).hardnessAndResistance( 3.0F ).sound( SoundType.GLASS ), true,
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
		
		return createBlockItem( ModBlocks.BIG_DOOR_BIRCH, properties, registry_name );
	}
}
