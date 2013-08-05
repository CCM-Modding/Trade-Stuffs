/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.inventory.slot.SlotInput;
import ccm.trade_stuffs.items.CoinItem;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.NBTHelper;

/**
 * ContainerWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerWallet extends ContainerBase
{

    public InventoryWallet wallet;

    public ContainerWallet(final ItemStack item, final EntityPlayer player)
    {
        super(player.inventory);
        wallet = new InventoryWallet(item);
        addPlayerInventory(8, 51);
        addSlotToContainer(new SlotInput(wallet, 0, 8, 29));
    }

    @Override
    public void onContainerClosed(final EntityPlayer player)
    {
        if (!player.worldObj.isRemote)
        {
            for (final ItemStack stack : player.inventory.mainInventory)
            {
                if (stack != null)
                {
                    if (NBTHelper.hasTag(stack, WalletItem.openedWallet))
                    {
                        if (NBTHelper.hasTag(stack, WalletItem.fullWallet))
                        {
                            NBTHelper.removeTag(stack, WalletItem.fullWallet);
                        }
                        wallet.writeToNBT(stack);
                        NBTHelper.removeTag(stack, WalletItem.openedWallet);
                    }
                }
            }
        }
        super.onContainerClosed(player);
    }

    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player, final int index)
    {
        ItemStack stack = null;
        final Slot slot = (Slot) inventorySlots.get(index);
        if ((slot != null) && slot.getHasStack())
        {
            final ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();
            if (index < wallet.getSizeInventory())
            {
                if (!mergeItemStack(slotStack, wallet.getSizeInventory(), inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else
                if (slotStack.getItem() instanceof CoinItem)
                {
                    if (!mergeItemStack(slotStack, 0, 0, false))
                    {
                        return null;
                    }
                }
            if (slotStack.stackSize == 0)
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