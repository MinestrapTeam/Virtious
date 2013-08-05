package teamm.mods.virtious.renderer;

import teamm.mods.virtious.entity.EntityBurfalaunt;
import teamm.mods.virtious.entity.EntityNative;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNative extends RenderLiving
{
    private static final ResourceLocation TEXTURE_NATIVE = new ResourceLocation("virtious:textures/models/Native.png");

    public RenderNative(ModelBase modelBase, float size)
    {
        super(modelBase, size);
    }

    protected ResourceLocation func_110832_a(EntityNative entityBurfalaunt)
    {
        return TEXTURE_NATIVE;
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return this.func_110832_a((EntityNative)entity);
    }
}
