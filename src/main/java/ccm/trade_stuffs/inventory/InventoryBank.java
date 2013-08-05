/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;

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