/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.drops;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * EntityDrops
 * <p>
 * 
 * @author Captain_Shadows
 */
public class EntityDrops
{
    private static final List<EntityDrop> drops = new ArrayList<EntityDrop>();

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
                                          final int amount,
                                          final float dropRate,
                                          final Class<? extends EntityLivingBase> entity)
    {
        final EntityDrop tmp = new EntityDrop(modID, item, amount, dropRate, entity);
        registerDrop(tmp);
        return tmp;
    }
}