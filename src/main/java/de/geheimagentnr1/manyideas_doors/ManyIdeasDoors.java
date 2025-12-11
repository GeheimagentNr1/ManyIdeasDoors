package de.geheimagentnr1.manyideas_doors;


import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.manyideas_doors.elements.creative_mod_tabs.ModCreativeModeTabRegisterFactory;
import de.geheimagentnr1.manyideas_core.core.AbstractMod;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


@Mod( ManyIdeasDoors.MODID )
public class ManyIdeasDoors extends AbstractMod {
	
	
	@NotNull
	public static final String MODID = "manyideas_doors";
	
	public ManyIdeasDoors( @NotNull IEventBus modEventBus, @NotNull ModContainer modContainer ) {
		
		super( modEventBus, modContainer );
	}
	
	@NotNull
	public static ResourceLocation modLoc( @NotNull String path ) {
		
		return ResourceLocation.fromNamespaceAndPath( MODID, path );
	}
	
	@NotNull
	@Override
	public String getModId() {
		
		return MODID;
	}
	
	@Override
	protected void initMod() {
		
		ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
		registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
	}
}
