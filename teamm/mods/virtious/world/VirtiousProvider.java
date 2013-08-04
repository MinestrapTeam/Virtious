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
		this.worldChunkMgr = new VirtiousChunkManager();
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
	
	public Vec3 getFogColor(float par1, float par2)
    {
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.2F)
        {
            f2 = 0.2F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        
        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        //TODO Change these for sky colors
        f3 = 0.9F * f2;
        f4 = 0.75F * f2;
        f5 = 0.9F * f2;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
    }

    @Override
    public boolean doesXZShowFog(int par1, int par2)
    {
    	return false;
    }
	
}
