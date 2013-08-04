package teamm.mods.virtious.world;

import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPortal extends TileEntity{

	int tick = 0;
	@Override
	public void updateEntity()
	{			
		if(!this.worldObj.isRemote)System.out.println("poartl tileentity tick");

		if(tick % 10 == 0)
		{
			if(!canStay())
			{
				this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, 0);
			}
		}
		tick++;

	}
	
	public boolean canStay(){
		for(int x = -1; x <= 1; x++)
		{
			for(int z = -1; z <= 1; z++)
			{
				if(this.worldObj.getBlockId(this.xCoord + x, this.yCoord - 1, this.zCoord + z) != VirtiousBlocks.blockIlluminous.blockID)
					return false;
			}
		}
		return true;
	}
}
