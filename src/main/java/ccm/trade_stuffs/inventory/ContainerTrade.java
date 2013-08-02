/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.TradeStation;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerTrade extends ContainerBase
{
    private final TradeStation trade;

    public ContainerTrade(final InventoryPlayer player, final TradeStation tile)
    {
        super(player);
        trade = tile;
    }
}