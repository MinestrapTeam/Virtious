package teamm.mods.virtious.item;

import teamm.mods.virtious.Virtious;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class VirtiousItem extends Item
{
	public VirtiousItem(int id)
	{
		super(id);
		this.setCreativeTab(Virtious.tabVirtious);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("virtious:" + this.getUnlocalizedName().substring(5));
	}
}
