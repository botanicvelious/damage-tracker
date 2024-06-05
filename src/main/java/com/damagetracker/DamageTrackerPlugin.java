package com.damagetracker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Provider;

import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.hiscore.HiscorePanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import java.util.regex.Pattern;
import lombok.Getter;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.hiscore.HiscoreEndpoint;

@Slf4j
@PluginDescriptor(
		name = "Damage Tracker"
)

public class DamageTrackerPlugin extends Plugin
{
	private static final String LOOKUP = "Lookup";
	private static final Pattern BOUNTY_PATTERN = Pattern.compile("You have been assigned a new target: <col=[0-9a-f]+>(.*)</col>");

	@Inject
	@Nullable
	private Client client;

	@Inject
	private Provider<MenuManager> menuManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private DamageTrackerConfig config;

	private NavigationButton navButton;
	private DamageTrackerPanel damageTrackerPanel;

	@Getter
	private HiscoreEndpoint localHiscoreEndpoint;

	@Provides
	DamageTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DamageTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		damageTrackerPanel = injector.getInstance(DamageTrackerPanel.class);

        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "damagetracker.png");

        navButton = NavigationButton.builder()
				.tooltip("Damage Tracker")
				.icon(icon)
				.priority(5)
				.panel(damageTrackerPanel)
				.build();

		clientToolbar.addNavigation(navButton);

	}

	@Override
	protected void shutDown() throws Exception
	{
		damageTrackerPanel.shutdown();
		clientToolbar.removeNavigation(navButton);

	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("damagetracker"))
		{

		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{

	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		//Highscore plugin base
	}



}
