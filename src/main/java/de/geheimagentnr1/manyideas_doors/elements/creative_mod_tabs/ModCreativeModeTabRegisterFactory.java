package de.geheimagentnr1.manyideas_doors.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_doors.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabRegisterFactory;
import lombok.RequiredArgsConstructor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@RequiredArgsConstructor
public class ModCreativeModeTabRegisterFactory extends CreativeModeTabRegisterFactory {
	
	
	@NotNull
	private final ModBlocksRegisterFactory modBlocksRegisterFactory;
	
	@NotNull
	@Override
	protected List<CreativeModeTabFactory> factories() {
		
		return List.of(
			new ManyIdeasHalloweenCreativeModeTabFactory( modBlocksRegisterFactory )
		);
	}
	
	@SubscribeEvent
	public void handleRegisterEvent( @NotNull RegisterEvent event ) {
		
		doRegisterEvent( event );
	}
}
