/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import static ccm.trade_stuffs.items.ModItems.wallet;
import static ccm.trade_stuffs.utils.lib.Archive.MOD_ID;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;
import ccm.trade_stuffs.api.drops.EntityDrops;

/**
 * SackAdditionRegistry
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class SackAdditionRegistry
{
    public static void addMobDrops()
    {
        EntityDrops.registerDrop(MOD_ID, new ItemStack(wallet), 1F,   2, 2, EntityDragon.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(wallet), 0.5F, 1, 1, EntityWither.class);
    }
}