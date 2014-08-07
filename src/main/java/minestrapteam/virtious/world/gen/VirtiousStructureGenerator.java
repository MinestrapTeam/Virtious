package minestrapteam.virtious.world.gen;

import java.util.Random;

import minestrapteam.virtious.world.VirtiousChunkProvider;
import minestrapteam.virtious.world.biome.BiomeGenVirtiousOcean;
import minestrapteam.virtious.world.gen.component.RuinedTempleMain;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class VirtiousStructureGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(chunkGenerator instanceof VirtiousChunkProvider)
		{
			generateVirtious(random, chunkX * 16, chunkZ * 16, world);
		}
	} 
	
	public void generateVirtious(Random random, int blockX, int blockZ, World world)
	{
		int x = blockX + random.nextInt(16);
		int z = blockZ + random.nextInt(16);
		if(!(world.getBiomeGenForCoords(x, z) instanceof BiomeGenVirtiousOcean))
		{
			//TODO Fix for next release
//			if(random.nextInt(200) == 1)
//			{
//				new VirtiousGenTempleGood().generate(world, random, x, world.getFirstUncoveredBlock(x, z), z);
//			}
			
			if(random.nextInt(200) == 1)
			{
				new VirtiousGenCytoidCommandCenter().generate(world, random, x, world.getFirstUncoveredBlock(x, z), z);
			}
		}
		
		/*
		x = blockX + random.nextInt(16);
		z = blockZ + random.nextInt(16);
		if(!(world.getBiomeGenForCoords(x, z) instanceof BiomeGenVirtiousOcean))
		{
//			if(random.nextInt(50) == 1)
//			{
				new RuinedTempleMain().generate(world, random, x, world.getFirstUncoveredBlock(x, z), z);
//			}
		}*/
	}

}
