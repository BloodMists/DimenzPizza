package bloods.common.dimenPizza.item;

import bloods.common.dimenPizza.Blooddp;
import bloods.common.dimenPizza.reference.Reference;
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
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (itemStack.getItem().equals(Blooddp.fancyBoots))
		{
			if (player.getCurrentArmor(1) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(3) == null)				
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30, 3));
			}
/*			else if (player.getCurrentArmor(1) != null || player.getCurrentArmor(2) != null)
			{
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 10, 0));
			}*/
		//player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 3));
		player.fallDistance = 0;
		}
	}
}
