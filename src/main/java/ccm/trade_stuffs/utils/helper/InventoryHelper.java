/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * InventoryHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class InventoryHelper
{
    public static final String slot = "CCM.SLOT";

    public static NBTTagList writeInventoryToNBT(final ItemStack[] stacks)
    {
        final NBTTagList list = new NBTTagList();
        NBTTagCompound nbt;
        for (int i = 0; i < stacks.length; i++)
        {
            if (stacks[i] == null)
            {
                continue;
            }
            nbt = new NBTTagCompound();
            nbt.setInteger(slot, i);
            stacks[i].writeToNBT(nbt);
            list.appendTag(nbt);
        }
        return list;
    }

    public static ItemStack[] readInventoryFromNBT(final NBTTagList list, final int size)
    {
        final ItemStack[] stacks = new ItemStack[size];
        NBTTagCompound nbt;
        for (int i = 0; i < list.tagCount(); i++)
        {
            nbt = (NBTTagCompound) list.tagAt(i);
            stacks[nbt.getInteger(slot)] = ItemStack.loadItemStackFromNBT(nbt);
        }
        return stacks;
    }

    public static ItemStack decreaseStackSize(final IInventory inventory, final int slot, final int amount)
    {
        if (inventory.getStackInSlot(slot) != null)
        {
            ItemStack itemStack;
            if (inventory.getStackInSlot(slot).stackSize <= amount)
            {
                itemStack = inventory.getStackInSlot(slot);
                inventory.setInventorySlotContents(slot, null);
            }
            else
            {
                itemStack = inventory.getStackInSlot(slot).splitStack(amount);
                if (inventory.getStackInSlot(slot).stackSize == 0)
                {
                    inventory.setInventorySlotContents(slot, null);
                }
            }
            inventory.onInventoryChanged();
            return itemStack;
        }
        return null;
    }
    
    public static boolean areItemStacksEqualWithoutSize(ItemStack stack1, ItemStack stack2) {
		return stack1.itemID != stack2.itemID ? false : (stack1.getItemDamage() != stack2.getItemDamage() ? false : (stack1.stackTagCompound == null && stack2.stackTagCompound != null ? false : stack1.stackTagCompound == null || stack1.stackTagCompound.equals(stack2.stackTagCompound)));
	}
}