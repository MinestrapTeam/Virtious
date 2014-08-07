package minestrapteam.virtious.world.gen;

import java.util.Random;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.lib.VirtiousBlocks;
import minestrapteam.virtious.world.VirtiousChunkProvider;
import minestrapteam.virtious.world.biome.BiomeGenVirtious;
import minestrapteam.virtious.world.biome.BiomeGenVirtiousOcean;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;

import cpw.mods.fml.common.IWorldGenerator;

public class VirtiousWorldGenerator implements IWorldGenerator
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
		for(int l = 0; l < 2; l ++)
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
		

		VirtiousGenVirtianTree treeVirtian = new VirtiousGenVirtianTree(VirtiousBlocks.leavesVirtian.blockID, VirtiousBlocks.logVirtian.blockID, false);
		VirtiousGenAmberTree treeAmber = new VirtiousGenAmberTree(VirtiousBlocks.leavesAmber.blockID, VirtiousBlocks.logAmber.blockID, false);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);
		
		if (biome instanceof BiomeGenVirtious) {

			int Xcoord = blockX + random.nextInt(16);
			int Zcoord = blockZ + random.nextInt(16);
			int i = world.getHeightValue(Xcoord, Zcoord);
			if (random.nextInt(2) == 1)
				treeVirtian.generate(world, random, Xcoord, i, Zcoord);
			else
				treeAmber.generate(world, random, Xcoord, i, Zcoord);

		}
	}
}
