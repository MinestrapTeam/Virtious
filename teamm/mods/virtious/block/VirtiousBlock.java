package teamm.mods.virtious.block;

import teamm.mods.virtious.Virtious;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class VirtiousBlock extends Block
{
	public VirtiousBlock(int id, Material mat) 
	{
		super(id, mat);
		this.setCreativeTab(Virtious.tabVirtious);
	}
	
	public void registerIcons(IconRegister r)
	{
		this.blockIcon = r.registerIcon("virtious:" + this.getUnlocalizedName().substring(5));
	}
}
