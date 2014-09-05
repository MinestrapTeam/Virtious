package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenGravelBeach extends BiomeGenBase
{	
	public BiomeGenGravelBeach(int id)
	{
		super(id);
		
		this.setHeight(new Height(0.3F, 0.2F));
		this.setColor(16440917);
		this.setTemperatureRainfall(0.7F, 0.3F);
		
		this.spawnableCreatureList.clear();
		
		this.topBlock = VBlocks.fine_gravel;
		this.fillerBlock = VBlocks.canyonstone;
	}
}
