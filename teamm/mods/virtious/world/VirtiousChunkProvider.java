package teamm.mods.virtious.world;

import java.util.List;
import java.util.Random;

import teamm.mods.virtious.block.VirtiousBlock;
import teamm.mods.virtious.lib.VirtiousBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.Event.*;
import net.minecraftforge.event.terraingen.*;

public class VirtiousChunkProvider extends ChunkProviderGenerate
{

	public VirtiousChunkProvider(World par1World, long par2, boolean par4) {
		super(par1World, par2, par4);
	}
   
}
