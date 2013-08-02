package teamm.mods.virtious.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VirtiousRecipes 
{
	public VirtiousRecipes()
	{
		GameRegistry.addSmelting(VirtiousBlocks.oreVIron.blockID, new ItemStack(Item.ingotIron), 0.7F);
		GameRegistry.addSmelting(VirtiousBlocks.oreBrazeum.blockID, new ItemStack(VirtiousItems.ingotBrazeum), 0.7F);
		GameRegistry.addSmelting(VirtiousBlocks.virtiancobblestone.blockID, new ItemStack(VirtiousBlocks.virtianstone), 0.5F);
		GameRegistry.addSmelting(VirtiousBlocks.oreDeepIron.blockID, new ItemStack(Item.ingotIron), 0.8F);
		GameRegistry.addRecipe(new ItemStack(Block.furnaceIdle), new Object[]
				{
			"SSS", "S S", "SSS", Character.valueOf('S'), VirtiousBlocks.virtiancobblestone
				});
		
		//TODO Load all recipes here
	}
}
