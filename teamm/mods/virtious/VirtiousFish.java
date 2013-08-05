package teamm.mods.virtious;

import teamm.mods.virtious.lib.VirtiousItems;
import net.minecraft.item.ItemStack;

public class VirtiousFish 
{
	public static VirtiousLootSet lootSet;
	
	static
	{
		lootSet = new VirtiousLootSet();
		addFish(new ItemStack(VirtiousItems.fishEbulus), 50);
		//TODO Add fish
	}
	
	public static void addFish(ItemStack fish, int probability)
	{
		lootSet.addLoot(fish, probability, 1, 1);
	}
	
	public static ItemStack getRandomFish()
	{
		return lootSet.getRandomLoot();
	}
}
