/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.api.drops;

import java.util.ArrayList;
import java.util.List;

/**
 * EntityDrops
 * <p>
 * 
 * @author Captain_Shadows
 */
public class EntityDrops
{
    private static final List<EntityDrop> drops = new ArrayList<EntityDrop>();

    public static void registerDrop(final EntityDrop drop)
    {
        drops.add(drop);
    }
}
