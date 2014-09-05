package minestrapteam.virtious.block;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomPlant;
import minestrapteam.virtious.lib.VItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVirtiousFlowers extends BlockCustomPlant
{
	public BlockVirtiousFlowers(String[] names, Object icons)
	{
		super(names, icons);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int par3)
	{
		return metadata == 0 ? VItems.veer_seed : null;
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		if (metadata == 0)
		{
			return random.nextInt(2) == 1 ? 1 : 0;
		}
		return 1;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float chance, int fortune)
	{
		super.dropBlockAsItemWithChance(world, x, y, z, metadata, chance, fortune);
		
		if (metadata == 0)
		{
			this.dropBlockAsItem(world, x, y, z, new ItemStack(VItems.veer_dye));
		}
	}
}
