package com.Bloods.dimenPizza.item;

import java.util.List;

import com.Bloods.dimenPizza.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class itemPizzas extends ItemBDP
{
	public static String[] subPizza = 
		{/*Plain Pizzas*/"pizza", "pizzaSauced", "pizzaChz", "pizzaBeef", "pizzaCkn", "pizzaHam", "pizzaSaus", "pizzaPep", "pizzaShroom",
		 /*Ckn Pizzas*/"pizzaCknBeef", "pizzaCknSaus", "pizzaCknPep", "pizzaCknShroom",
		 /*Beef Pizzas*/"pizzaBeefSaus", "pizzaBeefPep", "pizzaBeefShroom",
		 /*Saus Pizzas*/"pizzaSausHam", "pizzaSausPep", "pizzaSausShroom",
		 /*Shroom Pizzas*/"pizzaShroomHam", "pizzaShroomPep",
		 /*Specialty Pizzas*/"pizzaSuprime", "pizzaHawaiian", "pizzaMeatLvr",
		 
		 //Slices
		 /*
		  * Todo: Add slices
		  */
		};
	IIcon[] icons = new IIcon[subPizza.length];
	
	public itemPizzas()
	{
		super();
		this.setMaxStackSize(8);
	}

	@Override
	public void registerIcons(IIconRegister icon)
	{
		for (int i=0; i<icons.length; i++)
			this.icons[i] = icon.registerIcon(Reference.Mod_ID.toLowerCase() + ":" + subPizza[i]);
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if(meta>=0 && meta<icons.length)
			return this.icons[meta];
		return icons[0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i=0;i<subPizza.length;i++)
			list.add(new ItemStack(this,1,i));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName()+"."+subPizza[stack.getItemDamage()];
	}
}
