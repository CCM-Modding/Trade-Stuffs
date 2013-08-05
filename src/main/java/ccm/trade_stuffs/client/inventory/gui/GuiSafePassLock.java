/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.inventory.ContainerEmpty;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiSafePassLock extends GuiContainer
{
    EntityClientPlayerMP         player = Minecraft.getMinecraft().thePlayer;
    private final TileEntitySafe safe;
    GuiButton                    enter;
    GuiButton                    rest;

    /**
     * @param container
     */
    public GuiSafePassLock(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(new ContainerEmpty(player));
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
        safe.setPass(0);
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
        final int pass = safe.getPass();
        if (tmpPass.length() == 4)
        {
            if (pass == 0)
            {
                final int tmpPassword = Integer.valueOf(tmpPass.toString());
                System.out.println(tmpPassword);
                sendPassUpdate(tmpPassword);
                // safe.setPass(tmpPassword);
                tmpPass = new StringBuilder();
                player.sendChatMessage("Your Password has been Set");
                player.sendChatMessage("Please Input it again");
            }
            else
                if (pass == Integer.valueOf(tmpPass.toString()))
                {
                    tmpPass = new StringBuilder();
                    canOpen = true;
                    enter.enabled = canOpen;
                    rest.enabled = canOpen;
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
            else
            {
                // openGUI(button);
            }
        }
    }

    public void sendPassUpdate(final int pass)
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(12);
            dos.writeInt(safe.xCoord);
            dos.writeInt(safe.yCoord);
            dos.writeInt(safe.zCoord);

            dos.writeInt(pass);
        } catch (final Exception e)
        {
            e.printStackTrace();
        }
        final Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "TradeStuffs";
        packet.data = bos.toByteArray();
        packet.length = bos.size();
        PacketDispatcher.sendPacketToServer(packet);
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