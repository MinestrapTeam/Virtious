package minestrapteam.virtious.lib;

import clashsoft.cslib.config.CSConfig;
import minestrapteam.virtious.world.VirtiousWorldProvider;
import minestrapteam.virtious.world.biome.BiomeGenCanyon;
import minestrapteam.virtious.world.biome.BiomeGenVirtious;
import minestrapteam.virtious.world.biome.BiomeGenVirtiousOcean;
import minestrapteam.virtious.world.biome.BiomeGenWhiskerfield;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class VWorld
{
	public static int			dimensionID			= DimensionManager.getNextFreeDimId();
	
	public static int			virtiousBiomeID		= 25;
	public static int			canyonBiomeID		= 26;
	public static int			whiskerfieldBiomeID	= 27;
	public static int			gravelBeachBiomeID	= 28;
	public static int			virtiousOceanID		= 29;
	
	public static BiomeGenBase	virtiousBiome;
	public static BiomeGenBase	canyonBiome;
	public static BiomeGenBase	whiskerfieldBiome;
	public static BiomeGenBase	gravelBeachBiome;
	public static BiomeGenBase	virtiousOceanBiome;
	
	public static void readConfig()
	{
		dimensionID = CSConfig.getDimension("Virtious Dimension ID", dimensionID);
		
		virtiousBiomeID = CSConfig.getBiome("Virtious Biome ID", virtiousBiomeID);
		canyonBiomeID = CSConfig.getBiome("Canyon Biome ID", canyonBiomeID);
		gravelBeachBiomeID = CSConfig.getBiome("Gravel Beach Biome ID", gravelBeachBiomeID);
		whiskerfieldBiomeID = CSConfig.getBiome("Whiskerfield Biome ID", whiskerfieldBiomeID);
		virtiousOceanID = CSConfig.getBiome("Virtious Ocean Biome ID", virtiousOceanID);
	}
	
	public static void load()
	{
		DimensionManager.registerProviderType(dimensionID, VirtiousWorldProvider.class, true);
		DimensionManager.registerDimension(dimensionID, dimensionID);
		
		virtiousBiome = new BiomeGenVirtious(virtiousBiomeID);
		canyonBiome = new BiomeGenCanyon(canyonBiomeID);
		whiskerfieldBiome = new BiomeGenWhiskerfield(whiskerfieldBiomeID);
		gravelBeachBiome = new BiomeGenCanyon(canyonBiomeID);
		virtiousOceanBiome = new BiomeGenVirtiousOcean(virtiousOceanID);
	}
}
