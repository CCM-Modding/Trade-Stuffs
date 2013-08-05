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
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        Properties.tradeStationID = config.getBlock("TradeStation", 400).getInt();

        Properties.bankID = config.getBlock("Bank", 401).getInt();

        Properties.safeID = config.getBlock("Safe", 402).getInt();

        Properties.coinsID = config.getItem("Coins", 4000).getInt();

        Properties.walletID = config.getItem("Wallet", 4001).getInt();
        String cat = "RandomConfigs";
        config.addCustomCategoryComment(cat, "Random Configurations");
        Properties.WALLET_STACKS_PER_COIN = config.get(cat, "Maximum number of stacks per type of coin inside of the wallet", 8).getInt();
        // TODO FIX COMMENT
        Properties.BANK_STACKS_PER_COIN = config.get(cat, "Maximum number of stacks per type of coin inside of the Bank", ((Integer.MAX_VALUE + 1) / 64) - 64).getInt();
        // TODO FIX COMMENT
        Properties.BANK_ITEMS_PER_ITEM = config.get(cat, "Maximum number of di", 256).getInt();
        
        cat = "CoinDrops";
        config.addCustomCategoryComment(cat, "All of the Coin Drops are set in this category");

        
        cat = "BagDrops";
        config.addCustomCategoryComment(cat, "All of the Bag Drops are set in this category");
        // TODO FIX COMMENT  
        Properties.DRAGON_DROP_CHANCE = config.get(cat, "Wallet", 4001).getDouble(1);
        Properties.DRAGON_MAX_DROP = config.get(cat, "Wallet", 2).getInt();
        Properties.DRAGON_MIN_DROP = config.get(cat, "Wallet", 2).getInt();

        if (config.hasChanged())
        {
            config.save();
        }
    }
}