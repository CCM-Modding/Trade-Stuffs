/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ModBlocks
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ModBlocks
{

    public static TradeStationBlock tradeStation;

    public static void init()
    {
        tradeStation = new TradeStationBlock(Properties.tradeStationID);

        GameRegistry.registerBlock(tradeStation, "CCM.TRADE.BLOCK");
    }
}