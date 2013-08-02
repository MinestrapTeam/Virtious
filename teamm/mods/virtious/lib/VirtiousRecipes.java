package teamm.mods.virtious.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VirtiousRecipes 
{
	public VirtiousRecipes()
	{
		GameRegistry.addSmelting(VirtiousBlocks.oreVIron.blockID, new ItemStack(Item.ingotIron), 0.7F);
		GameRegistry.addSmelting(VirtiousBlocks.oreBrazeum.blockID, new ItemStack(VirtiousItems.ingotBrazeum), 0.7F);
		//TODO Load all recipes here
	}
}
