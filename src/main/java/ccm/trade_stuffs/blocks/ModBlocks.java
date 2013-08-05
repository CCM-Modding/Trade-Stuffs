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
public class ModBlocks {

	public static BlockTradeStation tradeStation;
	public static BlockBank bank;
	public static BlockSafe safe;

	public static void init() {
		tradeStation = new BlockTradeStation(Properties.tradeStationID);
		bank = new BlockBank(Properties.bankID);
		safe = new BlockSafe(Properties.safeID);

		GameRegistry.registerBlock(tradeStation, "CCM.TRADE.BLOCK");
		GameRegistry.registerBlock(bank, "CCM.BANK.BLOCK");
		GameRegistry.registerBlock(safe, "CCM.SAFE.BLOCK");
	}
}