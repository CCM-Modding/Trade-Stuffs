/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.items.ItemWallet;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.utils.helper.NBTHelper;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * WalletInventory
 * <p>
 * 
 * @author Captain_Shadows
 */
public class InventoryWallet implements IInventory
{

    public HashMap<CoinType, Integer> coins       = new HashMap<CoinType, Integer>();
    private ItemStack                 slotStack;
    private ItemStack                 slotFakeCoins;

    private final ItemStack           wallet;

    private int                       coinBalance = 0;

    public InventoryWallet(final ItemStack wallet)
    {
        this.wallet = wallet;
        readFromNBT(wallet);
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack decrStackSize(final int slot, final int amount)
    {
        if (slot == 0)
        {
            if (slotStack != null)
            {
                ItemStack stack;
                if (slotStack.stackSize <= amount)
                {
                    stack = slotStack;
                    slotStack = null;
                    onInventoryChanged();
                    return stack;
                }
                else
                {
                    stack = slotStack.splitStack(amount);
                    if (slotStack.stackSize == 0)
                    {
                        slotStack = null;
                    }
                    onInventoryChanged();
                    return stack;
                }
            }
            else
            {
                return null;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlot(final int slot)
    {
        if (slot == 0)
        {
            return slotStack;
        }
        else
            if (slot == 1)
            {
                return slotFakeCoins;
            }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int slot)
    {
        if (slot == 0)
        {
            final ItemStack temp = slotStack;
            slotStack = null;
            return temp;
        }
        else
            if (slot == 1)
            {
                final ItemStack temp = slotFakeCoins;
                slotFakeCoins = null;
                return temp;
            }
        return null;
    }

    @Override
    public void setInventorySlotContents(final int slot, final ItemStack stack)
    {
        if (slot == 0)
        {
            if (stack != null)
            {
                final CoinType coinType = CoinTypes.getTypes().get(stack.getItemDamage());
                int coinAmount = 0;
                if (coins.containsKey(coinType))
                {
                    coinAmount = coins.get(coinType);
                }
                if (coinAmount < (getStacksPerCoin() * 64))
                {
                    final int canAdd = (getStacksPerCoin() * 64) - coinAmount;
                    int added = 0;
                    if (stack.stackSize < canAdd)
                    {
                        added = stack.stackSize;
                        stack.stackSize = 0;
                    }
                    else
                    {
                        added = canAdd;
                        stack.stackSize -= canAdd;
                    }
                    coins.put(coinType, coinAmount + added);
                }
                else
                {
                    slotStack = stack;
                }
                if (stack.stackSize != 0)
                {
                    slotStack = stack;
                }
                else
                {
                    slotStack = null;
                }
            }
            else
            {
                slotStack = null;
            }
            countCoinBalance();
            slotFakeCoins = new ItemStack(ModItems.coin, getCoinBalance(), 0);
        }
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

    @Override
    public void onInventoryChanged()
    {}

    public void countCoinBalance()
    {
        coinBalance = 0;
        for (final CoinType coinType : coins.keySet())
        {
            coinBalance += (coinType.getValue() * coins.get(coinType));
        }
        setHasMoney(coinBalance > 0);
    }

    public int getCoinBalance()
    {
        return coinBalance;
    }

    public int getStacksPerCoin()
    {
        return Properties.WALLET_STACKS_PER_COIN;
    }

    public void readFromNBT(final ItemStack stack)
    {
        NBTHelper.initCompound(stack);
        final NBTTagCompound nbt = stack.getTagCompound();
        coins = new HashMap<CoinType, Integer>();
        for (final CoinType coinType : CoinTypes.getTypes())
        {
            if (nbt.hasKey("COIN-" + coinType.getName()))
            {
                coins.put(coinType, nbt.getInteger("COIN-" + coinType.getName()));
            }
        }
        countCoinBalance();
    }

    public void writeToNBT(final ItemStack stack)
    {
        NBTHelper.initCompound(stack);
        final NBTTagCompound nbt = stack.getTagCompound();
        for (final CoinType coinType : coins.keySet())
        {
            nbt.setInteger("COIN-" + coinType.getName(), coins.get(coinType));
        }
    }

    public void setHasMoney(final boolean has)
    {
        NBTHelper.setBoolean(wallet, ItemWallet.fullWallet, has);
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