package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenWhiskerfield extends BiomeGenBase
{
	public BiomeGenWhiskerfield(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new BiomeDecoratorWhiskerfield();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = 4;
		this.theBiomeDecorator.grassPerChunk = 10;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityBurfalaunt.class, 12, 4, 4));
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = VBlocks.virtian_grass;
		this.fillerBlock = VBlocks.virtian_soil;
	}
}
