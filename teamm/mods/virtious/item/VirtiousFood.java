package teamm.mods.virtious.item;

import teamm.mods.virtious.Virtious;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class VirtiousFood extends ItemFood
{
	public VirtiousFood(int id, int healamt, int sat)
	{
		super(id, healamt, sat, false);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("virtious:" + this.getUnlocalizedName().substring(5));
	}
}
