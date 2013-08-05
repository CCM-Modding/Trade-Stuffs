package ccm.trade_stuffs.inventory;

import net.minecraft.inventory.InventoryBasic;
import ccm.trade_stuffs.tileentity.TileEntityBank;

public class InventoryBankCoins extends InventoryBasic {

	private TileEntityBank associatedBank;
	
	public InventoryBankCoins() {
		super("inventory.bank", false, 72);
	}
}
