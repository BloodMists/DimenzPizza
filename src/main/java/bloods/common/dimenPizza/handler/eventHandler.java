package bloods.common.dimenPizza.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import bloods.common.dimenPizza.Blooddp;
import bloods.common.dimenPizza.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class eventHandler
{
	@SubscribeEvent
	public void onLiving(LivingEvent.LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer){ EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack armor = player.getEquipmentInSlot(3);
			if (armor == null || !armor.getItem().equals(Blooddp.platedWings))
			{
				if (player.capabilities.allowFlying && !player.capabilities.isCreativeMode)
				{
					player.capabilities.allowFlying = false;
					//logHelper.info("Flight Disabled");
				}
					player.sendPlayerAbilities();
			}
		}
	}

}
