/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import ccm.nucleum.omnium.utils.helper.ItemNBTHelper;
import ccm.trade_stuffs.inventory.slot.SlotCoins;
import ccm.trade_stuffs.items.ItemCoin;
import ccm.trade_stuffs.utils.lib.NBTConstants;

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
        addSlotToContainer(new SlotCoins(wallet, 0, 8, 29));
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
                    if (ItemNBTHelper.hasTag(stack, NBTConstants.NBT_OPENED_ITEM))
                    {
                        if (ItemNBTHelper.hasTag(stack, NBTConstants.NBT_WALLET_OPEN_FULL))
                        {
                            ItemNBTHelper.removeTag(stack, NBTConstants.NBT_WALLET_OPEN_FULL);
                        }
                        wallet.writeToNBT(stack);
                        ItemNBTHelper.removeTag(stack, NBTConstants.NBT_OPENED_ITEM);
                    }
                }
            }
        }
        if ((wallet != null) && (wallet.getStackInSlot(0) != null))
        {
            player.dropPlayerItem(wallet.getStackInSlotOnClosing(0));
        }
        super.onContainerClosed(player);
    }

    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player, final int index)
    {
        System.out.println(index);
        ItemStack stack = null;
        final Slot slot = (Slot) inventorySlots.get(index);
        if ((slot != null) && slot.getHasStack())
        {
            final ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();

            if (index < wallet.getSizeInventory())
            {
                if (!mergeItemStack(slotStack, 1, inventorySlots.size(), true))
                {
                    return null;
                }
            } else if (slotStack.getItem() instanceof ItemCoin)
            {
                if (!mergeItemStack(slotStack, 0, wallet.getSizeInventory(), false))
                {
                    return null;
                }
            }
            if (slotStack.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            } else
            {
                slot.onSlotChanged();
            }
        }
        return stack;
    }
}