package teamm.mods.virtious;

import java.io.File;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousCreativeTab;
import teamm.mods.virtious.lib.VirtiousItems;
import teamm.mods.virtious.lib.VirtiousRecipes;
import teamm.mods.virtious.world.VirtiousProvider;

import net.minecraft.creativetab.CreativeTabs;
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
	
	public static VirtiousConfig config;
	
	public static VirtiousCreativeTab tabVirtious = new VirtiousCreativeTab(CreativeTabs.getNextID(), "Virtious Mod");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new VirtiousConfig(new File(event.getModConfigurationDirectory(), "Virtious.cfg"));
		
		try
		{
			config.load();
			
			//Other config
			Property idDim = Virtious.config.get("Special", "dimensionID", Config.DimensionID);
			dimensionID = idDim.getInt();
			
			//ItemStack config
			new VirtiousBlocks();
			new VirtiousItems();
			
			new VirtiousRecipes();
		
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		} 
		finally 
		{
			config.save();
		}
		
		
		
		DimensionManager.registerProviderType(dimensionID, VirtiousProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);

	}
}
