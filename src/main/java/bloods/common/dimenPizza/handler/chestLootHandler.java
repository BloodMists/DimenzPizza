package bloods.common.dimenPizza.handler;

import bloods.common.dimenPizza.Blooddp;
import bloods.common.dimenPizza.init.BDPItemsLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class chestLootHandler
{
	public static void init()
	{
		String c = ChestGenHooks.DUNGEON_CHEST;
		if (configHandler.gGIsEnabled == true){
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(Blooddp.forgottenExo), 1, 1, 5));
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(Blooddp.leafBand), 1, 1, 5));
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(Blooddp.fancyBoots), 1, 1, 1));
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(Blooddp.platedWings), 1, 1, 1));
		}
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(BDPItemsLoader.seed), 1, 4, 50));
	}
}
