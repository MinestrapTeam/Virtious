package teamm.mods.virtious.proxy;

import teamm.mods.virtious.entity.item.EntityStickyBomb;
import teamm.mods.virtious.renderer.RenderStickyBomb;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());
	}
}
