package teamm.mods.virtious.item;

import java.util.Random;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.world.VirtiousTeleporter;
import teamm.mods.virtious.world.gen.VirtiousGenAmberTree;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityStickyBomb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeleporterItem extends VirtiousItem{

	public TeleporterItem(int id) {
		super(id);
	}
    
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i, int j, int k, int par7, float par8, float par9, float par10)
	{
		world.spawnEntityInWorld(new EntityStickyBomb(world, i, j, k));
		
//		VirtiousGenAmberTree gen = new VirtiousGenAmberTree();
//		gen.generate(world, new Random(), i, j, k);
		return true;
		
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
