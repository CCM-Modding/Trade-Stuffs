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
