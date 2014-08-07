package minestrapteam.virtious.renderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.model.ModelNative;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNative extends RenderLiving
{
    private static final ResourceLocation TEXTURE_NATIVE = new ResourceLocation("virtious:textures/models/Native.png");
    private static final ResourceLocation TEXTURE_NATIVE_GLOW = new ResourceLocation("virtious:textures/models/Native_glow.png");
	private ModelNative nativeModel;

    public RenderNative(ModelBase modelBase, float size)
    {
        super(modelBase, size);
        this.nativeModel = (ModelNative)super.mainModel;
        this.setRenderPassModel(this.nativeModel);
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return TEXTURE_NATIVE;
    }
    
    /**
     * Render the endermans eyes
     */
    protected int renderGlowing(EntityNative entity, int par2, float par3)
    {
        if (par2 != 0)
        {
            return -1;
        }
        else
        {
            this.func_110776_a(TEXTURE_NATIVE_GLOW);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
//            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (entity.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }
    
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase entity, int par2, float par3)
    {
        return this.renderGlowing((EntityNative)entity, par2, par3);
    }
    
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderLiving((EntityNative)par1Entity, par2, par4, par6, par8, par9);
    }
    
    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderLiving((EntityNative)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }
}
