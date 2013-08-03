/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.utils.exeptions;

import cpw.mods.fml.common.Loader;

/**
 * FailedToMakeCoinType
 * <p>
 * Only happens if someone tries to make an invalid coin type
 * 
 * @author Captain_Shadows
 */
public class FailedToMakeCoinType extends Exception
{
    /**
     * long, serialVersionUID
     */
    private static final long serialVersionUID = 575359934266632708L;

    /**
     * Error that caused this Exception
     */
    private final String      error;

    /**
     * @param error
     *            The Error that caused this Exception
     */
    public FailedToMakeCoinType(final String error)
    {
        this.error = error;
    }

    public FailedToMakeCoinType(final String modID, final String name, final int value)
    {
        if (modID != null)
        {
            if (Loader.isModLoaded(modID))
            {
                if (name != null)
                {
                    if (value >= 1)
                    {
                        error = "I Don't really know";
                    }
                    else
                    {
                        error = "The Value was less than 1";
                    }
                }
                else
                {
                    error = "The Name was Null";
                }
            }
            else
            {
                error = "The Mod tring to register this type was not loaded";
            }
        }
        else
        {
            error = "The Mod ID was Null";
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to crate a new Coin type\n");
        sb.append("Because: ");
        sb.append(error);
        sb.append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}