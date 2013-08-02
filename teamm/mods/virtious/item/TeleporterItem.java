package teamm.mods.virtious.item;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.world.VirtiousTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeleporterItem extends VirtiousItem{

	public TeleporterItem(int id) {
		super(id);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
		
		if(player.isSneaking() && (player instanceof EntityPlayerMP)){
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			
			playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, Virtious.dimensionID,
					new VirtiousTeleporter(playermp.mcServer.worldServerForDimension(Virtious.dimensionID)));
		}
		
		return item;
	}
}
