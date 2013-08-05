package teamm.mods.virtious.block;

import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCytoidControlPanelOff extends Block
{
	private Icon front;
	public BlockCytoidControlPanelOff(int id)
	{
		super(id, Material.iron);

	}

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	par1World.setBlock(par2, par3, par4, VirtiousBlocks.cytoidControlOn.blockID);
    	return true;
    }
    
    public void registerIcons(IconRegister r)
    {
    	blockIcon = r.registerIcon("virtious:CytoidWall");
    	front = r.registerIcon("virtious:CytoidControlPanelOff");
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
    	return par1 == 1 ? this.blockIcon : (par1 == 0 ? this.blockIcon : (par1 != par2 ? this.blockIcon : this.front));
    }   
}
