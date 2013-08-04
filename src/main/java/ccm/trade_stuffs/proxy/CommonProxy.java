/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.inventory.ContainerTrade;
import ccm.trade_stuffs.inventory.ContainerWallet;
import ccm.trade_stuffs.tileentity.Bank;
import ccm.trade_stuffs.tileentity.Safe;
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
        GameRegistry.registerTileEntity(Bank.class, "CCM.TILE.ENTITY.BANK");
        GameRegistry.registerTileEntity(Safe.class, "CCM.TILE.ENTITY.SAFE");
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
                return new ContainerWallet(player.getCurrentEquippedItem(), player);
            case Guis.GUI_SAFE:
                return new ContainerSafe(player.inventory, (Safe) world.getBlockTileEntity(x, y, z));
            default:
                return null;
        }
    }

    /**
     * @param worldID
     * @param xPosition
     * @param yPosition
     * @param zPosition
     * @param pass
     */
    public void handlePassUpdate(final int worldID,
                                 final int xPosition,
                                 final int yPosition,
                                 final int zPosition,
                                 final byte pass)
    {
        final Safe safe = (Safe) TradeStuffs.instance.server.worldServers[worldID].getBlockTileEntity(xPosition,
                                                                                                      yPosition,
                                                                                                      zPosition);
        safe.setPass(String.valueOf(pass));
    }
}