package de.geheimagentnr1.manyideas_doors.setup;

import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTile;
import de.geheimagentnr1.manyideas_doors.elements.blocks.doors.special.end.DoorSpecialEndTileRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class ClientProxy implements IProxy {
	
	
	@Override
	public void init() {
		
		ClientRegistry.bindTileEntitySpecialRenderer( DoorSpecialEndTile.class, new DoorSpecialEndTileRenderer() );
	}
}
