/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;

import ccm.trade_stuffs.utils.helper.java.JavaHelper;

/**
 * NBTHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public class NBTHelper
{
    public static void initCompound(final ItemStack item)
    {
        if (item != null)
        {
            if (item.getTagCompound() == null)
            {
                item.setTagCompound(new NBTTagCompound());
            }
        }
    }

    public static boolean hasTag(final ItemStack item, final String key)
    {
        if (item.getTagCompound() != null)
        {
            return item.getTagCompound().hasKey(key);
        }
        return false;
    }

    public static void removeTag(final ItemStack item, final String key)
    {
        if (item.getTagCompound() != null)
        {
            item.getTagCompound().removeTag(key);
        }
    }

    public static void setBoolean(final ItemStack item, final String keyName, final boolean value)
    {
        initCompound(item);

        item.getTagCompound().setBoolean(keyName, value);
    }

    public static boolean getBoolean(final ItemStack item, final String keyName)
    {
        initCompound(item);

        if (!(item.getTagCompound().hasKey(keyName)))
        {

        }
        return item.getTagCompound().getBoolean(keyName);
    }

    public static final String NBT_ENCRYPTION = "CCM.ENCRYPTED.PASS";

    public static NBTTagString encryptString(final String data)
    {
        return new NBTTagString(NBT_ENCRYPTION, JavaHelper.encrypt(data));
    }

    public static String decryptString(final NBTTagCompound data)
    {
        return JavaHelper.decrypt(data.getString(NBT_ENCRYPTION));
    }
}