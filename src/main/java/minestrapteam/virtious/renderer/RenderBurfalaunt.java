package minestrapteam.virtious.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityBurfalaunt;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBurfalaunt extends RenderLiving
{
    private static final ResourceLocation TEXTURE_BURFALAUNT = new ResourceLocation("virtious:textures/models/Burfalaunt.png");

    public RenderBurfalaunt(ModelBase modelBase, float size)
    {
        super(modelBase, size);
    }

    protected ResourceLocation func_110832_a(EntityBurfalaunt entityBurfalaunt)
    {
        return TEXTURE_BURFALAUNT;
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return this.func_110832_a((EntityBurfalaunt)entity);
    }
}
