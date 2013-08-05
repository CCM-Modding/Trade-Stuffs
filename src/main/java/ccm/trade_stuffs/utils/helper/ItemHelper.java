/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * ItemHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ItemHelper
{
    public static void
            dropItem(final ItemStack item, final EntityPlayer player, final EntityLivingBase entity)
    {
        if (FunctionHelper.shouldDropItem(entity))
        {
            final double rand = Math.random();

            if (rand < 0)
            {
                entity.dropItem(item.itemID, amount);
            }
        }
    }
}