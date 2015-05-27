package com.Bloods.dimenPizza;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.Bloods.dimenPizza.handler.configHandler;
import com.Bloods.dimenPizza.handler.recipeHandler;
import com.Bloods.dimenPizza.init.BDPBlocksLoader;
import com.Bloods.dimenPizza.init.BDPItemsLoader;
import com.Bloods.dimenPizza.item.itemArmor;
import com.Bloods.dimenPizza.item.itemTools;
import com.Bloods.dimenPizza.proxy.IProxy;
import com.Bloods.dimenPizza.reference.Reference;
import com.Bloods.dimenPizza.utility.logHelper;
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

	public static Item fancyBoots;
	public static ArmorMaterial PvEArmorMat = EnumHelper.addArmorMaterial("PvEArmorMat", 1, new int[] {1,1,1,1}, 1);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		configHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new configHandler());
		logHelper.info("Pre Init Complete.");
		
		BDPItemsLoader.init();
		BDPBlocksLoader.init();
		
		fancyBoots = new itemArmor(PvEArmorMat, 3, "fancyBoots");
		GameRegistry.registerItem(fancyBoots, "fancyBoots");
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		recipeHandler.init();
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
