package teamm.mods.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.jcraft.jorbis.VorbisFile;

import teamm.mods.virtious.Virtious;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PortalBlock extends VirtiousBlock
{
    public PortalBlock(int par1)
    {
        super(par1, Material.portal);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
  


    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        par1World.setBlock(par2, par3, par4, this.blockID, 0, 2);
        return true;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity)
    {

        if (entity.ridingEntity == null && entity.riddenByEntity == null)
        {
        	if(entity.dimension == Virtious.dimensionID)
        	{
        		
        	}
        	else
        	{
        		if(entity instanceof EntityPlayerMP){
        			EntityPlayerMP player = (EntityPlayerMP) entity;
        			player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Virtious.dimensionID);
        		}
        	}
        }
    }


}
