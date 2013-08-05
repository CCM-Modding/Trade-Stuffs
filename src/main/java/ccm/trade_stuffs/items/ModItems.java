/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.api.drops.EntityDrops;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ModItems
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ModItems
{
    public static Item     coin;

    public static Item     wallet;

    public static ItemReed tradeStation;

    public static void init()
    {
        coin = new CoinItem(Properties.coinsID);
        wallet = new WalletItem(Properties.walletID);

        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityCreeper.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySkeleton.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySpider.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityGiantZombie.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityZombie.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySlime.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityGhast.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityPigZombie.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityEnderman.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityCaveSpider.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySilverfish.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityBlaze.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityMagmaCube.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityDragon.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityWither.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityBat.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityWitch.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityPig.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySheep.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityCow.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityChicken.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntitySquid.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityWolf.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityMooshroom.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityOcelot.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityHorse.class);
        EntityDrops.registerDrop(Archive.MOD_ID, new ItemStack(coin), 1, 0.05F, EntityVillager.class);

        GameRegistry.registerItem(coin, "CCM.COIN", Archive.MOD_ID);
        GameRegistry.registerItem(wallet, "CCM.WALLET", Archive.MOD_ID);
    }
}