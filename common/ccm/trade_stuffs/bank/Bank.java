/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.bank;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Bank
{
    private static Bank instance = new Bank();

    private final HashMap<String, BankAccount> accounts;

    private Bank()
    {
        accounts = new HashMap<String, BankAccount>();
    }

    public static Bank getInstance()
    {
        return instance;
    }

    public static void addAcount(final BankAccount acc)
    {
        getInstance().accounts.put(acc.getOwner(), acc);
    }

    public static BankAccount getAccount(final String owner)
    {
        return getInstance().accounts.get(owner);
    }

    public static boolean hasAccount(final String owner)
    {
        return getInstance().accounts.containsKey(owner);
    }

    public static HashMap<String, BankAccount> getAccounts()
    {
        return new HashMap<String, BankAccount>(getInstance().accounts);
    }

    public static void readFromNBT(final NBTTagCompound nbt)
    {
        if (nbt.hasKey("Accounts"))
        {
            getInstance().accounts.clear();
            final NBTTagList list = nbt.getTagList("Accounts");
            for (int i = 0; i < list.tagCount(); i++)
            {
                final NBTTagCompound tag = (NBTTagCompound) list.tagAt(i);
                final BankAccount account = new BankAccount(tag.getString("Owner"));
                account.readFromNBT(tag);
                addAcount(account);
            }
        }
    }

    public static void writeToNBT(final NBTTagCompound nbt)
    {
        final NBTTagList list = new NBTTagList();
        for (final BankAccount account : getAccounts().values())
        {
            if (account != null)
            {
                final NBTTagCompound tag = new NBTTagCompound();
                account.writeToNBT(tag);
                list.appendTag(tag);
            }
        }
        nbt.setTag("Accounts", list);
    }
}