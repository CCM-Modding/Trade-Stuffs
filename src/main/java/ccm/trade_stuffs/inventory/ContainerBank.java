/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.Bank;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerBank extends ContainerBase
{
    private final Bank bank;

    public ContainerBank(final InventoryPlayer player, final Bank tile)
    {
        super(player);
        bank = tile;
    }
}