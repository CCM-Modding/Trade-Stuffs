/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.util.HashMap;

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
}