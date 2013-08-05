/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.api.CoinTypes;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.InventoryHelper;
import ccm.trade_stuffs.utils.helper.NBTHelper;

/**
 * WalletInventory
 * <p>
 * 
 * @author Captain_Shadows
 */
public class WalletInventory implements IInventory
{
    ItemStack[]      inventory = new ItemStack[CoinTypes.getTypes().size() + 1];

    public ItemStack wallet;

    // TODO: fix this class
    public WalletInventory(final ItemStack item)
    {
        wallet = item;
        readFromNBT(item, item.getTagCompound());
    }

    public void hasMoney(final boolean has)
    {
        NBTHelper.setBoolean(wallet, WalletItem.fullWallet, has);
    }

    @Override
    public int getSizeInventory()
    {
        return CoinTypes.getTypes().size() + 1;
    }

    @Override
    public ItemStack decrStackSize(final int slot, final int amount)
    {
        return InventoryHelper.decreaseStackSize(this, slot, amount);
    }

    @Override
    public ItemStack getStackInSlot(final int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int slot)
    {
        if (inventory[slot] != null)
        {
            final ItemStack tmp = inventory[slot];
            inventory[slot] = null;
            return tmp;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(final int slot, final ItemStack item)
    {
        inventory[slot] = item;
    }

    @Override
    public String getInvName()
    {
        return wallet.hasDisplayName() ? wallet.getDisplayName() : "inventory.wallet";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return wallet.hasDisplayName();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public ItemStack[] getInventory()
    {
        return inventory;
    }

    @Override
    public void onInventoryChanged()
    {}

    public static final String INVENTORY_WALLET = "CCM.WALLET.INVENTORY";

    public void readFromNBT(final ItemStack item, final NBTTagCompound nbt)
    {
        NBTHelper.initCompound(item);
        System.out.println(nbt);
        if (NBTHelper.hasTag(item, INVENTORY_WALLET))
        {
            setInventory(InventoryHelper.readInventoryFromNBT(nbt.getTagList(INVENTORY_WALLET),
                                                              getSizeInventory()));
        }
    }

    /**
     * @param readInventoryFromNBT
     */
    private void setInventory(final ItemStack[] inventory)
    {
        this.inventory = inventory;
    }

    public void writeToNBT(final ItemStack item)
    {
        NBTTagCompound tag = item.getTagCompound();
        if (tag == null)
        {
            tag = new NBTTagCompound();
        }
        tag.setTag(INVENTORY_WALLET, InventoryHelper.writeInventoryToNBT(inventory));
        item.setTagCompound(tag);
        System.out.println(tag);
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public void openChest()
    {}

    @Override
    public void closeChest()
    {}

    @Override
    public boolean isItemValidForSlot(final int slot, final ItemStack item)
    {
        return false;
    }
}