/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.bank.Bank;
import ccm.trade_stuffs.bank.BankAccount;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntityBank extends TileEntity
{

    public String      bankName    = "";

    private String     playerUsing = "";
    private boolean    inUse       = false;
    private byte       selectedTab = 0;

    public BankAccount currentAccount;
    private int        coinBalance;
    private int        itemCount;

    @Override
    public Packet getDescriptionPacket()
    {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            dos.writeInt(0);
            dos.writeInt(xCoord);
            dos.writeInt(yCoord);
            dos.writeInt(zCoord);

            dos.writeUTF(bankName);
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

    public boolean isUseableByPlayer(final EntityPlayer player)
    {
        return !inUse;
    }

    public void openChest()
    {
        inUse = true;
        if (!Bank.hasAccount(playerUsing))
        {
            Bank.addAcount(new BankAccount(playerUsing));
        }
        currentAccount = Bank.getAccount(playerUsing);
        countCoins();
        countItems();
    }

    public void closeChest()
    {
        inUse = false;
        playerUsing = "";
        currentAccount = null;
    }

    public boolean isInUse()
    {
        return inUse;
    }

    public void setInUse(final boolean use)
    {
        inUse = use;
    }

    public String getPlayerUsing()
    {
        return playerUsing;
    }

    public void setPlayerUsing(final String player)
    {
        playerUsing = player;
    }

    public void openTab(final byte tab)
    {
        selectedTab = tab;
        final EntityPlayer player = worldObj.getPlayerEntityByName(playerUsing);
        player.closeScreen();
        setPlayerUsing(player.username);
        setInUse(true);
        player.openGui(TradeStuffs.instance,
                       tab == 0 ? Guis.GUI_BANK_COINS : Guis.GUI_BANK_ITEMS,
                       worldObj,
                       xCoord,
                       yCoord,
                       zCoord);
    }

    public void setSelectedTab(final byte tab)
    {
        selectedTab = tab;
    }

    public int getCoinBalance()
    {
        return coinBalance;
    }

    public void countCoins()
    {
        coinBalance = 0;
        ItemStack stack = null;
        for (int i = 0; i < 72; i++)
        {
            stack = currentAccount.getCoins().getStackInSlot(i);
            if (stack != null)
            {
                coinBalance += CoinTypes.getCoinType(stack.getItemDamage()).getValue() * stack.stackSize;
            }
        }
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
            stack = currentAccount.getItems().getStackInSlot(i);
            if (stack != null)
            {
                itemCount += stack.stackSize;
            }
        }
    }

    @Override
    public void readFromNBT(final NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        bankName = nbt.getString("BankName");
    }

    @Override
    public void writeToNBT(final NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setString("BankName", bankName);
    }
}