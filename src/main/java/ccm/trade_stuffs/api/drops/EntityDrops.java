/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.drops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.ItemStack;

/**
 * EntityDrops
 * <p>
 * 
 * @author Captain_Shadows
 */
public class EntityDrops
{
    private static final List<EntityDrop>             drops   = new ArrayList<EntityDrop>();

    public static final List<Class<EntityLivingBase>> allMobs = Arrays.asList(EntityCreeper.class,
                                                                              EntitySkeleton.class);

    /**
     * Registers a EntityDrop
     */
    public static void registerDrop(final EntityDrop drop)
    {
        drops.add(drop);
    }

    /**
     * @param modID
     *            ID of the mod adding this drop
     * @param item
     *            The Item to drop
     * @param dropRate
     *            the Rate at which to drop it
     * @param entitys
     *            the entity's that are allowed to drop it
     */
    public static EntityDrop registerDrop(final String modID,
                                          final ItemStack item,
                                          final float dropRate,
                                          final List<Class<EntityLivingBase>> entitys)
    {
        final EntityDrop tmp = new EntityDrop(modID, item, dropRate, entitys);
        registerDrop(tmp);
        return tmp;
    }

    /**
     * @param modID
     *            ID of the mod adding this drop
     * @param item
     *            The Item to drop
     * @param dropRate
     *            the Rate at which to drop it
     * @param entitys
     *            the entity's that are allowed to drop it
     */
    public static EntityDrop registerDrop(final String modID,
                                          final ItemStack item,
                                          final float dropRate,
                                          final Class<EntityLivingBase>[] entitys)
    {
        return registerDrop(modID, item, dropRate, Arrays.asList(entitys));
    }

    /**
     * @param modID
     *            ID of the mod adding this drop
     * @param item
     *            The Item to drop
     * @param dropRate
     *            the Rate at which to drop it
     * @param entity
     *            the entity that is allowed to drop it
     */
    public static EntityDrop registerDrop(final String modID,
                                          final ItemStack item,
                                          final float dropRate,
                                          final Class<EntityLivingBase> entity)
    {
        return registerDrop(modID, item, dropRate, entity);
    }
}