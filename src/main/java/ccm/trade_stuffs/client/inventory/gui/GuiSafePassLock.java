/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.inventory.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.inventory.ContainerEmpty;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * GUITrade
 * <p>
 * 
 * @author Captain_Shadows
 */
@SideOnly(Side.CLIENT)
public class GuiSafePassLock extends GuiContainer {
	
	private EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
	private TileEntitySafe safe;
	private GuiButton enter;
	private GuiButton reset;
	private StringBuilder tmpPass = new StringBuilder();
	private boolean canOpen = false;
	private String message = "";
		
	public GuiSafePassLock(InventoryPlayer player, TileEntitySafe safe) {
		super(new ContainerEmpty(player));
		this.safe = safe;
		xSize = 122;
		ySize = 112;
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int i = 0;
		buttonList.add(new GuiButton(i, guiLeft + 49, guiTop + 80, 20, 20, "" + i));
		i++;
		for(int column = 0; column < 3; column++) {
			for(int row = 0; row < 3; row++) {
				buttonList.add(new GuiButton(i, ((22 * row) + guiLeft) + 27, ((22 * column) + guiTop) + 14, 20, 20, "" + i));
				i++;
			}
		}
		enter = new GuiButton(i++, guiLeft + 27, guiTop + 80, 20, 20, "E");
		enter.enabled = false;
		buttonList.add(enter);
		reset = new GuiButton(i, guiLeft + 71, guiTop + 80, 20, 20, "S/R");
		reset.enabled = false;
		buttonList.add(reset);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == reset.id) {
			reset();
		} else if(button.id == enter.id) {
			enter();
		} else {
			enterNumber(button.displayString);
		}
		super.actionPerformed(button);
	}

	private void enterNumber(String number) {
		tmpPass.append(number);
		if(tmpPass.length() == 4) {
			enter.enabled = true;
		}
	}
	
	private void enter() {
		int password = Integer.parseInt(tmpPass.toString());
		if(safe.hasPass()) {
			if(safe.getPass() == password) {
				openGui();
			}
		} else {
			sendNewPassword(password);
		}	
		enter.enabled = false;
		tmpPass = new StringBuilder();
		//TODO:has access && password is set --> enable rest
	}
	
	private void reset() {
		sendResetPassword();
		reset.enabled = false;
	}
	
	/*private void reset(GuiButton button) {
		safe.setPass(0);
		player.sendChatMessage("Your Password has been Reseted");
	}

	private void pass(GuiButton button) {
		final int pass = safe.getPass();
		if(tmpPass.length() == 4) {
			if(pass == 0) {
				final int tmpPassword = Integer.valueOf(tmpPass.toString());
				System.out.println(tmpPassword);
				sendPassUpdate(tmpPassword);
				// safe.setPass(tmpPassword);
				tmpPass = new StringBuilder();
				player.sendChatMessage("Your Password has been Set");
				player.sendChatMessage("Please Input it again");
			} else if(pass == Integer.valueOf(tmpPass.toString())) {
				tmpPass = new StringBuilder();
				canOpen = true;
				enter.enabled = canOpen;
				rest.enabled = canOpen;
			} else {
				player.sendChatMessage("Invalid Password");
				canOpen = false;
				tmpPass = new StringBuilder();
			}
		} else {
			if(button.id != enter.id) {
				tmpPass.append(button.displayString);
			} else {
				// openGUI(button);
			}
		}
	}*/

	/*public void sendPassUpdate(int pass) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(12);
			dos.writeInt(safe.xCoord);
			dos.writeInt(safe.yCoord);
			dos.writeInt(safe.zCoord);

			dos.writeInt(pass);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.func_110434_K().func_110577_a(Guis.TEXTURE_GUI_SAFE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(!safe.hasPass()) {
			message = "Set Password";
			fontRenderer.drawString(message, guiLeft + 25, guiTop - 12, 0xFFFFFF);
		} else {
			message = "Enter Password";
			fontRenderer.drawString(message, guiLeft + 20, guiTop - 12, 0xFFFFFF);
		}
	}
	
	private void sendResetPassword() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(12);
			dos.writeInt(safe.xCoord);
			dos.writeInt(safe.yCoord);
			dos.writeInt(safe.zCoord);
			dos.writeInt(safe.worldObj.provider.dimensionId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}
	
	private void sendNewPassword(int password) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(13);
			dos.writeInt(safe.xCoord);
			dos.writeInt(safe.yCoord);
			dos.writeInt(safe.zCoord);
			dos.writeInt(safe.worldObj.provider.dimensionId);
			dos.writeInt(password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}
	
	private void openGui() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(14);
			dos.writeInt(safe.xCoord);
			dos.writeInt(safe.yCoord);
			dos.writeInt(safe.zCoord);
			dos.writeInt(safe.worldObj.provider.dimensionId);
			dos.writeUTF(mc.thePlayer.username);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}
}