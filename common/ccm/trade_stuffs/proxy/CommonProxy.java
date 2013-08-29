/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;

/**
 * CommonProxy
 * <p>
 * 
 * @author Captain_Shadows
 */
public class CommonProxy
{

    public void initRenderingStuffs()
    {}

    public void registerTileEntitys()
    {
        GameRegistry.registerTileEntity(TileEntityTradeStation.class, "CCM.TradeStation");
        GameRegistry.registerTileEntity(TileEntityBank.class, "CCM.Bank");
        GameRegistry.registerTileEntity(TileEntitySafe.class, "CCM.Safe");
    }
}