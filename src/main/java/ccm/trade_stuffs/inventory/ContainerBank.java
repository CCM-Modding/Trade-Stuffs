/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;

import ccm.trade_stuffs.tileentity.Bank;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerBank extends ContainerBase {
	
	private Bank bank;

	public ContainerBank(InventoryPlayer player, Bank tile) {
		super(player);
		bank = tile;
		addPlayerInventory(15, 139);
	}
}