/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import ccm.trade_stuffs.client.inventory.gui.GUIBank;
import ccm.trade_stuffs.client.inventory.gui.GUITrade;
import ccm.trade_stuffs.tileentity.Bank;
import ccm.trade_stuffs.tileentity.TradeStation;
import ccm.trade_stuffs.utils.lib.Guis;

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
        switch (ID)
        {
            case Guis.GUI_TRADE:
                return new GUITrade(player.inventory, (TradeStation) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_BANK:
                return new GUIBank(player.inventory, (Bank) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_WALLET:
                return new GUIWallet(player);

            default:
                return null;
        }
    }
}