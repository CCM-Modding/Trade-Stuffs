/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.coins;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import ccm.nucleum.omnium.utils.helper.JavaHelper;

/**
 * CoinType
 * <p>
 * This class defines the name and value of any coin and thus they are stored that way in CoinTypes, It also defines a couple things that are used internally to crate the item
 * <p>
 * If you want to add a Coin type, you DO NOT need to create an Item for it, the mod WILL add it to its current list, just create the texture and lang file. Which should be: coin_X
 * <p>
 * 'X' being the name of the type that you added
 * 
 * @author Captain_Shadows
 */
public final class CoinType
{
    /**
     * long, serialVersionUID
     */
    private static final long serialVersionUID = -6507593853569541421L;

    /**
     * Name of the mod registering this coin
     */
    private final String modID;

    /**
     * Name of the coin
     */
    private final String name;
    /**
     * Value of the coin
     */
    private final int value;
    /**
     * Icon of the coin
     */
    private Icon icon;

    /**
     * @param modID
     *            ID of the mod adding this type of coin
     * @param name
     *            Name of the type
     * @param value
     *            Value of the coin, based on copper coins (copper = 1)
     */
    public CoinType(final String modID, final String name, final int value)
    {
        this.modID = modID;
        this.name = name;
        this.value = value;
    }

    /**
     * @return The ID of the mod that registered this coin
     */
    public String getModID()
    {
        return modID;
    }

    /**
     * @return The name of the coin
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The value of the coin
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @param item
     *            The item stack containing this coin
     * @return The value of the ItemStack as a whole
     */
    public int getValueStack(final ItemStack item)
    {
        return getValue() * item.stackSize;
    }

    /**
     * @return The icon of the coin
     */
    public Icon getIcon()
    {
        return icon;
    }

    /**
     * @return The "icon" name of the coin
     */
    public String getIconName()
    {
        return "coin_" + name;
    }

    /**
     * @return A Title Cased version of the Name
     */
    public String getTypeName()
    {
        return JavaHelper.titleCase(name);
    }

    /**
     * Registers the coin's Icon
     */
    public void registerIcon(final IconRegister register)
    {
        icon = register.registerIcon(modID + ":" + getIconName());
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((icon == null) ? 0 : icon.hashCode());
        result = (prime * result) + ((modID == null) ? 0 : modID.hashCode());
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        result = (prime * result) + value;
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof CoinType))
        {
            return false;
        }
        final CoinType other = (CoinType) obj;
        if (icon == null)
        {
            if (other.icon != null)
            {
                return false;
            }
        } else if (!icon.equals(other.icon))
        {
            return false;
        }
        if (modID == null)
        {
            if (other.modID != null)
            {
                return false;
            }
        } else if (!modID.equals(other.modID))
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        } else if (!name.equals(other.name))
        {
            return false;
        }
        if (value != other.value)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("CoinType [");
        builder.append("Mod = ").append(modID).append(", ");
        builder.append("Name = ").append(name).append(", ");
        builder.append("Value = ").append(value).append(", ");
        if (icon != null)
        {
            builder.append("Icon = ").append(icon);
        }
        builder.append("]");
        return builder.toString();
    }
}