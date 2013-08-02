package teamm.mods.virtious;

import java.io.File;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;
import teamm.mods.virtious.world.VirtiousProvider;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.Property;

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
	
	public static Virtious getInstance()
	{
		return instance;
	}
	
	public static int dimensionID;
	
	private static VirtiousConfig config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new VirtiousConfig(new File(event.getModConfigurationDirectory(), "Virtious.cfg"));
		
		try
		{
			config.load();
			
			Property idDim = Virtious.config.get("Special", "dimensionID", Config.DimensionID);
			dimensionID = idDim.getInt();
			
		} catch(Exception e)
		{
			
		} 
		finally 
		{
			config.save();
		}
		
		VirtiousBlocks.loadAllBlocks();
		VirtiousItems.loadAllItems();
		
		DimensionManager.registerProviderType(dimensionID, VirtiousProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);

	}
}
