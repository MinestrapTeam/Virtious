package teamm.mods.virtious.event;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import teamm.mods.virtious.block.BlockSaplingAmber;
import teamm.mods.virtious.block.BlockSaplingVirtian;
import teamm.mods.virtious.block.VeerCrops;
import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;

public class VirtiousEventHandler 
{
	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent event) 
	{
		if (event.ID == VirtiousBlocks.saplingAmber.blockID) 
		{
			if (!event.world.isRemote) 
			{
				((BlockSaplingAmber)VirtiousBlocks.saplingAmber).markOrGrowMarked(event.world, event.X, event.Y, event.Z, new Random());			
				event.setResult(Result.ALLOW);
			}            
		}
		
		if (event.ID == VirtiousBlocks.saplingVirtian.blockID) 
		{
			if (!event.world.isRemote) 
			{
				((BlockSaplingVirtian)VirtiousBlocks.saplingVirtian).markOrGrowMarked(event.world, event.X, event.Y, event.Z, new Random());			
				event.setResult(Result.ALLOW);
			}            
		}
		

		if (event.ID == VirtiousBlocks.plantVeer.blockID) 
		{
			if (!event.world.isRemote) 
			{
				((VeerCrops)VirtiousBlocks.plantVeer).fertilize(event.world, event.X, event.Y, event.Z);			
				event.setResult(Result.ALLOW);
			}            
		}
	}
	
	@ForgeSubscribe
	public void onBucketFill(FillBucketEvent event) {
		ItemStack result = attemptFill(event.world, event.target);

		if (result != null) {
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}

	private ItemStack attemptFill(World world, MovingObjectPosition target) {
		int id = world.getBlockId(target.blockX, target.blockY, target.blockZ);

		if (id == VirtiousBlocks.virtiousAcid.blockID) {
			if (world.getBlockMetadata(target.blockX, target.blockY, target.blockZ) == 0) {
				world.setBlock(target.blockX, target.blockY, target.blockZ, 0);

				return new ItemStack(VirtiousItems.bucketAcid);
			}
		}
		return null;
	}
}
