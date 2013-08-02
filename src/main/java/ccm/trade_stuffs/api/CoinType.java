/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

/**
 * CoinType
 * <p>
 * This class defines the name and value of any coin and thus they are stored that way in CoinTypes
 * 
 * @author Captain_Shadows
 */
public class CoinType
{
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
    private final int    value;
    /**
     * Icon of the coin
     */
    private Icon         icon;

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
     * @return The name of the coin
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

    public String getTypeName()
    {
        final String firstLetter = name.substring(0);
        firstLetter.toUpperCase();
        final String rest = name.substring(1);
        return firstLetter + rest;
    }

    /**
     * Registers the coin's Icon
     */
    public void registerIcon(final IconRegister register)
    {
        icon = register.registerIcon(modID + ":" + getIconName());
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
        }
        else
            if (!icon.equals(other.icon))
            {
                return false;
            }
        if (modID == null)
        {
            if (other.modID != null)
            {
                return false;
            }
        }
        else
            if (!modID.equals(other.modID))
            {
                return false;
            }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else
            if (!name.equals(other.name))
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
        if (modID != null)
        {
            builder.append("Mod = ").append(modID).append(", ");
        }
        else
        {
            builder.append("Mod = NULL");
        }
        if (name != null)
        {
            builder.append("Name = ").append(name).append(", ");
        }
        else
        {
            builder.append("Name = NULL");
        }
        builder.append("Value = ").append(value).append(", ");
        if (icon != null)
        {
            builder.append("Icon = ").append(icon);
        }
        else
        {
            builder.append("Icon = NULL");
        }
        builder.append("]");
        return builder.toString();
    }
}