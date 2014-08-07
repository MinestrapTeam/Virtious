package minestrapteam.virtious.proxy;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityLaser;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.entity.EntityNativeSkeleton;
import minestrapteam.virtious.entity.item.EntityStickyBomb;
import minestrapteam.virtious.entity.item.EntityVirtiousFishHook;
import minestrapteam.virtious.lib.VirtiousItems;
import minestrapteam.virtious.lib.VirtiousSound;
import minestrapteam.virtious.model.ModelBurfalaunt;
import minestrapteam.virtious.model.ModelNative;
import minestrapteam.virtious.renderer.*;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		Virtious.lightStripRendererID = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForge.EVENT_BUS.register(new VirtiousSound());
      
		RenderingRegistry.registerBlockHandler(Virtious.lightStripRendererID, new RenderGlowingBlock());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyBomb.class, new RenderStickyBomb());
		RenderingRegistry.registerEntityRenderingHandler(EntityVirtiousFishHook.class, new RenderVirtiousFish());
		
		MinecraftForgeClient.registerItemRenderer(VirtiousItems.itemStickyBomb.itemID, new StickyBombItemRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityBurfalaunt.class, new RenderBurfalaunt(new ModelBurfalaunt(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNative.class, new RenderNative(new ModelNative(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNativeSkeleton.class, new RenderNativeSkeleton(new ModelNative(), 1F));
	
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
	}
}
