/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.tileentity.Bank;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GUIBank extends GuiContainer
{
    private final Bank bank;

    /**
     * @param container
     */
    public GUIBank(final InventoryPlayer player, final Bank tile)
    {
        super(new ContainerBank(player, tile));
        bank = tile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        // TODO Auto-generated method stub

    }
}