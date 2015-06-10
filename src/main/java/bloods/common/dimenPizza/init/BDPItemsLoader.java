package bloods.common.dimenPizza.init;

import net.minecraft.item.ItemFood;
import bloods.common.dimenPizza.reference.Reference;
import bloods.common.dimenPizza.item.ItemBDP;
import bloods.common.dimenPizza.item.itemIngredients;
import bloods.common.dimenPizza.item.itemPizzas;
import bloods.common.dimenPizza.item.itemTools;
import bloods.common.dimenPizza.item.seedTomato;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.Mod_ID)

public class BDPItemsLoader
{
	//General Items
	public static final ItemBDP stuffs = new itemIngredients();
	public static final ItemFood pizzas = new itemPizzas();
	public static final ItemBDP tools = new itemTools();
	public static final seedTomato seed = new seedTomato(null, null);

	public static void init()
	{
		//General Items
		GameRegistry.registerItem(stuffs, "stuffs");
		GameRegistry.registerItem(pizzas, "pizzas");
		GameRegistry.registerItem(tools, "tools");
		GameRegistry.registerItem(seed, "seed");
	}
}
