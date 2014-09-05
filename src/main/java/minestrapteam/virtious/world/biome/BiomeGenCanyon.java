package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.entity.EntityNativeSkeleton;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenCanyon extends BiomeGenBase
{
	public BiomeGenCanyon(int id)
	{
		super(id);
		
		this.setHeight(new Height(0.9F, 0.6F));
		this.setDisableRain();
		this.setTemperatureRainfall(2.0F, 0.0F);
		
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityNativeSkeleton.class, 10, 4, 4));
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = VBlocks.canyonstone;
		this.fillerBlock = VBlocks.canyonstone;
		
		// TODO New biome decorator
		// this.theBiomeDecorator = new BiomeDecoratorVirtious(this);
	}
}
