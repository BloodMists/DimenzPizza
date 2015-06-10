package bloods.common.dimenPizza.handler;

import java.io.File;

import bloods.common.dimenPizza.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class configHandler
{
	public static Configuration configuration;
	public static boolean godlyGear = false;
	public static boolean gGIsEnabled = false;
	
	public static void init(File configFile)
	{
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration(); //Create config file if none
		}
	}
	
	private static void loadConfiguration()
	{
		
		godlyGear = configuration.getBoolean("GodlyGearCraftable", Configuration.CATEGORY_GENERAL, false, "Allow Crafting");
		gGIsEnabled = configuration.getBoolean("GodlyGearEnabled?", Configuration.CATEGORY_GENERAL, true, "Enables Godly Gear in survival");
		
		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.Mod_ID))
		{
			loadConfiguration(); //Resync Config
		}
	}

}