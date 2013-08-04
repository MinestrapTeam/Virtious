package teamm.mods.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLogAmber extends VirtiousBlock
{	
	@SideOnly(Side.CLIENT)
	private Icon iconTop;
	
	@SideOnly(Side.CLIENT)
	private Icon iconSide;
	
	public BlockLogAmber(int id)
	{
		super(id, Material.wood);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World world, int x, int y, int z, int par5, int meta)
	{
		byte distance = 2;
		int j1 = distance + 1;

		if (world.checkChunksExist(x - j1, y - j1, z - j1, x + j1, y + j1, z + j1))
		{
			for (int i = -distance; i <= distance; ++i)
			{
				for (int j = -distance; j <= distance; ++j)
				{
					for (int k = -distance; k <= distance; ++k)
					{
						int id = world.getBlockId(x + i, y + j, z + k);

						if (Block.blocksList[id] != null)
						{
							Block.blocksList[id].beginLeavesDecay(world, x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}
	
	@Override
	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	 */
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		int j1 = par9 & 3;
		byte b0 = 0;

		switch (par5)
		{
			case 0:
			case 1:
				b0 = 0;
				break;
			case 2:
			case 3:
				b0 = 8;
				break;
			case 4:
			case 5:
				b0 = 4;
		}

		return j1 | b0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.iconTop : (k == 4 && (par1 == 5 || par1 == 4) ? this.iconTop : (k == 8 && (par1 == 2 || par1 == 3) ? this.iconTop : this.iconSide));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconTop = par1IconRegister.registerIcon("virtious:AmberWoodTop");
		this.iconSide = par1IconRegister.registerIcon("virtious:AmberWoodSide");
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}
}
