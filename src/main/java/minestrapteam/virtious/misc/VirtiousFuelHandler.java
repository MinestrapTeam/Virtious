package minestrapteam.virtious.misc;

import minestrapteam.virtious.lib.VirtiousItems;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;

public class VirtiousFuelHandler implements IFuelHandler
{

	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.itemID == VirtiousItems.tak.itemID)
		{
			return 2400;
		}
		return 0;
	}

}
