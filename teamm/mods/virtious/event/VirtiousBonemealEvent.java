package teamm.mods.virtious.event;

import java.util.Random;

import teamm.mods.virtious.block.BlockSaplingAmber;
import teamm.mods.virtious.block.BlockSaplingVirtian;
import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

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
	
	public void onRightClick(PlayerInteractEvent event){
		if(event.action == Action.RIGHT_CLICK_BLOCK){
			if(!event.isCanceled()){
				World world = event.entity.worldObj;
				if(world.getBlockId(event.x, event.y, event.z) == Block.field_111034_cE.blockID && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem() == new ItemStack(Item.flintAndSteel)){//coalBlock
					for(int i = -1; i <= 1; i++)
					{
						for(int j = -1; j <= 1; j++)
						{
							if(world.getBlockId(i, event.y + 1, j) == VirtiousBlocks.deepStoneMossy.blockID)//FIXME
								return;
							
							//PortalGenCode
						}
					}
				}
			}
		}
	}
}
