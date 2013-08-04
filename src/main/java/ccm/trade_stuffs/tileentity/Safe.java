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
     *            The pass to set
     */
    public void setPass(final String pass)
    {
        this.pass = pass;
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
        System.out.println(nbt);
    }

    @Override
    public void readFromNBT(final NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        if (nbt.hasKey(SAFE_PASS))
        {
            pass = nbt.getString(SAFE_PASS);
        }
        System.out.println(nbt);
    }
}