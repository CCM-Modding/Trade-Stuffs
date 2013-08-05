/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.bank.stuffs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import ccm.trade_stuffs.bank.BankAccount;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Bank
{
    public static final String       ACCOUNT = "CCM.BANK.ACCOUNTS";
    
    private Map<String, Account> accounts 

    private static final Bank   instance = new Bank();

    private Bank()
    {
        accounts = new HashMap<String, Account>();
    }

    public static Bank getInstance()
    {
        return instance;
    }
    
    public static void addAcount(final Account acc)
    {
        getInstance().accounts.put(acc.getOwner(), acc);
    }
    
    public static Account getAccount(final String owner){
        return getInstance().accounts.get(owner);
    }
    
    /**
     * @return the accounts
     */
    public Map<String, Account> getAccounts()
    {
        return new HashMap<String, Account>(accounts);
    }

    public static void readFromNBT(final NBTTagCompound nbt) {
        accounts = new HashMap<String, BankAccount>();
        if(nbt.hasKey(ACCOUNT)) {
                final NBTTagList list = nbt.getTagList(ACCOUNT);
                for(int i = 0 ; i < list.tagCount(); i++) {
                        final NBTTagCompound tag = (NBTTagCompound) list.tagAt(i);
                        final BankAccount account = new BankAccount(tag.getString("Player"));
                        account.readFromNBT(tag);
                        accounts.put(account.player, account);
                }
        }
}

public static void writeToNBT(final NBTTagCompound nbt) {
        final NBTTagList list = new NBTTagList();
        for(final BankAccount account : accounts.values()) {
                if(account != null) {
                        final NBTTagCompound tag = new NBTTagCompound();
                        account.writeToNBT(tag);
                        list.appendTag(tag);
                }
        }
        nbt.setTag(ACCOUNT, list);
}
}