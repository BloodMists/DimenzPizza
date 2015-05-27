package com.Bloods.dimenPizza.init;

import com.Bloods.BloodTG.item.ItemBTG;

import cpw.mods.fml.common.registry.GameRegistry;
import com.Bloods.dimenPizza.reference.Reference;
import com.Bloods.dimenPizza.item.ItemBDP;
import com.Bloods.dimenPizza.item.itemIngredients;
import com.Bloods.dimenPizza.item.itemPizzas;
import com.Bloods.dimenPizza.item.itemTools;

@GameRegistry.ObjectHolder(Reference.Mod_ID)

public class BDPItemsLoader
{
	//General Items
	public static final ItemBDP stuffs = new itemIngredients();
	public static final ItemBDP pizzas = new itemPizzas();
	public static final ItemBDP tools = new itemTools();

	public static void init()
	{
		//General Items
		GameRegistry.registerItem(stuffs, "stuffs");
		GameRegistry.registerItem(pizzas, "pizzas");
		GameRegistry.registerItem(tools, "tools");
	}
}
