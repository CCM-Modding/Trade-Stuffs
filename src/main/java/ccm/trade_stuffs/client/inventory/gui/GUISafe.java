/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.tileentity.Safe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GUISafe extends GuiContainer
{
    /**
     * @param container
     */
    public GUISafe(final InventoryPlayer player, final Safe tile)
    {
        super(new ContainerSafe(player, tile));
    }

    @Override
    public void initGui()
    {
        super.initGui();
        buttonList.clear();
        int i = 0;
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                buttonList.add(new GuiButton(i,
                                             ((22 * row) + guiLeft) + 27,
                                             ((22 * column) + guiTop) + 38,
                                             20,
                                             20,
                                             "" + i));
                i += 1;
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        GL11.glColor4f(1, 1, 1, 1);

        mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_SAFE);

        final int xStart = (width - xSize) / 2;
        final int yStart = (height - ySize) / 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}