package teamm.mods.virtious.entity.item;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStickyBombItem extends EntityThrowable
{

	public EntityStickyBombItem(World world, double i, double j, double k) {
		super(world, i, j, k);
	}
	public EntityStickyBombItem(World world)
    {
        super(world);
    }

    public EntityStickyBombItem(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		 if (!this.worldObj.isRemote)
	        {
	         	this.worldObj.spawnEntityInWorld(new EntityStickyBomb(this.worldObj, this.posX, this.posY, this.posZ));
//	         	PacketDispatcher.sendPacketToAllAround(X, Y, Z, range, dimensionId, packet)
	            this.setDead();
	        }
	}

}
