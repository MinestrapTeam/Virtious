package minestrapteam.virtious.item;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.entity.EntityLaser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGun extends Item
{
	private int firetick;
	
	protected int damage;
	protected int firemax;
	protected String sound;
	
	public ItemGun(int damage, int firemax, String sound)
	{
		this.firetick = this.firemax;
		this.damage = damage;
		this.firemax = firemax;
		this.setMaxStackSize(1);
		this.setMaxDamage(3000);
		this.setCreativeTab(Virtious.tabVirtiousItems);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if (this.firetick == this.firemax)
			{
				world.spawnEntityInWorld(new EntityLaser(world, player, this.damage));
				//TODO Gun sound
			}
		}
		return stack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int ticks)
	{
		this.firetick = this.firemax;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}
}
