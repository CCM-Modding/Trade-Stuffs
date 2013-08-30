/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import static ccm.trade_stuffs.items.ModItems.coin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;

import ccm.nucleum.omnium.utils.handler.entity.drop.EntityDropHandler;
import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * CoinAdditionRegistry
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class CoinAdditionRegistry
{

    public static void addCoins()
    {
        register("copper", 1);
        register("silver", 25);
        register("gold", 50);
        register("platinum", 100);
    }

    public static void addMobDrops()
    {
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_CREEPER), Properties.COIN_CREEPER_DROP_CHANCE, Properties.COIN_CREEPER_MIN_DROP, Properties.COIN_CREEPER_MAX_DROP,
                EntityCreeper.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SKELETON), Properties.COIN_SKELETON_DROP_CHANCE, Properties.COIN_SKELETON_MIN_DROP, Properties.COIN_SKELETON_MAX_DROP,
                EntitySkeleton.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SPIDER), Properties.COIN_SPIDER_DROP_CHANCE, Properties.COIN_SPIDER_MIN_DROP, Properties.COIN_SPIDER_MAX_DROP,
                EntitySpider.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_GIANTZOMBIE), Properties.COIN_GIANTZOMBIE_DROP_CHANCE, Properties.COIN_GIANTZOMBIE_MIN_DROP,
                Properties.COIN_GIANTZOMBIE_MAX_DROP, EntityGiantZombie.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_ZOMBIE), Properties.COIN_ZOMBIE_DROP_CHANCE, Properties.COIN_ZOMBIE_MIN_DROP, Properties.COIN_ZOMBIE_MAX_DROP,
                EntityZombie.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SLIME), Properties.COIN_SLIME_DROP_CHANCE, Properties.COIN_SLIME_MIN_DROP, Properties.COIN_SLIME_MAX_DROP,
                EntitySlime.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_GHAST), Properties.COIN_GHAST_DROP_CHANCE, Properties.COIN_GHAST_MIN_DROP, Properties.COIN_GHAST_MAX_DROP,
                EntityGhast.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_PIGZOMBIE), Properties.COIN_PIGZOMBIE_DROP_CHANCE, Properties.COIN_PIGZOMBIE_MIN_DROP,
                Properties.COIN_PIGZOMBIE_MAX_DROP, EntityPigZombie.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_ENDERMEN), Properties.COIN_ENDERMEN_DROP_CHANCE, Properties.COIN_ENDERMEN_MIN_DROP, Properties.COIN_ENDERMEN_MAX_DROP,
                EntityEnderman.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_CAVESPIDER), Properties.COIN_CAVESPIDER_DROP_CHANCE, Properties.COIN_CAVESPIDER_MIN_DROP,
                Properties.COIN_CAVESPIDER_MAX_DROP, EntityCaveSpider.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SILVERFISH), Properties.COIN_SILVERFISH_DROP_CHANCE, Properties.COIN_SILVERFISH_MIN_DROP,
                Properties.COIN_SILVERFISH_MAX_DROP, EntitySilverfish.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_BLAZE), Properties.COIN_BLAZE_DROP_CHANCE, Properties.COIN_BLAZE_MIN_DROP, Properties.COIN_BLAZE_MAX_DROP,
                EntityBlaze.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_MAGMACUBE), Properties.COIN_MAGMACUBE_DROP_CHANCE, Properties.COIN_MAGMACUBE_MIN_DROP,
                Properties.COIN_MAGMACUBE_MAX_DROP, EntityMagmaCube.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_DRAGON), Properties.COIN_DRAGON_DROP_CHANCE, Properties.COIN_DRAGON_MIN_DROP, Properties.COIN_DRAGON_MAX_DROP,
                EntityDragon.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_WITHER), Properties.COIN_WITHER_DROP_CHANCE, Properties.COIN_WITHER_MIN_DROP, Properties.COIN_WITHER_MAX_DROP,
                EntityWither.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_BAT), Properties.COIN_BAT_DROP_CHANCE, Properties.COIN_BAT_MIN_DROP, Properties.COIN_BAT_MAX_DROP, EntityBat.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_WITCH), Properties.COIN_WITCH_DROP_CHANCE, Properties.COIN_WITCH_MIN_DROP, Properties.COIN_WITCH_MAX_DROP,
                EntityWitch.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_PIG), Properties.COIN_PIG_DROP_CHANCE, Properties.COIN_PIG_MIN_DROP, Properties.COIN_PIG_MAX_DROP, EntityPig.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SHEEP), Properties.COIN_SHEEP_DROP_CHANCE, Properties.COIN_SHEEP_MIN_DROP, Properties.COIN_SHEEP_MAX_DROP,
                EntitySheep.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_COW), Properties.COIN_COW_DROP_CHANCE, Properties.COIN_COW_MIN_DROP, Properties.COIN_COW_MAX_DROP, EntityCow.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_CHICKEN), Properties.COIN_CHICKEN_DROP_CHANCE, Properties.COIN_CHICKEN_MIN_DROP, Properties.COIN_CHICKEN_MAX_DROP,
                EntityChicken.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_SQUID), Properties.COIN_SQUID_DROP_CHANCE, Properties.COIN_SQUID_MIN_DROP, Properties.COIN_SQUID_MAX_DROP,
                EntitySquid.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_WOLF), Properties.COIN_WOLF_DROP_CHANCE, Properties.COIN_WOLF_MIN_DROP, Properties.COIN_WOLF_MAX_DROP,
                EntityWolf.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_MOOSHROOM), Properties.COIN_MOOSHROOM_DROP_CHANCE, Properties.COIN_MOOSHROOM_MIN_DROP,
                Properties.COIN_MOOSHROOM_MAX_DROP, EntityMooshroom.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_OCELOT), Properties.COIN_OCELOT_DROP_CHANCE, Properties.COIN_OCELOT_MIN_DROP, Properties.COIN_OCELOT_MAX_DROP,
                EntityOcelot.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_HORSE), Properties.COIN_HORSE_DROP_CHANCE, Properties.COIN_HORSE_MIN_DROP, Properties.COIN_HORSE_MAX_DROP,
                EntityHorse.class);
        register(new ItemStack(coin, 0, Properties.COIN_TYPE_VILLAGER), Properties.COIN_VILLAGER_DROP_CHANCE, Properties.COIN_VILLAGER_MIN_DROP,
                Properties.COIN_VILLAGERS_MAX_DROP, EntityVillager.class);
    }

    static void register(final ItemStack item, final double dropRate, final int minValue, final int maxValue, final Class<? extends Entity> entity)
    {
        EntityDropHandler.registerDrop(TradeStuffs.instance, item, (float) dropRate, minValue, maxValue, entity);
    }

    static void register(final String name, final int value)
    {
        CoinTypes.registerCoinType(TradeStuffs.instance, name, value);
    }
}