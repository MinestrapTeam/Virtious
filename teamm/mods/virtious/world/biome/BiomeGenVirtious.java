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

public class BiomeGenVirtious extends BiomeGenBase {

	public BiomeGenVirtious(int par1) {
		super(par1);
		
		this.maxHeight = 1F;
		this.minHeight = 0.1F;
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
		this.topBlock = (byte) VirtiousBlocks.virtianGrass.blockID;
		this.fillerBlock = (byte) VirtiousBlocks.virtianSoil.blockID;
        
        this.setBiomeName("Virtious biome");
        
        this.theBiomeDecorator = new BiomeDecoratorVirtious(this);
    }
}
