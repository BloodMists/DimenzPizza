package com.Bloods.dimenPizza.item;

import com.Bloods.dimenPizza.Blooddp;
import com.Bloods.dimenPizza.reference.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class itemArmor extends ItemArmor
{
	public String textureName;

	public itemArmor(ArmorMaterial material, int type, String name) {
		super(material,0,type);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.Mod_ID + ":" + getUnlocalizedName());
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	
			if (itemStack.getItem().equals(Blooddp.fancyBoots))
			{ 
				if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3).getItem().equals(Blooddp.fancyBoots))
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 2));
					player.fallDistance = 0;
			}
	}
}
