/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

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

    }

    public void addPlayerInventory(final InventoryPlayer player)
    {
        // Player's Inventory
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                addSlotToContainer(new Slot(player,
                                            column + (row * 9) + 9,
                                            8 + (column * 18),
                                            94 + (row * 18)));
            }
        }
        // Player's Hot Bar
        for (int index = 0; index < 9; index++)
        {
            addSlotToContainer(new Slot(player, index, 8 + (index * 18), 152));
        }
    }

    @Override
    public boolean canInteractWith(final EntityPlayer player)
    {
        return true;
    }
}