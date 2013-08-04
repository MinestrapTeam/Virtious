package teamm.mods.virtious.block;

import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTakOre extends VirtiousBlock{

	public BlockTakOre(int id, Material mat) {
		super(id, mat);
	}
	
	@Override
	public int idDropped(int blockID, Random rand, int meta)
	{
		return VirtiousItems.tak.itemID; 
	}
	
//	@Override
//    public void onNeighborBlockChange(World world, int i, int j, int k, int id)
//    {
//    	if(id == Block.fire.blockID)
//    		world.createExplosion(null, i, j, k, 2F, false);
//    }
    
    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
    	return true;
    }
}
