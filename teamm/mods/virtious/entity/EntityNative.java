package teamm.mods.virtious.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.entity.ai.EntityAIEatVirtiousGrass;
import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityNative extends EntityAgeable implements INpc
{
	/**
     * Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each
     * tick.
     */
	/** the time between each jump of the slime */
    private int slimeJumpDelay;
    
	public EntityNative(World par1World)
    {
        super(par1World);
        
        this.slimeJumpDelay = this.rand.nextInt(20) + 10;

        this.setSize(0.5F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));this.tasks.addTask(1, new EntityAIMoveIndoors(this));
        this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(4, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(4, new EntityAIWatchClosest2(this, EntityNative.class, 5.0F, 0.02F));
        this.tasks.addTask(4, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }


    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    public float field_70813_a;
    public float field_70811_b;
    public float field_70812_c;
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
        this.field_70812_c = this.field_70811_b;
        boolean flag = this.onGround;
        super.onUpdate();
        int i;

        if (this.onGround && !flag)
        {

//            if (this.makesSoundOnLand())
//            {
//                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
//            }

            this.field_70813_a = -0.5F;
        }
        else if (!this.onGround && flag)
        {
            this.field_70813_a = 1.0F;
        }

        this.field_70813_a *= 0.6F;

        if (this.worldObj.isRemote)
        {
        }
    }
    protected void updateEntityActionState()
    {
        this.despawnEntity();
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        if (entityplayer != null)
        {
            this.faceEntity(entityplayer, 10.0F, 20.0F);
        }

        if (this.onGround && this.slimeJumpDelay-- <= 0)
        {
            this.slimeJumpDelay = this.getJumpDelay();

            if (entityplayer != null)
            {
                this.slimeJumpDelay /= 3;
            }

            this.isJumping = true;

//            if (this.makesSoundOnJump())
//            {
//                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
//            }

            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
            this.moveForward = 1F;
        }
        else
        {
            this.isJumping = false;

            if (this.onGround)
            {
                this.moveStrafing = this.moveForward = 0.0F;
            }
        }
    }
    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }


	/**
//     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
//     */
//    public boolean interact(EntityPlayer par1EntityPlayer)
//    {
//        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
//        boolean flag = itemstack != null && itemstack.itemID == Item.monsterPlacer.itemID;
//
//        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild())
//        {
//            if (!this.worldObj.isRemote)
//            {
//                this.setCustomer(par1EntityPlayer);
//                par1EntityPlayer.displayGUIMerchant(this, this.getCustomNameTag());
//            }
//
//            return true;
//        }
//        else
//        {
//            return super.interact(par1EntityPlayer);
//        }
//    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
    }

//    /**
//     * (abstract) Protected helper method to write subclass entity data to NBT.
//     */
//    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
//    {
//        super.writeEntityToNBT(par1NBTTagCompound);
//        par1NBTTagCompound.setInteger("Profession", this.getProfession());
//        par1NBTTagCompound.setInteger("Riches", this.wealth);
//
//        if (this.buyingList != null)
//        {
//            par1NBTTagCompound.setCompoundTag("Offers", this.buyingList.getRecipiesAsTags());
//        }
//    }
//
//    /**
//     * (abstract) Protected helper method to read subclass entity data from NBT.
//     */
//    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
//    {
//        super.readEntityFromNBT(par1NBTTagCompound);
//        this.setProfession(par1NBTTagCompound.getInteger("Profession"));
//        this.wealth = par1NBTTagCompound.getInteger("Riches");
//
//        if (par1NBTTagCompound.hasKey("Offers"))
//        {
//            NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
//            this.buyingList = new MerchantRecipeList(nbttagcompound1);
//        }
//    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }


    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.death";
    }


	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return null;
	}

//    public void setProfession(int par1)
//    {
//        this.dataWatcher.updateObject(16, Integer.valueOf(par1));
//    }
//
//    public int getProfession()
//    {
//        return this.dataWatcher.getWatchableObjectInt(16);
//    }
//
//    public boolean isMating()
//    {
//        return this.isMating;
//    }
//
//    public void setMating(boolean par1)
//    {
//        this.isMating = par1;
//    }
//
//    public void setPlaying(boolean par1)
//    {
//        this.isPlaying = par1;
//    }
//
//    public boolean isPlaying()
//    {
//        return this.isPlaying;
//    }

//    public void setRevengeTarget(EntityLivingBase par1EntityLivingBase)
//    {
//        super.setRevengeTarget(par1EntityLivingBase);
//
//        if (this.villageObj != null && par1EntityLivingBase != null)
//        {
//            this.villageObj.addOrRenewAgressor(par1EntityLivingBase);
//
//            if (par1EntityLivingBase instanceof EntityPlayer)
//            {
//                byte b0 = -1;
//
//                if (this.isChild())
//                {
//                    b0 = -3;
//                }
//
//                this.villageObj.setReputationForPlayer(((EntityPlayer)par1EntityLivingBase).getCommandSenderName(), b0);
//
//                if (this.isEntityAlive())
//                {
//                    this.worldObj.setEntityState(this, (byte)13);
//                }
//            }
//        }
//    }

    /**
     * Called when the mob's health reaches 0.
     */
//    public void onDeath(DamageSource par1DamageSource)
//    {
//        if (this.villageObj != null)
//        {
//            Entity entity = par1DamageSource.getEntity();
//
//            if (entity != null)
//            {
//                if (entity instanceof EntityPlayer)
//                {
//                    this.villageObj.setReputationForPlayer(((EntityPlayer)entity).getCommandSenderName(), -2);
//                }
//                else if (entity instanceof IMob)
//                {
//                    this.villageObj.endMatingSeason();
//                }
//            }
//            else if (entity == null)
//            {
//                EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0D);
//
//                if (entityplayer != null)
//                {
//                    this.villageObj.endMatingSeason();
//                }
//            }
//        }
//
//        super.onDeath(par1DamageSource);
//    }

//    public void setCustomer(EntityPlayer par1EntityPlayer)
//    {
//        this.buyingPlayer = par1EntityPlayer;
//    }
//
//    public EntityPlayer getCustomer()
//    {
//        return this.buyingPlayer;
//    }
//
//    public boolean isTrading()
//    {
//        return this.buyingPlayer != null;
//    }
//
//    public void useRecipe(MerchantRecipe par1MerchantRecipe)
//    {
//        par1MerchantRecipe.incrementToolUses();
//        this.livingSoundTime = -this.getTalkInterval();
//        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
//
//        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
//        {
//            this.timeUntilReset = 40;
//            this.needsInitilization = true;
//
//            if (this.buyingPlayer != null)
//            {
//                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
//            }
//            else
//            {
//                this.lastBuyingPlayer = null;
//            }
//        }
//
//        if (par1MerchantRecipe.getItemToBuy().itemID == Item.emerald.itemID)
//        {
//            this.wealth += par1MerchantRecipe.getItemToBuy().stackSize;
//        }
//    }
//
//    public void func_110297_a_(ItemStack par1ItemStack)
//    {
//        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20)
//        {
//            this.livingSoundTime = -this.getTalkInterval();
//
//            if (par1ItemStack != null)
//            {
//                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
//            }
//            else
//            {
//                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
//            }
//        }
//    }
//
//    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
//    {
//        if (this.buyingList == null)
//        {
//            this.addDefaultEquipmentAndRecipies(1);
//        }
//
//        return this.buyingList;
//    }
//
//    private float func_82188_j(float par1)
//    {
//        float f1 = par1 + this.field_82191_bN;
//        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
//    }
//
//    /**
//     * based on the villagers profession add items, equipment, and recipies adds par1 random items to the list of things
//     * that the villager wants to buy. (at most 1 of each wanted type is added)
//     */
//    private void addDefaultEquipmentAndRecipies(int par1)
//    {
//        if (this.buyingList != null)
//        {
//            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
//        }
//        else
//        {
//            this.field_82191_bN = 0.0F;
//        }
//
//        MerchantRecipeList merchantrecipelist;
//        merchantrecipelist = new MerchantRecipeList();
//        VillagerRegistry.manageVillagerTrades(merchantrecipelist, this, this.getProfession(), this.rand);
//        int j;
//        label50:
//
//        switch (this.getProfession())
//        {
//            case 0:
//                addMerchantItem(merchantrecipelist, Item.wheat.itemID, this.rand, this.func_82188_j(0.9F));
//                addMerchantItem(merchantrecipelist, Block.cloth.blockID, this.rand, this.func_82188_j(0.5F));
//                addMerchantItem(merchantrecipelist, Item.chickenRaw.itemID, this.rand, this.func_82188_j(0.5F));
//                addMerchantItem(merchantrecipelist, Item.fishCooked.itemID, this.rand, this.func_82188_j(0.4F));
//                addBlacksmithItem(merchantrecipelist, Item.bread.itemID, this.rand, this.func_82188_j(0.9F));
//                addBlacksmithItem(merchantrecipelist, Item.melon.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.appleRed.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.cookie.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.shears.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.flintAndSteel.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.chickenCooked.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.arrow.itemID, this.rand, this.func_82188_j(0.5F));
//
//                if (this.rand.nextFloat() < this.func_82188_j(0.5F))
//                {
//                    merchantrecipelist.add(new MerchantRecipe(new ItemStack(Block.gravel, 10), new ItemStack(Item.emerald), new ItemStack(Item.flint.itemID, 4 + this.rand.nextInt(2), 0)));
//                }
//
//                break;
//            case 1:
//                addMerchantItem(merchantrecipelist, Item.paper.itemID, this.rand, this.func_82188_j(0.8F));
//                addMerchantItem(merchantrecipelist, Item.book.itemID, this.rand, this.func_82188_j(0.8F));
//                addMerchantItem(merchantrecipelist, Item.writtenBook.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Block.bookShelf.blockID, this.rand, this.func_82188_j(0.8F));
//                addBlacksmithItem(merchantrecipelist, Block.glass.blockID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.compass.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.pocketSundial.itemID, this.rand, this.func_82188_j(0.2F));
//
//                if (this.rand.nextFloat() < this.func_82188_j(0.07F))
//                {
//                    Enchantment enchantment = Enchantment.enchantmentsBookList[this.rand.nextInt(Enchantment.enchantmentsBookList.length)];
//                    int k = MathHelper.getRandomIntegerInRange(this.rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
//                    ItemStack itemstack = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(enchantment, k));
//                    j = 2 + this.rand.nextInt(5 + k * 10) + 3 * k;
//                    merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.book), new ItemStack(Item.emerald, j), itemstack));
//                }
//
//                break;
//            case 2:
//                addBlacksmithItem(merchantrecipelist, Item.eyeOfEnder.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.expBottle.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.redstone.itemID, this.rand, this.func_82188_j(0.4F));
//                addBlacksmithItem(merchantrecipelist, Block.glowStone.blockID, this.rand, this.func_82188_j(0.3F));
//                int[] aint = new int[] {Item.swordIron.itemID, Item.swordDiamond.itemID, Item.plateIron.itemID, Item.plateDiamond.itemID, Item.axeIron.itemID, Item.axeDiamond.itemID, Item.pickaxeIron.itemID, Item.pickaxeDiamond.itemID};
//                int[] aint1 = aint;
//                int l = aint.length;
//                j = 0;
//
//                while (true)
//                {
//                    if (j >= l)
//                    {
//                        break label50;
//                    }
//
//                    int i1 = aint1[j];
//
//                    if (this.rand.nextFloat() < this.func_82188_j(0.05F))
//                    {
//                        merchantrecipelist.add(new MerchantRecipe(new ItemStack(i1, 1, 0), new ItemStack(Item.emerald, 2 + this.rand.nextInt(3), 0), EnchantmentHelper.addRandomEnchantment(this.rand, new ItemStack(i1, 1, 0), 5 + this.rand.nextInt(15))));
//                    }
//
//                    ++j;
//                }
//            case 3:
//                addMerchantItem(merchantrecipelist, Item.coal.itemID, this.rand, this.func_82188_j(0.7F));
//                addMerchantItem(merchantrecipelist, Item.ingotIron.itemID, this.rand, this.func_82188_j(0.5F));
//                addMerchantItem(merchantrecipelist, Item.ingotGold.itemID, this.rand, this.func_82188_j(0.5F));
//                addMerchantItem(merchantrecipelist, Item.diamond.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.swordIron.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.swordDiamond.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.axeIron.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.axeDiamond.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.pickaxeIron.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.pickaxeDiamond.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.shovelIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.shovelDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.hoeIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.hoeDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.bootsIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.bootsDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.helmetIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.helmetDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.plateIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.plateDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.legsIron.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.legsDiamond.itemID, this.rand, this.func_82188_j(0.2F));
//                addBlacksmithItem(merchantrecipelist, Item.bootsChain.itemID, this.rand, this.func_82188_j(0.1F));
//                addBlacksmithItem(merchantrecipelist, Item.helmetChain.itemID, this.rand, this.func_82188_j(0.1F));
//                addBlacksmithItem(merchantrecipelist, Item.plateChain.itemID, this.rand, this.func_82188_j(0.1F));
//                addBlacksmithItem(merchantrecipelist, Item.legsChain.itemID, this.rand, this.func_82188_j(0.1F));
//                break;
//            case 4:
//                addMerchantItem(merchantrecipelist, Item.coal.itemID, this.rand, this.func_82188_j(0.7F));
//                addMerchantItem(merchantrecipelist, Item.porkRaw.itemID, this.rand, this.func_82188_j(0.5F));
//                addMerchantItem(merchantrecipelist, Item.beefRaw.itemID, this.rand, this.func_82188_j(0.5F));
//                addBlacksmithItem(merchantrecipelist, Item.saddle.itemID, this.rand, this.func_82188_j(0.1F));
//                addBlacksmithItem(merchantrecipelist, Item.plateLeather.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.bootsLeather.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.helmetLeather.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.legsLeather.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.porkCooked.itemID, this.rand, this.func_82188_j(0.3F));
//                addBlacksmithItem(merchantrecipelist, Item.beefCooked.itemID, this.rand, this.func_82188_j(0.3F));
//        }
//
//        if (merchantrecipelist.isEmpty())
//        {
//            addMerchantItem(merchantrecipelist, Item.ingotGold.itemID, this.rand, 1.0F);
//        }
//
//        Collections.shuffle(merchantrecipelist);
//
//        if (this.buyingList == null)
//        {
//            this.buyingList = new MerchantRecipeList();
//        }
//
//        for (int j1 = 0; j1 < par1 && j1 < merchantrecipelist.size(); ++j1)
//        {
//            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(j1));
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void setRecipes(MerchantRecipeList par1MerchantRecipeList) {}
//
//    /**
//     * each recipie takes a random stack from villagerStockList and offers it for 1 emerald
//     */
//    public static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
//    {
//        if (par2Random.nextFloat() < par3)
//        {
//            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Item.emerald));
//        }
//    }
//
//    private static ItemStack getRandomSizedStack(int par0, Random par1Random)
//    {
//        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
//    }
//
//    /**
//     * default to 1, and villagerStockList contains a min/max amount for each index
//     */
//    private static int getRandomCountForItem(int par0, Random par1Random)
//    {
//        Tuple tuple = (Tuple)villagerStockList.get(Integer.valueOf(par0));
//        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
//    }
//
//    public static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
//    {
//        if (par2Random.nextFloat() < par3)
//        {
//            int j = getRandomCountForBlacksmithItem(par1, par2Random);
//            ItemStack itemstack;
//            ItemStack itemstack1;
//
//            if (j < 0)
//            {
//                itemstack = new ItemStack(Item.emerald.itemID, 1, 0);
//                itemstack1 = new ItemStack(par1, -j, 0);
//            }
//            else
//            {
//                itemstack = new ItemStack(Item.emerald.itemID, j, 0);
//                itemstack1 = new ItemStack(par1, 1, 0);
//            }
//
//            par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
//        }
//    }
//
//    private static int getRandomCountForBlacksmithItem(int par0, Random par1Random)
//    {
//        Tuple tuple = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));
//        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void handleHealthUpdate(byte par1)
//    {
//        if (par1 == 12)
//        {
//            this.generateRandomParticles("heart");
//        }
//        else if (par1 == 13)
//        {
//            this.generateRandomParticles("angryVillager");
//        }
//        else if (par1 == 14)
//        {
//            this.generateRandomParticles("happyVillager");
//        }
//        else
//        {
//            super.handleHealthUpdate(par1);
//        }
//    }
//
//    public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
//    {
//        par1EntityLivingData = super.func_110161_a(par1EntityLivingData);
//        VillagerRegistry.applyRandomTrade(this, worldObj.rand);
//        return par1EntityLivingData;
//    }
//
//    @SideOnly(Side.CLIENT)
//
//    /**
//     * par1 is the particleName
//     */
//    private void generateRandomParticles(String par1Str)
//    {
//        for (int i = 0; i < 5; ++i)
//        {
//            double d0 = this.rand.nextGaussian() * 0.02D;
//            double d1 = this.rand.nextGaussian() * 0.02D;
//            double d2 = this.rand.nextGaussian() * 0.02D;
//            this.worldObj.spawnParticle(par1Str, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
//        }
//    }
//
//    public void func_82187_q()
//    {
//        this.field_82190_bM = true;
//    }
//
//    public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable)
//    {
//        EntityVillager entityvillager = new EntityVillager(this.worldObj);
//        entityvillager.func_110161_a((EntityLivingData)null);
//        return entityvillager;
//    }
//
//    public boolean func_110164_bC()
//    {
//        return false;
//    }
//
//    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
//    {
//        return this.func_90012_b(par1EntityAgeable);
//    }
}
