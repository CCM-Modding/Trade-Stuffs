/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ccm.trade_stuffs.tileentity.TileEntityBank;

/**
 * InventoryBank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class InventoryBank extends InventoryBase {
	
	private TileEntityBank associatedBank;

	public InventoryBank() {
		super("inventory.bank", 72);
	}
	
	@Override
	public ItemStack decrStackSize(int index, int amount) {
		ItemStack ret = super.decrStackSize(index, amount);
		if(this instanceof InventoryBankCoins) {
			associatedBank.countCoins();
		} else if(this instanceof InventoryBankItems) {
			associatedBank.countItems();
		}
		return ret;
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack item) {
		boolean flag = item != null;
		super.setInventorySlotContents(index, item);
		if(flag) {
			if(this instanceof InventoryBankCoins) {
				associatedBank.countCoins();
			} else if(this instanceof InventoryBankItems) {
				associatedBank.countItems();
			}
		}
	}

	public InventoryBank setBank(TileEntityBank bank) {
		associatedBank = bank;
		return this;
	}

	@Override
	public String getInvName() {
		return associatedBank.bankName.length() > 1 ? associatedBank.bankName : "inventory.bank";
	}

	@Override
	public boolean isInvNameLocalized() {
		return associatedBank.bankName.length() > 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return (associatedBank != null) && !associatedBank.isUseableByPlayer(par1EntityPlayer) ? false : super.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public void openChest() {
		if(associatedBank != null) {
			associatedBank.openChest();
		}
		super.openChest();
	}

	@Override
	public void closeChest() {
		if(associatedBank != null) {
			associatedBank.closeChest();
		}

		super.closeChest();
		associatedBank = null;
	}
}