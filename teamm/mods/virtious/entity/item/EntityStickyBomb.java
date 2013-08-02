package teamm.mods.virtious.entity.item;

import teamm.mods.virtious.network.StickyBombPacket;
import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityStickyBomb extends Entity/* implements EntityOwnable*/{

	private String Owner;

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
        this.motionY -= 0.04D;

        if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == Material.lava)
        {
            this.motionY = 0.20000000298023224D;
            this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        }

        this.pushOutOfBlocks(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0D, this.posZ);
        double d0 = 8.0D;


        this.moveEntity(this.motionX, this.motionY, this.motionZ);
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
            this.motionY *= -0.8999999761581421D;
        }

//        if (this.xpOrbAge >= 6000)
//        {
//            this.setDead();
//        }
    }
    
    /**
     * Will deal the specified amount of damage to the entity if the entity isn't immune to fire damage. Args:
     * amountDamage
     */
    protected void dealFireDamage(int par1)
    {
        this.attackEntityFrom(DamageSource.inFire, (float)par1);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            this.setBeenAttacked();
            
            //blow up
            this.setDead();

            return false;
        }
    }
    
    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (!this.worldObj.isRemote)
        {
        	player.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1.0F, true);
        	this.setDead();
        }
    }
    
    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
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
//		if(!worldObj.isRemote){
//			System.out.println("Sticky Bomb init");
//	        EntityTracker entitytracker = ((WorldServer)this.worldObj).getEntityTracker();
//	        entitytracker.addEntityToTracker(this, 165, 20, true);
//		}
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}
}
