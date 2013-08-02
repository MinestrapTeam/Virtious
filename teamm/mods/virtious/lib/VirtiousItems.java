package teamm.mods.virtious.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import teamm.mods.virtious.Config;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.item.VirtiousItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.Property;

public class VirtiousItems 
{
	public static Item ingotBrazeum;
	public static Item shardIgnus;
	public static Item gemPluthorium;
	
	/**
	 * Loads all item objects
	 */
	public VirtiousItems()
	{
		Property idIngotBrazeum = Virtious.config.getItem("Brazeum Ingot ID", Config.idIngotBrazeum);
		int ingotBrazeumId = idIngotBrazeum.getInt();
		ingotBrazeum = new VirtiousItem(ingotBrazeumId).setUnlocalizedName("BrazeumIngot");
		LanguageRegistry.addName(ingotBrazeum, "Brazeum Ingot");
		
		Property idShardIgnus = Virtious.config.getItem("Virtious Shard ID", Config.idIgnusShard);
		int shardIgnusId = idShardIgnus.getInt();
		shardIgnus = new VirtiousItem(shardIgnusId).setUnlocalizedName("IgnusShard");
		LanguageRegistry.addName(shardIgnus, "Ignus Shard");
		
		Property idGemPluthorium = Virtious.config.getItem("Pluthorium Gem", Config.idGemPluthorium);
		int gemPluthoriumId = idGemPluthorium.getInt();
		gemPluthorium = new VirtiousItem(gemPluthoriumId).setUnlocalizedName("PluthoriumGem");
		LanguageRegistry.addName(gemPluthorium, "Pluthorium Gem");
		
		//TODO load all item objects
	}
}
