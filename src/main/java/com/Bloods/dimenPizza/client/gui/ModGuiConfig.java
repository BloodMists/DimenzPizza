package com.Bloods.dimenPizza.client.gui;

import com.Bloods.BloodTG.handler.configHandler;
import com.Bloods.BloodTG.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;


public class ModGuiConfig extends GuiConfig
{
	public ModGuiConfig(GuiScreen guiScreen)
	{
		super (guiScreen,
				new ConfigElement(configHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.Mod_ID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(configHandler.configuration.toString()));
	}
}
