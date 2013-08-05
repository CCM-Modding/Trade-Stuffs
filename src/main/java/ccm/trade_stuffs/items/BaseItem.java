/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.item.Item;

import ccm.trade_stuffs.TradeStuffs;

/**
 * BaseItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BaseItem extends Item
{

    /**
     * @param id
     */
    public BaseItem(final int id)
    {
        super(id - 256);
        setCreativeTab(TradeStuffs.tradeStuffs);
    }
}