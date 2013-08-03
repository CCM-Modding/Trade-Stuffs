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

    public static String tileCase(final String input)
    {
        if (input.contains(" "))
        {
            final String[] strings = input.split(" ");
            final StringBuilder sb = new StringBuilder();
            for (final String s : strings)
            {
                sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
                sb.append(" ");
                System.out.println(sb.toString());
            }
            return sb.toString();
        }
        else
        {
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
    }
}