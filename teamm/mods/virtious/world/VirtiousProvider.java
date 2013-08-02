package teamm.mods.virtious.world;

import teamm.mods.virtious.Virtious;
import net.minecraft.world.WorldProvider;

public class VirtiousProvider extends WorldProvider {

	public VirtiousProvider(){
		this.worldChunkMgr = new VirtiousChunkManager();
		this.dimensionId = Virtious.dimensionID;
	}
	
	@Override
	public String getDimensionName() {
		return "Virtious";
	}

}
