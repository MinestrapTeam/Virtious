package minestrapteam.virtious.world.biome;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.lib.VirtiousBlocks;

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
		
		this.maxHeight = .5F;
		this.minHeight = 0.1F;
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBurfalaunt.class,  12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityNative.class,  12, 4, 4));
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
		this.topBlock = (byte) VirtiousBlocks.virtianGrass.blockID;
		this.fillerBlock = (byte) VirtiousBlocks.virtianSoil.blockID;
        
        this.setBiomeName("Virtious biome");
        
        this.theBiomeDecorator = new BiomeDecoratorVirtious(this);
    }
}
