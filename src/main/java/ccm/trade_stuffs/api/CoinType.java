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
     *            Name of the mod registering this coin
     * @param name
     *            Name of the coin
     * @param value
     *            Value of the coin
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

    /**
     * Registers the coin's Icon
     */
    public void registerIcon(final IconRegister register)
    {
        icon = register.registerIcon(modID + ":" + getIconName());
    }
}