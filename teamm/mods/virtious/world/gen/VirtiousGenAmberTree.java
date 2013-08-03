package teamm.mods.virtious.world.gen;

import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VirtiousGenAmberTree extends WorldGenerator
{
	int leavesId,logId;
	boolean fromSapling;

	public VirtiousGenAmberTree(int leavesId, int logId, boolean fromSapling)
	{
		super(fromSapling);
		this.leavesId = leavesId;
		this.logId = logId;
		this.fromSapling = fromSapling;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) 
	{
		//TODO Fix odd sapling growth
		//FIXME ^^
		int height = random.nextInt(4) + 5;
		int leavesStart = random.nextInt(2) + 4;
		
		int minTreeHeight = 8;
		
		int treeHeight = leavesStart + minTreeHeight;
		
		if(fromSapling)
		{
			for(int j1 = 1; j1 <= treeHeight; j1++)
			{
				if(!world.isAirBlock(i, j+j1, k))
				return false;
			}
		}
		
		for(int y = 1; y < height; y++)
		{
			world.setBlock(i, j + y, k, logId);

			if(y > leavesStart)
			{
				for(int x = -2; x <3; x++)
				{
					for(int z = -2; z <     3; z++)
					{			
						if(random.nextInt(2) == 1 && x != 0 && y != 0){//FIXME add check for override/ can leaves replace block
							world.setBlock(i + x, j + y, k + z, leavesId);
						}
					}
				}
			}
		}
		
		return true;
	}

}
