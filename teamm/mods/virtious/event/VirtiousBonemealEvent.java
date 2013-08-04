package teamm.mods.virtious.event;

import java.util.Random;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import teamm.mods.virtious.block.BlockSaplingAmber;
import teamm.mods.virtious.block.BlockSaplingVirtian;
import teamm.mods.virtious.lib.VirtiousBlocks;

public class VirtiousBonemealEvent 
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
	}
}
