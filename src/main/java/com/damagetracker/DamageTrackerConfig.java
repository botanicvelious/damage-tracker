package com.damagetracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("damagetracker")
public interface DamageTrackerConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "playerOption",
			name = "Player option",
			description = "Add Lookup option to players"
	)
	default boolean playerOption()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "menuOption",
			name = "Menu option",
			description = "Show Lookup option in menus"
	)
	default boolean menuOption()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "virtualLevels",
			name = "Display virtual levels",
			description = "Display levels over 99 in the hiscore panel"
	)
	default boolean virtualLevels()
	{
		return true;
	}

	@ConfigItem(
			position = 4,
			keyName = "autocomplete",
			name = "Autocomplete",
			description = "Predict names when typing a name to lookup"
	)
	default boolean autocomplete()
	{
		return true;
	}

	@ConfigItem(
			position = 5,
			keyName = "bountylookup",
			name = "Bounty lookup",
			description = "Automatically lookup the stats of your bounty hunter target"
	)
	default boolean bountylookup()
	{
		return false;
	}
}
