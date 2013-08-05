package teamm.mods.virtious.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockCytoidLongWall extends VirtiousBlock
{
	private String direction;
	private Icon inside;
	private Icon otherInside;
	private Icon upper;
	private Icon lower;
	
	public BlockCytoidLongWall(int id, String direction) 
	{
		super(id, Material.iron);
		this.direction = direction;
	}
	
	public void registerIcons(IconRegister r)
	{
		inside = r.registerIcon("virtious:CytoidWallInside");
		otherInside = r.registerIcon("virtious:CytoidWall");
		upper = r.registerIcon("virtious:CytoidWallUpper");
		lower = r.registerIcon("virtious:CytoidWallLower");
	}
	
	public Icon getIcon(int side, int meta)
	{
		if(direction.equals("up"))
		{
			return side == 0 ? inside : side == 1 ? otherInside : upper; 
		}
		if(direction.equals("down"))
		{
			return side == 1 ? inside : side == 0 ? otherInside : lower; 
		}
		else
		{
			System.err.println("Virtious: Could not load wall textures do to mis-naming.");
		}
		return upper;
	}
}
