package minestrapteam.virtious;

import clashsoft.cslib.minecraft.init.BaseMod;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.virtious.common.VCommonProxy;
import minestrapteam.virtious.common.VEventHandler;
import minestrapteam.virtious.common.VFuelHandler;
import minestrapteam.virtious.creativetab.TabVirtiousBlocks;
import minestrapteam.virtious.creativetab.TabVirtiousItems;
import minestrapteam.virtious.entity.EntityBurfalaunt;
import minestrapteam.virtious.entity.EntityLaser;
import minestrapteam.virtious.entity.EntityNative;
import minestrapteam.virtious.entity.EntityNativeSkeleton;
import minestrapteam.virtious.entity.item.EntityStickyBomb;
import minestrapteam.virtious.lib.VItems;
import minestrapteam.virtious.lib.VWorld;
import minestrapteam.virtious.world.gen.VirtiousWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(name = Virtious.MOD_NAME, modid = Virtious.MOD_ID, version = Virtious.VERSION)
public class Virtious extends BaseMod
{
	public static final String		MOD_ID				= "virtious";
	public static final String		MOD_NAME			= "Virtious";
	public static final String		VERSION				= "1.7.10-0.8.0";
	
	public static Fluid				virtiousFluid;
	
	@Instance(Virtious.MOD_ID)
	public static Virtious			instance;
	
	public static TabVirtiousBlocks	tabVirtiousBlocks	= new TabVirtiousBlocks(CreativeTabs.getNextID(), "Virtious Mod - Blocks");
	public static TabVirtiousItems	tabVirtiousItems	= new TabVirtiousItems(CreativeTabs.getNextID(), "Virtious Mod - Items");
	
	public static VCommonProxy		proxy				= createProxy("minestrapteam.virtious.client.VClientProxy", "minestrapteam.virtious.common.VCommonProxy");
	
	public Virtious()
	{
		super(proxy, MOD_ID, MOD_NAME, VERSION);
	}
	
	@Override
	public void readConfig()
	{
		VWorld.readConfig();
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		GameRegistry.registerWorldGenerator(new VirtiousWorldGenerator(), 0);
		
		virtiousFluid = new Fluid("Virtian Acid");
		FluidRegistry.registerFluid(virtiousFluid);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		FluidContainerRegistry.registerFluidContainer(virtiousFluid, new ItemStack(VItems.acid_bucket), new ItemStack(Items.bucket));
		
		MinecraftForge.EVENT_BUS.register(new VEventHandler());
		
		GameRegistry.registerFuelHandler(new VFuelHandler());
		
		EntityRegistry.registerModEntity(EntityStickyBomb.class, "StickyBomb", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityLaser.class, "entityLaser", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
		EntityRegistry.registerGlobalEntityID(EntityBurfalaunt.class, "Burfalaunt", EntityRegistry.findGlobalUniqueEntityId(), 0x110802, 0x3f1e06);
		EntityRegistry.registerGlobalEntityID(EntityNative.class, "NativeAlien", EntityRegistry.findGlobalUniqueEntityId(), 0x59563e, 0x2d3c21);
		EntityRegistry.registerGlobalEntityID(EntityNativeSkeleton.class, "NativeSkeleton", EntityRegistry.findGlobalUniqueEntityId(), 0x494949, 0xd8d8d8);
		EntityRegistry.registerModEntity(EntityFishHook.class, "EntityVirtiousFishHook", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
