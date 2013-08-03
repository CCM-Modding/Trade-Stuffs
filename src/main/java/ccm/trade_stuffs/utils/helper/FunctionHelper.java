/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * FunctionHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class FunctionHelper
{
    public static ItemStack getCurrentItem(final EntityPlayer player, final ItemStack item)
    {
        boolean found = false;
        ItemStack result = null;
        for (final ItemStack stack : player.inventory.mainInventory)
        {
            if (found)
            {
                break;
            }
            else
            {
                if (stack != null)
                {
                    if (stack.itemID == item.itemID)
                    {
                        found = true;
                        result = stack;
                    }
                }
            }
        }
        return result;
    }
}
