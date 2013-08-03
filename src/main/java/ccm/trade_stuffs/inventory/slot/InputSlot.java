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
        final ItemStack input = getStack();
        if (input != null)
        {
            final int indexed = input.getItemDamage() + 2;
            final int inputSize = input.stackSize;
            final ItemStack current = inventory.getStackInSlot(indexed);
            if (current != null)
            {
                final int currentSize = current.stackSize;
                if ((inputSize + currentSize) > current.getMaxStackSize())
                {
                    if (currentSize != current.getMaxStackSize())
                    {
                        int tmp = inputSize + currentSize;
                        tmp -= current.getMaxStackSize();
                        System.out.println(tmp);
                    }
                }
                else
                {
                    inventory.setInventorySlotContents(getSlotIndex(), null);
                    current.stackSize += inputSize;
                    inventory.setInventorySlotContents(indexed, current);
                }
            }
            else
            {

            }
        }
    }
}