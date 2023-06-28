package de.geheimagentnr1.manyideas_doors.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_doors.ManyIdeasDoors;
import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryEntry;
import lombok.RequiredArgsConstructor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@RequiredArgsConstructor
public class ManyIdeasHalloweenCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@NotNull
	private final ModBlocksRegisterFactory modBlocksRegisterFactory;
	
	@NotNull
	@Override
	public String getRegistryName() {
		
		return ManyIdeasDoors.MODID;
	}
	
	@NotNull
	@Override
	public ItemLike getIconItem() {
		
		return ModBlocksRegisterFactory.DOOR_OAK_ORIGIN;
	}
	
	@NotNull
	@Override
	public List<RegistryEntry<Block>> getDisplayBlocks() {
		
		return modBlocksRegisterFactory.getBlocks();
	}
}
