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

import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Guis;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GUIBank extends GuiContainer {

	private TileEntityBank bank;
	
	public int selectedTab = 0;
	
	private ItemStack displayCoins = new ItemStack(ModItems.coin.itemID, 1, 0);
	private ItemStack displayItems  = new ItemStack(Block.stone.blockID, 1, 0);

	public GUIBank(InventoryPlayer player, TileEntityBank tile) {
		super(new ContainerBank(player, tile));
		bank = tile;
		xSize = 190;
		ySize = 221;
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);
		if(mouseX > guiLeft - 27 && mouseX <= guiLeft) {
			if(mouseY > guiTop + 17 && mouseY <= guiTop + 38) {
				selectedTab = 0;
			} else if(mouseY > guiTop + 38 && mouseY <= guiTop + 59) {
				selectedTab = 1;
			}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int mouseX, int mouseY) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_BANK);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(selectedTab == 0) {
			drawTexturedModalRect(guiLeft - 24, guiTop + 17, 229, 0, 27, 21);
		} else {
			drawTexturedModalRect(guiLeft - 24, guiTop + 17, 229, 21, 27, 21);
		}
		if(selectedTab == 1) {
			drawTexturedModalRect(guiLeft - 24, guiTop + 17 + 21, 229, 0, 27, 21);
		} else {
			drawTexturedModalRect(guiLeft - 24, guiTop + 17 + 21, 229, 21, 27, 21);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.func_110434_K(), displayCoins, -18, 20);
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.func_110434_K(), displayItems, -18, 41);
		
		fontRenderer.drawString(bank.isInvNameLocalized() ? bank.getInvName() : I18n.func_135053_a(bank.getInvName()), 8, 6, 4210752);
	}
}