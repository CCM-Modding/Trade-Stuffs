package ccm.trade_stuffs.inventory.slot;

import ccm.trade_stuffs.api.coins.CoinTypes;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCoins extends Slot {

	public SlotCoins(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return CoinTypes.getCoinType(stack) != null;
	}
}
