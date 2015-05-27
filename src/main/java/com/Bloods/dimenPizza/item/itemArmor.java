package com.Bloods.dimenPizza.item;

import net.minecraft.item.ItemArmor;

public class itemArmor extends ItemArmor
{
	public String textureName;

	public itemArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
		super(material,0,type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(textureName);
		// TODO Auto-generated constructor stub
	}

}
