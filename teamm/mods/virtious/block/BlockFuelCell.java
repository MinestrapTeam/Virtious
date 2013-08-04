package teamm.mods.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFuelCell extends VirtiousBlock{

	@SideOnly(Side.CLIENT)
	private static Icon top;
	
	@SideOnly(Side.CLIENT)
	private static Icon bottom;
	
	public BlockFuelCell(int id, Material mat) {
		super(id, mat);
	}
	
	@Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float par7, float par8, float par9){
    	if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem() == new ItemStack(Item.flintAndSteel))//FIXME
    	{
    		
    	}
    	return false;
    }
	@Override
    public void registerIcons(IconRegister r)
	{
		this.top = r.registerIcon("virtious:FuelBlockTop");
		this.bottom = r.registerIcon("FuelBlockBottom");
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int meta)
    {
		if(side == 1)
			return this.top;
		if(side == 0)
			return this.bottom;
        return this.blockIcon;
    }
}
