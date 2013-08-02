package teamm.mods.virtious.world.gen;

import java.util.Random;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.world.VirtiousChunkProvider;
import teamm.mods.virtious.world.biome.BiomeGenVirtious;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import cpw.mods.fml.common.IWorldGenerator;

public class VirtiousOreGenerator implements IWorldGenerator
{

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
		//Tak Ore
		for(int l = 0; l < 15; l ++)
		{
			new VirtiousGenMinable(VirtiousBlocks.oreTak.blockID, 9).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		//VIron
		for(int l = 0; l < 10; l ++)
		{
			new VirtiousGenMinable(VirtiousBlocks.oreVIron.blockID, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(63), blockZ + random.nextInt(16));
		}
		
		//Brazeum
		for(int l = 0; l < 9; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.oreBrazeum.blockID, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		//Aquieus
		for(int l = 0; l < 7; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.oreAquieus.blockID, 6).generate(world, random, blockX + random.nextInt(16), random.nextInt(32), blockZ + random.nextInt(16));
		}
		
		//Pluthorium
		for(int l = 0; l < 3; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.orePluthorium.blockID, 6).generate(world, random, blockX + random.nextInt(16), random.nextInt(16), blockZ + random.nextInt(16));
		}
		
		//Illuminous
		for(int l = 0; l < 11; l ++)
		{
			new VirtiousGenMinable(VirtiousBlocks.oreIlluminous.blockID, 7).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		//Deep Illuminous
		for(int l = 0; l < 11; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.oreDeepIlluminous.blockID, 7).generate(world, random, blockX + random.nextInt(16), random.nextInt(64), blockZ + random.nextInt(16));
		}
		
		//Deep Tak
		for(int l = 0; l < 15; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.oreDeepTak.blockID, 9).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		//Deep Tak
		for(int l = 0; l < 10; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.oreDeepIron.blockID, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		//Deep Tak
		for(int l = 0; l < 9; l ++)
		{
			new VirtiousGenDeepstone(VirtiousBlocks.deepStoneMossy.blockID, 8).generate(world, random, blockX + random.nextInt(16), random.nextInt(40), blockZ + random.nextInt(16));
		}
		
		//TODO Fix
		
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);
		if(biome instanceof BiomeGenVirtious)
		{
			for(int y = 0; y < 9; y++)
			{
				new WorldGenFlowers(VirtiousBlocks.blockNightwhisker.blockID).generate(world, random, blockX + random.nextInt(16), random.nextInt(128), blockZ + random.nextInt(16));
			}	
		}
	
	}
	

}
