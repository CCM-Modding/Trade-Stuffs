package ccm.trade_stuffs.bank;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.utils.helper.InventoryHelper;

public class BankAccount {

	public String player;

	public HashMap<CoinType, Integer> coins = new HashMap<CoinType, Integer>();
	public ArrayList<ItemStack> items = new ArrayList<ItemStack>();

	private int coinBalance = 0;

	public BankAccount(String player) {
		this.player = player;
	}

	public void addCoins(CoinType coinType, int amount) {
		int balance = 0;
		if(coins.containsKey(coinType)) {
			balance = coins.get(coinType);
		}
		coins.put(coinType, balance + amount);
		countCoinBalance();
	}

	public void removeCoins(CoinType coinType, int amount) {
		int balance = 0;
		if(coins.containsKey(coinType)) {
			balance = coins.get(coinType);
		}
		coins.put(coinType, (int) Math.min(0, balance - amount));
		countCoinBalance();
	}

	public void addItemStack(ItemStack stack) {
		boolean found = false;
		for(ItemStack item : items) {
			if(item != null && InventoryHelper.areItemStacksEqualWithoutSize(stack, item)) {
				stack.stackSize += item.stackSize;
				found = true;
			}
		}
		if(!found) {
			items.add(stack);
		}
	}

	public void removeItemStack(ItemStack stack) {
		for(ItemStack item : items) {
			if(item != null && InventoryHelper.areItemStacksEqualWithoutSize(stack, item)) {
				stack.stackSize -= item.stackSize;
			}
		}
	}

	public void countCoinBalance() {
		coinBalance = 0;
		for(CoinType coinType : coins.keySet()) {
			coinBalance += (coinType.getValue() * coins.get(coinType));
		}
	}

	public int getCoinBalance() {
		return coinBalance;
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		player = nbt.getString("Player");
		
		coins = new HashMap<CoinType, Integer>();
		for(CoinType coinType : CoinTypes.getTypes()) {
			if(nbt.hasKey("Coin-" + coinType.getName())) {
				coins.put(coinType, nbt.getInteger("Coin-" + coinType.getName()));
			}
		}
		countCoinBalance();
		
		NBTTagList list = nbt.getTagList("Items");
		ItemStack[] stacks = InventoryHelper.readInventoryFromNBT(list, list.tagCount());		
		for(int i = 0; i < stacks.length; i++) {
			items.add(stacks[i]);
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setString("Player", player);
		for(CoinType coinType : coins.keySet()) {
			nbt.setInteger("Coin-" + coinType.getName(), coins.get(coinType));
		}
		
		nbt.setTag("Items", InventoryHelper.writeInventoryToNBT(items.toArray(new ItemStack[items.size()])));
	}
}
