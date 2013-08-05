package ccm.trade_stuffs.inventory.slot;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.inventory.InventoryBank;
import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;

public class SlotBank extends Slot {

	private InventoryBank inventory;
	
	public SlotBank(InventoryBank inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		this.inventory = inventory;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		if(inventory instanceof InventoryBankCoins) {
			return CoinTypes.getCoinType(stack) != null;
		} else if(inventory instanceof InventoryBankItems) {
			return CoinTypes.getCoinType(stack) == null;
		}
		return false;
	}
}
