package teamm.mods.virtious.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.IRenderHandler;

public class SkyRenderer extends IRenderHandler {

	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc) {

	}

}
