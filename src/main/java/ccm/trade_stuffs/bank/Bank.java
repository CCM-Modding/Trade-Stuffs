/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.bank;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Bank {

	private static Bank instance = new Bank();
	
	private HashMap<String, BankAccount> accounts;	

	private Bank() {
		accounts = new HashMap<String, BankAccount>();
	}

	public static Bank getInstance() {
		return instance;
	}

	public static void addAcount(BankAccount acc) {
		getInstance().accounts.put(acc.getOwner(), acc);
	}

	public static BankAccount getAccount(String owner) {
		return getInstance().accounts.get(owner);
	}

	public static boolean hasAccount(String owner) {
		return getInstance().accounts.containsKey(owner);
	}

	public static HashMap<String, BankAccount> getAccounts() {
		return new HashMap<String, BankAccount>(getInstance().accounts);
	}

	public static void readFromNBT(NBTTagCompound nbt) {
		if(nbt.hasKey("Accounts")) {
			getInstance().accounts.clear();
			NBTTagList list = nbt.getTagList("Accounts");
			for(int i = 0; i < list.tagCount(); i++) {
				NBTTagCompound tag = (NBTTagCompound) list.tagAt(i);
				BankAccount account = new BankAccount(tag.getString("Owner"));
				account.readFromNBT(tag);
				addAcount(account);
			}
		}
	}

	public static void writeToNBT(NBTTagCompound nbt) {
		NBTTagList list = new NBTTagList();
		for(BankAccount account : getAccounts().values()) {
			if(account != null) {
				NBTTagCompound tag = new NBTTagCompound();
				account.writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		nbt.setTag("Accounts", list);
	}
}