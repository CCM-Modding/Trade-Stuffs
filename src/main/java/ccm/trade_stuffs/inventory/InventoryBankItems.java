package ccm.trade_stuffs.inventory;

import ccm.trade_stuffs.utils.lib.Properties;

public class InventoryBankItems extends InventoryBank
{

    @Override
    public int getInventoryStackLimit()
    {
        return Properties.BANK_ITEMS_PER_ITEM;
    }
}