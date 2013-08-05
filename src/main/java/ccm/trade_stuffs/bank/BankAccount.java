/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.bank;

import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;

/**
 * Account
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BankAccount {
	
	private String player;

	private InventoryBankCoins coins;
	private InventoryBankItems items;

	public BankAccount(String player) {
		this.player = player;
		coins = new InventoryBankCoins();
		items = new InventoryBankItems();
	}

	public void readFromNBT(NBTTagCompound nbt) {
		player = nbt.getString("Owner");
		coins.loadInventoryFromNBT(nbt.getTagList("Coins"));
		items.loadInventoryFromNBT(nbt.getTagList("Items"));
	}

	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setString("Owner", player);
		nbt.setTag("Coins", coins.saveInventoryToNBT());
		nbt.setTag("Items", items.saveInventoryToNBT());
	}

	public String getOwner() {
		return player;
	}

	public InventoryBankCoins getCoins() {
		return coins;
	}

	public InventoryBankItems getItems() {
		return items;
	}
}