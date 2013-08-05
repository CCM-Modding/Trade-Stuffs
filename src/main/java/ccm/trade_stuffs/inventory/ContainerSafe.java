/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

import ccm.trade_stuffs.tileentity.TileEntitySafe;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerSafe extends ContainerBase {
	
	private TileEntitySafe safe;

	public ContainerSafe(InventoryPlayer player, TileEntitySafe safe) {
		super(player);
		this.safe = safe;
		addPlayerInventory(15, 139);

		for(int row = 0; row < 6; row++) {
			for(int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(safe, column + (row * 9) + 9, 8 + (column * 18), 18 + (row * 18)));
			}
		}
	}
}