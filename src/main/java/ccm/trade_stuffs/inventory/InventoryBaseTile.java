package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import ccm.trade_stuffs.utils.helper.InventoryHelper;

public abstract class InventoryBaseTile extends TileEntity implements IInventory {

	private String inventoryTitle;
	private int slotsCount;
	private ItemStack[] inventoryContents;

	public InventoryBaseTile(String name, int inventorySize) {
		inventoryTitle = name;
		slotsCount = inventorySize;
		inventoryContents = new ItemStack[inventorySize];
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int index) {
		return inventoryContents[index];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int index, int amount) {
		return InventoryHelper.decreaseStackSize(this, index, amount);
	}

	String slot = "CCM.SLOT";

	public void loadInventoryFromNBT(NBTTagList list) {
		NBTTagCompound nbt;
		for(int i = 0; i < list.tagCount(); i++) {
			nbt = (NBTTagCompound) list.tagAt(i);
			setInventorySlotContents(nbt.getInteger(slot), ItemStack.loadItemStackFromNBT(nbt));
		}
	}

	public NBTTagList saveInventoryToNBT() {
		NBTTagList list = new NBTTagList();
		NBTTagCompound nbt;
		for(int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);
			if(stack != null) {
				nbt = new NBTTagCompound();
				nbt.setInteger(slot, i);
				stack.writeToNBT(nbt);
				list.appendTag(nbt);
			}
		}
		return list;
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem - like when you close a workbench GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if(inventoryContents[index] != null) {
			ItemStack itemstack = inventoryContents[index];
			inventoryContents[index] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int index, ItemStack item) {
		inventoryContents[index] = item;

		if((item != null) && (item.stackSize > getInventoryStackLimit())) {
			item.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return slotsCount;
	}

	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInvName() {
		return inventoryTitle;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Called when an the contents of an Inventory change, usually
	 */
	@Override
	public void onInventoryChanged() {
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack item) {
		return false;
	}
}
