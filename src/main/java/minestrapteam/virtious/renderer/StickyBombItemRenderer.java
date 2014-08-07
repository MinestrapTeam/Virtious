package minestrapteam.virtious.renderer;

import org.lwjgl.opengl.GL11;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.entity.item.EntityStickyBomb;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class StickyBombItemRenderer implements IItemRenderer {
    private static final ResourceLocation TEXTURE_STICKY_BOMB = new ResourceLocation("virtious", "textures/models/sticky_bomb.png");

	private static WavefrontObject model;
    public StickyBombItemRenderer()
    {
        model = new WavefrontObject("sticky_bomb.obj", Virtious.class.getResource("/assets/virtious/models/sticky_bomb.obj"));

    }
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		if(type == ItemRenderType.EQUIPPED)
			GL11.glTranslatef((float) 0.3F, (float) 0.5F, (float) 0F);
		if(type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			GL11.glTranslatef((float) .75, (float) .5F, (float) -.3);
		if(type == ItemRenderType.INVENTORY)
		{
			GL11.glDepthMask(false);
			GL11.glTranslatef(8F, 7.5F, 0F);
			GL11.glScalef(17F, 17F, 17F);
		}
			Minecraft.getMinecraft().renderEngine.func_110577_a(TEXTURE_STICKY_BOMB);
			model.renderAll();
		if(type == ItemRenderType.INVENTORY)
		{
			GL11.glDepthMask(true);
		}

		GL11.glPopMatrix();
	}
}
