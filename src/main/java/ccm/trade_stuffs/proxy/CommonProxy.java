/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.inventory.ContainerTrade;
import ccm.trade_stuffs.tileentity.Bank;
import ccm.trade_stuffs.tileentity.TradeStation;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * CommonProxy
 * <p>
 * 
 * @author Captain_Shadows
 */
public abstract class CommonProxy implements IGuiHandler
{

    public abstract void initRenderingStuffs();

    public void registerTileEntitys()
    {
        GameRegistry.registerTileEntity(TradeStation.class, "CCM.TILE.ENTITY.TRADE.STATION");
    }

    @Override
    public Object getServerGuiElement(final int ID,
                                      final EntityPlayer player,
                                      final World world,
                                      final int x,
                                      final int y,
                                      final int z)
    {
        switch (ID)
        {
            case Guis.GUI_TRADE:
                return new ContainerTrade(player.inventory, (TradeStation) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_BANK:
                return new ContainerBank(player.inventory, (Bank) world.getBlockTileEntity(x, y, z));
            case Guis.GUI_WALLET:
                return new ContainerWallet(player);
            default:
                return null;
        }
    }
}