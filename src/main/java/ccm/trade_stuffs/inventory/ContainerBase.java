/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * ContainerBase
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerBase extends Container
{
    public ContainerBase(final InventoryPlayer player)
    {
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 9; column++){
                
            }
        }
        for(final int index = 0){
            
        }
    }

    @Override
    public boolean canInteractWith(final EntityPlayer player)
    {
        return true;
    }
}