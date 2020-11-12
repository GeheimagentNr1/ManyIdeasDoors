package de.geheimagentnr1.manyideas_doors.handlers;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorTile;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
public class RegistryEventHandler {
	
	
	@SubscribeEvent
	public static void setup( FMLCommonSetupEvent event ) {
		
		ManyIdeasDoors.proxy.init();
	}
	
	@SubscribeEvent
	public static void onBlocksRegistry( RegistryEvent.Register<Block> blockRegistryEvent ) {
		
		blockRegistryEvent.getRegistry().registerAll( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void onItemsRegistry( RegistryEvent.Register<Item> itemRegistryEvent ) {
		
		Item.Properties properties = new Item.Properties().group( ManyIdeasDoors.setup.manyIdeasDoorsItemGroup );
		
		for( Block block : ModBlocks.BLOCKS ) {
			if( block instanceof BlockItemInterface ) {
				BlockItemInterface blockItem = (BlockItemInterface)block;
				itemRegistryEvent.getRegistry().register( blockItem.getBlockItem( properties ) );
			}
		}
	}
	
	@SuppressWarnings( "ConstantConditions" )
	@SubscribeEvent
	public static void onTileEntityRegistry( RegistryEvent.Register<TileEntityType<?>> event ) {
		
		event.getRegistry().register( TileEntityType.Builder.create( DoorSpecialEndTile::new,
			ModBlocks.DOOR_SPECIAL_END ).build( null ).setRegistryName( DoorSpecialEnd.registry_name ) );
		event.getRegistry().register( TileEntityType.Builder.create( PlayerDoorSensorTile::new,
			ModBlocks.PLAYER_DOOR_SENSOR ).build( null ).setRegistryName( PlayerDoorSensor.registry_name ) );
	}
}
