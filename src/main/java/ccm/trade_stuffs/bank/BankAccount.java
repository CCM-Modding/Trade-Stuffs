package ccm.trade_stuffs.bank;

import net.minecraft.nbt.NBTTagCompound;
import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;

public class BankAccount {

	public String player;
	
	public InventoryBankCoins coins;
	public InventoryBankItems items;

	public BankAccount(String player) {
		this.player = player;
	}
	
	public void readFromNBT(NBTTagCompound nbt) {		
		player = nbt.getString("Player");	
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setString("Player", player);
	}
}
