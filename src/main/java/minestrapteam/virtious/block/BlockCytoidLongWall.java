package minestrapteam.virtious.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCytoidLongWall extends VBlock
{
	private IIcon insideIcon;
	private IIcon upper;
	private IIcon lower;
	
	public BlockCytoidLongWall() 
	{
		super(Material.iron);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:cytoid_wall");
		this.insideIcon = iconRegister.registerIcon("virtious:cytoid_wall_inside");
		this.upper = iconRegister.registerIcon("virtious:cytoid_wall_upper");
		this.lower = iconRegister.registerIcon("virtious:cytoid_wall_lower");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(metadata == 0)
		{
			return side == 0 ? this.insideIcon : side == 1 ? this.blockIcon : this.upper; 
		}
		if(metadata == 1)
		{
			return side == 1 ? this.insideIcon : side == 0 ? this.blockIcon : this.lower; 
		}
		return this.blockIcon;
	}
}
