package me.langur.minecrafteconomy.commands;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import me.langur.minecrafteconomy.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Top extends EcoCommand {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	SettingsManager sm = SettingsManager.getInstance();
	
	public Top() {
		super("Top", "Get top balances.", "");
	}
	
	public void run(CommandSender sender, String[] args) {
		if(args.length > 0) {
			sender.sendMessage(prefix + ChatColor.RED + "Too many arguments.");
			return;
		}
		
		List<String> data = sm.getValues();
		
		Collections.sort(data, new Comparator<String>() {
			public int compare(String a, String b) {
				int aVal = Integer.parseInt(a.split(" ")[0]);
				int bVal = Integer.parseInt(b.split(" ")[0]);
				
				return Integer.compare(aVal, bVal);
			}
		});
		
		for(int i = (data.size() > 10 ? 10 : data.size()) - 1; i >= 0; i--) {
			String line = data.get(i);
			String player = line.split(" ")[1], bal = line.split(" ")[0];
			
			sender.sendMessage(prefix + ChatColor.YELLOW + player + ": " + bal + " coins");
		}
	}
}
