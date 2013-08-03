/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.utils.helper.InventoryHelper;

/**
 * WalletInventory
 * <p>
 * 
 * @author Captain_Shadows
 */
public class WalletInventory implements IInventory
{
    ItemStack[] inventory = new ItemStack[3];

    ItemStack   wallet;

    public WalletInventory(final ItemStack item)
    {
        wallet = item;
        onInventoryChanged();
        readFromNBT(wallet.getTagCompound());
    }

    @Override
    public int getSizeInventory()
    {
        return 3;
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

    @Override
    public void onInventoryChanged()
    {
        if (wallet.getTagCompound() == null)
        {
            final NBTTagCompound tag = new NBTTagCompound();
            wallet.setTagCompound(tag);
        }
        writeToNBT(wallet.getTagCompound());
    }

    public void readFromNBT(final NBTTagCompound nbt)
    {
        if (nbt.hasKey("CCM.TILE.ENTITY.INVENTORY"))
        {
            setInventory(InventoryHelper.readInventoryFromNBT(nbt.getTagList("container.inventory"),
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

    public void writeToNBT(final NBTTagCompound nbt)
    {
        nbt.setTag("CCM.TILE.ENTITY.INVENTORY", InventoryHelper.writeInventoryToNBT(inventory));
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