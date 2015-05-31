package bloods.common.dimenPizza.item;

import java.util.List;

import bloods.common.dimenPizza.creativetab.CreativetabIBDP;
import bloods.common.dimenPizza.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class itemPizzas extends ItemFood
{
	public static String[] subPizza = {
		/*Plain Pizzas*/ "pizzaEmpty", "pizzaSauced", "pizzaChz", "pizzaBeef", "pizzaCkn", "pizzaHam", "pizzaSaus", "pizzaPep", "pizzaShroom",
		 /*Ckn Pizzas*/  "pizzaCknBeef", "pizzaCknSaus", "pizzaCknPep", "pizzaCknShroom",
		 /*Beef Pizzas*/ "pizzaBeefSaus", "pizzaBeefPep", "pizzaBeefShroom",
		 /*Saus Pizzas*/ "pizzaSausHam", "pizzaSausPep", "pizzaSausShroom",
	/*Shroom Pizzas*/	 "pizzaShroomHam", "pizzaShroomPep",
	/*Specialty Pizzas*/ "pizzaSuprime", "pizzaHawaiian", "pizzaMeatLvr"};
	IIcon[] icons = new IIcon[subPizza.length];
	
	public itemPizzas()
	{
		super(12, 0.6F, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(8);
		this.setCreativeTab(CreativetabIBDP.Dimenz_Pizza_Items);
		this.setUnlocalizedName(Reference.itemname);
	}
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{	return 64;}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		for (int i=0; i<icons.length; i++)
			this.icons[i] = icon.registerIcon(Reference.itemname + ":" + subPizza[i]);
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if(meta >= 0 && meta<icons.length)
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
