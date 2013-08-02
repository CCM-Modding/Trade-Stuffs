/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.Block;

import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ModBlocks
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ModBlocks
{

    public static Block tradeStation;

    public static void init()
    {
        tradeStation = new TradeStationBlock(Properties.tradeStationID);
    }
}