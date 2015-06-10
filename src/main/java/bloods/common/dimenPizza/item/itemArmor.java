package bloods.common.dimenPizza.item;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bloods.common.dimenPizza.Blooddp;
import bloods.common.dimenPizza.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class itemArmor extends ItemArmor
{
	public String textureName;

	public itemArmor(ArmorMaterial material, int type, String name) {
		super(material,0,type);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.Mod_ID + ":" + getUnlocalizedName());
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (stack.getItem().equals(Blooddp.fancyBoots))
		{
			if (player.getCurrentArmor(1) == null && player.getCurrentArmor(2) == null && player.getCurrentArmor(3) == null)				
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30, 3));
			}
			else if (player.getCurrentArmor(1) != null || player.getCurrentArmor(2) != null)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 4));
			}
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 3));
		player.fallDistance = 0;
		}
		
		if (stack.getItem().equals(Blooddp.forgottenExo))
		{
			player.fallDistance -= 0.7f;
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 5));
		}
		
		if (stack.getItem().equals(Blooddp.platedWings))
		{
			if (player.getCurrentArmor(0) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(3) == null)				
			{
				player.capabilities.allowFlying = true;
			}
			//else if (player.getCurrentArmor(0) == null && player.getCurrentArmor(3) == null && stack.getItem().equals(Blooddp.forgottenExo))
			//{
			//	player.capabilities.allowFlying = true;
			//}
			else
			{
				player.capabilities.allowFlying = false;
				player.addPotionEffect(new PotionEffect(Potion.wither.id, 30, 5));
			}
		player.fallDistance = 0;
		}
		
		if (stack.getItem().equals(Blooddp.leafBand))
		{
			if (player.getCurrentArmor(0) == null && player.getCurrentArmor(1) == null && player.getCurrentArmor(2) == null)
			{
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 30, 0));
			}
			else player.addPotionEffect(new PotionEffect(Potion.blindness.id, 30, 5));
		}
	}


	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if (stack.getItem().equals(Blooddp.fancyBoots))
		{	
			list.add("\u00A7fFancy boots blessed with");
			list.add("\u00A7flimitless life and a feathery touch.");
			list.add("\u00A74Note: Do not wash or wear with mortal garb.");
		}
		
		if (stack.getItem().equals(Blooddp.forgottenExo))
		{
			list.add("\u00A75A rusted exo-suit from an ancient world");
			list.add("\u00A71'It apperes to still be of some use.'");
		}
		
		if (stack.getItem().equals(Blooddp.platedWings))
		{
			list.add("\u00A76Metal Wings blessed with true flight.");
			list.add("\u00A74Death awaits those whom disgrace them.");
		}
		
		if (stack.getItem().equals(Blooddp.leafBand))
		{
			list.add("\u00A72Aleaf circlet from the ancient garden.");
			list.add("\u00A74The leaves of heaven tend to turn from mortal garbs");
		}
	}
}
