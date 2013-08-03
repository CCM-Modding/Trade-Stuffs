/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.api.CoinTypes;
import ccm.trade_stuffs.inventory.ContainerWallet;
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
    /**
     * @param container
     */
    public GUIWallet(final ItemStack item, final EntityPlayer player)
    {
        super(new ContainerWallet(item, player));
    }

    @Override
    public void initGui()
    {
        super.initGui();

        buttonList.clear();

        buttonList.add(new GuiButton(0, guiLeft + 125, guiTop + 27, 20, 20, "+"));
        buttonList.add(new GuiButton(1, guiLeft + 98, guiTop + 27, 20, 20, "-"));
    }

    @Override
    protected void actionPerformed(final GuiButton button)
    {
        final ContainerWallet container = (ContainerWallet) inventorySlots;
        if (container != null)
        {
            if (container.wallet != null)
            {
                switch (button.id)
                {
                    case 0:

                        break;
                    case 1:

                        break;
                    default:
                        break;
                }
            }
        }
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
        final ContainerWallet container = (ContainerWallet) inventorySlots;
        if (container != null)
        {
            if (container.wallet != null)
            {
                final StringBuilder sb = new StringBuilder();
                sb.append("You have ");
                int value = 0;
                for (final ItemStack item : container.wallet.getInventory())
                {
                    if (item != null)
                    {
                        value += CoinTypes.getTypes().get(item.getItemDamage()).getValueStack(item);
                    }
                }
                sb.append(value + " coin");
                if (value != 1)
                {
                    sb.append("s");
                }
                fontRenderer.drawString(sb.toString(), 6, 6, 0, false);
                if (value > 0)
                {
                    container.wallet.hasMoney(true);
                }
                else
                {
                    container.wallet.hasMoney(false);
                }
            }
        }
        final ArrayList<String> text = new ArrayList<String>();
        if (isPointInRegion(125, 27, 20, 20, x, y))
        {
            text.add("MOAR!");
            drawHoveringText(text, 110, 64, fontRenderer);
        }
        if (isPointInRegion(98, 27, 20, 20, x, y))
        {
            text.add("Ooups less");
            drawHoveringText(text, 68, 64, fontRenderer);
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
                    if (NBTHelper.hasTag(stack, WalletItem.openedWallet))
                    {
                        if (NBTHelper.hasTag(stack, WalletItem.fullWallet))
                        {
                            NBTHelper.removeTag(stack, WalletItem.fullWallet);
                        }
                        NBTHelper.removeTag(stack, WalletItem.openedWallet);
                    }
                }
            }
        }

        super.onGuiClosed();
    }
}