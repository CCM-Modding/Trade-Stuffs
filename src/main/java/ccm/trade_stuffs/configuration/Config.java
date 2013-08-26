/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.configuration;

import ccm.nucleum.omnium.configuration.AdvConfiguration;
import ccm.nucleum.omnium.utils.handler.config.IConfig;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * Config
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class Config implements IConfig
{
    AdvConfiguration config;

    @Override
    public AdvConfiguration getConfiguration()
    {
        return config;
    }

    @Override
    public IConfig setConfiguration(final AdvConfiguration config)
    {
        this.config = config;
        return this;
    }

    @Override
    public void init()
    {
        loadItemsBlocks();

        loadCoinDrops();
        loadBagDrops();
        loadRandom();
    }

    private void loadItemsBlocks()
    {
        Properties.tradeStationID = config.getBlock("TradeStation", 400).getInt();
        Properties.bankID = config.getBlock("Bank", 401).getInt();
        Properties.safeID = config.getBlock("Safe", 402).getInt();
        Properties.coinsID = config.getItem("Coins", 4000).getInt();
        Properties.walletID = config.getItem("Wallet", 4001).getInt();
    }

    private void loadCoinDrops()
    {
        final String cat = "CoinDrops";
        config.addCustomCategoryComment(cat, "Coin Type,Drop Chance, Min/Max Drops are all editable here per mob. " + "Coin Type (Type of coin)" + "     0 = Copper (Value of 1)"
                + "     1 = Silver (Value of 25)" + "     2 = Gold (Value of 50)" + "     3 = Platnum (Value of 100)" + "Drop Chance (Keep in 0.00 Format unless set to 1!)"
                + "Minimum Drop (The most amount of coins one mob can drop.)" + "Maximum Drop (The least amount of coins one mob can drop.)");

        loadPassive();

        loadHostile();

        loadBoss();
    }

    private void loadPassive()
    {
        String cat = "CoinDrops.Passive";
        config.addCustomCategoryComment(cat, "Values For Passive Mobs");

        cat = "CoinDrops.Passive.Villager";
        Properties.COIN_TYPE_VILLAGER = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_VILLAGER_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_VILLAGER_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 10).getInt();
        Properties.COIN_VILLAGERS_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 20).getInt();

        cat = "CoinDrops.Passive.Horse";
        Properties.COIN_TYPE_HORSE = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_HORSE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_HORSE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_HORSE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Ocelot";
        Properties.COIN_TYPE_OCELOT = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_OCELOT_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_OCELOT_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_OCELOT_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Mooshroom";
        Properties.COIN_TYPE_MOOSHROOM = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_MOOSHROOM_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_MOOSHROOM_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_MOOSHROOM_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Wolf";
        Properties.COIN_TYPE_WOLF = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_WOLF_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_WOLF_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 5).getInt();
        Properties.COIN_WOLF_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Passive.Squid";
        Properties.COIN_TYPE_SQUID = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SQUID_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_SQUID_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_SQUID_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Chicken";
        Properties.COIN_TYPE_CHICKEN = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_CHICKEN_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_CHICKEN_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_CHICKEN_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Cow";
        Properties.COIN_TYPE_COW = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_COW_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_COW_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_COW_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Sheep";
        Properties.COIN_TYPE_SHEEP = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SHEEP_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_SHEEP_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_SHEEP_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Passive.Bat";
        Properties.COIN_TYPE_BAT = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_BAT_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.10).getDouble(0.10);
        Properties.COIN_BAT_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_BAT_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Passive.Pig";
        Properties.COIN_TYPE_PIG = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_PIG_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_PIG_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_PIG_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();
    }

    private void loadHostile()
    {
        String cat = "CoinDrops.Hostile";
        config.addCustomCategoryComment(cat, "Values For Hostile Mobs");

        cat = "CoinDrops.Hostile.Witch";
        Properties.COIN_TYPE_WITCH = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_WITCH_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.25).getDouble(0.25);
        Properties.COIN_WITCH_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 15).getInt();
        Properties.COIN_WITCH_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 25).getInt();

        cat = "CoinDrops.Hostile.MagmaCube";
        Properties.COIN_TYPE_MAGMACUBE = config.get(cat, "Coin_Type", 1).getInt();
        Properties.COIN_MAGMACUBE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.80).getDouble(0.80);
        Properties.COIN_MAGMACUBE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_MAGMACUBE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 3).getInt();

        cat = "CoinDrops.Hostile.Blaze";
        Properties.COIN_TYPE_BLAZE = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_BLAZE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.65).getDouble(0.65);
        Properties.COIN_BLAZE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 35).getInt();
        Properties.COIN_BLAZE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 45).getInt();

        cat = "CoinDrops.Hostile.SilverFish";
        Properties.COIN_TYPE_SILVERFISH = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SILVERFISH_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_SILVERFISH_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_SILVERFISH_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Hostile.CaveSpider";
        Properties.COIN_TYPE_CAVESPIDER = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_CAVESPIDER_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.15).getDouble(0.15);
        Properties.COIN_CAVESPIDER_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 5).getInt();
        Properties.COIN_CAVESPIDER_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 25).getInt();

        cat = "CoinDrops.Hostile.Endermen";
        Properties.COIN_TYPE_ENDERMEN = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_ENDERMEN_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.60).getDouble(0.60);
        Properties.COIN_ENDERMEN_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 35).getInt();
        Properties.COIN_ENDERMEN_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 45).getInt();

        cat = "CoinDrops.Hostile.PigZombie";
        Properties.COIN_TYPE_PIGZOMBIE = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_PIGZOMBIE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.25).getDouble(0.25);
        Properties.COIN_PIGZOMBIE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 10).getInt();
        Properties.COIN_PIGZOMBIE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 15).getInt();

        cat = "CoinDrops.Hostile.Ghast";
        Properties.COIN_TYPE_GHAST = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_GHAST_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.30).getDouble(0.30);
        Properties.COIN_GHAST_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 15).getInt();
        Properties.COIN_GHAST_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 25).getInt();

        cat = "CoinDrops.Hostile.Slime";
        Properties.COIN_TYPE_SLIME = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SLIME_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.05).getDouble(0.05);
        Properties.COIN_SLIME_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_SLIME_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Hostile.Zombie";
        Properties.COIN_TYPE_ZOMBIE = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_ZOMBIE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.25).getDouble(0.25);
        Properties.COIN_ZOMBIE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_ZOMBIE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Hostile.GiantZombie";
        Properties.COIN_TYPE_GIANTZOMBIE = config.get(cat, "Coin_Type", 1).getInt();
        Properties.COIN_GIANTZOMBIE_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.70).getDouble(0.70);
        Properties.COIN_GIANTZOMBIE_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_GIANTZOMBIE_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 5).getInt();

        cat = "CoinDrops.Hostile.Spider";
        Properties.COIN_TYPE_SPIDER = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SPIDER_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.25).getDouble(0.25);
        Properties.COIN_SPIDER_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 1).getInt();
        Properties.COIN_SPIDER_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 10).getInt();

        cat = "CoinDrops.Hostile.Skeleton";
        Properties.COIN_TYPE_SKELETON = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_SKELETON_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.30).getDouble(0.30);
        Properties.COIN_SKELETON_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 5).getInt();
        Properties.COIN_SKELETON_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 15).getInt();

        cat = "CoinDrops.Hostile.Creeper";
        Properties.COIN_TYPE_CREEPER = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_CREEPER_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.40).getDouble(0.40);
        Properties.COIN_CREEPER_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 15).getInt();
        Properties.COIN_CREEPER_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 30).getInt();
    }

    private void loadBoss()
    {
        String cat = "CoinDrops.Boss";
        config.addCustomCategoryComment(cat, "Values for Boss Mobs");

        cat = "CoinDrops.Boss.EnderDragon";
        Properties.COIN_TYPE_DRAGON = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_DRAGON_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 1).getDouble(1);
        Properties.COIN_DRAGON_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 900).getInt();
        Properties.COIN_DRAGON_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 1100).getInt();

        cat = "CoinDrops.Boss.Wither";
        Properties.COIN_TYPE_WITHER = config.get(cat, "Coin_Type", 0).getInt();
        Properties.COIN_WITHER_DROP_CHANCE = config.get(cat, "Coin_Drop_Chance", 0.75).getDouble(0.75);
        Properties.COIN_WITHER_MIN_DROP = config.get(cat, "Coin_Minimum_Drop", 75).getInt();
        Properties.COIN_WITHER_MAX_DROP = config.get(cat, "Coin_Maximum_Drop", 225).getInt();
    }

    private void loadBagDrops()
    {
        String cat = "BagDrops";
        config.addCustomCategoryComment(
                cat,
                "All of the Bag Drops are set in this category. (Boss mobs only. Unless someone else changes it.) If you want a boss to drop a garenteed drop you need to use the same numbers in min/max and one in the chance.");
        // List of all the config options for Bag drops.

        cat = "BagDrops.EnderDragon";
        Properties.WALLET_DRAGON_DROP_CHANCE = config.get(cat, "Bag_Drop_Chance", 1).getDouble(1);
        Properties.WALLET_DRAGON_MIN_DROP = config.get(cat, "Bag_Minimum_Drop", 2).getInt();
        Properties.WALLET_DRAGON_MAX_DROP = config.get(cat, "Bag_Maximum_Drop", 2).getInt();

        cat = "BagDrops.Wither";
        Properties.WALLET_WITHER_DROP_CHANCE = config.get(cat, "Bag_Drop_Chance", 0.50).getDouble(0.50);
        Properties.WALLET_WITHER_MIN_DROP = config.get(cat, "Bag_Minimum_Drop", 1).getInt();
        Properties.WALLET_WITHER_MAX_DROP = config.get(cat, "Bag_Maximum_Drop", 1).getInt();
    }

    private void loadRandom()
    {
        final String cat = "RandomConfigs";
        config.addCustomCategoryComment(cat, "Random Configurations");
        Properties.WALLET_STACKS_PER_COIN = config.get(cat, "Maximum number of stacks per type of coin inside of the wallet", 8).getInt();
        // Changes the max stacks per coin type.
        Properties.BANK_STACKS_PER_COIN = config.get(cat, "Maximum number of stacks per type of coin inside of the Bank", ((Integer.MAX_VALUE + 1) / 64) - 64).getInt();
        // Changes the amount of items in each stack.
        Properties.BANK_ITEMS_PER_ITEM = config.get(cat, "Maximum number of items per stack", 256).getInt();
    }
}