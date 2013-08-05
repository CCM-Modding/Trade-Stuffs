/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import static ccm.trade_stuffs.items.ModItems.coin;
import static ccm.trade_stuffs.utils.lib.Archive.MOD_ID;

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

import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.api.drops.EntityDrops;

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
        CoinTypes.registerCoinType(MOD_ID, "copper", 1);
        CoinTypes.registerCoinType(MOD_ID, "silver", 25);
        CoinTypes.registerCoinType(MOD_ID, "gold", 50);
        CoinTypes.registerCoinType(MOD_ID, "platinum", 100);
    }

    public static void addMobDrops()
    {
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.40F, 15,  30,   EntityCreeper.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.30F, 5,   15,   EntitySkeleton.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.25F, 1,   10,   EntitySpider.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,1), 0.70F, 1,   5,    EntityGiantZombie.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.25F, 1,   10,   EntityZombie.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   10,   EntitySlime.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.30F, 15,  25,   EntityGhast.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.25F, 10,  15,   EntityPigZombie.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.60F, 35,  45,   EntityEnderman.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.15F, 5,   25,   EntityCaveSpider.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   10,   EntitySilverfish.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.65F, 35,  45,   EntityBlaze.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,2), 0.90F, 1,   2,    EntityMagmaCube.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 1.00F, 900, 1100, EntityDragon.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,2), 0.75F, 3,   9,    EntityWither.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.10F, 1,   10,   EntityBat.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.25F, 15,  25,   EntityWitch.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityPig.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntitySheep.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityCow.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityChicken.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntitySquid.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 5,   10,   EntityWolf.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityMooshroom.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityOcelot.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 1,   5,    EntityHorse.class);
        EntityDrops.registerDrop(MOD_ID, new ItemStack(coin,0,0), 0.05F, 10,  20,   EntityVillager.class);
    }
}
