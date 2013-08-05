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
public class TileEntityBank extends TileEntity implements IInventory {

	public ItemStack[] inventory = new ItemStack[72];
	
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
	
	@Override
	public int getSizeInventory() {
		return 72;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if(inventory[i] != null) {
			return inventory[i];
		}
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(inventory[slot] != null) {
			ItemStack stack;
			if(inventory[slot].stackSize <= amount) {
				stack = inventory[slot];
				inventory[slot] = null;
				onInventoryChanged();
				return stack;
			} else {
				stack = inventory[slot].splitStack(amount);
				if(inventory[slot].stackSize == 0) {
					inventory[slot] = null;
				}
				onInventoryChanged();
				return stack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(inventory[i] != null) {
			ItemStack stack = inventory[i];
			inventory[i] = null;
			return stack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 256;
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
		if(!Bank.accounts.containsKey(playerUsing)) {
			Bank.accounts.put(playerUsing, new BankAccount(playerUsing));
		}
		account = Bank.accounts.get(playerUsing);
	}

	@Override
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
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