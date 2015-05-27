package bloods.common.dimenPizza.creativetab;

import bloods.common.dimenPizza.init.BDPItemsLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativetabIBDP
{
	public static final CreativeTabs Dimenz_Pizza_Items = new CreativeTabs("tab.bloodbdp:IBDP") 
	{
		@Override
		public Item getTabIconItem()
		{
			return BDPItemsLoader.tools;
		}
		
	};
}
