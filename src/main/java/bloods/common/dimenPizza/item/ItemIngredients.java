package bloods.common.dimenPizza.item;

import java.util.List;

import bloods.common.dimenPizza.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class itemIngredients extends ItemBDP
{
	public static String[] subIngred = {"ingredTomato", "ingredSauce", "ingredDough", "ingredSalt", "ingredCheese", "ingredChicken", "ingredBeef",
		"ingredHam", "ingredPinapple","ingredSausage", "ingredPepperoni", "ingredSlicedShrooms", "ingredFlour", "ingredThreshedWheat"};
	IIcon[] icons = new IIcon[subIngred.length];
	
	public itemIngredients()
	{
		super();
		this.setMaxDamage(0);
		this.setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		for (int i=0; i<icons.length; i++)
			this.icons[i] = icon.registerIcon(Reference.itemname + ":" + subIngred[i]);
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
		for(int i=0;i<subIngred.length;i++)
			list.add(new ItemStack(this,1,i));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{	return this.getUnlocalizedName()+"."+subIngred[stack.getItemDamage()];}
}
