package com.Bloods.dimenPizza.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.Bloods.BloodTG.reference.Reference;

public class CreativetabBBDP
{
	public static final CreativeTabs Dimenz_Pizza_Blocks = new CreativeTabs("tab.bloodbdp:BBDP") 
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(null);
		}
		
	};
}
