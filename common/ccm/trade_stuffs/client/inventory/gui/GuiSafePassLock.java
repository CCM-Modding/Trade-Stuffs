/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.nucleum.omnium.utils.handler.ResourceHandler;
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
    // private final EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
    private final TileEntitySafe safe;
    private GuiButton enter;
    private GuiButton reset;
    private GuiButton open;
    private StringBuilder tmpPass = new StringBuilder();
    // private final boolean canOpen = false;
    private String message = "";

    public GuiSafePassLock(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(new ContainerEmpty(player));
        this.safe = safe;
        xSize = 122;
        ySize = 112;
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
                buttonList.add(new GuiButton(i, ((22 * row) + guiLeft) + 27, ((22 * column) + guiTop) + 14, 20, 20, "" + i));
                i++;
            }
        }
        enter = new GuiButton(i++, guiLeft + 27, guiTop + 80, 20, 20, "E");
        enter.enabled = false;
        buttonList.add(enter);
        reset = new GuiButton(i++, guiLeft + 71, guiTop + 80, 20, 20, "S/R");
        reset.enabled = false;
        buttonList.add(reset);
        open = new GuiButton(i++, guiLeft + 41, guiTop + 114, 40, 20, "Open");
        open.drawButton = false;
        open.enabled = false;
        buttonList.add(open);
    }

    @Override
    protected void actionPerformed(final GuiButton button)
    {
        if (button.id == reset.id)
        {
            reset();
        } else if (button.id == enter.id)
        {
            enter();
        } else if (button.id == open.id)
        {
            openGui();
        } else
        {
            enterNumber(button.displayString);
        }
        super.actionPerformed(button);
    }

    private void enterNumber(final String number)
    {
        if (tmpPass.length() < 4)
        {
            tmpPass.append(number);
        }
        if (tmpPass.length() == 4)
        {
            enter.enabled = true;
        }
    }

    private void enter()
    {
        final int password = Integer.parseInt(tmpPass.toString());
        if (safe.hasPass())
        {
            if (safe.getPass() == password)
            {
                open.drawButton = true;
                open.enabled = true;
                reset.enabled = true;
            }
        } else
        {
            sendNewPassword(password);
        }
        enter.enabled = false;
        tmpPass = new StringBuilder();

    }

    private void reset()
    {
        open.drawButton = false;
        open.enabled = false;
        sendResetPassword();
        reset.enabled = false;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        GL11.glColor4f(1, 1, 1, 1);
        ResourceHandler.bindGUI(mc, Guis.SAFE_LOCK_NAME);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (!safe.hasPass())
        {
            message = "Set Password";
            fontRenderer.drawString(message, guiLeft + 25, guiTop - 12, 0xFFFFFF);
        } else
        {
            message = "Enter Password";
            fontRenderer.drawString(message, guiLeft + 20, guiTop - 12, 0xFFFFFF);
        }
    }

    private void sendResetPassword()
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(12);
            dos.writeInt(safe.xCoord);
            dos.writeInt(safe.yCoord);
            dos.writeInt(safe.zCoord);
            dos.writeInt(safe.worldObj.provider.dimensionId);
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

    private void sendNewPassword(final int password)
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(13);
            dos.writeInt(safe.xCoord);
            dos.writeInt(safe.yCoord);
            dos.writeInt(safe.zCoord);
            dos.writeInt(safe.worldObj.provider.dimensionId);
            dos.writeInt(password);
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

    private void openGui()
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(14);
            dos.writeInt(safe.xCoord);
            dos.writeInt(safe.yCoord);
            dos.writeInt(safe.zCoord);
            dos.writeInt(safe.worldObj.provider.dimensionId);
            dos.writeUTF(mc.thePlayer.username);
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
}