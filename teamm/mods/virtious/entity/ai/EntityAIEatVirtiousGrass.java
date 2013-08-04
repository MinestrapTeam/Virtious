package teamm.mods.virtious.entity.ai;

import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAIEatVirtiousGrass extends EntityAIEatGrass{

	private EntityLiving theEntity;
    private World theWorld;
	

    /** A decrementing tick used for the sheep's head offset and animation. */
    int eatGrassTick;
    
	public EntityAIEatVirtiousGrass(EntityLiving entity) {
		super(entity);
		this.theEntity = entity;
        this.theWorld = entity.worldObj;
        this.setMutexBits(7);
	}
	
	/**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theEntity.getRNG().nextInt(this.theEntity.isChild() ? 50 : 1000) != 0)
        {
            return false;
        }
        else
        {
            int i = MathHelper.floor_double(this.theEntity.posX);
            int j = MathHelper.floor_double(this.theEntity.posY);
            int k = MathHelper.floor_double(this.theEntity.posZ);
            return this.theWorld.getBlockId(i, j, k) == VirtiousBlocks.blockNightwhisker.blockID && this.theWorld.getBlockMetadata(i, j, k) == 1 ? true : this.theWorld.getBlockId(i, j - 1, k) == VirtiousBlocks.virtianGrass.blockID;
        }
    }
	
	/**
     * Updates the task
     */
    public void updateTask()
    {
        this.eatGrassTick = Math.max(0, this.eatGrassTick - 1);

        if (this.eatGrassTick == 4)
        {
            int i = MathHelper.floor_double(this.theEntity.posX);
            int j = MathHelper.floor_double(this.theEntity.posY);
            int k = MathHelper.floor_double(this.theEntity.posZ);

            if (this.theWorld.getBlockId(i, j, k) == VirtiousBlocks.blockNightwhisker.blockID)
            {
                this.theWorld.destroyBlock(i, j, k, false);
                this.theEntity.eatGrassBonus();
            }
            else if (this.theWorld.getBlockId(i, j - 1, k) == VirtiousBlocks.virtianGrass.blockID)
            {
                this.theWorld.playAuxSFX(2001, i, j - 1, k, VirtiousBlocks.virtianGrass.blockID);
                this.theWorld.setBlock(i, j - 1, k, VirtiousBlocks.virtianSoil.blockID, 0, 2);
                this.theEntity.eatGrassBonus();
            }
        }
    }
}
