package minestrapteam.virtious.block;

import minestrapteam.virtious.Virtious;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockCytoidLightstrip extends VirtiousBlock
{
	public Icon[] icon = new Icon[3];
	
	public BlockCytoidLightstrip(int id)
	{
		super(id, Material.iron);
	}
	
	public void registerIcons(IconRegister r)
	{
		icon[0] = r.registerIcon("virtious:CytoidWall");
		icon[1] = r.registerIcon("virtious:CytoidLightstrip");
		icon[2] = r.registerIcon("virtious:CytoidLightstrip_light");
		
	}
	
	public Icon getIcon(int side, int meta)
	{
		return side == 0 ? icon[0] : side == 1 ? icon[0] : icon[1];
	}
	
	@Override
	public int getRenderType(){
		return Virtious.lightStripRendererID;
	}
	
	@Override
	public boolean isOpaqueCube(){
		 return false;
	}
}
