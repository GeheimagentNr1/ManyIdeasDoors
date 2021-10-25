package de.geheimagentnr1.manyideas_doors.handlers;

import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTileRenderer;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorTile;
import de.geheimagentnr1.manyideas_doors.elements.item_groups.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
public class RegistryEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		ClientRegistry.bindTileEntityRenderer( ModBlocks.DOOR_SPECIAL_END_TILE, DoorSpecialEndTileRenderer::new );
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void onBlocksRegistry( RegistryEvent.Register<Block> blockRegistryEvent ) {
		
		blockRegistryEvent.getRegistry().registerAll( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void onItemsRegistry( RegistryEvent.Register<Item> itemRegistryEvent ) {
		
		Item.Properties properties = new Item.Properties().tab( ModItemGroups.MANYIDEAS_DOORS_ITEM_GROUP );
		
		BlockRegistrationHelper.registerBlockItems( itemRegistryEvent, ModBlocks.BLOCKS, properties );
	}
	
	@SuppressWarnings( "ConstantConditions" )
	@SubscribeEvent
	public static void onTileEntityRegistry( RegistryEvent.Register<TileEntityType<?>> event ) {
		
		event.getRegistry().register(
			TileEntityType.Builder.of( DoorSpecialEndTile::new, ModBlocks.DOOR_SPECIAL_END )
				.build( null )
				.setRegistryName( DoorSpecialEnd.registry_name )
		);
		event.getRegistry().register(
			TileEntityType.Builder.of( PlayerDoorSensorTile::new, ModBlocks.PLAYER_DOOR_SENSOR )
				.build( null )
				.setRegistryName( PlayerDoorSensor.registry_name )
		);
	}
}
