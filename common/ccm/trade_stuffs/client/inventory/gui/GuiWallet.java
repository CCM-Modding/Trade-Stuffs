/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.nucleum.omnium.utils.handler.ResourceHandler;
import ccm.nucleum.omnium.utils.helper.ItemNBTHelper;
import ccm.trade_stuffs.inventory.ContainerWallet;
import ccm.trade_stuffs.utils.lib.Guis;
import ccm.trade_stuffs.utils.lib.NBTConstants;

/**
 * GUIWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiWallet extends GuiContainer
{

    EntityPlayer player;

    /**
     * @param container
     */
    public GuiWallet(final ItemStack item, final EntityPlayer player)
    {
        super(new ContainerWallet(item, player));
        this.player = player;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        GL11.glColor4f(1, 1, 1, 1);
        ResourceHandler.bindGUI(mc, Guis.WALLET_NAME);

        final int xStart = (width - xSize) / 2;
        final int yStart = (height - ySize) / 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(final int x, final int y)
    {
        final ContainerWallet container = (ContainerWallet) inventorySlots;
        if (container != null)
        {
            if (container.wallet != null)
            {
                final StringBuilder sb = new StringBuilder();
                sb.append("You have ");
                int value = 0;
                if (container.wallet.getStackInSlot(1) != null)
                {
                    value = container.wallet.getStackInSlot(1).stackSize;
                }
                sb.append(value + " coin");
                if (value != 1)
                {
                    sb.append("s");
                }
                fontRenderer.drawString(sb.toString(), 6, 6, 0, false);
                if (value > 0)
                {
                    fontRenderer.drawString("Now go to the closest bank to ", 6, 16, 0, false);
                    fontRenderer.drawString("get your money into your ", 30, 26, 0, false);
                    fontRenderer.drawString("bank acount, Safely!", 30, 36, 0, false);
                }
            }
        }
    }

    @Override
    public void onGuiClosed()
    {
        if (mc.thePlayer != null)
        {
            for (final ItemStack stack : mc.thePlayer.inventory.mainInventory)
            {
                if (stack != null)
                {
                    if (ItemNBTHelper.hasTag(stack, NBTConstants.NBT_OPENED_ITEM))
                    {
                        if (ItemNBTHelper.hasTag(stack, NBTConstants.NBT_WALLET_OPEN_FULL))
                        {
                            ItemNBTHelper.removeTag(stack, NBTConstants.NBT_WALLET_OPEN_FULL);
                        }
                        ItemNBTHelper.removeTag(stack, NBTConstants.NBT_OPENED_ITEM);
                    }
                }
            }
        }
        super.onGuiClosed();
    }
}