/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

/**
 * Safe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Safe extends BaseInventory
{
    private int pass;

    /**
     * @param pass
     *            The pass to set, it is checked to be 4 digits long
     */
    public void setPass(final int pass)
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
    public int getPass()
    {
        return pass;
    }

}