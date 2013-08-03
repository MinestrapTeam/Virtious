package teamm.mods.virtious.lib;

import net.minecraft.creativetab.CreativeTabs;

public class VirtiousCreativeTabItems extends CreativeTabs 
{
	public VirtiousCreativeTabItems(int par1, String par2Str) 
	{
		super(par1, par2Str);
	}
	
    public int getTabIconItemIndex()
    {
    	return VirtiousItems.shardAquieus.itemID;
    }
    
    public String getTranslatedTabLabel()
    {
    	return "Virtious Mod - Items";
    }
}
