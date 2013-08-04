package teamm.mods.virtious.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.world.gen.VirtiousGenAmberTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockSaplingAmber extends VirtiousFlower
{
    public static final String[] WOOD_TYPES = new String[] {"amber"};
    private static final String[] field_94370_b = new String[] {"sapling_amber"};

    public BlockSaplingAmber(int par1)
    {
        super(par1);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(Virtious.tabVirtiousBlocks);
    }
    
    @Override
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int par2, int par3, int par4, Random par5Random)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, par2, par3, par4, par5Random);

            if (world.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                this.markOrGrowMarked(world, par2, par3, par4, par5Random);
            }
        }
    }

    public void markOrGrowMarked(World world, int par2, int par3, int par4, Random par5Random)
    {
        int l = world.getBlockMetadata(par2, par3, par4);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
        }
        else
        {
            this.growTree(world, par2, par3, par4, par5Random);
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree(World world, int i, int j, int k, Random rand)
    {
        if (!TerrainGen.saplingGrowTree(world, rand, i, j, k)) return;

        VirtiousGenAmberTree fostimber = new VirtiousGenAmberTree(VirtiousBlocks.leavesAmber.blockID, VirtiousBlocks.logAmber.blockID, true);
		
		fostimber.generate(world, rand, i, j, k);
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    public boolean isSameSapling(World world, int par2, int par3, int par4, int par5)
    {
        return world.getBlockId(par2, par3, par4) == this.blockID && (world.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }
}
