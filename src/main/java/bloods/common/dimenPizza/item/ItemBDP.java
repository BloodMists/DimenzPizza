package bloods.common.dimenPizza.item;

import bloods.common.dimenPizza.creativetab.CreativetabIBDP;
import bloods.common.dimenPizza.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBDP extends Item
{
	public ItemBDP()
	{
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativetabIBDP.Dimenz_Pizza_Items);
		this.setUnlocalizedName(Reference.Mod_ID.toLowerCase());
	}

	protected void setUnlocalName(String name)
	{
		this.setUnlocalizedName(Reference.Mod_ID.toLowerCase() + "." + name);
		this.setTextureName(Reference.Mod_ID.toLowerCase() + ":" + name);		
	}
}
