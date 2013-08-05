/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.inventory.InventoryBankItems;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GuiSafe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class GuiSafe extends GuiContainer {
	
	private InventoryPlayer inventoryPlayer;
	private TileEntitySafe safe;

	private ItemStack displayCoins = new ItemStack(ModItems.coin, 1);
	private ItemStack displayItems = new ItemStack(Block.stone, 1);

	public GuiSafe(InventoryPlayer player, TileEntitySafe safe) {
		super(new ContainerSafe(player, safe));
		inventoryPlayer = player;
		this.safe = safe;
		xSize = 176;
		ySize = 238;
		allowUserInput = false;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int mouseX, int mouseY) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_BANK);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRenderer.drawString(inventoryPlayer.isInvNameLocalized() ? inventoryPlayer.getInvName() : I18n.func_135053_a(inventoryPlayer.getInvName()), 8, ySize - 93, 4210752);
		fontRenderer.drawString(safe.isInvNameLocalized() ? safe.getInvName() : I18n.func_135053_a(safe.getInvName()), 8, 6, 4210752);
		fontRenderer.drawString(mc.thePlayer.username, 80, 6, 4210752);
		
		fontRenderer.drawString("Items: " + Integer.toString(safe.getItemCount()), 80, ySize - 93, 4210752);
	}
}