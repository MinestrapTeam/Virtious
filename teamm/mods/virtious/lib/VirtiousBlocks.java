package teamm.mods.virtious.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
	public static Block virtianGrass;
	
	/**
	 * Loads all block objects
	 */
	public VirtiousBlocks()
	{
		Property idDeedStone = Virtious.config.getBlock("idDeepStone", Config.idDeedStone);
		int deepStoneID = idDeedStone.getInt();
		deepStone = new DeepStone(deepStoneID, Material.rock).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("DeepStone");
		registerBlock(deepStone, "Deep Stone");
		
		Property idPortalBlock = Virtious.config.getBlock("idPortalBlock", Config.idPortal);
		int portalBlockID = idPortalBlock.getInt();
		portalBlock = new PortalBlock(portalBlockID).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("vPortal");
		registerBlock(portalBlock, "Portal");
		
		Property idVirtianstone = Virtious.config.getBlock("Virtianstone Id", Config.idVirtianstone);
		int virtianstoneID = idVirtianstone.getInt();
		virtianstone = new VirtiousBlock(virtianstoneID, Material.rock).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Virtianstone");
		registerBlock(virtianstone, "Virtianstone");
		
		Property idVirtianGrass = Virtious.config.getBlock("Virtian Grass ID", Config.idVirtianGrass);
		int virtianGrassId = idVirtianGrass.getInt();
		virtianGrass = new BlockVirtianGrass(virtianGrassId).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("virtianGrass");
		registerBlock(virtianGrass, "Virtian Grass");
		
		//TODO add all block objects here
	}
	
	public void registerBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
}
