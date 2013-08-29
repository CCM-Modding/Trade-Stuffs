/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

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
}