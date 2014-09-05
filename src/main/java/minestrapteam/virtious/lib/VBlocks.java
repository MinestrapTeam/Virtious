package minestrapteam.virtious.lib;

import clashsoft.cslib.minecraft.block.*;
import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.block.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.material.Material;

public class VBlocks
{
	public static Block				virtious_portal;
	
	public static Block				virtianstone;
	public static Block				virtianstone_cobbled;
	public static Block				virtianstone_bricks;
	public static Block				deepstone;
	public static Block				deepstone_mossy;
	public static Block				deepstone_bricks;
	public static Block				canyonstone;
	public static Block				canyonstone_bricks;
	
	public static Block				virtian_grass;
	public static Block				virtian_soil;
	public static Block				virtian_soil_tilled;
	public static Block				fine_gravel;
	
	public static Block				virtian_iron_ore;
	public static Block				tak_ore;
	public static Block				brazeum_ore;
	public static Block				aquieus_ore;
	public static Block				pluthorium_ore;
	public static Block				illuminous_ore;
	
	public static Block				deep_iron_ore;
	public static Block				deep_tak_ore;
	public static Block				deep_illuminous_ore;
	
	public static Block				tak_block;
	public static Block				brazeum_block;
	public static Block				aquieus_block;
	public static Block				pluthorium_block;
	public static Block				illuminous_block;
	
	public static Block				virtious_logs;
	public static Block				virtious_leaves;
	public static Block				virtious_saplings;
	public static Block				virtious_planks;
	
	public static Block				blue_torch;
	public static Block				green_torch;
	
	public static Block				virtious_flowers;
	public static Block				veer_plant;
	
	public static Block				virtious_acid;
	
	public static Block				fuel_cell;
	public static Block				rough_glass;
	
	public static Block				cytoid_wall;
	public static Block				cytoid_wall_dark;
	public static BlockCustomSlab	cytoid_floor;
	public static BlockCustomSlab	cytoid_floor_double;
	
	public static Block				cytoid_glass;
	public static Block				cytoid_door;
	public static Block				cytoid_control_panel;
	public static BlockCustomLamp				cytoid_lamp_off;
	public static BlockCustomLamp				cytoid_lamp_on;
	public static Block				cytoid_lightstrip;
	
	public static void init()
	{
		virtious_portal = new BlockVirtiousPortal("virtious_portal", null).setHardness(5.0F).setStepSound(Block.soundTypeStone);
		
		virtianstone = new VBlock(Material.rock).setHardness(1.5F).setStepSound(Block.soundTypeStone);
		virtianstone_cobbled = new VBlock(Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
		virtianstone_bricks = new VBlock(Material.rock).setHardness(3.0F);
		
		deepstone = new VBlock(Material.rock).setHardness(5.0F).setStepSound(Block.soundTypeStone);
		deepstone_mossy = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F);
		deepstone_bricks = new VBlock(Material.rock).setHardness(5.0F);
		
		canyonstone = new VBlock(Material.rock).setHardness(2.0F).setResistance(0.3F);
		canyonstone_bricks = new VBlock(Material.rock).setHardness(3.0F);
		
		virtian_grass = new BlockCustomGrass("virtiangrass", "virtious:mossy_soil").setHardness(0.6F).setStepSound(Block.soundTypeGrass);
		virtian_soil = new VBlock(Material.ground).setHardness(0.6F).setStepSound(Block.soundTypeGravel);
		virtian_soil_tilled = new BlockCustomFarmland(virtian_soil).setHardness(0.6F).setStepSound(Block.soundTypeGravel);
		fine_gravel = new BlockGravel().setHardness(0.6F).setStepSound(Block.soundTypeGravel);
		
		virtian_iron_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F);
		tak_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.2F).setResistance(5.2F);
		brazeum_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setResistance(5.0F);
		aquieus_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(4.0F).setResistance(6.0F);
		pluthorium_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(4.0F).setResistance(6.0F);
		illuminous_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(3.0F).setLightLevel(0.8F);
		
		deep_iron_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.5F).setResistance(8.5F);
		deep_tak_ore = new BlockTakOre(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F).setResistance(0.8F);
		deep_illuminous_ore = new VBlock(Material.rock).setStepSound(Block.soundTypeStone).setHardness(5.0F).setResistance(8.0F).setLightLevel(0.8F);
		
		tak_block = new BlockTakOre(Material.rock).setHardness(5.0F).setStepSound(Block.soundTypeStone);
		brazeum_block = new VBlock(Material.iron).setHardness(3.0F);
		aquieus_block = new VBlock(Material.iron).setHardness(3.0F);
		pluthorium_block = new VBlock(Material.iron).setHardness(3.0F);
		illuminous_block = new VBlock(Material.rock).setHardness(3.0F).setLightLevel(1.0F);
		
		String[] woodTypes = new String[] { "virtianwood", "amberwood" };
		virtious_logs = new BlockCustomLog(woodTypes, new String[] { "virtious:virtianwood_log_top", "virtious:amberwood_log_top" }, new String[] { "virtious:virtianwood_log_side", "virtious:amberwood_log_side" }).setHardness(2.0F).setStepSound(Block.soundTypeWood);
		virtious_leaves = new BlockCustomLeaves(woodTypes, new String[] { "virtious:virtianwood_leaves", "virtious:amberwood_leaves" }).setHardness(0.2F).setStepSound(Block.soundTypeGrass);
		virtious_saplings = new BlockVirtiousSapling(woodTypes, new String[] { "virtious:virtianwood_sapling", "virtious:amberwood_sapling" }).setStepSound(Block.soundTypeGrass);
		virtious_planks = new CustomBlock(Material.wood, woodTypes, new String[] { "virtious:virtianwood_planks", "virtious:amberwood_planks" }, null).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		
		blue_torch = new VBlockTorch().setHardness(0.0F).setLightLevel(0.85F).setStepSound(Block.soundTypeWood);
		green_torch = new VBlockTorch().setHardness(0.0F).setLightLevel(0.8F).setStepSound(Block.soundTypeWood);
		
		virtious_flowers = new BlockVirtiousFlowers(new String[] { "veer_flower", "nightwhisker", "blue_mushroom", "green_mushroom" }, new String[] { "virtious:veer_flower", "virtious:nightwhisker", "virtious:blue_mushroom", "virtious:green_mushroom" }).setStepSound(Block.soundTypeGrass).setLightLevel(0.4F);
		veer_plant = new BlockCustomCrops(6);
		
		virtious_acid = new BlockVirtiousAcid().setHardness(100.0F).setLightOpacity(3);
		
		fuel_cell = new BlockFuelCell(Material.rock).setHardness(3.0F);
		rough_glass = new BlockGlass(Material.glass, true).setStepSound(Block.soundTypeGlass);
		
		cytoid_wall = new VBlock(Material.rock).setStepSound(Block.soundTypeStone);
		cytoid_wall_dark = new VBlock(Material.iron).setHardness(3.0F).setResistance(8.0F);
		cytoid_floor = (BlockCustomSlab) new BlockCytoidFloor(false).setHardness(1.8F).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_floor_double = (BlockCustomSlab) new BlockCytoidFloor(true).setHardness(1.8F);
		BlockCustomSlab.bind(cytoid_floor, cytoid_floor_double);
		
		cytoid_glass = new BlockGlass(Material.glass, false).setStepSound(Block.soundTypeGlass);
		cytoid_door = new BlockCytoidDoor(Material.iron).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName("virtious:cytoid_door");
		cytoid_control_panel = new BlockCytoidControlPanel().setCreativeTab(Virtious.tabVirtiousBlocks).setHardness(3.0F);
		
		cytoid_lamp_off = (BlockCustomLamp) new BlockCytoidLamp(false).setCreativeTab(Virtious.tabVirtiousBlocks);
		cytoid_lamp_on = (BlockCustomLamp) new BlockCytoidLamp(true).setLightLevel(0.8F);
		BlockCustomLamp.bind(cytoid_lamp_off, cytoid_lamp_on);
		cytoid_lightstrip = new BlockCytoidLightstrip();
		
		tak_ore.setHarvestLevel("pickaxe", 1);
		brazeum_ore.setHarvestLevel("pickaxe", 1);
		deepstone.setHarvestLevel("pickaxe", 2);
		deepstone_mossy.setHarvestLevel("pickaxe", 2);
		pluthorium_ore.setHarvestLevel("pickaxe", 3);
		deep_illuminous_ore.setHarvestLevel("pickaxe", 2);
		deep_iron_ore.setHarvestLevel("pickaxe", 2);
		deep_tak_ore.setHarvestLevel("pickaxe", 2);
	}
	
	public static void load()
	{
		CSBlocks.addBlock(virtious_portal, "virtious_portal");
		
		CSBlocks.addBlock(virtianstone, "virtianstone");
		CSBlocks.addBlock(virtianstone_cobbled, "virtianstone_cobbled");
		CSBlocks.addBlock(virtianstone_bricks, "virtianstone_bricks");
		CSBlocks.addBlock(deepstone, "deepstone");
		CSBlocks.addBlock(deepstone_mossy, "deepstone_mossy");
		CSBlocks.addBlock(deepstone_bricks, "deepstone_bricks");
		CSBlocks.addBlock(canyonstone, "canyonstone");
		CSBlocks.addBlock(canyonstone_bricks, "canyonstone_bricks");
		
		CSBlocks.addBlock(virtian_grass, "virtian_grass");
		CSBlocks.addBlock(virtian_soil, "virtian_soil");
		CSBlocks.addBlock(virtian_soil_tilled, "virtian_soil_tilled");
		CSBlocks.addBlock(fine_gravel, "fine_gravel");
		
		CSBlocks.addBlock(virtian_iron_ore, "virtian_iron_ore");
		CSBlocks.addBlock(tak_ore, "tak_ore");
		CSBlocks.addBlock(brazeum_ore, "brazeum_ore");
		CSBlocks.addBlock(aquieus_ore, "aquieus_ore");
		CSBlocks.addBlock(pluthorium_ore, "pluthorium_ore");
		CSBlocks.addBlock(illuminous_ore, "illuminous_ore");
		
		CSBlocks.addBlock(deep_iron_ore, "deep_iron_ore");
		CSBlocks.addBlock(deep_tak_ore, "deep_tak_ore");
		CSBlocks.addBlock(deep_illuminous_ore, "deep_illuminous_ore");
		
		CSBlocks.addBlock(tak_block, "tak_block");
		CSBlocks.addBlock(brazeum_block, "brazeum_block");
		CSBlocks.addBlock(aquieus_block, "aquieus_block");
		CSBlocks.addBlock(pluthorium_block, "pluthorium_block");
		CSBlocks.addBlock(illuminous_block, "illuminous_block");
		
		CSBlocks.addBlock(virtious_logs, "virtious_logs");
		CSBlocks.addBlock(virtious_leaves, "virtious_leaves");
		CSBlocks.addBlock(virtious_saplings, "virtious_saplings");
		CSBlocks.addBlock(virtious_planks, "virtious_planks");
		
		CSBlocks.addBlock(blue_torch, "blue_torch");
		CSBlocks.addBlock(green_torch, "green_torch");
		
		CSBlocks.addBlock(virtious_flowers, "virtious_flowers");
		CSBlocks.addBlock(veer_plant, "veer_plant");
		
		CSBlocks.addBlock(virtious_acid, "virtious_acid");
		
		CSBlocks.addBlock(fuel_cell, "fuel_cell");
		CSBlocks.addBlock(rough_glass, "rough_glass");
		
		CSBlocks.addBlock(cytoid_wall, "cytoid_wall");
		CSBlocks.addBlock(cytoid_wall_dark, "cytoid_wall_dark");
		CSBlocks.addBlock(cytoid_floor, "cytoid_floor");
		CSBlocks.addBlock(cytoid_floor_double, "cytoid_floor_double");
		
		CSBlocks.addBlock(cytoid_glass, "cytoid_glass");
		CSBlocks.addBlock(cytoid_door, "cytoid_door");
		CSBlocks.addBlock(cytoid_control_panel, "cytoid_control_panel");
		CSBlocks.addBlock(cytoid_lamp_off, "cytoid_lamp_off");
		CSBlocks.addBlock(cytoid_lamp_on, "cytoid_lamp_on");
		CSBlocks.addBlock(cytoid_lightstrip, "cytoid_lightstrip");
	}
}
