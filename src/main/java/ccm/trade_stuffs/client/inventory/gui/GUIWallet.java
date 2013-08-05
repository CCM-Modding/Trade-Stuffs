/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import ccm.trade_stuffs.inventory.ContainerWallet;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.NBTHelper;
import ccm.trade_stuffs.utils.lib.Guis;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * GUIWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiWallet extends GuiContainer {
	
	EntityPlayer player;

	/**
	 * @param container
	 */
	public GuiWallet(final ItemStack item, final EntityPlayer player) {
		super(new ContainerWallet(item, player));
		this.player = player;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float opacity, final int x, final int y) {
		GL11.glColor4f(1, 1, 1, 1);

		mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_WALLET);

		final int xStart = (width - xSize) / 2;
		final int yStart = (height - ySize) / 2;
		drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int x, final int y) {
		final ContainerWallet container = (ContainerWallet) inventorySlots;
		if(container != null) {
			if(container.wallet != null) {
				final StringBuilder sb = new StringBuilder();
				sb.append("You have ");
				int value = 0;
				if(container.wallet.getStackInSlot(1) != null) {
					value = container.wallet.getStackInSlot(1).stackSize;
				}
				sb.append(value + " coin");
				if(value != 1) {
					sb.append("s");
				}
				fontRenderer.drawString(sb.toString(), 6, 6, 0, false);
				if(value > 0) {
					fontRenderer.drawString("Now go to the closest bank to ", 6, 16, 0, false);
					fontRenderer.drawString("get your money into your ", 30, 26, 0, false);
					fontRenderer.drawString("bank acount, Safely!", 30, 36, 0, false);
				}
			}
		}
	}

	@Override
	public void onGuiClosed() {
		if(mc.thePlayer != null) {
			for(final ItemStack stack : mc.thePlayer.inventory.mainInventory) {
				if(stack != null) {
					if(NBTHelper.hasTag(stack, WalletItem.openedWallet)) {
						if(NBTHelper.hasTag(stack, WalletItem.fullWallet)) {
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