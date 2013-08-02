package teamm.mods.virtious.entity.item;

import teamm.mods.virtious.network.StickyBombPacket;
import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.world.World;

public class EntityStickyBomb extends Entity implements EntityOwnable{

	private String Owner;

	public EntityStickyBomb(World world) {
		super(world);
		this.setSize(.5F,  .5F);
		
//		PacketDispatcher.;
		//                entitytracker.sendPacketToAllPlayersTrackingEntity(par1Entity, new Packet22Collect(par1Entity.entityId, this.entityId));

	}
	public EntityStickyBomb(World world, double i, double j, double k)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(i, j, k);
      }
	
	@Override
	protected void entityInit() {
	}

	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {

        if (this.getOwnerName() == null)
        {
            par1NBTTagCompound.setString("Owner", "");
        }
        else
        {
            par1NBTTagCompound.setString("Owner", this.getOwnerName());
        }

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        String s = par1NBTTagCompound.getString("Owner");

        if (s.length() > 0)
        {
            this.setOwner(s);
        }
    }
    
    public void setOwner(String par1Str)
    {
        this.dataWatcher.updateObject(17, par1Str);
    }
    
    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if (!this.worldObj.isRemote)
        {
        }
    }
    
    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
    }

	@Override
	public String getOwnerName() {
		return null;
	}

	@Override
	public Entity getOwner() {
		return null;
	}
}
