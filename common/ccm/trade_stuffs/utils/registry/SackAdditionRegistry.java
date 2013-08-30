/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import static ccm.trade_stuffs.items.ModItems.wallet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;

import ccm.nucleum.omnium.utils.handler.entity.drop.EntityDropHandler;
import ccm.trade_stuffs.TradeStuffs;
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
        register(new ItemStack(wallet), Properties.WALLET_DRAGON_DROP_CHANCE, Properties.WALLET_DRAGON_MIN_DROP, Properties.WALLET_DRAGON_MAX_DROP, EntityDragon.class);
        register(new ItemStack(wallet), Properties.WALLET_WITHER_DROP_CHANCE, Properties.WALLET_WITHER_MIN_DROP, Properties.WALLET_WITHER_MAX_DROP, EntityWither.class);
    }

    static void register(final ItemStack item, final double dropRate, final int minValue, final int maxValue, final Class<? extends Entity> entity)
    {
        EntityDropHandler.registerDrop(TradeStuffs.instance, item, (float) dropRate, minValue, maxValue, entity);
    }
}