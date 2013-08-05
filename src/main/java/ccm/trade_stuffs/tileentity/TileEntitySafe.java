/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

import ccm.trade_stuffs.inventory.InventoryBaseTile;

/**
 * Safe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntitySafe extends InventoryBaseTile
{

    public String   safeName    = "";
    private int     pass        = 0;
    private boolean hasPass     = false;
    public boolean  guiPassLock = true;

    private int     itemCount;

    public TileEntitySafe()
    {
        super("inventory.safe", 72);
    }

    public int getPass()
    {
        return pass;
    }

    public void setPass(final int pass)
    {
        this.pass = pass;
        hasPass = true;
    }

    public void resetPass()
    {
        pass = 0;
        hasPass = false;
    }

    public boolean hasPass()
    {
        return hasPass;
    }

    public void setHasPass(final boolean has)
    {
        hasPass = has;
    }

    @Override
    public ItemStack decrStackSize(final int index, final int amount)
    {
        final ItemStack ret = super.decrStackSize(index, amount);
        countItems();
        return ret;
    }

    @Override
    public void setInventorySlotContents(final int index, final ItemStack item)
    {
        final boolean flag = item != null;
        super.setInventorySlotContents(index, item);
        if (flag)
        {
            countItems();
        }
    }

    public void setInventorySlotContentsNoFormat(final int index, final ItemStack item)
    {
        super.setInventorySlotContents(index, item);
    }

    @Override
    public Packet getDescriptionPacket()
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(1);
            dos.writeInt(xCoord);
            dos.writeInt(yCoord);
            dos.writeInt(zCoord);

            dos.writeInt(pass);
            dos.writeBoolean(hasPass);
            dos.writeBoolean(guiPassLock);
            dos.writeUTF(safeName);
        } catch (final Exception e)
        {
            e.printStackTrace();
        }
        final Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "TradeStuffs";
        packet.data = bos.toByteArray();
        packet.length = bos.size();
        packet.isChunkDataPacket = true;
        return packet;
    }

    @Override
    public void readFromNBT(final NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        pass = nbt.getInteger("Password");
        hasPass = nbt.getBoolean("HasPass");
        safeName = nbt.getString("SafeName");
        countItems();
    }

    @Override
    public void writeToNBT(final NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("Password", pass);
        nbt.setBoolean("HasPass", hasPass);
        nbt.setString("SafeName", safeName);
    }

    @Override
    public String getInvName()
    {
        return safeName.length() > 1 ? safeName : "inventory.safe";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return safeName.length() > 1;
    }

    public int getItemCount()
    {
        return itemCount;
    }

    public void countItems()
    {
        itemCount = 0;
        ItemStack stack = null;
        for (int i = 0; i < 72; i++)
        {
            stack = getStackInSlot(i);
            if (stack != null)
            {
                itemCount += stack.stackSize;
            }
        }
    }

    @Override
    public void openChest()
    {
        super.openChest();
        countItems();
    }
}