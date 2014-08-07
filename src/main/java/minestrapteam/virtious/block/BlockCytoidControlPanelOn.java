package minestrapteam.virtious.block;

import java.util.Random;

import minestrapteam.virtious.lib.VirtiousBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCytoidControlPanelOn extends Block
{
	private Icon front;
	public BlockCytoidControlPanelOn(int id)
	{
		super(id, Material.iron);
	}
	
	/**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return true;
    }

    /**
     * Returns true if the block is emitting indirect/weak redstone power on the specified side. If isBlockNormalCube
     * returns true, standard redstone propagation rules will apply instead and this will not be called. Args: World, X,
     * Y, Z, side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
     */
    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return 15;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	par1World.setBlock(par2, par3, par4, VirtiousBlocks.cytoidControlOff.blockID);
    	return true;
    }
    
    public void registerIcons(IconRegister r)
    {
    	blockIcon = r.registerIcon("virtious:CytoidWall");
    	front = r.registerIcon("virtious:CytoidControlPanel");
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
    	return par1 == 1 ? this.blockIcon : par1 == 0 ? this.blockIcon : this.front;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return VirtiousBlocks.cytoidControlOff.blockID;
    }
}
