/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ccm.trade_stuffs.bank.BankAccount;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Bank extends BaseInventory {

	public HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();
	
	@Override
	public String getInvName() {
		return "inventory.bank";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
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
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
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