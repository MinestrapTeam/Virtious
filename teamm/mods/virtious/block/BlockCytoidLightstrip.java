package teamm.mods.virtious.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockCytoidLightstrip extends VirtiousBlock
{
	private Icon topbottom;
	
	public BlockCytoidLightstrip(int id)
	{
		super(id, Material.iron);
	}
	
	public void registerIcons(IconRegister r)
	{
		blockIcon = r.registerIcon("virtious:CytoidLightstrip");
		topbottom = r.registerIcon("virtious:CytoidWall");
	}
	
	public Icon getIcon(int side, int meta)
	{
		return side == 0 ? topbottom : side == 1 ? topbottom : blockIcon;
	}
	
	
	
	@Override
	public boolean isOpaqueCube(){
		 return false;
	}
}
