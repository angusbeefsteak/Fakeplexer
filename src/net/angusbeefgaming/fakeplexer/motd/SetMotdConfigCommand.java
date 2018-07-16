package net.angusbeefgaming.fakeplexer.motd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class SetMotdConfigCommand extends Command {
	public SetMotdConfigCommand() {
		super("setmotdconfig", "infinitygames.core.setmotdconfig");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length > 1) {
			sender.sendMessage(ChatColor.BLUE + "MOTD Manager> " + ChatColor.GRAY + "You must Provide valid MOTD Mode!");
			return;
		}
		String modeToSet = args[0];
		if(modeToSet.equals("DEFAULT")) {
			sender.sendMessage(ChatColor.BLUE + "MOTD Manager> " + ChatColor.GRAY + "Server Mode has been updated to DEFAULT!");
			MotdManager.setMode(MOTDMode.DEFAULT);
			return;
		}
		if(modeToSet.equals("MAINTENANCE") || modeToSet.equals("SETUP")) {
			sender.sendMessage(ChatColor.BLUE + "MOTD Manager> " + ChatColor.GRAY + "Server Mode has been updated to MAINTENANCE!");
			MotdManager.setMode(MOTDMode.MAINTENANCE);
			return;
		}
		if(modeToSet.equals("SALE")) {
			sender.sendMessage(ChatColor.BLUE + "MOTD Manager> " + ChatColor.GRAY + "Server Mode has been updated to SALE!");
			MotdManager.setMode(MOTDMode.SALE);
			return;
		}
		else {
			sender.sendMessage(ChatColor.BLUE + "MOTD Manager> " + ChatColor.GRAY + "Sorry, but I was unable to find that Mode!");
			return;
		}
	}
}
