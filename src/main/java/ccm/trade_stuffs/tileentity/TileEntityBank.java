/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.bank.Bank;
import ccm.trade_stuffs.bank.BankAccount;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntityBank extends TileEntity {
	
	public String bankName = "";
	
	private String playerUsing = "";
	private boolean inUse = false;
	private byte selectedTab = 0;
	
	public BankAccount account;
	
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
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		return !inUse;
	}

	public void openChest() {
		inUse = true;
		if(!Bank.accounts.containsKey(playerUsing)) {
			Bank.accounts.put(playerUsing, new BankAccount(playerUsing));
		}
		account = Bank.accounts.get(playerUsing);
	}

	public void closeChest() {
		inUse = false;
		playerUsing = "";
		account = null;
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
	
	public void setSelectedTab(byte tab) {
		selectedTab = tab;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		bankName = nbt.getString("BankName");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("BankName", bankName);
	}
}