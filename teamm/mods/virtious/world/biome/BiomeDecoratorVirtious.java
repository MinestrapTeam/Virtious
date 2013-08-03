package teamm.mods.virtious.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorVirtious extends BiomeDecorator 
{
	public BiomeDecoratorVirtious(BiomeGenBase biomeGenBase) 
	{
		super(biomeGenBase);
//		this.customplant = new customplant(id);
	}
	
	/**
	 * The method that does the work of actually decorating chunks
	 */
	protected void decorate()
	{
		int i;
		int j;
		int k;
		boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, GRASS);
		
		for(int x = 0; doGen && x < this.grassPerChunk; ++x)
		{
			
			i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			j = this.randomGenerator.nextInt(128);
			k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			
			WorldGenerator curlGrass = new WorldGenTallGrass(VirtiousBlocks.blockNightwhisker.blockID, 0);
			curlGrass.generate(this.currentWorld, this.randomGenerator, i, j, k);
		}
	}
}
