/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

import ccm.trade_stuffs.inventory.ContainerBank;
import ccm.trade_stuffs.inventory.ContainerEmpty;
import ccm.trade_stuffs.inventory.ContainerSafe;
import ccm.trade_stuffs.inventory.ContainerTrade;
import ccm.trade_stuffs.inventory.ContainerWallet;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * CommonProxy
 * <p>
 * 
 * @author Captain_Shadows
 */
public class CommonProxy implements IGuiHandler {

	public void initRenderingStuffs() {
	}

	public void registerTileEntitys() {
		GameRegistry.registerTileEntity(TileEntityTradeStation.class, "CCM.TradeStation");
		GameRegistry.registerTileEntity(TileEntityBank.class, "CCM.Bank");
		GameRegistry.registerTileEntity(TileEntitySafe.class, "CCM.Safe");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case Guis.GUI_TRADE:
			return new ContainerTrade(player.inventory, (TileEntityTradeStation) world.getBlockTileEntity(x, y, z));
		case Guis.GUI_BANK_COINS:
			TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
			tile.openChest();
			return new ContainerBank(player.inventory, tile.currentAccount.getCoins().setBank(tile), tile, (byte) 0);
		case Guis.GUI_BANK_ITEMS:
			TileEntityBank tile2 = (TileEntityBank) world.getBlockTileEntity(x, y, z);
			tile2.openChest();
			return new ContainerBank(player.inventory, tile2.currentAccount.getItems().setBank(tile2), tile2, (byte) 1);
		case Guis.GUI_WALLET:
			return new ContainerWallet(player.getCurrentEquippedItem(), player);
		case Guis.GUI_SAFE:
			return new ContainerEmpty(player.inventory);
		case Guis.GUI_SAFE_INVENTORY:
			return new ContainerSafe(player.inventory, (TileEntitySafe) world.getBlockTileEntity(x, y, z));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}