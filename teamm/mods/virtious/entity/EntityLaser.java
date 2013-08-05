package teamm.mods.virtious.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable
{
	private int damage;
	
	public EntityLaser(World w)
	{
		super(w);
	}
	
	public EntityLaser(World w, EntityLivingBase e, int dmg)
	{
		super(w, e);
		this.damage = dmg;
	}
	public EntityLaser(World par1World, double par2, double par4, double par6) 
	{
		super(par1World, par2, par4, par6);
	}

	 @Override
	 protected void onImpact(MovingObjectPosition var1)
	 {
	     if (var1.entityHit != null)
	     {
	         var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
	     }

	     if (!this.worldObj.isRemote)
	     {
	         this.setDead();
	     }
	 }

}
