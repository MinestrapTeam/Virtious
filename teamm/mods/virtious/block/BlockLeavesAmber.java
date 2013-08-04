package teamm.mods.virtious.block;

import java.util.ArrayList;
import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IShearable;

public class BlockLeavesAmber extends VirtiousBlock implements IShearable
{	
    @SideOnly(Side.CLIENT)
    private Icon leaves_fast;

    @SideOnly(Side.CLIENT)
    private Icon leaves;
    
    int[] adjacentTreeBlocks;

	public BlockLeavesAmber(int id, Material mat)
	{
		super(id, mat);
        this.setTickRandomly(true);
	}
	
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
    	return true;
    }

	@Override
	/**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
		if(Minecraft.getMinecraft().gameSettings.fancyGraphics)
			return this.leaves;
		return this.leaves_fast;
    }
	
	@Override
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (!world.isRemote)
        {
            int meta = world.getBlockMetadata(i, j, k);
            int distance = 3;
            
            for(int x = -distance; x <= distance; x++)
            {
        		for(int z = -distance; z <= distance; z++)
                {
        			for(int y = -distance; y <= distance; y++)
        			{
            			if(world.getBlockId(i + x, j + y, k + z) == VirtiousBlocks.logAmber.blockID)
            				return;
                    }
                }
            }
            
            if (meta <= 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, 8, 4);//metadata 8 ?
            }
            else
            {
                this.removeLeaves(world, i, j, k);
            }
        }
    }
    
    private void removeLeaves(World par1World, int par2, int par3, int par4)
    {
        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
        par1World.setBlockToAir(par2, par3, par4);
    }
    
    @Override
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(20) == 0 ? 1 : 0;
    }
    
    @Override
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return VirtiousBlocks.saplingAmber.blockID;
    }
    
    @Override
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (!par1World.isRemote)
        {
            int j1 = 20;

            if ((par5 & 3) == 3)
            {
                j1 = 40;
            }

            if (par7 > 0)
            {
                j1 -= 2 << par7;

                if (j1 < 10)
                {
                    j1 = 10;
                }
            }

            if (par1World.rand.nextInt(j1) == 0)
            {
                int k1 = this.idDropped(par5, par1World.rand, par7);
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
            }

            j1 = 200;

            if (par7 > 0)
            {
                j1 -= 10 << par7;

                if (j1 < 40)
                {
                    j1 = 40;
                }
            }

//            if ((par5 & 3) == 0 && par1World.rand.nextInt(j1) == 0)
//            {
//                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.appleRed, 1, 0));
//            }
        }
    }
    
    @Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}
    
    @Override
    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }
    
    @Override
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1 & 3;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return !Minecraft.getMinecraft().gameSettings.fancyGraphics;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.leaves = par1IconRegister.registerIcon("virtious:AmberLeaves");
        this.leaves_fast = par1IconRegister.registerIcon("virtious:AmberLeavesFast");

    }
    
    @Override
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
        return !Minecraft.getMinecraft().gameSettings.fancyGraphics && i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }
    

    @Override
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }
}
