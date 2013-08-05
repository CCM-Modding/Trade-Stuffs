/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.tileentity.TileEntityBank;

/**
 * InventoryBank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class InventoryBank extends InventoryBase
{

    private TileEntityBank associatedBank;

    public InventoryBank()
    {
        super("inventory.bank", 72);
    }

    @Override
    public ItemStack decrStackSize(final int index, final int amount)
    {
        final ItemStack ret = super.decrStackSize(index, amount);
        if (this instanceof InventoryBankCoins)
        {
            associatedBank.countCoins();
        }
        else
            if (this instanceof InventoryBankItems)
            {
                associatedBank.countItems();
            }
        return ret;
    }

    @Override
    public void setInventorySlotContents(final int index, final ItemStack item)
    {
        final boolean flag = item != null;
        super.setInventorySlotContents(index, item);
        if ((associatedBank != null) && flag)
        {
            if (this instanceof InventoryBankCoins)
            {
                associatedBank.countCoins();
                // formatCoins();
            }
            else
                if (this instanceof InventoryBankItems)
                {
                    associatedBank.countItems();
                    // formatItems();
                }
        }
    }

    public void setInventorySlotContentsNoFormat(final int index, final ItemStack item)
    {
        super.setInventorySlotContents(index, item);
    }

    public void formatCoins()
    {
        final ArrayList<ItemStack> oldStacks = new ArrayList<ItemStack>();
        for (int i = 0; i < 72; i++)
        {
            if (getStackInSlot(i) != null)
            {
                oldStacks.add(getStackInSlotOnClosing(i));
            }
        }
        final ItemStack[] newStacks = new ItemStack[72];
        for (final ItemStack stack : oldStacks)
        {
            if (newStacks[stack.getItemDamage()] != null)
            {
                newStacks[stack.getItemDamage()].stackSize += stack.stackSize;
            }
            else
            {
                newStacks[stack.getItemDamage()] = stack.copy();
            }
        }
        int index = 0;
        for (int i = 0; i < CoinTypes.getTypes().size(); i++)
        {
            if (newStacks[i] != null)
            {
                setInventorySlotContentsNoFormat(index++, newStacks[i]);
            }
        }
        // oldStacks.clear();
        // newStacks = null;
    }

    public void formatItems()
    {

    }

    public InventoryBank setBank(final TileEntityBank bank)
    {
        associatedBank = bank;
        return this;
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

    @Override
    public boolean isUseableByPlayer(final EntityPlayer par1EntityPlayer)
    {
        return (associatedBank != null) && !associatedBank.isUseableByPlayer(par1EntityPlayer) ? false
                                                                                              : super.isUseableByPlayer(par1EntityPlayer);
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