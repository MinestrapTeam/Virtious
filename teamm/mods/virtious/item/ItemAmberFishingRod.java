package teamm.mods.virtious.item;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.entity.item.EntityVirtiousFishHook;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemAmberFishingRod extends Item
{
    @SideOnly(Side.CLIENT)
    private Icon theIcon;

    public ItemAmberFishingRod(int par1)
    {
        super(par1);
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(Virtious.tabVirtiousItems);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.fishEntity != null)
        {
            int i = Virtious.fishEntity.catchFish();
            par1ItemStack.damageItem(i, par3EntityPlayer);
            par3EntityPlayer.swingItem();
        }
        else
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityVirtiousFishHook(par2World, par3EntityPlayer));
            }

            par3EntityPlayer.swingItem();
        }

        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("virtious:AmberRodUncast");
        this.theIcon = par1IconRegister.registerIcon("viritous:AmberWoodRodCast");
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94597_g()
    {
        return this.theIcon;
    }
}
