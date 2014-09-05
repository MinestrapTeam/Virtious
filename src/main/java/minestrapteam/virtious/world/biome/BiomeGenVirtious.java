package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVirtious extends BiomeGenBase
{
	public BiomeGenVirtious(int id)
	{
		super(id);
		
		this.setHeight(new Height(0.3F, 0.2F));
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityBurfalaunt.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityNative.class, 12, 4, 4));
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = VBlocks.virtian_grass;
		this.fillerBlock = VBlocks.virtian_soil;
		
		this.theBiomeDecorator = new BiomeDecoratorVirtious();
	}
}
