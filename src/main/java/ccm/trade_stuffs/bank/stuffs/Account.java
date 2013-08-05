/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.bank.stuffs;

import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;

/**
 * Account
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Account
{
    private String                   player;

    private final InventoryBankCoins coins;
    private final InventoryBankItems items;

    public static final String       OWNER = "CCM.ACCOUNT.OWNER";
    public static final String       COINS = "CCM.ACCOUNT.COINS";
    public static final String       ITEMS = "CCM.ACCOUNT.ITEMS";

    public Account(final String player)
    {
        this.player = player;
        coins = new InventoryBankCoins();
        items = new InventoryBankItems();
    }

    public void readFromNBT(final NBTTagCompound nbt)
    {
        player = nbt.getString(OWNER);
        coins.loadInventoryFromNBT(nbt.getTagList(COINS));
        items.loadInventoryFromNBT(nbt.getTagList(ITEMS));
    }

    public void writeToNBT(final NBTTagCompound nbt)
    {
        nbt.setString(OWNER, player);
        nbt.setTag(COINS, coins.saveInventoryToNBT());
        nbt.setTag(ITEMS, items.saveInventoryToNBT());
    }

    /**
     * @return
     */
    public String getOwner()
    {
        return player;
    }
}
