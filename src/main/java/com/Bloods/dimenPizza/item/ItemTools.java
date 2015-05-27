package com.Bloods.dimenPizza.item;

import java.util.List;

import com.Bloods.dimenPizza.creativetab.CreativetabIBDP;
import com.Bloods.dimenPizza.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class itemTools extends ItemBDP
{
	public static String[] subTools = {"toolRPin", "toolKnife", "toolCutter", "toolChurn", "toolPress", "knifeBlade"};
	IIcon[] icons = new IIcon[subTools.length];

	public itemTools()
	{
		super();
		this.setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		for (int i=0; i<icons.length; i++)
			this.icons[i] = icon.registerIcon(Reference.Mod_ID.toLowerCase() + ":" + subTools[i]);
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
		for(int i=0;i<subTools.length;i++)
			list.add(new ItemStack(this,1,i));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName()+"."+subTools[stack.getItemDamage()];
	}
	

	public ItemStack getContainerItem(ItemStack is)
	{
		if(is.getItemDamage() > getMaxDamage()) return null;
		return new ItemStack(this, 1, is.getItemDamage() + 0);
	}
	
	public boolean hasContainerItem(ItemStack is)
	{ return true; }
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack is)
	{ return false; }
}
