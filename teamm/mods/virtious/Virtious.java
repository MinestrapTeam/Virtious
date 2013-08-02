package teamm.mods.virtious;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Virtious.modName, modid = Virtious.modId, useMetadata = false, version = "1.0")
//@NetworkMod(...)
public class Virtious {
	public static final String modId = "virtious";
	public static final String modName = "Virtious mod";
	
	@Instance(Virtious.modId)
	private static Virtious instance;
	
	public static Virtious getInstance(){
		return instance;
	}
	
	public static int dimensionID;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
	}
}
