/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import ccm.trade_stuffs.api.drops.EntityDrops;

/**
 * EntityHandler
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class EntityHandler
{
    @ForgeSubscribe
    public void onEntityLivingDeath(final LivingDeathEvent event)
    {
        if (event.source.getDamageType().equalsIgnoreCase("player"))
        {
            EntityDrops.dropItem(event.entityLiving);
        }
        if (event.source.getSourceOfDamage() instanceof EntityArrow)
        {
            if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
            {
                if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer)
                {
                    EntityDrops.dropItem(event.entityLiving);
                }
            }
        }
    }
}