package me.langur.minecrafteconomy;

import java.util.List;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class VaultConnector implements Economy {
	
	SettingsManager sm = SettingsManager.getInstance();
	
	@Override
	public EconomyResponse bankBalance(String arg0) {
		
		return null;
	}

	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		
		return null;
	}

	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		
		return null;
	}

	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, String arg1) { 
		return null;
	}

	@Override
	public boolean createPlayerAccount(String name) {
		sm.setBalance(name, 0);
		return true;
	}

	@Override
	public boolean createPlayerAccount(String name, String world) {
		return createPlayerAccount(name);
	}

	@Override
	public String currencyNamePlural() {
		return "Coins";
	}

	@Override
	public String currencyNameSingular() {
		return "Coin";
	}

	@Override
	public EconomyResponse deleteBank(String arg0) {
		
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String name, double amnt) {
		sm.addBalance(name,  amnt);
		return new EconomyResponse(amnt, sm.getBalance(name), ResponseType.SUCCESS, "");
	}

	@Override
	public EconomyResponse depositPlayer(String name, String world, double amnt) {
		return depositPlayer(name, amnt);
	}

	@Override
	public String format(double amnt) {
		return String.valueOf(amnt);
	}

	@Override
	public int fractionalDigits() {
		
		return 2;
	}

	@Override
	public double getBalance(String name) {
		return sm.getBalance(name);
	}

	@Override
	public double getBalance(String name, String world) {
		return getBalance(name);
	}

	@Override
	public List<String> getBanks() {
		
		return null;
	}

	@Override
	public String getName() {
		return "MinecraftEconomy";
	}

	@Override
	public boolean has(String player, double amnt) {
		return sm.getBalance(player) >= amnt;
	}

	@Override
	public boolean has(String player, String world, double amnt) {
		return has(player, amnt);
	}

	@Override
	public boolean hasAccount(String arg0) {
		
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		
		return false;
	}

	@Override
	public boolean hasBankSupport() {
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		return null;
	}

	@Override
	public boolean isEnabled() {
		return sm.getPlugin().isEnabled();
	}

	@Override
	public EconomyResponse withdrawPlayer(String player, double amnt) {
		return new EconomyResponse(amnt, sm.getBalance(player) - amnt, sm.removeBalance(player, amnt) ? ResponseType.SUCCESS : ResponseType.FAILURE, "Insufficient funds.");
	}

	@Override
	public EconomyResponse withdrawPlayer(String player, String world, double amnt) {
		return withdrawPlayer(player, amnt);
	}
	
}
