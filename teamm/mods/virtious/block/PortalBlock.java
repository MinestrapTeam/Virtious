package teamm.mods.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.jcraft.jorbis.VorbisFile;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.world.VirtiousTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

public class PortalBlock extends Block
{
	public PortalBlock(int par1)
    {
        super(par1, Material.air);
//        this.setBlockBounds(0.5F, 1F, 0.5F, 0.5F, 1F, 0.5F);
        this.setTickRandomly(true);
    }

    
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity)
    {
    	if (entity.ridingEntity == null && entity.riddenByEntity == null)
        {
	    	if(entity instanceof EntityPlayerMP){
				EntityPlayerMP playermp = (EntityPlayerMP) entity;
				
				if(entity.dimension == Virtious.dimensionID)
				{
					playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0,
							new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(0)));
				} else {
					playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, Virtious.dimensionID,
							new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(Virtious.dimensionID)));
				}
			}
    	}
    }
}
