package teamm.mods.virtious.lib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Property;
import teamm.mods.virtious.Config;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.block.DeepStone;

public class VirtiousBlocks 
{
	public static Block deepStone;
	
	/**
	 * Loads all block objects
	 */
	public VirtiousBlocks()
	{
		Property idDeedStone = Virtious.config.getBlock("idStone", Config.idDeedStone);
		int deepStoneID = idDeedStone.getInt();
		deepStone = new DeepStone(deepStoneID, Material.rock).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("deepStone").setCreativeTab(CreativeTabs.tabBlock);
		
		
		//TODO add all block objects here
	}
}
