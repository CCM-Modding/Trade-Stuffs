package ccm.trade_stuffs.inventory;

import net.minecraft.inventory.InventoryBasic;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Properties;

public class InventoryBankItems extends InventoryBasic {

	private TileEntityBank associatedBank;
	
	public InventoryBankItems() {
		super("inventory.bank", false, 72);
	}
	
	@Override
	public int getInventoryStackLimit() {
		return Properties.BANK_ITEMS_PER_ITEM;
	}
}
