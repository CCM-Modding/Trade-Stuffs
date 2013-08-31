/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import ccm.nucleum.omnium.BaseMod;
import ccm.nucleum.omnium.IMod;
import ccm.nucleum.omnium.creativetab.CreativeTab;
import ccm.nucleum.omnium.utils.handler.ModLoadingHandler;
import ccm.nucleum.omnium.utils.handler.config.ConfigurationHandler;
import ccm.nucleum.omnium.utils.handler.config.NOConfig;
import ccm.trade_stuffs.blocks.ModBlocks;
import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.proxy.CommonProxy;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Locations;
import ccm.trade_stuffs.utils.registry.Registry;

@Mod(modid = Archive.MOD_ID, name = Archive.MOD_NAME, useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TradeStuffs extends BaseMod implements IMod
{
    @Instance(Archive.MOD_ID)
    public static TradeStuffs instance;

    @SidedProxy(serverSide = Locations.SERVER_PROXY, clientSide = Locations.CLIENT_PROXY)
    public static CommonProxy proxy;

    public static CreativeTab tab = new CreativeTab(Archive.MOD_ID);

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        ModLoadingHandler.loadMod(this);

        initializeConfig(event);
        ConfigurationHandler.init(this, NOConfig.class);

        ModBlocks.init();
        ModItems.init();

        tab.init(new ItemStack(ModItems.coin));
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        proxy.registerTileEntitys();
        proxy.initRenderingStuffs();

        Registry.init();
    }
}