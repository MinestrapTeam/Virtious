package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVirtiousOcean extends BiomeGenBase
{
	public BiomeGenVirtiousOcean(int id)
	{
		super(id);
		this.setHeight(new Height(-0.2F, 0.6F));
		
		this.topBlock = VBlocks.virtian_grass;
		this.fillerBlock = VBlocks.virtian_soil;
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
	}
}
