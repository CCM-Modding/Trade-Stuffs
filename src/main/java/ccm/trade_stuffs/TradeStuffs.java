/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import ccm.trade_stuffs.proxy.CommonProxy;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Locations;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * TradeStuffs
 * 
 * @author Captain_Shadows
 */
@Mod(modid = Archive.MOD_ID,
     name = Archive.MOD_NAME,
     version = Archive.MOD_VERSION)
public class TradeStuffs
{
    @Instance(Archive.MOD_ID)
    public static TradeStuffs instance;

    @SidedProxy(serverSide = Locations.SERVER_PROXY,
                clientSide = Locations.CLIENT_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        final Configuration config = new Configuration(event.getModConfigurationDirectory());

        Properties.coinsID = config.getItem("Coins", 4000).getInt();

        Properties.walletID = config.getItem("Wallet", 4001).getInt();

        Properties.tradeStationID = config.getBlock("TradeStation", 400).getInt();

        if (config.hasChanged())
        {
            config.save();
        }
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {

    }
}