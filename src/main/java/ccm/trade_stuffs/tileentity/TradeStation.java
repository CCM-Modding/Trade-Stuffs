/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * TradeStation
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStation extends TileEntity implements IInventory
{

    @Override
    public int getSizeInventory()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(final int i)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack decrStackSize(final int i, final int j)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int i)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(final int i, final ItemStack itemstack)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInvNameLocalized()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer entityplayer)
    {

        return false;
    }

    @Override
    public void openChest()
    {}

    @Override
    public void closeChest()
    {}

    @Override
    public boolean isItemValidForSlot(final int i, final ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
