/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * TradeStation
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStation extends TileEntity implements IInventory
{

    private ItemStack[] inventory;

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(final int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(final int slot, final int amount)
    {
        if (inventory[slot] != null)
        {
            ItemStack itemStack;
            if (inventory[slot].stackSize <= amount)
            {
                itemStack = inventory[slot];
                inventory[slot] = null;
                onInventoryChanged();
            } else
            {
                itemStack = inventory[slot].splitStack(amount);
                if (inventory[slot].stackSize == 0)
                {
                    inventory[slot] = null;
                }
                onInventoryChanged();
            }
            return itemStack;
        } else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int slot)
    {
        if (inventory[slot] != null)
        {

        }
    }

    @Override
    public void setInventorySlotContents(final int i, final ItemStack itemstack)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName()
    {
        return null;
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer player)
    {
        return player.getDistance(xCoord, yCoord, yCoord) <= 10;
    }

    @Override
    public boolean isItemValidForSlot(final int i, final ItemStack itemstack)
    {
        return false;
    }

    @Override
    public void openChest()
    {}

    @Override
    public void closeChest()
    {}
}