/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ccm.trade_stuffs.inventory.slot.InputSlot;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.NBTHelper;

/**
 * ContainerWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerWallet extends ContainerBase {

	public InventoryWallet wallet;

	public ContainerWallet(ItemStack item, EntityPlayer player) {
		super(player.inventory);
		wallet = new InventoryWallet(item);
		addPlayerInventory(8, 51);
		addSlotToContainer(new InputSlot(wallet, 0, 8, 29));
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		if(!player.worldObj.isRemote) {
			for(final ItemStack stack : player.inventory.mainInventory) {
				if(stack != null) {
					if(NBTHelper.hasTag(stack, WalletItem.openedWallet)) {
						if(NBTHelper.hasTag(stack, WalletItem.fullWallet)) {
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
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		return null;
	}
}