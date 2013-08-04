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
     * @return
     */
    public void setPass(final int pass)
    {
        final String s = String.valueOf(pass);
        if (s.length() == 4)
        {

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
