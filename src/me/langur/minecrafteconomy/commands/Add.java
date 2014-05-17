package me.langur.minecrafteconomy.commands;

import me.langur.minecrafteconomy.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Add extends EcoCommand {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	SettingsManager sm = SettingsManager.getInstance();
	
	public Add() {
		super("Add", "Add coins to balance.", "<Player> <Amount>");
	}
	
	public void run(CommandSender sender, String[] args) {
		if(!sender.hasPermission("MinecraftEconomy.add")) {
			sender.sendMessage(prefix + ChatColor.RED + "You can't use this command.");
			return;
		}
		
		if(args.length < 2) {
			sender.sendMessage(prefix + ChatColor.RED + "You didn't enter enough arguments.");
			return;
		}
		
		String name = args[0];
		double amnt;
		
		try { amnt = Double.parseDouble(args[1]); }
		catch (Exception e) {
			sender.sendMessage(prefix + ChatColor.RED + "Invalid number.");
			return;
		}
		
		sm.addBalance(name, amnt);
		sender.sendMessage(prefix + ChatColor.GREEN + "Added " + amnt + " coins to " + name + "'s account. They now have " + sm.getBalance(name) + " coins.");
	}
}
