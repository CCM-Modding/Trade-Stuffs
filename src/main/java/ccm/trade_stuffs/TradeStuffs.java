/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import ccm.trade_stuffs.utils.lib.Archive;

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

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {

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