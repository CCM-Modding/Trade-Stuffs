/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.api.drops.EntityDrops;
import ccm.trade_stuffs.utils.lib.Archive;
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
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), );

        GameRegistry.registerItem(coin, "CCM.COIN", Archive.MOD_ID);
        GameRegistry.registerItem(wallet, "CCM.WALLET", Archive.MOD_ID);
    }
}