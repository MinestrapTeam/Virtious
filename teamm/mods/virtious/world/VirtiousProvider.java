package teamm.mods.virtious.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.renderer.SkyRenderer;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class VirtiousProvider extends WorldProvider {

	public VirtiousProvider(){
		this.worldChunkMgr = new VirtiousChunkManager(Virtious.virtiousBiome, 1F, 0);
		this.dimensionId = Virtious.dimensionID;
	}
	
	@Override
	public void registerWorldChunkManager(){
		this.dimensionId = Virtious.dimensionID;
		this.hasNoSky = false;
		if(worldObj.isRemote)
		{
			this.setSkyRenderer(new SkyRenderer());
		}
	}
	
	@Override
	public IChunkProvider createChunkGenerator(){
		return new VirtiousChunkProvider(this.worldObj, this.getSeed(), true);//FIXME false
		
	}
	
	@Override
	public String getDimensionName() {
		return "Virtious";
	}
	
	
}
