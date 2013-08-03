/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.items.ModItems;

/**
 * InputSlot
 * <p>
 * 
 * @author Captain_Shadows
 */
public class InputSlot extends Slot
{
    public InputSlot(final IInventory inventory, final int index, final int x, final int y)
    {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(final ItemStack item)
    {
        return item.itemID == ModItems.coin.itemID;
    }

    @Override
    public void onSlotChanged()
    {
        super.onSlotChanged();
        final ItemStack tmp = inventory.getStackInSlot(getSlotIndex());
        if (tmp != null)
        {
            final int index = 2 + tmp.getItemDamage();
            final ItemStack tmp2 = inventory.getStackInSlot(index);
            if (!(tmp2.stackSize >= tmp2.getMaxStackSize()))
            {
                if(!((tmp.stackSize + tmp2.stackSize) >= tmp2.getMaxStackSize()))
            }
        }
    }
}