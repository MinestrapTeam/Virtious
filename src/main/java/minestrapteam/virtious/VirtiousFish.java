package minestrapteam.virtious;

import minestrapteam.virtious.lib.VItems;

import net.minecraft.item.ItemStack;

public class VirtiousFish 
{
	public static VirtiousLootSet lootSet;
	
	static
	{
		lootSet = new VirtiousLootSet();
		addFish(new ItemStack(VItems.evulus_fish), 50);
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
