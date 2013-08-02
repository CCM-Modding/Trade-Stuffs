/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.item.Item;

import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ModItems
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ModItems
{
    public static Item coin;

    public static Item wallet;

    public static void init()
    {
        coin = new CoinItem(Properties.tradeStationID);
        wallet = new WalletItem(Properties.tradeStationID);
    }
}