/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

import ccm.trade_stuffs.blocks.ModBlocks;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ModItems
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ModItems
{
    public static Item     coin;

    public static Item     wallet;

    public static ItemReed tradeStation;

    public static void init()
    {
        coin = new CoinItem(Properties.coinsID);
        wallet = new WalletItem(Properties.walletID);
        tradeStation = new ItemReed(Properties.tradeStationItemID, ModBlocks.tradeStation);
    }
}