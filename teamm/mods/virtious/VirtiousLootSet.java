package teamm.mods.virtious;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.item.ItemStack;

public class VirtiousLootSet 
{
	public Map<Integer, ItemStack> loot;
	public Map<Integer, Integer> lootMin;
	public Map<Integer, Integer> lootMax;
	public int totalWeight;

	public VirtiousLootSet()
	{
		loot = new HashMap<Integer, ItemStack>();
		lootMin = new HashMap<Integer, Integer>();
		lootMax = new HashMap<Integer, Integer>();
		totalWeight = 0;
	}

	public void addLoot(ItemStack stack, int weight, int min, int max)
	{
		if(weight <= 0 || stack == null)
			return;

		loot.put(totalWeight + weight, stack);
		lootMin.put(totalWeight + weight, min);
		lootMax.put(totalWeight + weight, max);
		totalWeight += weight;
	}

	public ItemStack getRandomLoot()
	{
		Random rand = new Random();
		int weight = rand.nextInt(totalWeight);

		ItemStack stack = null;

		Set<Integer> keySet = loot.keySet();
		Integer[] keys = keySet.toArray(new Integer[keySet.size()]);
		Arrays.sort(keys);

		for(Integer key : keys)
		{
			if(key >= weight)
			{
				stack = loot.get(key).copy();
				int min = lootMin.get(key);
				int max = lootMax.get(key);
				int amount = rand.nextInt(max - min + 1) + min;
				stack.stackSize = amount;
				break;
			}
		}

		return stack;
	}
}