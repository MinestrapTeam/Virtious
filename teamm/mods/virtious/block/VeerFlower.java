package teamm.mods.virtious.block;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;

public class VeerFlower extends VirtiousFlower{


	public VeerFlower(int id) {
		super(id);
	}
	
    @Override
	public int getRenderBlockPass()
	{
	    return 1;
	}
    
    @Override
	public int idDropped(int par1, Random rand, int par3)
	{
		return VirtiousItems.seedVeer.itemID;
	}
	
	/**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random)
    {
    	return random.nextInt(2) == 1 ? 1 : 0;
	}
    
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    @Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		
        ItemStack itemstack = new ItemStack(VirtiousItems.dyeVeer);
		this.dropBlockAsItem_do(par1World, par2, par3, par4, itemstack);
    }
}

