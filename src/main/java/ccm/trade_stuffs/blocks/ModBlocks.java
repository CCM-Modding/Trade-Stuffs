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
s
    public static TradeStationBlock tradeStation;
    public static BankBlock         bank;
    public static SafeBlock         safe;

    public static void init()
    {
        tradeStation = new TradeStationBlock(Properties.tradeStationID);
        bank = new BankBlock(Properties.bankID);
        safe = new SafeBlock(Properties.safeID);

        GameRegistry.registerBlock(tradeStation, "CCM.TRADE.BLOCK");
        GameRegistry.registerBlock(bank, "CCM.BANK.BLOCK");
        GameRegistry.registerBlock(safe, "CCM.SAFE.BLOCK");
    }
}