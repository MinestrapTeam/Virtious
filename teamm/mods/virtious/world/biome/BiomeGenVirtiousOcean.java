package teamm.mods.virtious.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVirtiousOcean extends BiomeGenBase
{
    public BiomeGenVirtiousOcean(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.setBiomeName("Virtious Acid Ocean");
        this.setMinMaxHeight(-1.0F, 0.4F);
    }
}
