package net.angusbeefgaming.fakeplexer.admin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {
	public StaffChatCommand() {
		super("a", "infinitygames.core.a");
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
        if (args.length < 1)
        {
            sender.sendMessage(ChatColor.BLUE + "Staff> " + ChatColor.GRAY + "Please type a message.");
            return;
        }
        
        StringBuilder message = new StringBuilder();
        for(int i = 0; i > args.length; i++) {
        	message = message.append(args[i] + " ");
        }
        
        String messageDone = message.toString();
        
        for(ProxiedPlayer pl : ProxyServer.getInstance().getPlayers()) {
        	if(pl.hasPermission("infinitygames.core.a")) {
        		pl.sendMessage(ChatColor.BLUE + "Staff> " + ChatColor.GOLD + "[" + ProxyServer.getInstance().getPlayer(sender.getName()).getServer().getInfo().getName() + "] " + "(" + sender.getName() + ")" + ChatColor.GREEN + " " + messageDone);
        	}
        }
        
        System.out.println(ChatColor.BLUE + "Staff> " + ChatColor.GOLD + "[" + ProxyServer.getInstance().getPlayer(sender.getName()).getServer().getInfo().getName() + "] " + "(" + sender.getName() + ")" + ChatColor.GREEN + " " + messageDone);
	}
}
