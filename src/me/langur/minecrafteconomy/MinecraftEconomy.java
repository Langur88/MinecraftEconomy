package me.langur.minecrafteconomy;

import net.gravitydevelopment.updater.Updater;
import net.gravitydevelopment.updater.Updater.UpdateType;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftEconomy extends JavaPlugin {
	
	public void onEnable() {
		SettingsManager sm = SettingsManager.getInstance();
		
		sm.setup(this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new MoneyEvents(), this);
		
		CommandManager cm = new CommandManager();
		getCommand("coins").setExecutor(cm);
		
		new Updater(this, 76869, getFile(), UpdateType.DEFAULT, true);
		
		if(Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
			Bukkit.getServer().getServicesManager().register(Economy.class, new VaultConnector(), this, ServicePriority.Highest);
		}
	}
}
