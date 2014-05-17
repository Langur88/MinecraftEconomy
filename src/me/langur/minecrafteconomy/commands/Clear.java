package me.langur.minecrafteconomy.commands;

import me.langur.minecrafteconomy.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Clear extends EcoCommand {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	SettingsManager sm = SettingsManager.getInstance();
	
	public Clear() {
		super("Clear", "Clears a players balance.", "<player>");
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if(!sender.hasPermission("MinecraftEconomy.clear")) {
			sender.sendMessage(prefix + ChatColor.RED + "You can't use this command.");
			return;
		}
		
		if(args.length < 1) {
			sender.sendMessage(prefix + ChatColor.RED + "You didn't enter enough arguments.");
			return;
		}
		
		String name = args[0];
		
		sm.removeBalance(name, sm.getBalance(name));
		sender.sendMessage(prefix + ChatColor.GREEN + "Cleared " + name + "'s balance.");
	}
}
