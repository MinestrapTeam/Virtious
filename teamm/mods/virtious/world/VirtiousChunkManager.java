package teamm.mods.virtious.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class VirtiousChunkManager extends WorldChunkManager {

	public VirtiousChunkManager(){
		this.allowedBiomes.clear();
		this.allowedBiomes.add(BiomeGenBase.mushroomIsland);
	}
}
