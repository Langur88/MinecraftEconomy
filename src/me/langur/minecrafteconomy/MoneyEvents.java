package me.langur.minecrafteconomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MoneyEvents implements Listener {
	
	private SettingsManager sm = SettingsManager.getInstance();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "$" + sm.getBalance(p.getName().toLowerCase()) + ChatColor.DARK_GRAY + "] " + p.getDisplayName() + ChatColor.GOLD + ": " + ChatColor.WHITE + e.getMessage());
	}
}
