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

import ccm.trade_stuffs.inventory.ContainerWallet;
import ccm.trade_stuffs.inventory.WalletInventory;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.NBTHelper;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GUIWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GUIWallet extends GuiContainer
{
    private final WalletInventory wallet;

    /**
     * @param container
     */
    public GUIWallet(final ItemStack item, final EntityPlayer player)
    {
        super(new ContainerWallet(item, player));
        wallet = new WalletInventory(item);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y)
    {
        GL11.glColor4f(1, 1, 1, 1);

        mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_WALLET);

        final int xStart = (width - xSize) / 2;
        final int yStart = (height - ySize) / 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(final int x, final int y)
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("You have %s coin");

        fontRenderer.drawString(sb.toString(), 6, 6, 0, false);
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
                    if (NBTHelper.hasTag(stack, WalletItem.openedWallet))
                    {
                        NBTHelper.removeTag(stack, WalletItem.openedWallet);
                    }
                }
            }
        }

        super.onGuiClosed();
    }
}