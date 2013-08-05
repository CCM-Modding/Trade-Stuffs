/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.PacketDispatcher;

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
public class GuiSafe extends GuiContainer {
	private final TileEntitySafe safe;

	public byte selectedTab = 0;

	private final ItemStack displayCoins = new ItemStack(ModItems.coin, 1);
	private final ItemStack displayItems = new ItemStack(Block.stone, 1);

	public GuiSafe(final InventoryPlayer player, final TileEntitySafe safe) {
		super(new ContainerSafe(player, safe));
		this.safe = safe;
		xSize = 190;
		ySize = 221;
	}

	public void sendTabUpdate() {
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(11);
			dos.writeInt(safe.xCoord);
			dos.writeInt(safe.yCoord);
			dos.writeInt(safe.zCoord);
			dos.writeInt(safe.worldObj.provider.dimensionId);

			dos.writeByte(selectedTab);
		} catch(final Exception e) {
			e.printStackTrace();
		}
		final Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float opacity, final int mouseX, final int mouseY) {
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

		drawTexturedModalRect(guiLeft + 174, guiTop + 18, 190, 0, 8, 11);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.func_110434_K(), displayCoins, -18, 20);
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.func_110434_K(), displayItems, -18, 41);

		fontRenderer.drawString(safe.isInvNameLocalized() ? safe.getInvName() : I18n.func_135053_a(safe.getInvName()), 8, 6, 4210752);
	}
}