package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomGenLayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerVirtious extends CustomGenLayer
{
	@Override
	public GenLayer getBiomeGenLayer(long seed, WorldType worldType)
	{
		return new GenLayerBiomesVirtious(seed);
	}
	
	@Override
	public int getBiomeSize(long seed, WorldType worldType)
	{
		return 3;
	}
}
