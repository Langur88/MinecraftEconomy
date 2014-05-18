package me.langur.minecrafteconomy.commands;

import me.langur.minecrafteconomy.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Check extends EcoCommand {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	SettingsManager sm = SettingsManager.getInstance();
	
	public Check() {
		super("Check", "Check a player's balance.", "<player>");
	}
	
	public void run(CommandSender sender, String[] args) {
		if(!sender.hasPermission("MinecraftEconomy.check")) {
			sender.sendMessage(prefix + ChatColor.RED + "You can't use this command.");
			return;
		}
		
		if(args.length < 1) {
			sender.sendMessage(prefix + ChatColor.RED + "You didn't enter enough arguments.");
			return;
		}
		
		String name = args[0];
		
		sender.sendMessage(prefix + ChatColor.GREEN + name + " has " + sm.getBalance(name) + " coins.");
	}
}
