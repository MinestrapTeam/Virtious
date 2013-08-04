package teamm.mods.virtious.proxy;

import teamm.mods.virtious.entity.EntityBurfalaunt;
import teamm.mods.virtious.entity.item.EntityStickyBomb;
import teamm.mods.virtious.entity.item.EntityVirtiousFishHook;
import teamm.mods.virtious.model.ModelBurfalaunt;
import teamm.mods.virtious.renderer.RenderBurfalaunt;
import teamm.mods.virtious.renderer.RenderStickyBomb;
import teamm.mods.virtious.renderer.RenderVirtiousFish;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());
		RenderingRegistry.registerEntityRenderingHandler(EntityVirtiousFishHook.class, new RenderVirtiousFish());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBurfalaunt.class, new RenderBurfalaunt(new ModelBurfalaunt(), 1F));
	}
}
