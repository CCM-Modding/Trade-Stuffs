/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.drops;

import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * EntityDrop
 * <p>
 * 
 * @author Captain_Shadows
 */
public class EntityDrop
{
    /**
     * Name of the mod registering this coin
     */
    private final String                 modID;

    /**
     * Item to drop
     */
    private final ItemStack              item;
    /**
     * The drop rate of it
     */
    private final int                    dropRate;
    /**
     * A list of entity's that should drop it
     */
    private final List<EntityLivingBase> entitys;

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
    public EntityDrop(final String modID,
                      final ItemStack item,
                      final int dropRate,
                      final List<EntityLivingBase> entitys)
    {
        this.modID = modID;
        this.item = item;
        this.dropRate = dropRate;
        this.entitys = entitys;
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
    public EntityDrop(final String modID,
                      final ItemStack item,
                      final int dropRate,
                      final EntityLivingBase[] entitys)
    {
        this(modID, item, dropRate, Arrays.asList(entitys));
    }

    /**
     * @param modID
     *            ID of the mod adding this drop
     * @param item
     *            The Item to drop
     * @param dropRate
     *            the Rate at which to drop it
     * @param entity
     *            the entity's that are allowed to drop it
     */
    public EntityDrop(final String modID,
                      final ItemStack item,
                      final int dropRate,
                      final EntityLivingBase entity)
    {
        this(modID, item, dropRate, Arrays.asList(entity));
    }

    /**
     * @return The ID of the mod that registered this coin
     */
    public String getModID()
    {
        return modID;
    }

    /**
     * @return The item to drop
     */
    public ItemStack getDrop()
    {
        return item;
    }

    /**
     * @return The drop rate
     */
    public int getDropRate()
    {
        return dropRate;
    }
}