package teamm.mods.virtious.lib;

import net.minecraftforge.common.Property;
import teamm.mods.virtious.Config;
import teamm.mods.virtious.Virtious;

public class VirtiousBlocks 
{
	/**
	 * Loads all block objects
	 */
	public static void loadAllBlocks()
	{
		Property idStone = Virtious.config.getBlock("idStone", Config.idStone);
		int stoneID = idStone.getInt();
		
		//TODO add all block objects here
	}
}
