package teamm.mods.virtious.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import teamm.mods.virtious.Config;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.block.BlockVirtianGrass;
import teamm.mods.virtious.block.DeepStone;
import teamm.mods.virtious.block.PortalBlock;
import teamm.mods.virtious.block.VirtiousBlock;

public class VirtiousBlocks 
{
	public static Block deepStone;
	public static Block portalBlock;
	public static Block virtianstone;
	public static Block virtiancobblestone;
	public static Block virtianGrass;
	public static Block virtianSoil;
	public static Block deepStoneMossy;
	public static Block oreVIron;
	public static Block oreTak;
	public static Block oreBrazeum;
	public static Block oreAquieus;
	
	/**
	 * Loads all block objects
	 */
	public VirtiousBlocks()
	{
		Property idDeedStone = Virtious.config.getTerrainBlock("worldgen", "idDeepStone", Config.idDeedStone, null);
		int deepStoneID = idDeedStone.getInt();
		deepStone = new DeepStone(deepStoneID, Material.rock).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("DeepStone");
		registerBlock(deepStone, "Deep Stone");
		
//		Property idPortalBlock = Virtious.config.getBlock("idPortalBlock", Config.idPortal);
//		int portalBlockID = idPortalBlock.getInt();
//		portalBlock = new PortalBlock(portalBlockID).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("vPortal");
//		registerBlock(portalBlock, "Portal");
		
		Property idVirtianstone = Virtious.config.getTerrainBlock("worldgen", "Virtianstone Id", Config.idVirtianstone, null);
		int virtianstoneID = idVirtianstone.getInt();
		virtianstone = new VirtiousBlock(virtianstoneID, Material.rock).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Virtianstone");
		registerBlock(virtianstone, "Virtianstone");
		
		Property idVirtiancobblestone = Virtious.config.getBlock("Virtian Cobblestone Id", Config.idvirtiancobblestone);
		int virtiancobblestoneId = idVirtiancobblestone.getInt();
		virtiancobblestone = new VirtiousBlock(virtiancobblestoneId, Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CobbledVirtianstone");
		registerBlock(virtiancobblestone, "Virtian Cobblestone");
		
		Property idVirtianGrass = Virtious.config.getTerrainBlock("worldgen", "Virtian Grass ID", Config.idVirtianGrass, null);
		int virtianGrassId = idVirtianGrass.getInt();
		virtianGrass = new BlockVirtianGrass(virtianGrassId).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("virtianGrass");
		registerBlock(virtianGrass, "Virtian Grass");
		
		Property idVirtianSoil = Virtious.config.getTerrainBlock("worldgen", "Virtian Soil ID", Config.idVirtianSoil, null);
		int virtianSoilId = idVirtianSoil.getInt();
		virtianSoil = new VirtiousBlock(virtianSoilId, Material.ground).setHardness(0.6F).setUnlocalizedName("VirtianSoil").setStepSound(Block.soundGravelFootstep);
		registerBlock(virtianSoil, "Virtian Soil");
		
		Property iddeepStoneMossy = Virtious.config.getTerrainBlock("worldgen", "Mossy Deep Stone ID", Config.iddeepStoneMossy, null);
		int deepStoneMossyId = iddeepStoneMossy.getInt();
		deepStoneMossy = new VirtiousBlock(deepStoneMossyId, Material.rock).setHardness(5.0F).setUnlocalizedName("MossyDeepStone");
		registerBlock(deepStoneMossy, "Mossy Deep Stone");
		
		Property idoreVIron = Virtious.config.getBlock("Virtian Iron Ore ID", Config.idoreVIron);
		int oreVIronId = idoreVIron.getInt();
		oreVIron = new VirtiousBlock(oreVIronId, Material.rock).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VirtianIronOre");
		registerBlock(oreVIron, "Virtian Iron Ore");
		
		Property idoreTak = Virtious.config.getBlock("Tak Ore Id", Config.idoreTak);
		int oreTakId = idoreTak.getInt();
		oreTak = new VirtiousBlock(oreTakId, Material.rock).setHardness(3.2F).setResistance(5.2F).setUnlocalizedName("TakOre");
		registerBlock(oreTak,"Tak Ore");
		
		Property idoreBrazeum = Virtious.config.getBlock("Brazeum Ore Id", Config.idoreBrazeum);
		int oreBrazeumId = idoreBrazeum.getInt();
		oreBrazeum = new VirtiousBlock(oreBrazeumId, Material.rock).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("BrazeumOre");
		registerBlock(oreBrazeum, "Brazeum Ore");
		
		Property idoreAquieus = Virtious.config.getBlock("Auieus Ore Id", Config.idoreAquieus);
		int oreAquieusId = idoreAquieus.getInt();
		oreAquieus = new VirtiousBlock(oreAquieusId, Material.rock).setHardness(4.0F).setResistance(6.0F).setUnlocalizedName("AquieusOre").setLightValue(0.4F);
		registerBlock(oreAquieus, "Aquieus Ore");
		
		MinecraftForge.setBlockHarvestLevel(oreTak, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreBrazeum, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(deepStone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(deepStoneMossy, "pickaxe", 2);
		
		//TODO add all block objects here
	}
	
	public void registerBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
}
