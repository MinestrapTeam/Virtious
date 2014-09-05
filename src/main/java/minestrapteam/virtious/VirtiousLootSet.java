package minestrapteam.virtious;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.item.ItemStack;

public class VirtiousLootSet
{
	public Map<Integer, ItemStack>	loot;
	public Map<Integer, Integer>	lootMin;
	public Map<Integer, Integer>	lootMax;
	public int						totalWeight;
	
	public VirtiousLootSet()
	{
		this.loot = new HashMap<Integer, ItemStack>();
		this.lootMin = new HashMap<Integer, Integer>();
		this.lootMax = new HashMap<Integer, Integer>();
		this.totalWeight = 0;
	}
	
	public void addLoot(ItemStack stack, int weight, int min, int max)
	{
		if (weight <= 0 || stack == null)
			return;
		
		this.totalWeight += weight;
		this.loot.put(this.totalWeight, stack);
		this.lootMin.put(this.totalWeight, min);
		this.lootMax.put(this.totalWeight, max);
	}
	
	public ItemStack getRandomLoot()
	{
		Random rand = new Random();
		int weight = rand.nextInt(this.totalWeight);
		
		ItemStack stack = null;
		
		Set<Integer> keySet = this.loot.keySet();
		Integer[] keys = keySet.toArray(new Integer[keySet.size()]);
		Arrays.sort(keys);
		
		for (Integer key : keys)
		{
			if (key >= weight)
			{
				stack = this.loot.get(key).copy();
				int min = this.lootMin.get(key);
				int max = this.lootMax.get(key);
				int amount = rand.nextInt(max - min + 1) + min;
				stack.stackSize = amount;
				break;
			}
		}
		
		return stack;
	}
}