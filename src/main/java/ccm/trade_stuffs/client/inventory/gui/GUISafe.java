/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.tileentity.Safe;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GUISafe extends GuiContainer
{
    private final Safe safe;

    /**
     * @param container
     */
    public GUISafe(final InventoryPlayer player, final Safe tile)
    {
        super(new ContainerSafe(player, tile));
        safe = tile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        // TODO Auto-generated method stub

    }
}