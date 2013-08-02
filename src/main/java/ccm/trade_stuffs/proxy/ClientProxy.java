/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.blocks.TradeStationBlock;
import ccm.trade_stuffs.client.renderer.item.TradeItemRenderer;
import ccm.trade_stuffs.tileentity.TradeStation;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * ClientProxy
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void initRenderingStuffs()
    {
        TradeStationBlock.renderID = RenderingRegistry.getNextAvailableRenderId();

        MinecraftForgeClient.registerItemRenderer(Properties.tradeStationID, new TradeItemRenderer());
    }

    @Override
    public void registerTileEntitys()
    {
        GameRegistry.registerTileEntity(TradeStation.class, "CCM.TILE.ENTITY.TRADE.STATION");
    }

    @Override
    public Object getClientGuiElement(final int ID,
                                      final EntityPlayer player,
                                      final World world,
                                      final int x,
                                      final int y,
                                      final int z)
    {
        return null;
    }
}