/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import ccm.trade_stuffs.tileentity.TradeStation;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerTrade extends Container
{
    public ContainerTrade(final InventoryPlayer player, final TradeStation tile)
    {

    }

    @Override
    public boolean canInteractWith(final EntityPlayer player)
    {
        return true;
    }
}