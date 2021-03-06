package net.angusbeefgaming.fakeplexer.motd;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class MotdManager implements Listener, Runnable
{
	private Plugin _plugin;
	
	public static MOTDMode myMode = MOTDMode.SALE;
	
	private Random _random = new Random();
	
	// Yes, here is where the MOTD for the Proxy server is set.
	
	private String _firstLine = "                §b§l§m   §8§l§m[ §r §9§lFakeplex§r §f§lGames§r §8§l§m ]§b§l§m   §r";
	
	private String defaultMotd = "§f§l◄§c§l WELCOME TO FAKEPLEX! §f§l►";
	private String saleMotd = "§f§l◄§b§l ALL PRICES REDUCED! §f§l►";
	private String MAINTENANCEMotd =  "                        §f§l◄§c§l MAINTENANCE §f§l►";
	
	// ALL LINES
	// "                        §f§l◄§c§l MAINTENANCE §f§l►"
	
	
	private List<String> _motdLines;
	
	public MotdManager(Plugin plugin)
	{
		_plugin = plugin;
		
		_plugin.getProxy().getScheduler().schedule(_plugin, this, 5L, 30L, TimeUnit.SECONDS);
		_plugin.getProxy().getPluginManager().registerListener(_plugin, this);
		
		run();
	}
	
	public static void setMode(MOTDMode mode) {
		myMode = mode;
		System.out.println("MOTD Manager> Set Mode to " + mode.toString());
	}
	
 
	@EventHandler
	public void serverPing(ProxyPingEvent event)
	{
		net.md_5.bungee.api.ServerPing serverPing = event.getResponse();
		
		String motd = "ALERT! SYSTEM ERROR. CONTACT ATTICUS ZAMBRANA ASAP!";
		
		if(myMode == MOTDMode.DEFAULT) {
			motd = _firstLine + "\n" + defaultMotd;
		}
		if(myMode == MOTDMode.MAINTENANCE) {
			motd = _firstLine + "\n" + MAINTENANCEMotd;
		}
		if(myMode == MOTDMode.SALE) {
			motd = _firstLine + "\n" + saleMotd;
		}
		
		event.setResponse(new net.md_5.bungee.api.ServerPing(serverPing.getVersion(), serverPing.getPlayers(), motd, serverPing.getFaviconObject()));
	}
	
	@Override
	public void run()
	{

	}
	
	/**
	 * Update the main {@link GlobalMotd} determining the MOTD for Bungee instances.
	 * @param motdLines - the lines to update the MOTD to.
	 */
	public void updateMainMotd(String headline, List<String> motdLines)
	{
	}

	public List<String> getMotdLines()
	{
		return _motdLines;
	}
}
