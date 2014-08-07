package minestrapteam.virtious.entity.item;

import cpw.mods.fml.common.network.PacketDispatcher;
import minestrapteam.virtious.network.StickyBombPacket;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class EntityStickyBomb extends Entity/* implements EntityOwnable*/{

	private String Owner;
	public boolean fuse = false;
	public int countdown = (int)(20 * 1.5);

	public EntityStickyBomb(World world) {
		super(world);
		this.setSize(.5F, .5F);
		
//		PacketDispatcher.;
		//                entitytracker.sendPacketToAllPlayersTrackingEntity(par1Entity, new Packet22Collect(par1Entity.entityId, this.entityId));

	}

	public EntityStickyBomb(World world, double i, double j, double k)
	{
	    super(world);
	    this.height = 1F;

	    this.setSize(0.5F, 0.5F);
	    this.yOffset = this.height / 2.0F;
	    this.setPosition(i, j, k);
	 }
	
	public EntityStickyBomb(World world, double i, double j, double k, EntityPlayer owner)
	{
	    super(world);
	    this.setSize(0.5F, 0.5F);
	    this.height = 1F;
//	    this.yOffset = this.height / 2.0F;
	    this.setPosition(i, j, k);
//	    this.setOwner(owner.getEntityName());
	 }
	
	/**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.noClip = this.pushOutOfBlocks(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0D, this.posZ);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        boolean flag = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;

        if (flag || this.ticksExisted % 25 == 0)
        {
            if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == Material.lava)
            {
                this.motionY = 0.20000000298023224D;
                this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
                this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            }
        }

        float f = 0.98F;

        if (this.onGround)
        {
            f = 0.58800006F;
            int i = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));

            if (i > 0)
            {
                f = Block.blocksList[i].slipperiness * 0.98F;
            }
        }

        this.motionX *= (double)f;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= (double)f;

        if (this.onGround)
        {
            this.motionY *= -0.5D;
        }

        if(this.fuse)
        {
//            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 1.0D, 0.0D);

        	if(countdown-- < 1)
        	{
        		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
            	this.setDead();
        	}
        }
    }
    

    /**
     * Called when the entity is attacked.
     */
//	public boolean attackEntityFrom(DamageSource damageSource, float strength) {
//		this.setBeenAttacked();
//		if (!this.isDead && !this.fuse) {
//			if (damageSource != DamageSource.setExplosionSource(par0Explosion)) {
//				this.worldObj.createExplosion(this, this.posX, this.posY,
//						this.posZ, 1.0F, true);
//				this.setDead();
//			}
//		}
//
//		return false;
//	}
    
    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer player)
    {
    	if(!player.capabilities.isCreativeMode)
    	{
    		this.fuse = true;
    		this.playSound("random.fuse", 1.0F, 0.5F);
    	}
    }
    
    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return true;
    }

//	public String getOwnerName()
//    {
//        return this.dataWatcher.getWatchableObjectString(17);
//    }
//	@Override
//	public Entity getOwner() {
//		return this.worldObj.getPlayerEntityByName(this.getOwnerName());
//	}
	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		this.countdown = nbttagcompound.getShort("Countdown");
		this.fuse = nbttagcompound.getBoolean("fuse");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setShort("Countdown", (short)this.countdown);
		nbttagcompound.setBoolean("fuse", this.fuse);

	}
}
