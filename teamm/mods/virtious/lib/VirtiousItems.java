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
	/**
	 * Loads all item objects
	 */
	public VirtiousItems()
	{
		Property idIngotBrazeum = Virtious.config.getItem("Brazeum Ingots ID", Config.idIngotBrazeum);
		int ingotBrazeumId = idIngotBrazeum.getInt();
		ingotBrazeum = new VirtiousItem(ingotBrazeumId).setUnlocalizedName("ingotBrazeum");
		LanguageRegistry.addName(idIngotBrazeum, "Brazeum Ingot");
		
		//TODO load all item objects
	}
}
