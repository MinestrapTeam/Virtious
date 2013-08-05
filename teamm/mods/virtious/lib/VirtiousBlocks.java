package teamm.mods.virtious.lib;

import cpw.mods.fml.common.Mod.FingerprintWarning;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import teamm.mods.virtious.Config;
import teamm.mods.virtious.Virtious;
import teamm.mods.virtious.block.*;
import teamm.mods.virtious.world.VirtiousTeleporter;

public class VirtiousBlocks {
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
	public static Block orePluthorium;
	public static Block oreIlluminous;
	public static Block oreDeepTak;
	public static Block oreDeepIron;
	public static Block oreDeepIlluminous;
	public static Block blockTak;
	public static Block blockNightwhisker;
	public static Block logAmber;
	public static Block leavesAmber;
	public static Block saplingAmber;
	public static Block logVirtian;
	public static Block leavesVirtian;
	public static Block saplingVirtian;
	public static Block plankAmber;
	public static Block plankVirtian;
	public static Block canyonstone;
	public static Block virtiousAcid;
	public static Block blockBrazeum;
	public static Block blockAquieus;
	public static Block blockPluthorium;
	public static Block virtianstoneBricks;
	public static Block blockIlluminous;
	public static Block flowerVeer;
	public static Block deepstoneBricks;
	public static Block canyonstoneBricks;
	public static Block fuelCell;
	public static Block torchBlue;
	public static Block torchGreen;
	public static Block mushroomBlue;
	public static Block mushroomGreen;
	public static Block fineGravel;
	public static Block cytoidControlOff;
	public static Block cytoidControlOn;
	public static Block cytoidDoor;
	public static BlockHalfSlab cytoidFloorDouble;
	public static BlockHalfSlab cytoidFloor;
	public static Block cytoidGlass;
	public static Block cytoidLampIdle;
	public static Block cytoidLampOn;
	public static Block cytoidLightstrip;
	public static Block cytoidWall;
	public static Block tilledSoil;
	public static Block plantVeer;
	public static Block cytoidWallDark;
	public static Block cytoidWallDark2;
	public static Block cytoidWallDark3;
	public static Block cytoidWallDark4;
	public static Block roughGlass;
	public static Block reinforcedDeepstone;
	public static Block reinforcedStone;
	public static Block cytoidWallUpper;
	public static Block cytoidWallLower;
	
	/**
	 * Loads all block objects
	 */
	public VirtiousBlocks()
	{
		Property idDeepStone = Virtious.config.getTerrainBlock("worldgen", "idDeepStone", Config.idDeepStone, null);
		int deepStoneID = idDeepStone.getInt();
		deepStone = new DeepStone(deepStoneID, Material.rock).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("DeepStone");
		registerBlock(deepStone, "Deep Stone");
		
		Property idPortalBlock = Virtious.config.getBlock("idPortalBlock", Config.idPortal);
		int portalBlockID = idPortalBlock.getInt();
		portalBlock = new PortalBlock(portalBlockID).setHardness(5.0F).setStepSound(Block.soundStoneFootstep);
		registerBlock(portalBlock, "Portal");
		
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
		deepStoneMossy = new VirtiousBlock(deepStoneMossyId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(5.0F).setUnlocalizedName("MossyDeepStone");
		registerBlock(deepStoneMossy, "Mossy Deep Stone");
		
		Property idoreVIron = Virtious.config.getBlock("Virtian Iron Ore ID", Config.idoreVIron);
		int oreVIronId = idoreVIron.getInt();
		oreVIron = new VirtiousBlock(oreVIronId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VirtianIronOre");
		registerBlock(oreVIron, "Virtian Iron Ore");
		
		Property idoreTak = Virtious.config.getBlock("Tak Ore Id", Config.idoreTak);
		int oreTakId = idoreTak.getInt();
		oreTak = new VirtiousBlock(oreTakId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.2F).setResistance(5.2F).setUnlocalizedName("TakOre");
		registerBlock(oreTak,"Tak Ore");
		
		Property idoreBrazeum = Virtious.config.getBlock("Brazeum Ore Id", Config.idoreBrazeum);
		int oreBrazeumId = idoreBrazeum.getInt();
		oreBrazeum = new VirtiousBlock(oreBrazeumId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("BrazeumOre");
		registerBlock(oreBrazeum, "Brazeum Ore");
		
		Property idoreAquieus = Virtious.config.getBlock("Auieus Ore Id", Config.idoreAquieus);
		int oreAquieusId = idoreAquieus.getInt();
		oreAquieus = new VirtiousBlock(oreAquieusId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.0F).setResistance(6.0F).setUnlocalizedName("AquieusOre").setLightValue(0.4F);
		registerBlock(oreAquieus, "Aquieus Ore");
		
		Property idorePluthorium = Virtious.config.getBlock("Pluthorium Ore Id", Config.idorePluthorium);
		int orePluthoriumId = idorePluthorium.getInt();
		orePluthorium = new VirtiousBlock(orePluthoriumId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(4.0F).setResistance(6.0F).setUnlocalizedName("PluthoriumOre");
		registerBlock(orePluthorium, "Pluthorium Ore");
		
		Property idoreIlluminous = Virtious.config.getBlock("Illuminous Ore Id", Config.idoreIlluminous);
		int oreIlluminousId = idoreIlluminous.getInt();
		oreIlluminous = new VirtiousBlock(oreIlluminousId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(3.0F).setLightValue(0.8F).setUnlocalizedName("IlluminousOre");
		registerBlock(oreIlluminous, "Illuminous Ore");
		
		Property idoreDeepTak = Virtious.config.getBlock("Deep Tak Ore Id", Config.idoreDeepTak);
		int oreDeepTakId = idoreDeepTak.getInt();
		oreDeepTak = new BlockTakOre(oreDeepTakId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(5.0F).setResistance(0.8F).setUnlocalizedName("DeepTakOre");
		registerBlock(oreDeepTak, "Deep Tak Ore");
		
		Property idoreDeepIron = Virtious.config.getBlock("Deep Iron Ore Id", Config.idoreDeepIron);
		int oreDeepIronId = idoreDeepIron.getInt();
		oreDeepIron = new VirtiousBlock(oreDeepIronId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(5.5F).setResistance(8.5F).setUnlocalizedName("DeepIronOre");
		registerBlock(oreDeepIron, "Deep Iron Ore");
		
		Property idoreDeepIlluminous = Virtious.config.getBlock("Deep Illuminous Ore Id", Config.idoreDeepIlluminous);
		int oreDeepIlluminousId = idoreDeepIlluminous.getInt();
		oreDeepIlluminous = new VirtiousBlock(oreDeepIlluminousId, Material.rock).setStepSound(Block.soundStoneFootstep).setHardness(5.0F).setResistance(8.0F).setLightValue(0.8F).setUnlocalizedName("DeepIlluminousOre");
		registerBlock(oreDeepIlluminous,"Deep Illuminous Ore");
		
		Property idblockTak = Virtious.config.getBlock("Tak Block Id", Config.idblockTak);
		int blockTakId = idblockTak.getInt();
		blockTak = new BlockTakOre(blockTakId, Material.rock).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TakBlock");
		registerBlock(blockTak, "Tak Block");
		
		float f = 0.4F;
		Property idNightwhisker = Virtious.config.getBlock("Nightwhisker Block Id", Config.idblockNightwhisker);
		blockNightwhisker = new VirtiousFlower(idNightwhisker.getInt()).setLightValue(0.2F).setHardness(0.0F).setResistance(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("Nightwhisker");
		blockNightwhisker.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
		registerBlock(blockNightwhisker, "Nightwhisker");
		
		Property idlogAmber = Virtious.config.getBlock("Amber Log Id", Config.idlogAmber);
		logAmber = new BlockLogAmber(idlogAmber.getInt()).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("logAmber");
		registerBlock(logAmber, "Amber Log");
		
		Property idleavesAmber = Virtious.config.getBlock("Amber Leaves Id", Config.idleavesAmber);
		leavesAmber = new BlockLeavesAmber(idleavesAmber.getInt(), Material.leaves).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("leavesAmber").setLightValue(0.5F);
		registerBlock(leavesAmber, "Amber Leaves");
		
		Property idsaplingAmber = Virtious.config.getBlock("Amber Sapling Id", Config.idsaplingAmber);
		saplingAmber = new BlockSaplingAmber(idsaplingAmber.getInt()).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("AmberWoodSapling");
		registerBlock(saplingAmber, "Amber Sapling");
				
		Property idlogVirtian = Virtious.config.getBlock("Virtianwood Log Id", Config.idlogVirtian);
		logVirtian = new BlockLogVirtian(idlogVirtian.getInt(), Material.wood).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("logVirtian");
		registerBlock(logVirtian, "Virtian Log");
		
		Property idleavesVirtian = Virtious.config.getBlock("Virtian Leaves Id", Config.idleavesVirtian);
		leavesVirtian = new BlockLeavesVirtian(idleavesVirtian.getInt(), Material.leaves).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("leavesVirtian");
		registerBlock(leavesVirtian,"Virtian Leaves");
		
		Property idsaplingVirtian = Virtious.config.getBlock("Virtian Sapling ID", Config.idsaplingVirtian);
		saplingVirtian = new BlockSaplingVirtian(idsaplingVirtian.getInt()).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("VirtianwoodSapling");
		registerBlock(saplingVirtian, "Virtian Sapling");
		
		Property idplanksAmber = Virtious.config.getBlock("Amber Wood Planks Id", Config.idplankAmber);
		plankAmber = new VirtiousBlock(idplanksAmber.getInt(), Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("AmberWoodPlanks");
		registerBlock(plankAmber, "Amber Wood Planks");
		
		Property idplanksVirtian = Virtious.config.getBlock("Virtian Wood Planks Id", Config.idplankVirtian);
		plankVirtian = new VirtiousBlock(idplanksVirtian.getInt(), Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("VirtianWoodPlanks");
		registerBlock(plankVirtian, "Virtian Wood Planks");
		
		Property idcanyonstone = Virtious.config.getTerrainBlock("worldgen", "Canyonstone", Config.idcanyonstone, null);
		canyonstone = new VirtiousBlock(idcanyonstone.getInt(), Material.rock).setHardness(2.0F).setResistance(0.3F).setUnlocalizedName("Canyonstone");
		registerBlock(canyonstone, "Canyonstone");
		
		Property idvirtiousAcid = Virtious.config.getTerrainBlock("worldgen", "Virtious Acid Id", Config.idvirtiousAcid, null);
		virtiousAcid = new VirtiousAcid(idvirtiousAcid.getInt()).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("virtiousAcid");
		registerBlock(virtiousAcid, "Virtious Acid");	
		
		Property idblockBrazeum = Virtious.config.getBlock("Brazeum Block Id", Config.idblockBrazeum);
		blockBrazeum = new VirtiousBlock(idblockBrazeum.getInt(), Material.iron).setHardness(3.0F).setUnlocalizedName("BrazeumBlock");
		registerBlock(blockBrazeum, "Brazeum Block");
		
		Property idblockAquieus = Virtious.config.getBlock("Aquieus Block Id", Config.idblockAquieus);
		blockAquieus = new VirtiousBlock(idblockAquieus.getInt(), Material.iron).setHardness(3.0F).setUnlocalizedName("AquieusBlock");
		registerBlock(blockAquieus, "Aquieus Block");
		
		Property idblockPluthorium = Virtious.config.getBlock("Pluthorium Block Id", Config.idblockPluthorium);
		blockPluthorium = new VirtiousBlock(idblockPluthorium.getInt(), Material.iron).setHardness(3.0F).setUnlocalizedName("PluthoriumBlock");
		registerBlock(blockPluthorium, "Pluthorium Block");
		
		Property idvirtianstoneBricks = Virtious.config.getBlock("Virtianstone Bricks Id", Config.idblockvirtianstoneBricks);
		virtianstoneBricks = new VirtiousBlock(idvirtianstoneBricks.getInt(), Material.rock).setHardness(3.0F).setUnlocalizedName("VirtianstoneBricks");
		registerBlock(virtianstoneBricks, "Virtianstone Bricks");
		
		Property idblockIlluminous = Virtious.config.getBlock("Illuminous Block Id", Config.idblockIlluminous);
		blockIlluminous = new VirtiousBlock(idblockIlluminous.getInt(), Material.rock).setHardness(3.0F).setLightValue(1.0F).setUnlocalizedName("IlluminousBlock");
		registerBlock(blockIlluminous, "Illuminous Block");
		
		Property idflowerVeer = Virtious.config.getBlock("Veer Flower Id", Config.idflowerVeer);
		flowerVeer = new VeerFlower(idflowerVeer.getInt()).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setLightValue(0.4F).setUnlocalizedName("VeerFlower");
		registerBlock(flowerVeer, "Veer Flower");
		
		Property iddeepstoneBricks = Virtious.config.getBlock("Deepstone Bricks Id", Config.iddeepstoneBricks);
		deepstoneBricks = new VirtiousBlock(iddeepstoneBricks.getInt(),Material.rock).setHardness(5.0F).setUnlocalizedName("DeepstoneBricks");
		registerBlock(deepstoneBricks, "Deepstone Bricks");

		Property idcanyonstoneBricks = Virtious.config.getBlock("Canyonstone Bricks Id", Config.idcanyonstoneBricks);
		canyonstoneBricks = new VirtiousBlock(idcanyonstoneBricks.getInt(), Material.rock).setHardness(3.0F).setUnlocalizedName("CanyonstoneBricks");
		registerBlock(canyonstoneBricks, "Canyonstone Bricks");

		Property idFuelCell = Virtious.config.getBlock("Fuel Cell Id", Config.idFuelCell);
		fuelCell = new BlockFuelCell(idFuelCell.getInt(), Material.rock).setHardness(3.0F).setUnlocalizedName("FuelBlockSide");
		registerBlock(fuelCell, "Fuel Cell");

		Property idTorchBlue = Virtious.config.getBlock("Torch Blue Id", Config.idTorchBlue);
		torchBlue = new VirtiousTorchBlock(idTorchBlue.getInt()).setHardness(0.0F).setLightValue(0.85F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("BlueMushroomTorch");
		registerBlock(torchBlue, "Blue Mushroom Torch");
		
		Property idTorchGreen = Virtious.config.getBlock("Torch Green Id", Config.idTorchGreen);
		torchGreen = new VirtiousTorchBlock(idTorchGreen.getInt()).setHardness(0.0F).setLightValue(0.8F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("GreenMushroomTorch");
		registerBlock(torchGreen, "Green Mushroom Torch");

		Property idMushroomBlue = Virtious.config.getBlock("Mushroom Blue Id", Config.idMushroomBlue);
		mushroomBlue = new VirtiousFlower(idMushroomBlue.getInt()).setHardness(0.0F).setLightValue(0.75F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GlowingMushroomBlue");
		registerBlock(mushroomBlue, "Blue Mushroom");

		Property idMushroomGreen = Virtious.config.getBlock("Mushroom Green Id", Config.idMushroomGreen);
		mushroomGreen = new VirtiousFlower(idMushroomGreen.getInt()).setHardness(0.0F).setLightValue(0.7F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("GlowingMushroomGreen");
		registerBlock(mushroomGreen, "Green Mushroom");

		Property idFineGravel = Virtious.config.getBlock("Fine Gravel Id", Config.idFineGravel);
		fineGravel = new FineGravel(idFineGravel.getInt()).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("FineGravel");
		registerBlock(fineGravel, "Fine Gravel");
		
		Property idCytoidControlOff = Virtious.config.getBlock("Cytoid Control Panel Off", Config.idCytoidControlPanelOff);
		cytoidControlOff = new BlockCytoidControlPanelOff(idCytoidControlOff.getInt()).setCreativeTab(Virtious.tabVirtiousBlocks).setHardness(3.0F).setUnlocalizedName("cytoidControlOff");
		registerBlock(cytoidControlOff, "Cytoid Control Panel");
		
		Property idCytoidControlOn = Virtious.config.getBlock("Cytoid Control Panel On", Config.idCytoidControlPanelOn);
		cytoidControlOn = new BlockCytoidControlPanelOn(idCytoidControlOn.getInt()).setHardness(3.0F).setUnlocalizedName("cytoidControlOn");
		registerBlock(cytoidControlOn, "Cytoid Control Panel On");
		
		Property idCytoidDoor = Virtious.config.getBlock("Cytoid Door Id", Config.idCytoidDoor);
		cytoidDoor = new BlockCytoidDoor(idCytoidDoor.getInt(), Material.iron).setHardness(5.0F).setStepSound(Block.soundMetalFootstep).setBlockUnbreakable().setUnlocalizedName("doorCytoid");
		registerBlock(cytoidDoor, "Cytoid Door");
		
		Property idCytoidFloor = Virtious.config.getBlock("Cytoid Floor Id", Config.idCytoidFloor);
		cytoidFloor = (BlockHalfSlab)new BlockCytoidFloor(idCytoidFloor.getInt(), false).setCreativeTab(Virtious.tabVirtiousBlocks).setUnlocalizedName("cytoidFloor").setBlockUnbreakable();
		registerBlock(cytoidFloor, "Cytoid Floor");
		
		Property idCytoidFloorDouble = Virtious.config.getBlock("Cytoid Floor Double Id", Config.idCytoidFloorDouble);
		cytoidFloorDouble = (BlockHalfSlab)new BlockCytoidFloor(idCytoidFloorDouble.getInt(), true).setUnlocalizedName("cytoidFloorDouble").setBlockUnbreakable();
		registerBlock(cytoidFloorDouble, "Cytoid Floor Double");
		
		Property idCytoidGlass = Virtious.config.getBlock("Cytoid Glass Id", Config.idCytoidGlass);
		cytoidGlass = new VirtiousGlass(idCytoidGlass.getInt()).setUnlocalizedName("CytoidGlass").setBlockUnbreakable();
		registerBlock(cytoidGlass, "Cytoid Glass");
		
		Property idCytoidLampIdle = Virtious.config.getBlock("Cytoid Lamp Idle Id", Config.idCytoidLampIdle);
		cytoidLampIdle = new BlockCytoidLamp(idCytoidLampIdle.getInt(), false).setCreativeTab(Virtious.tabVirtiousBlocks).setBlockUnbreakable().setUnlocalizedName("CytoidLampOff").setStepSound(Block.soundGlassFootstep);
		registerBlock(cytoidLampIdle, "Cytoid Lamp");
		
		Property idCytoidLampOn = Virtious.config.getBlock("Cytoid Lamp On", Config.idCytoidLampOn);
		cytoidLampOn = new BlockCytoidLamp(idCytoidLampOn.getInt(), true).setBlockUnbreakable().setUnlocalizedName("CytoidLampOn").setStepSound(Block.soundGlassFootstep);
		registerBlock(cytoidLampOn, "Cytoid Lamp On");

		Property idCytoidLightstrip = Virtious.config.getBlock("Cytoid Lightstrip Id", Config.idCytoidLightstrip);
		cytoidLightstrip = new BlockCytoidLightstrip(idCytoidLightstrip.getInt()).setUnlocalizedName("cytoidLightstrip").setBlockUnbreakable();
		registerBlock(cytoidLightstrip, "Cytoid Lightstrip");
		
		Property idCytoidWall = Virtious.config.getBlock("Cytoid Wall Id", Config.idCytoidWall);
		cytoidWall = new VirtiousBlock(idCytoidWall.getInt(), Material.rock).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("CytoidWall").setBlockUnbreakable();
		registerBlock(cytoidWall, "Cytoid Wall");

		Property idTilledSoil = Virtious.config.getBlock("Tilled Soil Id", Config.idTilledSoil);
		tilledSoil = new VirtiousTilledBlock(idTilledSoil.getInt()).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("TilledVirtianSoil");
		registerBlock(tilledSoil, "Tilled Soil");
		
		Property idVeerPlant = Virtious.config.getBlock("Veer Plant Id", Config.idVeerPlant);
		plantVeer = new VeerCrops(idVeerPlant.getInt()).setUnlocalizedName("VeerCrop");
		registerBlock(plantVeer, "Veer Plant");

		Property idRoughGlass = Virtious.config.getBlock("Rough Glass Id", Config.idRoughGlass);
		roughGlass = new BlockRoughGlass(idRoughGlass.getInt(), Material.glass).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("RoughGlass");
		registerBlock(roughGlass, "Rough Glass");
		
		Property idCytoidWallDark = Virtious.config.getBlock("Dark Cytoid Wall", Config.idCytoidWallDark);
		cytoidWallDark = new VirtiousBlock(idCytoidWallDark.getInt(), Material.iron).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("CytoidWallDark1").setBlockUnbreakable();
		registerBlock(cytoidWallDark, "Dark Cytoid Wall");

		Property idReinforcedDeepstone = Virtious.config.getBlock("Reinforced Deepstone Id", Config.idReinforcedDeepstone);
		reinforcedDeepstone = new VirtiousBlock(idReinforcedDeepstone.getInt(), Material.rock).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ReinforcedDeepstone");
		registerBlock(reinforcedDeepstone, "Reinforced Deepstone");

		Property idReinforcedStone = Virtious.config.getBlock("Reinforced Stone Id", Config.idReinforcedStone);
		reinforcedStone = new VirtiousBlock(idReinforcedStone.getInt(), Material.rock).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("ReinforcedVirtianstone");
		registerBlock(reinforcedStone, "Reinforced Virtious Sone");
		
		Property idCytoidWallDark2 = Virtious.config.getBlock("Dark Cytoid Wall 2", Config.idCytoidWallDark2);
		cytoidWallDark2 = new VirtiousBlock(idCytoidWallDark2.getInt(), Material.iron).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("CytoidWallDark2").setBlockUnbreakable();
		registerBlock(cytoidWallDark2, "Dark Cytoid Wall 2");
		
		Property idCytoidWallDark3 = Virtious.config.getBlock("Dark Cytoid Wall 3", Config.idCytoidWallDark3);
		cytoidWallDark3 = new VirtiousBlock(idCytoidWallDark3.getInt(), Material.iron).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("CytoidWallDark3").setBlockUnbreakable();
		registerBlock(cytoidWallDark3, "Dark Cytoid Wall 3");
		
		Property idCytoidWallDark4 = Virtious.config.getBlock("Dark Cytoid Wall 4", Config.idCytoidWallDark4);
		cytoidWallDark4 = new VirtiousBlock(idCytoidWallDark4.getInt(), Material.iron).setHardness(3.0F).setResistance(8.0F).setUnlocalizedName("CytoidWallDark4").setBlockUnbreakable();
		registerBlock(cytoidWallDark4, "Dark Cytoid Wall 4");
		
		Property idCytoidWallUpper = Virtious.config.getBlock("Cytoid Wall Upper", Config.idCytoidWallUpper);
		cytoidWallUpper = new BlockCytoidLongWall(idCytoidWallUpper.getInt(), "up").setUnlocalizedName("cytoidWallUpper").setBlockUnbreakable();
		registerBlock(cytoidWallUpper, "Upper Cytoid Wall");
		
		Property idCytoidWallLower = Virtious.config.getBlock("Cytoid Wall Lower", Config.idCytoidWallLower);
		cytoidWallLower = new BlockCytoidLongWall(idCytoidWallLower.getInt(), "down").setUnlocalizedName("cytoidWallLower").setBlockUnbreakable();
		registerBlock(cytoidWallLower, "Lower Cytoid Wall");
			
		LanguageRegistry.instance().addStringLocalization("tile.cytoidFloor.cytoidfloor.name", "Cytoid Floor");
		
		MinecraftForge.setBlockHarvestLevel(oreTak, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreBrazeum, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(deepStone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(deepStoneMossy, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(orePluthorium, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreDeepIlluminous, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreDeepIron, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreDeepTak, "pickaxe", 2);
		
		//TODO add all block objects here
	}

	public void registerBlock(Block block, String name) 
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
}
