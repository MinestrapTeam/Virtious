package teamm.mods.virtious;

import java.io.File;
import java.util.logging.Level;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousCreativeTab;
import teamm.mods.virtious.lib.VirtiousItems;
import teamm.mods.virtious.lib.VirtiousRecipes;
import teamm.mods.virtious.proxy.CommonProxy;
import teamm.mods.virtious.world.VirtiousProvider;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.Property;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
<<<<<<< HEAD
=======
import cpw.mods.fml.common.SidedProxy;
>>>>>>> 0e71d529ab0770fc99537fac54851b39d645ea11
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
	
	public static Configuration config;
	
	public static VirtiousCreativeTab tabVirtious = new VirtiousCreativeTab(CreativeTabs.getNextID(), "Virtious Mod");
	
	@SidedProxy(clientSide = "teamm.mods.virtious.proxy.ClientProxy", serverSide = "teamm.mods.virtious.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(new File(event.getModConfigurationDirectory(), "Virtious.cfg"));
		
		try
		{
			config.load();
			
			//Other config
			Property idDim = Virtious.config.get("Special", "dimensionID", DimensionManager.getNextFreeDimId());
			dimensionID = idDim.getInt();
			
			//ItemStack config
			new VirtiousBlocks();
			new VirtiousItems();
			
			new VirtiousRecipes();
		
		} catch(Exception e)
		{
			System.err.println("Virtious: Could not load id's.");
			System.out.println(e.getMessage());
		} 
		finally 
		{
			config.save();
<<<<<<< HEAD
		}
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
=======
		}	
		
>>>>>>> 0e71d529ab0770fc99537fac54851b39d645ea11
		DimensionManager.registerProviderType(dimensionID, VirtiousProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		proxy.registerRenderThings();
	}
}
