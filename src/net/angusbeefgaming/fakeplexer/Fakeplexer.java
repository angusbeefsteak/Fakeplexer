package net.angusbeefgaming.fakeplexer;

import net.angusbeefgaming.fakeplexer.admin.StaffChatCommand;
import net.angusbeefgaming.fakeplexer.motd.MotdManager;
import net.angusbeefgaming.fakeplexer.motd.SetMotdConfigCommand;
import net.md_5.bungee.api.plugin.Plugin;

public class Fakeplexer extends Plugin {
	public void onEnable() {
		new MotdManager(this);
		
		getProxy().getPluginManager().registerCommand( this, new StaffChatCommand() );
		getProxy().getPluginManager().registerCommand(this, new SetMotdConfigCommand());
	}
}
