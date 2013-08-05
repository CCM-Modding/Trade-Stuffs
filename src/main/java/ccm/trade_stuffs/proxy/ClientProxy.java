/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import ccm.trade_stuffs.client.inventory.gui.uiBank;
import ccm.trade_stuffs.client.inventory.gui.uiSafe;
import ccm.trade_stuffs.client.inventory.gui.uiTrade;
import ccm.trade_stuffs.client.inventory.gui.uiWallet;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;
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
                return new uiTrade(player.inventory, (TileEntityTradeStation) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_BANK:
                return new uiBank(player.inventory, (TileEntityBank) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_WALLET:
                return new uiWallet(player.getCurrentEquippedItem(), player);
            case Guis.GUI_SAFE:
                return new uiSafe(player.inventory, (TileEntitySafe) world.getBlockTileEntity(x, y, z));
            default:
                return null;
        }
    }
}