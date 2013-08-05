package ccm.trade_stuffs.inventory;

import ccm.trade_stuffs.utils.lib.Properties;

public class InventoryBankCoins extends InventoryBank
{

    @Override
    public int getInventoryStackLimit()
    {
        return Properties.BANK_STACKS_PER_COIN * 64;
    }
}