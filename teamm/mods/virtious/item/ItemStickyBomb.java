package teamm.mods.virtious.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.entity.item.EntityStickyBomb;

public class ItemStickyBomb extends Item{

	public ItemStickyBomb(int id) {
		super(id);
		this.setCreativeTab(Virtious.tabVirtiousItems);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i, int j, int k, int par7, float par8, float par9, float par10)
	{
		if(!world.isRemote){
			EntityStickyBomb bomb = new EntityStickyBomb(world, i, j + 1.5F, k, player);
			world.spawnEntityInWorld(bomb);
			player.getCurrentEquippedItem().stackSize--;
		}
		return false;
	}
}
