package me.langur.minecrafteconomy;

import java.util.ArrayList;
import java.util.Arrays;

import me.langur.minecrafteconomy.commands.Add;
import me.langur.minecrafteconomy.commands.Clear;
import me.langur.minecrafteconomy.commands.EcoCommand;
import me.langur.minecrafteconomy.commands.Pay;
import me.langur.minecrafteconomy.commands.Remove;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "MinecraftEconomy" + ChatColor.DARK_GRAY + "] ";
	private ArrayList<EcoCommand> cmds = new ArrayList<EcoCommand>();
	SettingsManager sm = SettingsManager.getInstance();
	
	public CommandManager() {
		cmds.add(new Add());
		cmds.add(new Remove());
		cmds.add(new Clear());
		cmds.add(new Pay());
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("coins")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.sendMessage(prefix + ChatColor.GREEN + "You have " + sm.getBalance(p.getName()) + " coins.");
				}
				
				for(EcoCommand c : cmds) {
					sender.sendMessage(prefix + ChatColor.YELLOW + "/coins " + c.getName() + " " + c.getArgs() + " - " + c.getDescription());
				}
				
				return true;
			}
			
			ArrayList<String> a = new ArrayList<String>(Arrays.asList(args));
			a.remove(0);
			
			for(EcoCommand c : cmds) {
				if(c.getName().equalsIgnoreCase(args[0])) {
					try { c.run(sender, a.toArray(new String[a.size()])); }
					catch (Exception e) { sender.sendMessage(prefix + ChatColor.RED + "An error has occured."); e.printStackTrace(); }
					return true;
				}
			}
			
			sender.sendMessage(prefix + ChatColor.RED + "Invalid command.");
		}
		return true;
	}
}
