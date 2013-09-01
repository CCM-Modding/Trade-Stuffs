/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.inventory.ContainerTrade;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiTrade extends GuiContainer
{
    // private final TileEntityTradeStation trade;

    /**
     * @param container
     */
    public GuiTrade(final InventoryPlayer player, final TileEntityTradeStation tile)
    {
        super(new ContainerTrade(player, tile));
        // trade = tile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        // TODO Auto-generated method stub

    }
}