/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import static ccm.trade_stuffs.items.ModItems.wallet;
import static ccm.trade_stuffs.utils.lib.Archive.MOD_ID;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;

import ccm.nucleum.omnium.utils.handler.entity.drop.EntityDropHandler;
import ccm.trade_stuffs.utils.lib.Properties;

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
        EntityDropHandler.registerDrop(MOD_ID, new ItemStack(wallet), Properties.WALLET_DRAGON_DROP_CHANCE, Properties.WALLET_DRAGON_MIN_DROP, Properties.WALLET_DRAGON_MAX_DROP,
                EntityDragon.class);
        EntityDropHandler.registerDrop(MOD_ID, new ItemStack(wallet), Properties.WALLET_WITHER_DROP_CHANCE, Properties.WALLET_WITHER_MIN_DROP, Properties.WALLET_WITHER_MAX_DROP,
                EntityWither.class);
    }
}