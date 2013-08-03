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
		GameRegistry.addRecipe(new ItemStack(VirtiousBlocks.blockTak), new Object[]
				{
			"TTT", "TTT", "TTT", Character.valueOf('T'), VirtiousItems.tak
				});
		GameRegistry.addShapelessRecipe(new ItemStack(VirtiousBlocks.plankAmber, 4), new Object[]
				{
			VirtiousBlocks.logAmber
				});
		GameRegistry.addShapelessRecipe(new ItemStack(VirtiousBlocks.plankVirtian, 4), new Object[]
				{
			VirtiousBlocks.logVirtian
				});
		GameRegistry.addRecipe(new ItemStack(Item.stick, 4), new Object[]
				{
			"T", "T", Character.valueOf('T'), VirtiousBlocks.plankAmber
				});
		GameRegistry.addRecipe(new ItemStack(Item.stick, 4), new Object[]
				{
			"T", "T", Character.valueOf('T'), VirtiousBlocks.plankVirtian
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.amberwoodPickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.plankAmber, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.amberwoodAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousBlocks.plankAmber, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.amberwoodHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.plankAmber, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.amberwoodShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousBlocks.plankAmber, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.amberwoodSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousBlocks.plankAmber, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianwoodPickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.plankVirtian, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianwoodAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousBlocks.plankVirtian, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianwoodHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.plankVirtian, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianwoodShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousBlocks.plankVirtian, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianwoodSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousBlocks.plankVirtian, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianstonePickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.virtiancobblestone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianstoneAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousBlocks.virtiancobblestone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianstoneHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.virtiancobblestone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianstoneShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousBlocks.virtiancobblestone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.virtianstoneSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousBlocks.virtiancobblestone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.deepstonePickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.deepStone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.deepstoneAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousBlocks.deepStone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.deepstoneHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousBlocks.deepStone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.deepstoneShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousBlocks.deepStone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.deepstoneSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousBlocks.deepStone, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.brazeumPickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousItems.ingotBrazeum, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.brazeumAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousItems.ingotBrazeum, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.brazeumHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousItems.ingotBrazeum, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.brazeumShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousItems.ingotBrazeum, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.brazeumSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousItems.ingotBrazeum, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.aquieusPickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousItems.shardAquieus, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.aquieusAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousItems.shardAquieus, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.aquieusHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousItems.shardAquieus, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.aquieusShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousItems.shardAquieus, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.aquieusSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousItems.shardAquieus, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.pluthoriumPickaxe, 1), new Object[]
				{
			"WWW", " S ", " S ", Character.valueOf('W'), VirtiousItems.gemPluthorium, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.pluthoriumAxe, 1), new Object[]
				{
			"WW ", "WS ", " S ", Character.valueOf('W'), VirtiousItems.gemPluthorium, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.pluthoriumHoe, 1), new Object[]
				{
			"WW ", " S ", " S ", Character.valueOf('W'), VirtiousItems.gemPluthorium, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.pluthoriumShovel, 1), new Object[]
				{
			"W", "S", "S", Character.valueOf('W'), VirtiousItems.gemPluthorium, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(VirtiousItems.pluthoriumSword, 1), new Object[]
				{
			"W", "W", "S", Character.valueOf('W'), VirtiousItems.gemPluthorium, Character.valueOf('S'), Item.stick
				});
		
		//TODO Load all recipes here
	}
}
