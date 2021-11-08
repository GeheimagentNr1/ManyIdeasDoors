package de.geheimagentnr1.manyideas_doors.handlers;

import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntity;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntityRenderer;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorEntity;
import de.geheimagentnr1.manyideas_doors.elements.item_groups.ModItemGroups;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		BlockEntityRenderers.register( ModBlocks.DOOR_SPECIAL_END_ENTITY, DoorSpecialEndEntityRenderer::new );
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleBlockRegistryEvent( RegistryEvent.Register<Block> event ) {
		
		event.getRegistry().registerAll( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegistryEvent.Register<Item> event ) {
		
		Item.Properties properties = new Item.Properties().tab( ModItemGroups.MANYIDEAS_DOORS_ITEM_GROUP );
		
		BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
	}
	
	@SuppressWarnings( "ConstantConditions" )
	@SubscribeEvent
	public static void handleBlockEntityRegistryEvent( RegistryEvent.Register<BlockEntityType<?>> event ) {
		
		event.getRegistry().register(
			BlockEntityType.Builder.of( DoorSpecialEndEntity::new, ModBlocks.DOOR_SPECIAL_END )
				.build( null )
				.setRegistryName( DoorSpecialEnd.registry_name )
		);
		event.getRegistry().register(
			BlockEntityType.Builder.of( PlayerDoorSensorEntity::new, ModBlocks.PLAYER_DOOR_SENSOR )
				.build( null )
				.setRegistryName( PlayerDoorSensor.registry_name )
		);
	}
}
