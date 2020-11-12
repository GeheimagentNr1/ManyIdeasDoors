package de.geheimagentnr1.manyideas_doors;


import de.geheimagentnr1.manyideas_doors.setup.ClientProxy;
import de.geheimagentnr1.manyideas_doors.setup.IProxy;
import de.geheimagentnr1.manyideas_doors.setup.ModSetup;
import de.geheimagentnr1.manyideas_doors.setup.ServerProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;


@Mod( ManyIdeasDoors.MODID )
public class ManyIdeasDoors {
	
	
	public static final String MODID = "manyideas_doors";
	
	public static final IProxy proxy = DistExecutor.runForDist( () -> ClientProxy::new, () -> ServerProxy::new );
	
	public static final ModSetup setup = new ModSetup();
}
