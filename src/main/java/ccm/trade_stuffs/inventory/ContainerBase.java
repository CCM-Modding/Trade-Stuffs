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
    protected InventoryPlayer player;

    public ContainerBase(final InventoryPlayer player)
    {
        this.player = player;
    }

    public void addPlayerInventory(final int x, final int y)
    {
        // Player's Inventory
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                addSlotToContainer(new Slot(player, column + (row * 9) + 9, x + (column * 18), y + (row * 18)));
            }
        }
        // Player's Hot Bar
        for (int index = 0; index < 9; index++)
        {
            addSlotToContainer(new Slot(player, index, x + (index * 18), y + 58));
        }
    }

    @Override
    public boolean canInteractWith(final EntityPlayer player)
    {
        return true;
    }
}