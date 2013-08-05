/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
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
    EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
    private final TileEntitySafe   safe;
    GuiButton            enter;
    GuiButton            rest;

    /**
     * @param container
     */
    public GUISafe(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(new ContainerSafe(player, safe));
        this.safe = safe;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        buttonList.clear();
        int i = 0;
        buttonList.add(new GuiButton(i, guiLeft + 49, guiTop + 80, 20, 20, "" + i));
        i++;
        for (int column = 0; column < 3; column++)
        {
            for (int row = 0; row < 3; row++)
            {
                buttonList.add(new GuiButton(i,
                                             ((22 * row) + guiLeft) + 27,
                                             ((22 * column) + guiTop) + 14,
                                             20,
                                             20,
                                             "" + i));
                i++;
            }
        }
        enter = new GuiButton(i++, guiLeft + 27, guiTop + 80, 20, 20, "E");
        buttonList.add(enter);
        rest = new GuiButton(i, guiLeft + 71, guiTop + 80, 20, 20, "S/R");
        rest.enabled = false;
        buttonList.add(rest);
    }

    StringBuilder tmpPass = new StringBuilder();
    boolean       canOpen = false;

    @Override
    protected void actionPerformed(final GuiButton button)
    {
        if (button.id == rest.id)
        {
            reset(button);
        }
        else
        {
            pass(button);
        }
        super.actionPerformed(button);
    }

    /**
     * @param button
     */
    private void reset(final GuiButton button)
    {
        safe.setPass(" ");
        player.sendChatMessage("Your Password has been Reseted");
    }

    /**
     * @param button
     */
    private void openGUI(final GuiButton button)
    {
        if (canOpen)
        {
            player.openGui(TradeStuffs.instance,
                           Guis.GUI_SAFE_INVENTORY,
                           safe.worldObj,
                           safe.xCoord,
                           safe.yCoord,
                           safe.zCoord);
        }
    }

    private void pass(final GuiButton button)
    {
        final String pass = safe.getPass();
        /*
         * if (pass.equalsIgnoreCase(" "))
         * {
         * canOpen = true;
         * }
         */
        if (tmpPass.length() == 4)
        {
            if (pass.equalsIgnoreCase(" "))
            {
                safe.setPass(tmpPass.toString());
                tmpPass = new StringBuilder();
                player.sendChatMessage("Your Password has been Set");
                player.sendChatMessage("Please Input it again");
            }
            else
                if (pass.equalsIgnoreCase(tmpPass.toString()))
                {
                    tmpPass = new StringBuilder();
                    canOpen = true;
                    enter.enabled = canOpen;
                    rest.enabled = canOpen;
                    openGUI(button);
                }
                else
                {
                    player.sendChatMessage("Invalid Password");
                    canOpen = false;
                    tmpPass = new StringBuilder();
                }
        }
        else
        {
            if (button.id != enter.id)
            {
                tmpPass.append(button.displayString);
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