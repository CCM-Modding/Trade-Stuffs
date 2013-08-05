/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

import ccm.trade_stuffs.tileentity.TileEntityBank;

/**
 * ContainerTrade
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerBank extends ContainerBase {

	private TileEntityBank bank;

	public ContainerBank(InventoryPlayer player, TileEntityBank tile) {
		super(player);
		bank = tile;
		addPlayerInventory(15, 139);
		
		for(int row = 0; row < 6; row++) {
			for(int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(bank, column + (row * 9) + 9, 8 + (column * 18), 18 + (row * 18)));
			}
		}
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			bank.openChest();
		}
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			bank.closeChest();
		}
		bank.setInUse(false);
	}
}