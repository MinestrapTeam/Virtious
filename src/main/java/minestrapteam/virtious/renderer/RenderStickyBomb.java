package minestrapteam.virtious.renderer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.entity.item.EntityStickyBomb;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderStickyBomb extends Render
{
    private static final ResourceLocation TEXTURE_STICKY_BOMB = new ResourceLocation("virtious", "textures/models/sticky_bomb.png");
	private static WavefrontObject model;
    public RenderStickyBomb()
    {
        this.shadowSize = 0.15F;
        this.shadowOpaque = 0.75F;
        
        model = new WavefrontObject("sticky_bomb.obj", Virtious.class.getResource("/assets/virtious/models/sticky_bomb.obj"));

    }

    /**
     * Render
     */
    public void render(EntityStickyBomb bombEntity, double i, double j, double k)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)i, (float)j, (float)k);
        
        	Minecraft.getMinecraft().renderEngine.func_110577_a(TEXTURE_STICKY_BOMB);
        	model.renderAll();
        
        GL11.glPopMatrix();
    }


    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return TEXTURE_STICKY_BOMB;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity entity, double i, double j, double k, float par8, float par9)
    {
        this.render((EntityStickyBomb)entity, i, j, k);
    }
}
