package teamm.mods.virtious.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockVirtianGrass extends VirtiousBlock
{
	private Icon top;
	private Icon bottom;
	
	public BlockVirtianGrass(int id) 
	{
		super(id, Material.grass);
	}
	
	public void registerIcons(IconRegister r)
	{
		blockIcon = r.registerIcon("virtious:MossySoilSide");
		this.top = r.registerIcon("virtious:MossySoilTop");
		this.bottom = r.registerIcon("virtious:VirtianSoil");
	}
	
	public Icon getIcon(int i, int j)
	{
		return i == 1 ? top : i == 0 ? bottom : blockIcon;
	}
}
