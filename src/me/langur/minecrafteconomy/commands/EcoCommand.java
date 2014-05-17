package me.langur.minecrafteconomy.commands;

import org.bukkit.command.CommandSender;

public abstract class EcoCommand {
	
private String name, desc, args;
	
	public EcoCommand(String name, String desc, String args) {
		this.name = name;
		this.desc = desc;
		this.args = args;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public String getArgs() {
		return args;
	}
	
	public abstract void run(CommandSender sender, String[] args);
}
