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
public class Safe extends BaseInventory
{
    private String pass = " ";

    /**
     * @param pass
     *            The pass to set, it is checked to be 4 digits long
     */
    public void setPass(final String pass)
    {
        final String s = String.valueOf(pass);
        if (s.length() == 4)
        {
            this.pass = pass;
        }
    }

    /**
     * @return
     */
    public String getPass()
    {
        return pass;
    }

    public static String SAFE_PASS = "CCM.TILE.ENTITY.SAFE.PASS";

    @Override
    public void writeToNBT(final NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setString(SAFE_PASS, pass);
    }

    @Override
    public void readFromNBT(final NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        if (nbt.hasKey(SAFE_PASS))
        {
            pass = nbt.getString(SAFE_PASS);
        }
    }
}