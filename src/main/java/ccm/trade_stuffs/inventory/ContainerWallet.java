/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.inventory.slot.InputSlot;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.FunctionHelper;
import ccm.trade_stuffs.utils.helper.NBTHelper;

/**
 * ContainerWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerWallet extends ContainerBase
{
    private final WalletInventory wallet;

    public ContainerWallet(final EntityPlayer player)
    {
        super(player.inventory);
        wallet = new WalletInventory(FunctionHelper.getCurrentItem(player, new ItemStack(ModItems.wallet)));
        addPlayerInventory(8, 51);
        addSlotToContainer(new InputSlot(wallet, 0, 8, 29));
        addSlotToContainer(new InputSlot(wallet, 2, 152, 29));
        wallet.onInventoryChanged();
    }

    @Override
    public void onContainerClosed(final EntityPlayer player)
    {
        super.onContainerClosed(player);

        if (!(player.worldObj.isRemote))
        {
            for (final ItemStack stack : player.inventory.mainInventory)
            {
                if (stack != null)
                {
                    if (NBTHelper.hasTag(stack, WalletItem.openedWallet))
                    {
                        NBTHelper.removeTag(stack, WalletItem.openedWallet);
                    }
                }
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player, final int slot)
    {
        // Hacky crash fix :P
        wallet.onInventoryChanged();
        return null;
    }
}