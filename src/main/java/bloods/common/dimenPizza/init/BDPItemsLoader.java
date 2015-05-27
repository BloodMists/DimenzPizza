package bloods.common.dimenPizza.init;

import bloods.common.dimenPizza.reference.Reference;
import bloods.common.dimenPizza.item.ItemBDP;
import bloods.common.dimenPizza.item.itemIngredients;
import bloods.common.dimenPizza.item.itemPizzas;
import bloods.common.dimenPizza.item.itemTools;
import cpw.mods.fml.common.registry.GameRegistry;

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
