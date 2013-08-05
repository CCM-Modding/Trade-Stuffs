/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.drops;

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
     * 
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
}