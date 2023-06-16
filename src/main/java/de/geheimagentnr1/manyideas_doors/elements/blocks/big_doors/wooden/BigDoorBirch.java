package de.geheimagentnr1.manyideas_doors.elements.blocks.big_doors.wooden;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;


public class BigDoorBirch extends BigDoorWooden {
	
	
	public static final String registry_name = "big_door_birch";
	
	public BigDoorBirch() {
		
		super(
			BlockBehaviour.Properties.of().mapColor( MapColor.SAND ).sound( SoundType.GLASS ),
			BlockSetType.BIRCH,
			true
		);
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
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( ModBlocks.BIG_DOOR_BIRCH, _properties, registry_name );
	}
}
