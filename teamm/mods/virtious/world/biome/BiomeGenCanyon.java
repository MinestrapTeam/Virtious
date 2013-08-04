package teamm.mods.virtious.world.biome;

import java.util.Random;

import teamm.mods.virtious.lib.VirtiousBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenCanyon extends BiomeGenBase 
{

	public BiomeGenCanyon(int par1) {
		super(par1);
		
		this.setMinMaxHeight(0.3F, 1.5F);
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
		this.topBlock = (byte) VirtiousBlocks.canyonstone.blockID;
		this.fillerBlock = (byte) VirtiousBlocks.canyonstone.blockID;
        
        this.setBiomeName("Canyon Biome");
        
        //TODO New biome decorator
        //this.theBiomeDecorator = new BiomeDecoratorVirtious(this);
    }
}
