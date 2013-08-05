package teamm.mods.virtious.block;

import teamm.mods.virtious.Virtious;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class VirtiousAcid extends BlockFluidClassic
{
	protected Icon[] iconArray;
	
	public VirtiousAcid(int id) 
	{
		super(id, Virtious.virtiousFluid, Material.water);
		Virtious.virtiousFluid.setBlockID(id);
	}
	
	@Override
	public void registerIcons(IconRegister r)
	{
		this.iconArray = new Icon[]
				{
					r.registerIcon("virtious:VirtiousAcidFlowing"),
					r.registerIcon("virtious:VirtiousAcidStill")
				};
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return meta == 1 ? iconArray[0] : iconArray[1];		
	}
	
	@Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
    	if(entity instanceof EntityLivingBase)
    	{
    		EntityLivingBase mob = (EntityLivingBase) entity;
    		mob.addPotionEffect(new PotionEffect(Potion.poison.getId(), 30, 3, false));
    	}
    }

}
