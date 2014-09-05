package minestrapteam.virtious.world;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import minestrapteam.virtious.client.renderer.VirtiousSkyRenderer;
import minestrapteam.virtious.lib.VWorld;

import net.minecraft.world.chunk.IChunkProvider;

public class VirtiousWorldProvider extends CustomWorldProvider
{
	public VirtiousWorldProvider()
	{
		super(VWorld.dimensionID);
		this.hasNoSky = false;
		
		if (this.worldObj.isRemote)
		{
			this.setSkyRenderer(new VirtiousSkyRenderer());
		}
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new VirtiousChunkManager(this.worldObj);
		
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new VirtiousChunkProvider(this.worldObj, this.getSeed(), true);
	}

	@Override
	public String getDimensionName()
	{
		return "Virtious";
	}
}
