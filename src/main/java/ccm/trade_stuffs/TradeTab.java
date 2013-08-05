/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import ccm.trade_stuffs.items.ModItems;

/**
 * TradeTab
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeTab extends CreativeTabs
{
    public TradeTab()
    {
        super("Trade_Stuffs");
    }

    @Override
    public Item getTabIconItem()
    {
        return ModItems.coin;
    }
}