package bloods.common.dimenPizza.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class icedBoots extends Enchantment
{
	public icedBoots(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.armor_feet);
		this.setName("Icy");
	}
	
	public int getMinEnchantablity(int par1)
	{
		return 5+(par1 - 1)*10;		
	}
	
	public int getMaxEnchantability(int par1)
	{
		return this.getMinEnchantablity(par1) + 20;
	}
	
	public int getMaxLevel()
	{
		return 5;
	}
}
