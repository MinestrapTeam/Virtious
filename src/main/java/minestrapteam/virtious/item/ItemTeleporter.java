package minestrapteam.virtious.item;

import java.util.List;

import minestrapteam.virtious.lib.VWorld;
import minestrapteam.virtious.world.VirtiousTeleporter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemTeleporter extends Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && (player instanceof EntityPlayerMP))
		{
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			
			if (player.dimension == VWorld.dimensionID)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(0)));
			}
			else
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, VWorld.dimensionID, new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(VWorld.dimensionID)));
			}
		}
		
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.BLUE + "Too lazy to make a portal? Shift, then right click to insta-warp.");
	}
}
