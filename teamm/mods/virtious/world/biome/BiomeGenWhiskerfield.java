package teamm.mods.virtious.world.biome;

import teamm.mods.virtious.entity.EntityBurfalaunt;
import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenWhiskerfield extends BiomeGenBase
{
    public BiomeGenWhiskerfield(int par1)
    {
        super(par1);
        this.theBiomeDecorator = new BiomeDecoratorWhiskerfield(this);
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBurfalaunt.class,  12, 4, 4));
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        this.topBlock = (byte) VirtiousBlocks.virtianGrass.blockID;
		this.fillerBlock = (byte) VirtiousBlocks.virtianSoil.blockID;
        
        this.setBiomeName("Whiskerfield Biome");

    }
}
