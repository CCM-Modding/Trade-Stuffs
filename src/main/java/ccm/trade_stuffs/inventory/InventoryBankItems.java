package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Properties;

public class InventoryBankItems extends InventoryBasic {

	private TileEntityBank associatedBank;
	
	public InventoryBankItems() {
		super("inventory.bank", false, 72);
	}
	
	@Override
	public int getInventoryStackLimit() {
		return Properties.BANK_ITEMS_PER_ITEM;
	}
	
	@Override
	public String getInvName() {
		return associatedBank.bankName.length() > 1 ? associatedBank.bankName : "inventory.bank";
	}

	@Override
	public boolean isInvNameLocalized() {
		return associatedBank.bankName.length() > 1;
	}

	public void loadInventoryFromNBT(NBTTagList list) {
		for(int i = 0; i < getSizeInventory(); ++i) {
			setInventorySlotContents(i, (ItemStack) null);
		}
		for(int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound nbttagcompound = (NBTTagCompound) list.tagAt(i);
			int j = nbttagcompound.getByte("Slot") & 255;
			if(j >= 0 && j < getSizeInventory()) {
				setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound));
			}
		}
	}

	public NBTTagList saveInventoryToNBT() {
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < getSizeInventory(); ++i) {
			ItemStack stack = getStackInSlot(i);
			if(stack != null) {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte) i);
				stack.writeToNBT(nbttagcompound);
				list.appendTag(nbttagcompound);
			}
		}
		return list;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return associatedBank != null && !associatedBank.isUseableByPlayer(par1EntityPlayer) ? false : super.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return CoinTypes.getCoinType(stack) != null;
	}

	public void openChest() {
		if(associatedBank != null) {
			associatedBank.openChest();
		}
		super.openChest();
	}

	public void closeChest() {
		if(associatedBank != null) {
			associatedBank.closeChest();
		}

		super.closeChest();
		associatedBank = null;
	}
}
