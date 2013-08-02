/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

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
        NBTTagCompound nbt;
        final NBTTagList list = new NBTTagList();
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
}