package ccm.trade_stuffs.bank;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import ccm.trade_stuffs.api.coins.CoinType;

public class BankAccount {

	public String player;
	
	public HashMap<CoinType, Integer> coins;
	public ArrayList<ItemStack> items;
	
	public BankAccount(String player) {
		this.player = player;
		coins = new HashMap<CoinType, Integer>();
		items = new ArrayList<ItemStack>();
	}
}
