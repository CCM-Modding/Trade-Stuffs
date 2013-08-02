/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api;

import java.util.ArrayList;
import java.util.List;

import ccm.trade_stuffs.utils.lib.Archive;

/**
 * CoinTypes
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class CoinTypes
{
    /**
     * All of the registered coin types
     */
    private static List<CoinType> types = new ArrayList<CoinType>();

    /**
     * @param modID
     *            ID of the mod adding this type of coin
     * @param name
     *            Name of the type
     * @param value
     *            Value of the coin, based on copper coins (copper = 1)
     */
    public static void registerCoinType(final String modID, final String name, final int value)
    {
        registerCoinType(new CoinType(modID, name, value));
    }

    /**
     * @param type
     *            Add a new type of coin
     */
    public static void registerCoinType(final CoinType type)
    {
        types.add(type);
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
     * Registers all the basic coins
     */
    static
    {
        registerCoinType(Archive.MOD_ID, "copper", 1);
        registerCoinType(Archive.MOD_ID, "silver", 25);
        registerCoinType(Archive.MOD_ID, "gold", 100);
    }
}