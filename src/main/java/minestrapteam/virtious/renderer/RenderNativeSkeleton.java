package minestrapteam.virtious.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityNativeSkeleton;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNativeSkeleton extends RenderLiving
{
    private static final ResourceLocation TEXTURE_NATIVE_SKELETON = new ResourceLocation("virtious:textures/models/NativeSkeleton.png");

    public RenderNativeSkeleton(ModelBase modelBase, float size)
    {
        super(modelBase, size);
    }

    protected ResourceLocation func_110832_a(EntityNativeSkeleton entityBurfalaunt)
    {
        return TEXTURE_NATIVE_SKELETON;
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return this.func_110832_a((EntityNativeSkeleton)entity);
    }
}
