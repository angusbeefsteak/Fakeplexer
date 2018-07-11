package net.angusbeefgaming.fakeplexer;

import net.angusbeefgaming.fakeplexer.motd.MotdManager;
import net.md_5.bungee.api.plugin.Plugin;

public class Fakeplexer extends Plugin {
	public void onEnable() {
		new MotdManager(this);
	}
}
