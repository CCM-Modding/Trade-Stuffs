/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import ccm.trade_stuffs.bank.BankAccount;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntityBank extends TileEntity implements IInventory {

	public String bankName = "";
	
	private String playerUsing = "";
	private boolean inUse = false;
	
	@Override
	public Packet getDescriptionPacket() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(0);
			dos.writeInt(xCoord);
			dos.writeInt(yCoord);
			dos.writeInt(zCoord);

			dos.writeUTF(bankName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		packet.isChunkDataPacket = true;
		return packet;
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}
	
	@Override
	public String getInvName() {
		return bankName.length() > 1 ? bankName : "inventory.bank";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return bankName.length() > 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return !inUse;
	}

	@Override
	public void openChest() {
		inUse = true;
	}

	@Override
	public void closeChest() {
		inUse = false;
		playerUsing = "";
	}
	
	public boolean isInUse() {
		return inUse;
	}
	
	public void setInUse(boolean use) {
		inUse = use;
	}
	
	public String getPlayerUsing() {
		return playerUsing;
	}
	
	public void setPlayerUsing(String player) {
		playerUsing = player;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}