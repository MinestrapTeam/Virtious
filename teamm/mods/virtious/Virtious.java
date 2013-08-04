package teamm.mods.virtious; 

import java.io.File;
import java.util.logging.Level;

import teamm.mods.virtious.entity.EntityBurfalaunt;
import teamm.mods.virtious.entity.item.EntityStickyBomb;
import teamm.mods.virtious.entity.item.EntityVirtiousFishHook;
import teamm.mods.virtious.event.VirtiousBonemealEvent;
import teamm.mods.virtious.fluids.VirtiousFluids;
import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousCreativeTabBlocks;
import teamm.mods.virtious.lib.VirtiousCreativeTabItems;
import teamm.mods.virtious.lib.VirtiousItems;
import teamm.mods.virtious.lib.VirtiousRecipes;
import teamm.mods.virtious.misc.VirtiousFuelHandler;
import teamm.mods.virtious.network.PacketHandler;
import teamm.mods.virtious.proxy.CommonProxy;
import teamm.mods.virtious.world.TileEntityPortal;
import teamm.mods.virtious.world.VirtiousProvider;
import teamm.mods.virtious.world.biome.BiomeGenCanyon;
import teamm.mods.virtious.world.biome.BiomeGenVirtious;
import teamm.mods.virtious.world.gen.VirtiousOreGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.fluids.Fluid;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;

import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name = Virtious.modName, modid = Virtious.modId, useMetadata = false, version = "B1.0")
@NetworkMod(channels = {Virtious.CHANNEL_NAME}, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = true)
public class Virtious {
	public static final String modId = "virtious";
	public static final String modName = "Virtious mod";
	public static final String CHANNEL_NAME = "virtious_chan";
	
	public static Fluid virtiousFluid;
	public static EntityVirtiousFishHook fishEntity;
	
	@Instance(Virtious.modId)
	private static Virtious instance;
	
	public static Virtious getInstance()
	{
		return instance;
	}
	
	public static int dimensionID;
	public static int virtiousBiomeID;
	public static int canyonBiomeID;
	
	/* Biomes */
	public static BiomeGenBase virtiousBiome = null;
	public static BiomeGenBase canyonBiome = null;

	public static Configuration config;
	
	public static VirtiousCreativeTabBlocks tabVirtiousBlocks = new VirtiousCreativeTabBlocks(CreativeTabs.getNextID(), "Virtious Mod - Blocks");
	public static VirtiousCreativeTabItems tabVirtiousItems = new VirtiousCreativeTabItems(CreativeTabs.getNextID(), "Virtious Mod - Items");

	@SidedProxy(clientSide = "teamm.mods.virtious.proxy.ClientProxy", serverSide = "teamm.mods.virtious.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerTileEntity(TileEntityPortal.class, "VirtiousPortalTile");

		GameRegistry.registerWorldGenerator(new VirtiousOreGenerator());
		
		virtiousFluid = new VirtiousFluids("Virtian Acid");
		
		config = new Configuration(new File(event.getModConfigurationDirectory(), "Virtious.cfg"));
		
		try
		{
			config.load();
			
			//Other config
			Property idDim = Virtious.config.get("Special", "dimensionID", DimensionManager.getNextFreeDimId());
			dimensionID = idDim.getInt();

			Property idvirtiousBiome = Virtious.config.get("Special", "virtiousBiomeID", Config.virtiousBiomeID);
			virtiousBiomeID = idvirtiousBiome.getInt();
			
			Property idcanyonBiome = Virtious.config.get("Special", "Canyon Biome Id", Config.canyoneBiomeID);
			canyonBiomeID = idcanyonBiome.getInt();
			
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
		}
		
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		virtiousBiome = new BiomeGenVirtious(Virtious.virtiousBiomeID);
		canyonBiome = new BiomeGenCanyon(Virtious.canyonBiomeID);
		
		MinecraftForge.EVENT_BUS.register(new VirtiousBonemealEvent());
		
		GameRegistry.registerFuelHandler(new VirtiousFuelHandler());
				
		DimensionManager.registerProviderType(dimensionID, VirtiousProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);
		
		EntityRegistry.registerModEntity(EntityStickyBomb.class, "StickyBomb", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityVirtiousFishHook.class, "VirtiousFishingHook", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
		
		EntityRegistry.registerGlobalEntityID(EntityBurfalaunt.class, "Burfalaunt", EntityRegistry.findGlobalUniqueEntityId(), 0x110802, 0x3f1e06);
		LanguageRegistry.instance().addStringLocalization("entity.Burfalaunt.name", "en_US", "Burfalaunt");
		
		proxy.registerRenderThings();
	}
}
