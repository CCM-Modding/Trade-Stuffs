/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.coins;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;

/**
 * CoinTypes
 * <p>
 * This class keeps track of all the registered Coin Types, if you want to add a new one call the
 * {@code registerCoinType} method and provide a texture and lang file. Which should be: coin_X
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
    private static final long           serialVersionUID = 8699539912432140138L;

    /**
     * All of the registered coin types
     */
    private static final List<CoinType> types            = new ArrayList<CoinType>();

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

    /**
     * @param type
     *            The coin type to check
     * @return true if and ONLY if it is the Highest value registered
     */
    public static boolean isHigest(final CoinType type)
    {
        final int val = type.getValue();
        for (final CoinType coin : types)
        {
            if (coin.getValue() > val)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @param type
     *            The type who's value you want to convert
     * @param wantedType
     *            The type to which you want to convert it to
     * @return If the value of the first argument is NOT bigger than the second it returns 1
     *         <p>
     *         Other wise it returns {@code wantedType.value / type.value}
     */
    public static int getReleatedValue(final CoinType type, final CoinType wantedType)
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

    /**
     * @return a copy of the types
     */
    public static List<CoinType> getTypes()
    {
        return new ArrayList<CoinType>(types);
    }

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
        if (stack.getItem() instanceof ItemCloth)
        {
            return getCoinType(stack.getItemDamage());
        }
        return null;
    }

    public static CoinType getCoinType(final int itemDamage)
    {
        return getTypes().get(itemDamage);
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

    private static final String  modID    = "trade_stuffs";
    public static final CoinType COPPER   = registerCoinType(modID, "copper", 1);
    public static final CoinType SILVER   = registerCoinType(modID, "silver", 25);
    public static final CoinType GOLD     = registerCoinType(modID, "gold", 50);
    public static final CoinType PLATINUM = registerCoinType(modID, "platinum", 100);
}