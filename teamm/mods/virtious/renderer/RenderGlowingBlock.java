package teamm.mods.virtious.renderer;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.block.BlockCytoidLightstrip;
import teamm.mods.virtious.block.VirtiousBlock;
import teamm.mods.virtious.lib.VirtiousBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderGlowingBlock extends BlockRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		
		drawSideBlockFaces(renderer, block, ((BlockCytoidLightstrip) block).icon[1], ((BlockCytoidLightstrip) block).icon[0]);
		drawSideBlockFaces(renderer, block, ((BlockCytoidLightstrip) block).icon[2], ((BlockCytoidLightstrip) block).icon[0]);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int bb = setBrightness(world, x, y, z, block);

		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);

		Tessellator t = Tessellator.instance;
//		t.setColorOpaque_I(thaumcraft.common.world.BlockCustomOreItem.colors[metadata]);
		t.setBrightness(160);

		renderSides(world, x, y, z, block, renderer, ((BlockCytoidLightstrip) block).icon[2], false);

		renderer.clearOverrideBlockTexture();
		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return 0;
	}
}
