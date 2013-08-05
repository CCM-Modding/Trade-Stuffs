/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * EntityHandler
 * <p>
 * 
 * @author Captain_Shadows
 */
public class EntityHandler
{

    @ForgeSubscribe
    public void onEntityLivingDeath(final LivingDeathEvent event)
    {
        if (event.source.getDamageType().equalsIgnoreCase("player"))
        {

        }
        if (event.source.getSourceOfDamage() instanceof EntityArrow)
        {
            if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
            {
                if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer)
                {

                }
            }
        }
    }
}