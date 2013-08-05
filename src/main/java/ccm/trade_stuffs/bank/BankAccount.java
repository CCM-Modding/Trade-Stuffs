package ccm.trade_stuffs.bank;

import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;

public class BankAccount
{

    public String             player;

    public InventoryBankCoins coins = new InventoryBankCoins();
    public InventoryBankItems items = new InventoryBankItems();

    public BankAccount(final String player)
    {
        this.player = player;
    }

    public void readFromNBT(final NBTTagCompound nbt)
    {
        player = nbt.getString("Player");
        coins.loadInventoryFromNBT(nbt.getTagList("Coins"));
        items.loadInventoryFromNBT(nbt.getTagList("Items"));
    }

    public void writeToNBT(final NBTTagCompound nbt)
    {
        nbt.setString("Player", player);
        nbt.setTag("Coins", coins.saveInventoryToNBT());
        nbt.setTag("Items", items.saveInventoryToNBT());
    }
}
