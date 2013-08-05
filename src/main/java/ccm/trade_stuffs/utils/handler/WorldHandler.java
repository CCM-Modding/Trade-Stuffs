package ccm.trade_stuffs.utils.handler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

import ccm.trade_stuffs.bank.Bank;
import ccm.trade_stuffs.utils.helper.SaveHelper;

public class WorldHandler
{

    @ForgeSubscribe
    public void worldLoad(final WorldEvent.Load event)
    {
        if (event.world.isRemote)
        {
            return;
        }
        Bank.readFromNBT(SaveHelper.readData("bank"));
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
        SaveHelper.saveData("bank", nbt);
    }
}
