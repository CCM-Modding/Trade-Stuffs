/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Safe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntitySafe extends BaseInventory
{
    private int pass;

    /**
     * @param pass
     *            The pass to set
     */
    public void setPass(final int pass)
    {
        this.pass = pass;
    }

    /**
     * @return
     */
    public int getPass()
    {
        return pass;
    }

    public static String SAFE_PASS = "CCM.TILE.ENTITY.SAFE.PASS";

    @Override
    public void writeToNBT(final NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger(SAFE_PASS, pass);
        System.out.println("WRITING!");
        System.out.println(pass);
        System.out.println(nbt);
    }

    @Override
    public void readFromNBT(final NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        if (nbt.hasKey(SAFE_PASS))
        {
            pass = nbt.getInteger(SAFE_PASS);
        }
        else
        {
            nbt.setInteger(SAFE_PASS, 0);
            pass = 0;
        }
        System.out.println("READING!");
        System.out.println(pass);
        System.out.println(nbt);
    }
}