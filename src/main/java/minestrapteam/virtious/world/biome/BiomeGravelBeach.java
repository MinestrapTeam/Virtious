package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.lib.VirtiousBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGravelBeach extends BiomeGenBase{

	public BiomeGravelBeach(int id) {
		super(id);
		this.spawnableCreatureList.clear();
        this.topBlock = (byte)VirtiousBlocks.fineGravel.blockID;
        this.fillerBlock = (byte)VirtiousBlocks.canyonstone.blockID;

        this.setColor(16440917);
        this.setBiomeName("Gravel Beach").setTemperatureRainfall(0.7F, 0.3F).setMinMaxHeight(0.1F, 0.5F);
	}

}
