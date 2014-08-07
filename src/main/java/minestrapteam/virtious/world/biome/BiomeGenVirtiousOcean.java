package minestrapteam.virtious.world.biome;

import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.lib.VirtiousBlocks;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenVirtiousOcean extends BiomeGenBase
{
    public BiomeGenVirtiousOcean(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.setBiomeName("Virtious Acid Ocean");
        this.setMinMaxHeight(-1.0F, 0.4F);
        this.topBlock = (byte) VirtiousBlocks.virtianGrass.blockID;
        this.fillerBlock = (byte) VirtiousBlocks.virtianSoil.blockID;
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    }
}
