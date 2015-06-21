package bloods.common.dimenPizza;

import bloods.common.dimenPizza.handler.chestLootHandler;
import bloods.common.dimenPizza.handler.configHandler;
import bloods.common.dimenPizza.handler.eventHandler;
import bloods.common.dimenPizza.handler.recipeHandler;
import bloods.common.dimenPizza.init.BDPBlocksLoader;
import bloods.common.dimenPizza.init.BDPItemsLoader;
import bloods.common.dimenPizza.item.itemBloodArmor;
import bloods.common.dimenPizza.proxy.IProxy;
import bloods.common.dimenPizza.reference.Reference;
import bloods.common.dimenPizza.utility.logHelper;
import bloods.common.dimenPizza.enchants.icedBoots;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.Mod_ID, name = Reference.Mod_Name, version = Reference.Version, guiFactory = Reference.Gui_Factory)
public class Blooddp {
	
	@Mod.Instance(Reference.Mod_ID)
	public static Blooddp instance;
	
	@SidedProxy( clientSide = Reference.Client_Proxy, serverSide = Reference.Server_Proxy)
	public static IProxy proxy;

	public static ArmorMaterial BloodMat = EnumHelper.addArmorMaterial("BloodMat", 0, new int[] {2,0,8,2}, 0);
	public static Item fancyBoots;
	public static Item forgottenExo;
	public static Item platedWings;
	public static Item leafBand;

	public static ArmorMaterial BloodMat2 = EnumHelper.addArmorMaterial("BloodMat2", 40, new int[] {7,7,7,7}, 1);
	public static Item bootsBlooded;
	public static Item leggingsBlooded;
	public static Item chestpieceBlooded;
	public static Item helmBlooded;

	public static final Enchantment icedBoots = new icedBoots(configHandler.icedBootsID, 4);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		configHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new configHandler());
		logHelper.info("Pre Init Complete.");
		
		BDPItemsLoader.init();
		BDPBlocksLoader.init();
		chestLootHandler.init();
		
		leafBand = new itemBloodArmor(BloodMat, 0, "blooddp.leafBand");
		GameRegistry.registerItem(leafBand, "leafBand");
		platedWings = new itemBloodArmor(BloodMat, 1, "blooddp.platedWings");
		GameRegistry.registerItem(platedWings, "platedWings");
		forgottenExo = new itemBloodArmor(BloodMat, 2, "blooddp.forgottenExo");
		GameRegistry.registerItem(forgottenExo, "forgottenExo");
		fancyBoots = new itemBloodArmor(BloodMat, 3, "blooddp.fancyBoots");
		GameRegistry.registerItem(fancyBoots, "fancyBoots");
		
		helmBlooded = new itemBloodArmor(BloodMat2, 0, "blooddp.helmBlooded");
		GameRegistry.registerItem(helmBlooded, "helmBlooded");
		chestpieceBlooded = new itemBloodArmor(BloodMat2, 1, "blooddp.chestpieceBlooded");
		GameRegistry.registerItem(chestpieceBlooded, "chestpieceBlooded");
		leggingsBlooded = new itemBloodArmor(BloodMat2, 2, "blooddp.leggingsBlooded");
		GameRegistry.registerItem(leggingsBlooded, "leggingsBlooded");
		bootsBlooded = new itemBloodArmor(BloodMat2, 3, "blooddp.bootsBlooded");
		GameRegistry.registerItem(bootsBlooded, "bootsBlooded");

	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		recipeHandler.init();
		MinecraftForge.EVENT_BUS.register(new eventHandler());
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
