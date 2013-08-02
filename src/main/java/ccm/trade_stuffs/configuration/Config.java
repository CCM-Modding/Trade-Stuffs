/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.configuration;

import net.minecraftforge.common.Configuration;

import ccm.trade_stuffs.utils.lib.Properties;

/**
 * Config
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class Config
{
    public Configuration config;

    public Config(File config)
    {
        config = new Configuration(config);

        Properties.coinsID = config.getItem("Coins", 4000).getInt();

        Properties.walletID = config.getItem("Wallet", 4001).getInt();

        Properties.tradeStationID = config.getBlock("TradeStation", 400).getInt();

        if (config.hasChanged())
        {
            config.save();
        }
    }
}
