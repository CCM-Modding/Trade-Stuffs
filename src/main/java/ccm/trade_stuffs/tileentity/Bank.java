/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

/**
 * Bank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Bank extends BaseInventory {

	@Override
	public String getInvName() {
		return "inventory.bank";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return false;
	}
}