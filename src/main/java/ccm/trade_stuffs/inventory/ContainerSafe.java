/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.TileEntitySafe;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerSafe extends ContainerBase
{
    private final TileEntitySafe safe;

    public ContainerSafe(final InventoryPlayer player, final TileEntitySafe tile)
    {
        super(player);
        safe = tile;
    }
}