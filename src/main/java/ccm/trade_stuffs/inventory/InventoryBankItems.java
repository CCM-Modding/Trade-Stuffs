package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Properties;

public class InventoryBankItems extends InventoryBasic
{

    private TileEntityBank associatedBank;

    public InventoryBankItems()
    {
        super("inventory.bank", false, 72);
    }

    @Override
    public int getInventoryStackLimit()
    {
        return Properties.BANK_ITEMS_PER_ITEM;
    }

    @Override
    public String getInvName()
    {
        return associatedBank.bankName.length() > 1 ? associatedBank.bankName : "inventory.bank";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return associatedBank.bankName.length() > 1;
    }

    public void loadInventoryFromNBT(final NBTTagList list)
    {
        NBTTagCompound nbt;
        for (int i = 0; i < list.tagCount(); i++)
        {
            nbt = (NBTTagCompound) list.tagAt(i);
            setInventorySlotContents(nbt.getInteger("CCM.SLOT"), ItemStack.loadItemStackFromNBT(nbt));
        }
    }

    public NBTTagList saveInventoryToNBT()
    {
        final NBTTagList list = new NBTTagList();
        NBTTagCompound nbt;
        for (int i = 0; i < getSizeInventory(); i++)
        {
            final ItemStack stack = getStackInSlot(i);
            if (stack != null)
            {
                nbt = new NBTTagCompound();
                nbt.setInteger("CCM.SLOT", i);
                stack.writeToNBT(nbt);
                list.appendTag(nbt);
            }
        }
        return list;
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer par1EntityPlayer)
    {
        return (associatedBank != null) && !associatedBank.isUseableByPlayer(par1EntityPlayer) ? false
                                                                                              : super.isUseableByPlayer(par1EntityPlayer);
    }

    @Override
    public boolean isItemValidForSlot(final int slot, final ItemStack stack)
    {
        return false;
    }

    @Override
    public void openChest()
    {
        if (associatedBank != null)
        {
            associatedBank.openChest();
        }
        super.openChest();
    }

    @Override
    public void closeChest()
    {
        if (associatedBank != null)
        {
            associatedBank.closeChest();
        }

        super.closeChest();
        associatedBank = null;
    }
}
