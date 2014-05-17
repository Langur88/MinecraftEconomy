package me.langur.minecrafteconomy.commands;

import me.langur.minecrafteconomy.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pay extends EcoCommand {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	SettingsManager sm = SettingsManager.getInstance();
	
	public Pay() {
		super("Pay", "Pay a player with points.", "<player> <amount>");
	}
	
	public void run(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(prefix + ChatColor.RED + "You cannot do this.");
			return;
		}
		
		if(!sender.hasPermission("MinecraftEconomy.pay")) {
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
		sm.removeBalance(name, amnt);
		sender.sendMessage(prefix + ChatColor.GREEN + "Payed " + amnt + " coins to " + name + "'s account.");
		sender.sendMessage(prefix + ChatColor.GREEN + "They now have " + sm.getBalance(name) + " coins.");
		sender.sendMessage(prefix + ChatColor.GREEN + "You now have " + sm.getBalance(sender.getName()) + " coins.");
	}
}
