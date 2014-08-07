package minestrapteam.virtious.item;

import minestrapteam.virtious.Virtious;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class VirtiousFood extends ItemFood
{
	public VirtiousFood(int id, int healamt, float sat)
	{
		super(id, healamt, sat, false);
		this.setCreativeTab(Virtious.tabVirtiousItems);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("virtious:" + this.getUnlocalizedName().substring(5));
	}
}
