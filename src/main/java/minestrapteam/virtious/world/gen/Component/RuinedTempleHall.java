package minestrapteam.virtious.world.gen.Component;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class RuinedTempleHall extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}
	public RuinedTempleHall() { }

	public boolean generate(World world, Random rand, int i, int j, int k) 
	{
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
		world.setBlock(i + 1, j + 0, k + 0, Block.stone.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.stone.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 3, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Block.stone.blockID);
		world.setBlock(i + 1, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Block.stone.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Block.stone.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.stone.blockID);
		world.setBlock(i + 2, j + 1, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 1, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 2, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 2, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 3, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 3, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Block.stone.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Block.stone.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.stone.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.stone.blockID);
		world.setBlock(i + 3, j + 1, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 1, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 2, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 3, k + 4, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 0, Block.stone.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 2, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 3, Block.stoneBrick.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Block.stone.blockID);
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