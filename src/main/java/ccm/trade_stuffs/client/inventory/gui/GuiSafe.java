/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.items.ModItems;
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
    private final TileEntitySafe safe;

    public byte                  selectedTab  = 0;

    private final ItemStack      displayCoins = new ItemStack(ModItems.coin.itemID, 1, 0);
    private final ItemStack      displayItems = new ItemStack(Block.stone.blockID, 1, 0);

    public GuiSafe(final InventoryPlayer player, final TileEntitySafe safe)
    {
        super(new ContainerSafe(player, safe));
        this.safe = safe;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j)
    {
        GL11.glColor4f(1, 1, 1, 1);

        mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_BANK);

        final int xStart = (width - xSize) / 2;
        final int yStart = (height - ySize) / 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}