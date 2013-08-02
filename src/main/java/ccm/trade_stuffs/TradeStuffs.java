/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

import ccm.trade_stuffs.blocks.ModBlocks;
import ccm.trade_stuffs.configuration.Config;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.proxy.CommonProxy;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Locations;

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
        Config.load(event);

        ModBlocks.init();

        ModItems.init();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {

    }
}