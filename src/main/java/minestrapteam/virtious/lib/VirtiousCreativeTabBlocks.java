package minestrapteam.virtious.lib;

import net.minecraft.creativetab.CreativeTabs;

public class VirtiousCreativeTabBlocks extends CreativeTabs 
{
	public VirtiousCreativeTabBlocks(int par1, String par2Str) 
	{
		super(par1, par2Str);
	}
	
    public int getTabIconItemIndex()
    {
    	return VirtiousBlocks.virtianGrass.blockID;
    }
    
    public String getTranslatedTabLabel()
    {
    	return "Virtious Mod - Blocks";
    }
}
