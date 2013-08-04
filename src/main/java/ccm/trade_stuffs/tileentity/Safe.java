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
    private String pass;

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

}