/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.coins;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * CoinTypes
 * <p>
 * This class keeps track of all the registered Coin Types, if you want to add a new one call the {@code registerCoinType} method and provide a texture and lang file. Which should
 * be: coin_X
 * <p>
 * 'X' being the name of the type that you added
 * 
 * @author Captain_Shadows
 */
public final class CoinTypes
{
    /**
     * long, serialVersionUID
     */
    private static final long serialVersionUID = -2525214302579118813L;

    /**
     * All of the registered {@link CoinType}s
     */
    private static final List<CoinType> types = new ArrayList<CoinType>();

    /**
     * @param type
     *            Add a new type of coin
     */
    public static void registerCoinType(final CoinType type)
    {
        types.add(type);
    }

    /**
     * @param modID
     *            ID of the mod adding this type of coin
     * @param name
     *            Name of the type
     * @param value
     *            Value of the coin, based on copper coins (copper = 1)
     * @throws FailedToMakeCoinType
     *             if any of the arguments are null, the mod id is not loaded, or if the value is less than one
     */
    public static CoinType registerCoinType(final String modID, final String name, final int value)
    {
        final CoinType tmp = new CoinType(modID, name, value);
        registerCoinType(tmp);
        return tmp;
    }

    /**
     * @return a copy of the types
     */
    public static List<CoinType> getTypes()
    {
        return new ArrayList<CoinType>(types);
    }

    /**
     * @param meta
     *            The meta data of the item that you want to get the CoinType of
     * @return The {@link CoinType}
     */
    public static CoinType getCoinType(final int meta)
    {
        return getTypes().get(meta);
    }

    /**
     * @param stack
     *            The ItemStack to get the {@link CoinType} from
     * @return The corresponding {@link CoinType}
     */
    public static CoinType getCoinType(final ItemStack stack)
    {
        Class<?> coinClazz = null;
        try
        {
            coinClazz = Class.forName("ccm.trade_stuffs.items.CoinItem");
        } catch (final ClassNotFoundException e)
        {
            System.err.println("You need Trade Stuffs for you to see the coins!");
            e.printStackTrace();
        }
        if (coinClazz.isInstance(stack.getItem()))
        {
            return getCoinType(stack.getItemDamage());
        }
        return null;
    }

    /**
     * @param maximum
     *            The maximum stacks per coin type
     * @return the maximum vaule of all the coins
     */
    public static int getStackValue(final ItemStack item)
    {
        return getCoinType(item.getItemDamage()).getValue() * item.stackSize;
    }

    /**
     * @param maximum
     *            The maximum stacks per coin type
     * @return the maximum vaule of all the coins
     */
    public static int getMaxPossibleValue(final int maximum)
    {
        int value = 0;
        for (final CoinType type : CoinTypes.getTypes())
        {
            value += (type.getValue() * maximum) * 64;
        }
        return value;
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
}