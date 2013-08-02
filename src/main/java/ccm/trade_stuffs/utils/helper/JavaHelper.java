/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

/**
 * JavaHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class JavaHelper
{
    public static final String s = " ";

    public static String tileCase(final String input)
    {
        if (input.contains(s))
        {
            final String finished = input.substring(0, 1).toUpperCase();
            input.indexOf(s);
        }
        else
        {
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
    }
}