/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;

import org.lwjgl.opengl.GL11;

import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.inventory.InventoryBank;
import ccm.trade_stuffs.inventory.InventoryBankCoins;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Guis;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiBank extends GuiContainer {

	private TileEntityBank bank;
	private IInventory upperInventory;
	private IInventory lowerInventory;

	public byte selectedTab = 0;

	private ItemStack displayCoins = new ItemStack(ModItems.coin.itemID, 1, 0);
	private ItemStack displayItems = new ItemStack(Block.stone.blockID, 1, 0);

	public GuiBank(InventoryPlayer lowerInventory, InventoryBank upperInventory, TileEntityBank tile, byte tab) {
		super(new ContainerBank(lowerInventory, upperInventory, tile, tab));
		this.lowerInventory = lowerInventory;
		this.upperInventory = upperInventory;
		bank = tile;
		xSize = 176;
		ySize = 238;
		allowUserInput = false;
		selectedTab = tab;
	}
	
	@Override
	protected void drawSlotInventory(Slot slot) {
		super.drawSlotInventory(slot);
		if(slot.getStack() == null) {
			System.out.println(slot.slotNumber + ": null");
		} else {
			System.out.println(slot.slotNumber + ": " + slot.getStack().itemID + ":" + slot.getStack().getItemDamage() + " " + slot.getStack().stackSize);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);
		if((mouseX > (guiLeft - 27)) && (mouseX <= guiLeft)) {
			if((mouseY > (guiTop + 17)) && (mouseY <= (guiTop + 38))) {
				selectedTab = 0;
				sendTabUpdate();
			} else if((mouseY > (guiTop + 38)) && (mouseY <= (guiTop + 59))) {
				selectedTab = 1;
				sendTabUpdate();
			}
		}
	}

	public void sendTabUpdate() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(10);
			dos.writeInt(bank.xCoord);
			dos.writeInt(bank.yCoord);
			dos.writeInt(bank.zCoord);
			dos.writeInt(bank.worldObj.provider.dimensionId);

			dos.writeByte(selectedTab);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
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

		fontRenderer.drawString(lowerInventory.isInvNameLocalized() ? lowerInventory.getInvName() : I18n.func_135053_a(lowerInventory.getInvName()), 8, ySize - 93, 4210752);
		fontRenderer.drawString(upperInventory.isInvNameLocalized() ? upperInventory.getInvName() : I18n.func_135053_a(upperInventory.getInvName()), 8, 6, 4210752);
		fontRenderer.drawString(mc.thePlayer.username, 80, 6, 4210752);
		
		if(upperInventory instanceof InventoryBankCoins) {
			fontRenderer.drawString("Coins: " + Integer.toString(bank.getCoinBalance()), 80, ySize - 93, 4210752);
		} else if(upperInventory instanceof InventoryBankCoins) {
			fontRenderer.drawString("Items: " + Integer.toString(bank.getItemCount()), 80, ySize - 93, 4210752);
		}
	}
}