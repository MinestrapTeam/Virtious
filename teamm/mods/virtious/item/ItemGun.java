package teamm.mods.virtious.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.entity.EntityLaser;

public class ItemGun extends VirtiousItem
{
	private int damage;
	private int firetick;
	private int firemax;
	private String sound;
	
	public ItemGun(int id, int damage, int firemax, String sound)
	{
		super(id);
		this.firetick = this.firemax;
		this.damage = damage;
		this.firemax = firemax;
		this.setMaxStackSize(1);
		this.setMaxDamage(3000);
		this.setCreativeTab(Virtious.tabVirtiousItems);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if(!var2.isRemote)
		{
			if (this.firetick == this.firemax && this.firemax != 0)
			{
				var2.spawnEntityInWorld(new EntityLaser(var2, var3, damage));
				//TODO Gun sound
			}
		}
		return var1;
	}
	
	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		this.firetick = this.firemax;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}
}
