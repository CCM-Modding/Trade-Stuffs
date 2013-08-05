package ccm.trade_stuffs.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.api.coins.CoinTypes;

public class SlotCoins extends Slot
{

    public SlotCoins(final IInventory inventory, final int id, final int x, final int y)
    {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(final ItemStack stack)
    {
        return CoinTypes.getCoinType(stack) != null;
    }
}
