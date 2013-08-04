/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.api.CoinTypes;
import ccm.trade_stuffs.items.WalletItem;
import ccm.trade_stuffs.utils.helper.FunctionHelper;
import ccm.trade_stuffs.utils.helper.InventoryHelper;
import ccm.trade_stuffs.utils.helper.NBTHelper;

/**
 * WalletInventory
 * <p>
 * 
 * @author Captain_Shadows
 */
public class WalletInventory implements IInventory
{
    ItemStack[] inventory = new ItemStack[CoinTypes.getTypes().size() + 1];

    ItemStack   wallet;

    public WalletInventory(final ItemStack item)
    {
        wallet = item;
        readFromNBT(item.getTagCompound());
    }

    @SideOnly(Side.CLIENT)
    public void hasMoney(final boolean has)
    {
        NBTHelper.setBoolean(FunctionHelper.getCurrentItem(Minecraft.getMinecraft().thePlayer, wallet),
                             WalletItem.fullWallet,
                             has);
    }

    @Override
    public int getSizeInventory()
    {
        return CoinTypes.getTypes().size() + 1;
    }

    @Override
    public ItemStack decrStackSize(final int slot, final int amount)
    {
        return InventoryHelper.decreaseStackSize(this, slot, amount);
    }

    @Override
    public ItemStack getStackInSlot(final int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int slot)
    {
        if (inventory[slot] != null)
        {
            final ItemStack tmp = inventory[slot];
            inventory[slot] = null;
            return tmp;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(final int slot, final ItemStack item)
    {
        inventory[slot] = item;
    }

    @Override
    public String getInvName()
    {
        return wallet.hasDisplayName() ? wallet.getDisplayName() : "inventory.wallet";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return wallet.hasDisplayName();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public ItemStack[] getInventory()
    {
        return inventory;
    }

    @Override
    public void onInventoryChanged()
    {}

    public static final String INVENTORY_WALLET = "CCM.WALLET.INVENTORY";

    public void readFromNBT(final NBTTagCompound nbt)
    {
        System.out.println(nbt);
        if (nbt.hasKey(INVENTORY_WALLET))
        {
            setInventory(InventoryHelper.readInventoryFromNBT(nbt.getTagList(INVENTORY_WALLET),
                                                              getSizeInventory()));
        }
    }

    /**
     * @param readInventoryFromNBT
     */
    private void setInventory(final ItemStack[] inventory)
    {
        this.inventory = inventory;
    }

    public void writeToNBT(final ItemStack item)
    {
        NBTTagCompound tag = item.getTagCompound();
        if (tag == null)
        {
            tag = new NBTTagCompound();
        }
        System.out.println(tag);
        tag.setTag(INVENTORY_WALLET, InventoryHelper.writeInventoryToNBT(inventory));
        item.setTagCompound(tag);
        System.out.println(tag);
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public void openChest()
    {}

    @Override
    public void closeChest()
    {}

    @Override
    public boolean isItemValidForSlot(final int slot, final ItemStack item)
    {
        return false;
    }
}