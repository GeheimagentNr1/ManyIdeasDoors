package de.geheimagentnr1.manyideas_doors.handlers;

import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEnd;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntity;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndEntityRenderer;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensor;
import de.geheimagentnr1.manyideas_doors.elements.blocks.player_door_sensor.PlayerDoorSensorEntity;
import de.geheimagentnr1.manyideas_doors.elements.creative_mod_tabs.ModCreativeTabs;
import net.minecraft.Util;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;


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
	public static void handleBlockRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.BLOCKS ) ) {
			event.register(
				ForgeRegistries.Keys.BLOCKS,
				registerHelper -> ModBlocks.BLOCKS.forEach( registryEntry -> registerHelper.register(
					registryEntry.getRegistryName(),
					registryEntry.getValue()
				) )
			);
		}
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.ITEMS ) ) {
			Item.Properties properties = new Item.Properties();
			BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
		}
	}
	
	@SubscribeEvent
	public static void handleCreativeModeTabRegisterEvent( CreativeModeTabEvent.Register event ) {
		
		ModCreativeTabs.CREATIVE_TAB_FACTORIES.forEach( creativeModeTabFactory ->
			event.registerCreativeModeTab( creativeModeTabFactory.getName(), creativeModeTabFactory ) );
	}
	
	@SuppressWarnings( "ConstantConditions" )
	@SubscribeEvent
	public static void handleBlockEntityRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.BLOCK_ENTITY_TYPES ) ) {
			event.register(
				ForgeRegistries.Keys.BLOCK_ENTITY_TYPES,
				registerHelper -> {
					registerHelper.register(
						DoorSpecialEnd.registry_name,
						BlockEntityType.Builder.of( DoorSpecialEndEntity::new, ModBlocks.DOOR_SPECIAL_END )
							.build( Util.fetchChoiceType( References.BLOCK_ENTITY, DoorSpecialEnd.registry_name ) )
					);
					registerHelper.register(
						PlayerDoorSensor.registry_name,
						BlockEntityType.Builder.of( PlayerDoorSensorEntity::new, ModBlocks.PLAYER_DOOR_SENSOR )
							.build( Util.fetchChoiceType( References.BLOCK_ENTITY, PlayerDoorSensor.registry_name ) )
					);
				}
			);
		}
	}
}
