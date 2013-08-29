package ccm.trade_stuffs.utils.handler;

import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_FILE_BANK;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

import ccm.nucleum.omnium.utils.helper.DataHelper;
import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.bank.Bank;

public final class WorldHandler
{

    @ForgeSubscribe
    public void worldLoad(final WorldEvent.Load event)
    {
        if (event.world.isRemote)
        {
            return;
        }
        Bank.readFromNBT(DataHelper.readData(TradeStuffs.instance, NBT_FILE_BANK));
    }

    @ForgeSubscribe
    public void worldSave(final WorldEvent.Save event)
    {
        if (event.world.isRemote)
        {
            return;
        }
        final NBTTagCompound nbt = new NBTTagCompound();
        Bank.writeToNBT(nbt);
        DataHelper.saveData(TradeStuffs.instance, NBT_FILE_BANK, nbt);
    }
}
