package minestrapteam.virtious.world;

import net.minecraft.util.ChunkCoordinates;

public class VirtiousPortalPosition extends ChunkCoordinates
{
    /** The worldtime at which this PortalPosition was last verified */
    public long lastUpdateTime;

    /** The teleporter to which this PortalPosition applies */
    final VirtiousTeleporter teleporterInstance;

    public VirtiousPortalPosition(VirtiousTeleporter par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.teleporterInstance = par1Teleporter;
        this.lastUpdateTime = par5;
    }
}
