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
public class Bank
{
    public static final String         ACCOUNT  = "CCM.BANK.ACCOUNTS";

    private final Map<String, Account> accounts;

    private static final Bank          instance = new Bank();

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

    public static Account getAccount(final String owner)
    {
        return getInstance().accounts.get(owner);
    }

    public static boolean hasAccount(final String owner)
    {
        return getInstance().accounts.containsKey(owner);
    }

    /**
     * @return the accounts
     */
    public static Map<String, Account> getAccounts()
    {
        return new HashMap<String, Account>(getInstance().accounts);
    }

    public static void readFromNBT(final NBTTagCompound nbt)
    {
        if (nbt.hasKey(ACCOUNT))
        {
            getInstance().accounts.clear();
            final NBTTagList list = nbt.getTagList(ACCOUNT);
            for (int i = 0; i < list.tagCount(); i++)
            {
                final NBTTagCompound tag = (NBTTagCompound) list.tagAt(i);
                final Account account = new Account(tag.getString(Account.OWNER));
                System.out.println("NBT TAG:");
                System.out.println(tag);
                account.readFromNBT(tag);
                addAcount(account);
            }
        }
    }

    public static void writeToNBT(final NBTTagCompound nbt)
    {
        final NBTTagList list = new NBTTagList();
        for (final Account account : getAccounts().values())
        {
            if (account != null)
            {
                final NBTTagCompound tag = new NBTTagCompound();
                account.writeToNBT(tag);
                System.out.println("NBT TAG:");
                System.out.println(tag);
                list.appendTag(tag);
                System.out.println("NBT LIST:");
                System.out.println(list);
            }
        }
        nbt.setTag(ACCOUNT, list);
        System.out.println("NBT:");
        System.out.println(nbt);
    }
}