package teamm.mods.virtious.item;

import teamm.mods.virtious.Virtious;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class VirtiousBucketItem extends ItemBucket{

	public VirtiousBucketItem(int id, int blockID) {
		super(id, blockID);
		this.setContainerItem(Item.bucketEmpty);
		this.setCreativeTab(Virtious.tabVirtiousItems);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("virtious:" + this.getUnlocalizedName().substring(5));
	}
	
}
