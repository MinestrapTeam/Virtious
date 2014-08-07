/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package minestrapteam.virtious.world.gen.Component;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class RuinedTempleIntersectEmpty extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public RuinedTempleIntersectEmpty() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
//		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 4, j, k) || !LocationIsValidSpawn(world, i + 4, j, k + 4) || !LocationIsValidSpawn(world, i, j, k + 4))
//		{
//			return false;
//		}

		world.setBlock(i + 0, j + 0, k + 0, Block.stone.blockID);
		world.setBlock(i + 0, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Block.stone.blockID);
		world.setBlock(i + 0, j + 1, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 1, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 2, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 3, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 4, k + 0, Block.stone.blockID);
		world.setBlock(i + 0, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 0, j + 4, k + 4, Block.stone.blockID);
		world.setBlock(i + 1, j + 0, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Block.stone.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.stone.blockID);
		world.setBlock(i + 4, j + 1, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 3, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 4, k + 0, Block.stone.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Block.stone.blockID);

		return true;
	}
}