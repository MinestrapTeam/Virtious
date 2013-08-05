package teamm.mods.virtious.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class VirtiousTeleporter extends Teleporter
{
	

	private final WorldServer worldServerInstance;

    /** A private Random() function in Teleporter */
    private final Random random;

    /** Stores successful portal placement locations for rapid lookup. */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    
    public VirtiousTeleporter(WorldServer worldServer)
	{
		super(worldServer);
		this.worldServerInstance = worldServer;
		this.random = new Random(worldServer.getSeed());
	}
    /**
     * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
     * location.
     */
    private final List destinationCoordinateKeys = new ArrayList();

   

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity entity, double x, double y, double z, float par8)
    {
        if (this.worldServerInstance.provider.dimensionId != 1)
        {
            if (!this.placeInExistingPortal(entity, x, y, z, par8))
            {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, x, y, z, par8);
            }
        }
        else
        {
            int i = MathHelper.floor_double(entity.posX);
            int j = MathHelper.floor_double(entity.posY) - 1;
            int k = MathHelper.floor_double(entity.posZ);

            entity.setLocationAndAngles((double)i, (double)j, (double)k, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        }
    }

    /**
     * Place an entity in a nearby portal which already exists.
     */
    public boolean placeInExistingPortal(Entity entity, double par2, double par4, double par6, float par8)
    {
        short radius = 128;//for check
        double d3 = -1.0D;
        int i = 0;
        int j = 0;
        int k = 0;
        int entityx = MathHelper.floor_double(entity.posX);
        int entityZ = MathHelper.floor_double(entity.posZ);
        long chunkIntPair = ChunkCoordIntPair.chunkXZ2Int(entityx, entityZ);
        boolean flag = true;
        double zSpawn;
        int x;

        if (this.destinationCoordinateCache.containsItem(chunkIntPair))
        {
        	VirtiousPortalPosition VirtiousPortalPosition = (VirtiousPortalPosition)this.destinationCoordinateCache.getValueByKey(chunkIntPair);
            d3 = 0.0D;
            i = VirtiousPortalPosition.posX;
            j = VirtiousPortalPosition.posY;
            k = VirtiousPortalPosition.posZ;
            VirtiousPortalPosition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else
        {
            for (x = entityx - radius; x <= entityx + radius; ++x)
            {
                double d5 = (double)x + 0.5D - entity.posX;

                for (int z = entityZ - radius; z <= entityZ + radius; ++z)
                {
                    double d6 = (double)z + 0.5D - entity.posZ;

                    for (int y = this.worldServerInstance.getActualHeight() - 1; y >= 0; --y)
                    {
                        if (this.worldServerInstance.getBlockId(x, y, z) == VirtiousBlocks.portalBlock.blockID)
                        {

                            zSpawn = (double)y + 0.5D - entity.posY;
                            double d7 = d5 * d5 + zSpawn * zSpawn + d6 * d6;

                            if (d3 < 0.0D || d7 < d3)
                            {
                                d3 = d7;
                                i = x;
                                j = y;
                                k = z;
                            }
                        }
                    }
                }
            }
        }

        if (d3 >= 0.0D)
        {
            if (flag)
            {
                this.destinationCoordinateCache.add(chunkIntPair, new VirtiousPortalPosition(this, i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(chunkIntPair));
            }

            double xSpawn = (double)i + 0.5D;
            double ySpawn = (double)j + 0.5D;
            zSpawn = (double)k + 0.5D;
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            entity.setLocationAndAngles(xSpawn + 1, ySpawn + 1, zSpawn, entity.rotationYaw, entity.rotationPitch);

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean makePortal(Entity entity)
    {
        int checkRadius = 63;
        int i = MathHelper.floor_double(entity.posX);
        int k = MathHelper.floor_double(entity.posZ);
        
        int x, y, z;
        
        label274:
        while(true)
        {
        	int rand1 = random.nextInt(checkRadius * 2);
        	int rand2 = random.nextInt(checkRadius * 2);
        	
	        	x = i + rand1 - checkRadius;
    			z = k + rand2 - checkRadius;
	        	y = worldServerInstance.getActualHeight() - 1;
	        	while(y > 0 && worldServerInstance.isAirBlock(x, y-1, z))
	        	{
	        		y--;
	        	}
	        	
				if(this.worldServerInstance.getBlockId(x, y - 1, z) == VirtiousBlocks.virtianGrass.blockID ||
						this.worldServerInstance.getBlockId(x, y - 1, z) == VirtiousBlocks.virtianSoil.blockID ||
						this.worldServerInstance.getBlockId(x, y - 1, z) == Block.grass.blockID ||
						(this.worldServerInstance.getBiomeGenForCoords(x, z) != null && 
						this.worldServerInstance.getBiomeGenForCoords(x, z).topBlock == this.worldServerInstance.getBlockId(x, y - 1, z))){
					for(int x2 = x - 1; x2 <= x + 1; x2++)
					{
						for(int z2 = z - 1; z2 <= z + 1; z2++)
						{
							worldServerInstance.setBlock(x2, y, z2, Block.blockIron.blockID, 0, 2);///FIXME
						}

					}
					
					worldServerInstance.setBlock(x, y+1, z, VirtiousBlocks.portalBlock.blockID, 0, 2);
					System.out.println("X: " + x + " Y: " + (y + 1) + " Z: " + z);
					break;
				} else {
        			continue label274;
    			}
        }
                                   
        return true;
    }

    /**
     * called periodically to remove out-of-date portal locations from the cache list. Argument par1 is a
     * WorldServer.getTotalWorldTime() value.
     */
    public void removeStalePortalLocations(long par1)
    {
        if (par1 % 100L == 0L)
        {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = par1 - 600L;

            while (iterator.hasNext())
            {
                Long olong = (Long)iterator.next();
                VirtiousPortalPosition VirtiousPortalPosition = (VirtiousPortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

                if (VirtiousPortalPosition == null || VirtiousPortalPosition.lastUpdateTime < j)
                {
                    iterator.remove();
                    this.destinationCoordinateCache.remove(olong.longValue());
                }
            }
        }
    }
}