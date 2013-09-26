/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import ccm.nucleum.omnium.utils.handler.ResourceHandler;
import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GuiSafe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class GuiSafe extends GuiContainer
{

    private final InventoryPlayer inventoryPlayer;
    private final TileEntitySafe safe;

    // private final ItemStack displayCoins = new ItemStack(ModItems.coin, 1);
    // private final ItemStack displayItems = new ItemStack(Block.stone, 1);

    public GuiSafe(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(new ContainerSafe(player, safe));
        inventoryPlayer = player;
        this.safe = safe;
        xSize = 176;
        ySize = 238;
        allowUserInput = false;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float opacity, final int mouseX, final int mouseY)
    {
        GL11.glColor4f(1, 1, 1, 1);
        ResourceHandler.bindGUI(mc, Guis.SAFE_NAME);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY)
    {
        fontRenderer.drawString(inventoryPlayer.isInvNameLocalized() ? inventoryPlayer.getInvName() : I18n.getStringParams(inventoryPlayer.getInvName()), 8, ySize - 93, 4210752);
        fontRenderer.drawString(safe.isInvNameLocalized() ? safe.getInvName() : I18n.getStringParams(safe.getInvName()), 8, 6, 4210752);
        fontRenderer.drawString(mc.thePlayer.username, 80, 6, 4210752);

        fontRenderer.drawString("Items: " + Integer.toString(safe.getItemCount()), 80, ySize - 93, 4210752);
    }
}