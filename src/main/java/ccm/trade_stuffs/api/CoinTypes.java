/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api;

import java.util.ArrayList;
import java.util.List;

import ccm.trade_stuffs.api.utils.exeptions.FailedToMakeCoinType;

/**
 * CoinTypes
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class CoinTypes
{
    /**
     * long, serialVersionUID
     */
    private static final long     serialVersionUID = -7687489046333823903L;

    /**
     * All of the registered coin types
     */
    private static List<CoinType> types            = new ArrayList<CoinType>();

    /**
     * @param modID
     *            ID of the mod adding this type of coin
     * @param name
     *            Name of the type
     * @param value
     *            Value of the coin, based on copper coins (copper = 1)
     * @throws FailedToMakeCoinType
     *             if any of the arguments are null, the mod id is not loaded, or if the value is less than
     *             one
     */
    public static CoinType registerCoinType(final String modID, final String name, final int value)
    {
        final CoinType tmp = new CoinType(modID, name, value);
        registerCoinType(tmp);
        return tmp;
    }

    /**
     * @param type
     *            Add a new type of coin
     */
    public static void registerCoinType(final CoinType type)
    {
        types.add(type);
    }

    public static int getReleatedValue(final CoinType type, final CoinType wantedType)
    {
        if (wantedType.equals(COPPER))
        {
            return type.getValue();
        }
        else
        {
            final int typeValue = type.getValue();
            final int otherValue = wantedType.getValue();
            if (typeValue > otherValue)
            {
                return otherValue / typeValue;
            }
            else
            {
                return 1;
            }
        }
    }

    /**
     * @return a copy of the types
     */
    public static List<CoinType> getTypes()
    {
        final List<CoinType> copy = new ArrayList<CoinType>();
        for (final CoinType type : types)
        {
            copy.add(type);
        }
        return copy;
    }

    /**
     * A UID is a Unique Identifier
     * 
     * @return The UID of this class, used for version stuff
     */
    public long getUID()
    {
        return serialVersionUID;
    }

    static final String          modID    = "trade_stuffs";
    public static final CoinType COPPER   = registerCoinType(modID, "copper", 1);
    public static final CoinType SILVER   = registerCoinType(modID, "silver", 25);
    public static final CoinType GOLD     = registerCoinType(modID, "gold", 50);
    public static final CoinType PLATINUM = registerCoinType(modID, "platinum", 100);
}