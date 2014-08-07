package minestrapteam.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import com.jcraft.jorbis.VorbisFile;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.world.TileEntityPortal;
import minestrapteam.virtious.world.VirtiousTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

public class PortalBlock extends Block
{
	public PortalBlock(int par1)
    {
        super(par1, Material.glass);
        this.setBlockBounds(0.5F, 1F, 0.5F, 0.5F, 1F, 0.5F);
        this.setTickRandomly(true);
    }

	@SideOnly(Side.CLIENT)
	@Override
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random rand)
	{
		TileEntityPortal tile = (TileEntityPortal) world.getBlockTileEntity(i, j, k);
		
		
		int resolution = 16;
		for(int e = 0; e <= resolution; e++){
			float degree = (float)(2 * 3.14159 * e /resolution);
			float x = (float) (Math.cos(degree) * 0.5F);
			float y = (float) (Math.sin(degree) * 0.5F);
			world.spawnParticle("smoke", i + 0.5F + x, j + 0.5F, k + 0.5F + y, 0.0D, 0.0D , 0.0D);
		}
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
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
    	return 0;
    }
    
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    	if (entity.ridingEntity == null && entity.riddenByEntity == null)
        {
	    	if(entity instanceof EntityPlayerMP){
				EntityPlayerMP playermp = (EntityPlayerMP) entity;
//				TileEntityPortal tile = (TileEntityPortal) world.getBlockTileEntity(i, j, k);
				if(playermp.timeUntilPortal == 0)
				{
					if(!world.isRemote)
					{
						if(entity.dimension == Virtious.dimensionID)
						{
							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "The Overworld...");
						}
						
						else
						{
							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "Viritous...");
						}
					}
				}
//				
//				if(playermp.timeUntilPortal == 11)
//				{
//					if(!world.isRemote)
//					{
//						if(entity.dimension == Virtious.dimensionID)
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "The Overworld");
//						}
//						
//						else
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "Viritous");
//						}
//					}
//				}
//				
//				if(playermp.timeUntilPortal == 22)
//				{
//					if(!world.isRemote)
//					{
//						if(entity.dimension == Virtious.dimensionID)
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "The Overworld");
//						}
//						else
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "Viritous");
//						}
//					}
//				}
//				
//				if(playermp.timeUntilPortal == 33)
//				{
//					if(!world.isRemote)
//					{
//						if(entity.dimension == Virtious.dimensionID)
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "The Overworld");
//						}
//						else
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "Viritous");
//						}
//					}
//				}
				
//				if(playermp.timeUntilPortal == 44)
//				{
//					if(!world.isRemote)
//					{
//						if(entity.dimension == Virtious.dimensionID)
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "The Overworld...");
//						}
//						else
//						{
//							playermp.addChatMessage("Warping to " + EnumChatFormatting.GRAY + "Viritous...");
//						}
//					}
//				}
			
				if(playermp.timeUntilPortal >= 45)
				{
					if(entity.dimension == Virtious.dimensionID)
					{
						playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0,
								new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(0)));
					} else {
						playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, Virtious.dimensionID,
								new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(Virtious.dimensionID)));
					}
					playermp.timeUntilPortal = 0;
				}
				else
				{
					playermp.timeUntilPortal++;
				}
			}
    	}
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
		return new TileEntityPortal();
    }
}
