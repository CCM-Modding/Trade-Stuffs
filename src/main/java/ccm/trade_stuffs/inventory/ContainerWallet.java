/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.inventory.slot.InputSlot;
import ccm.trade_stuffs.inventory.slot.OutSlot;
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
    public final WalletInventory wallet;

    public ContainerWallet(final ItemStack item, final EntityPlayer player)
    {
        super(player.inventory);
        wallet = new WalletInventory(item);
        addPlayerInventory(8, 51);
        addSlotToContainer(new InputSlot(wallet, 0, 8, 29));
        addSlotToContainer(new OutSlot(wallet, 2, 152, 29));
    }

    @Override
    public void onContainerClosed(final EntityPlayer player)
    {
        if (!(player.worldObj.isRemote))
        {
            for (final ItemStack stack : player.inventory.mainInventory)
            {
                if (stack != null)
                {
                    if (NBTHelper.hasTag(stack, WalletItem.openedWallet))
                    {
                        wallet.writeToNBT(stack);
                        NBTHelper.removeTag(stack, WalletItem.openedWallet);
                    }
                }
            }
        }

        super.onContainerClosed(player);
    }

    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player, final int slot)
    {
        // Hacky crash fix :P
        return null;
    }
}