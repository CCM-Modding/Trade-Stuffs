/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.Safe;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerSafe extends ContainerBase
{
    private final Safe safe;

    public ContainerSafe(final InventoryPlayer player, final Safe tile)
    {
        super(player);
        safe = tile;
    }
}