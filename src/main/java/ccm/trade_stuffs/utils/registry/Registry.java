/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.registry;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.utils.handler.EntityHandler;
import ccm.trade_stuffs.utils.handler.ItemHandler;
import ccm.trade_stuffs.utils.handler.PlayerStalker;
import ccm.trade_stuffs.utils.handler.WorldHandler;

/**
 * Registry
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Registry
{

    public static void init()
    {
        CoinAdditionRegistry.addCoins();

        final PlayerStalker playerStalker = new PlayerStalker();

        MinecraftForge.EVENT_BUS.register(new ItemHandler());
        MinecraftForge.EVENT_BUS.register(new EntityHandler());
        MinecraftForge.EVENT_BUS.register(new WorldHandler());
        MinecraftForge.EVENT_BUS.register(playerStalker);

        GameRegistry.registerPlayerTracker(playerStalker);

        CoinAdditionRegistry.addMobDrops();
        SackAdditionRegistry.addMobDrops();
    }
}