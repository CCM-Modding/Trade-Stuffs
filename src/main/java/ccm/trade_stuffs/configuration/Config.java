/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.configuration;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import ccm.trade_stuffs.utils.lib.Properties;

/**
 * Config
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class Config
{

    public static void load(final FMLPreInitializationEvent event)
    {
        final Configuration config = new Configuration(event.getModConfigurationDirectory());

        Properties.coinsID = config.getItem("Coins", 4000).getInt();

        Properties.walletID = config.getItem("Wallet", 4001).getInt();

        Properties.tradeStationID = config.getBlock("TradeStation", 400).getInt();

        if (config.hasChanged())
        {
            config.save();
        }
    }
}
