/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.tileentity.TileEntitySafe;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerSafe extends ContainerBase
{

    private final TileEntitySafe safe;

    public ContainerSafe(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(player);
        this.safe = safe;
        addPlayerInventory(8, 156);

        for (int row = 0; row < 7; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                addSlotToContainer(new Slot(safe, column + (row * 9) + 9, 8 + (column * 18), 18 + (row * 18)));
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player, final int index)
    {
        ItemStack stack = null;
        final Slot slot = (Slot) inventorySlots.get(index);

        if ((slot != null) && slot.getHasStack())
        {
            final ItemStack itemstack = slot.getStack();
            stack = itemstack.copy();
            if (index < 72)
            {
                if (!mergeItemStack(itemstack, 72, inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else
                if (!mergeItemStack(itemstack, 0, 72, false))
                {
                    return null;
                }
            if (itemstack.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return stack;
    }
}