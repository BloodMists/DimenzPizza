package bloods.common.dimenPizza.init;

import bloods.common.dimenPizza.crops.cropTomato;
import bloods.common.dimenPizza.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.Mod_ID)

public class BDPBlocksLoader
{
	public static final cropTomato tomato = new cropTomato(); 
	
	public static void init()
	{
		GameRegistry.registerBlock(tomato, "cropTomato");
	}
}
