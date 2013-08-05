package ccm.trade_stuffs.bank;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Bank {

	public static HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();

	public static void readFromNBT(NBTTagCompound nbt) {
		accounts = new HashMap<String, BankAccount>();
		if(nbt.hasKey("Accounts")) {
			NBTTagList list = nbt.getTagList("Accounts");
			for(int i = 0 ; i < list.tagCount(); i++) {
				NBTTagCompound tag = (NBTTagCompound) list.tagAt(i);
				BankAccount account = new BankAccount(tag.getString("Player"));
				account.readFromNBT(tag);
				accounts.put(account.player, account);
			}
		}
	}
	
	public static void writeToNBT(NBTTagCompound nbt) {
		NBTTagList list = new NBTTagList();
		for(BankAccount account : accounts.values()) {
			if(account != null) {
				NBTTagCompound tag = new NBTTagCompound();
				account.writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		nbt.setTag("Accounts", list);
	}
}
