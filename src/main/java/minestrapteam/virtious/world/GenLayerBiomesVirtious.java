package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomBiomeLayer;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerBiomesVirtious extends CustomBiomeLayer
{
	public GenLayerBiomesVirtious(long seed)
	{
		super(seed);
	}

	@Override
	public BiomeGenBase[] getBiomes()
	{
		return VWorld.biomes;
	}
}
