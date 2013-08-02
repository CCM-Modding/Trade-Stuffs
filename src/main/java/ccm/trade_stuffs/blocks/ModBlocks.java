/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

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
        System.out.println("TradeBlock");
        tradeStation = new TradeStationBlock(Properties.tradeStationID);
    }
}