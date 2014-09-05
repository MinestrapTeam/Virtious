package minestrapteam.virtious.block;

import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import minestrapteam.virtious.lib.VWorld;
import minestrapteam.virtious.world.VirtiousTeleporter;
import clashsoft.cslib.minecraft.block.BlockCustomPortal;

public class BlockVirtiousPortal extends BlockCustomPortal
{
	public BlockVirtiousPortal(String name, String iconName)
	{
		super(name, iconName, VWorld.dimensionID);
	}

	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new VirtiousTeleporter(world);
	}

	@Override
	public void spawnParticle(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ)
	{
	}
}
