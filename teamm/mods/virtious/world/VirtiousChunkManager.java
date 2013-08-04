package teamm.mods.virtious.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import teamm.mods.virtious.Virtious;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;



public class VirtiousChunkManager extends WorldChunkManager {
	
	private GenLayer genBiomes;

    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    private GenLayer biomeIndexLayer;

    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;

    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;

    
    public VirtiousChunkManager()
    {
    	this.allowedBiomes.clear();
    	this.allowedBiomes.add(Virtious.biomeCanyon);
    	this.allowedBiomes.add(Virtious.biomeWhiskerfields);
    	
    	this.biomeCache = new BiomeCache(this);
    	this.biomesToSpawnIn = new ArrayList();
    	this.biomesToSpawnIn.addAll(allowedBiomes);

    }
 
    public VirtiousChunkManager(long seed, WorldType worldTyle)
    {
    	this();
    	GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(seed, worldTyle);
    	agenlayer = getModdedBiomeGenerators(worldTyle, seed, agenlayer);
    	this.genBiomes = agenlayer[0];
    	this.biomeIndexLayer = agenlayer[1];
	}
    
    public VirtiousChunkManager(World world)
    {
    	this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }
    
    @Override
    public  List getBiomesToSpawnIn()
    {
    	return this.biomesToSpawnIn;
    }
    
    /**
     * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
     */
    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] aint = this.biomeIndexLayer.getInts(par2, par3, par4, par5);

        for (int i1 = 0; i1 < par4 * par5; ++i1)
        {
            float f = (float)this.allowedBiomes.get(aint[i1] % allowedBiomes.size()).getIntRainfall() / 65536.0F;

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            par1ArrayOfFloat[i1] = f;
        }

        return par1ArrayOfFloat;
    }
    
    /**
     * Returns a list of temperatures to use for the specified blocks.  Args: listToReuse, x, y, width, length
     */
    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] aint = this.biomeIndexLayer.getInts(par2, par3, par4, par5);

        for (int i1 = 0; i1 < par4 * par5; ++i1)
        {
            float f = (float)this.allowedBiomes.get(aint[i1] % this.allowedBiomes.size()).getIntTemperature() / 65536.0F;

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            par1ArrayOfFloat[i1] = f;
        }

        return par1ArrayOfFloat;
    }
    
    /**
     * Returns the BiomeGenBase related to the x, z position on the world.
     */
    @Override
    public BiomeGenBase getBiomeGenAt(int x, int z)
    {
        return this.biomeCache.getBiomeGenAt(x, z);
    }

    /**
     * Returns an array of biomes for the location input.
     */
    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
    	IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);

        for (int i1 = 0; i1 < par4 * par5; ++i1)
        {
            par1ArrayOfBiomeGenBase[i1] = this.allowedBiomes.get(aint[i1] % allowedBiomes.size());
        }

        return par1ArrayOfBiomeGenBase;
    }


    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomeGenBase, int x, int z, int width, int depth)
    {
        return this.getBiomeGenAt(biomeGenBase, x, z, width, depth, true);

    }

    /**
     * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false,
     * don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
     */
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomeGenBase, int x, int z, int par4, int par5, boolean par6)
    {
    	IntCache.resetIntCache();

        if (biomeGenBase == null || biomeGenBase.length < par4 * par5)
        {
            biomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (x & 15) == 0 && (z & 15) == 0)
        {
            BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(x, z);
            System.arraycopy(abiomegenbase1, 0, biomeGenBase, 0, par4 * par5);
            return biomeGenBase;
        }
        else
        {
            int[] aint = this.biomeIndexLayer.getInts(x, z, par4, par5);

            for (int i1 = 0; i1 < par4 * par5; ++i1)
            {
                biomeGenBase[i1] = this.allowedBiomes.get(aint[i1] % allowedBiomes.size());
            }

            return biomeGenBase;
        }
    }

    /**
     * Finds a valid position within a range, that is in one of the listed biomes. Searches {par1,par2} +-par3 blocks.
     * Strongly favors positive y positions.
     */
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random)
    {
        IntCache.resetIntCache();
        int l = par1 - par3 >> 2;
        int i1 = par2 - par3 >> 2;
        int j1 = par1 + par3 >> 2;
        int k1 = par2 + par3 >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
        ChunkPosition chunkposition = null;
        int j2 = 0;

        for (int k2 = 0; k2 < l1 * i2; ++k2)
        {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[k2]];

            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(j2 + 1) == 0))
            {
                chunkposition = new ChunkPosition(l2, 0, i3);
                ++j2;
            }
        }

        return chunkposition;
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        IntCache.resetIntCache();
        int l = par1 - par3 >> 2;
        int i1 = par2 - par3 >> 2;
        int j1 = par1 + par3 >> 2;
        int k1 = par2 + par3 >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.genBiomes.getInts(l, i1, l1, i2);

        for (int j2 = 0; j2 < l1 * i2; ++j2)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.biomeList[aint[j2]];

            if (!par4List.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }
}
