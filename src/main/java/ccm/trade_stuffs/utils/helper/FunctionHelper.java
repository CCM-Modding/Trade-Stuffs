/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.utils.lib.Properties;

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

    public static int getMaxPossibleValue()
    {
        int maxValue = 0;
        for (final CoinType type : CoinTypes.getTypes())
        {
            maxValue += (type.getValue() * Properties.WALLET_STACKS_PER_COIN) * 64;
        }
        return maxValue;
    }
}