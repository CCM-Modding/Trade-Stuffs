/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

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
        // TradeStationBlock.renderID = RenderingRegistry.getNextAvailableRenderId();

        // MinecraftForgeClient.registerItemRenderer(Properties.tradeStationID, new TradeItemRenderer());
    }

    @Override
    public void registerTileEntitys()
    {
        super.registerTileEntitys();

        // ClientRegistry.bindTileEntitySpecialRenderer(TradeStation.class, new TradeTileRenderer());
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