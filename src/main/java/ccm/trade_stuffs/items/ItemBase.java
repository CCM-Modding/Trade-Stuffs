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
public class ItemBase extends Item
{

    /**
     * @param id
     */
    public ItemBase(final int id)
    {
        super(id - 256);
        setCreativeTab(TradeStuffs.tab);
    }
}