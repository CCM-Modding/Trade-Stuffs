/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.TileEntityTradeStation;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerTrade extends ContainerBase
{
    private final TileEntityTradeStation trade;

    public ContainerTrade(final InventoryPlayer player, final TileEntityTradeStation tile)
    {
        super(player);
        trade = tile;
    }
}