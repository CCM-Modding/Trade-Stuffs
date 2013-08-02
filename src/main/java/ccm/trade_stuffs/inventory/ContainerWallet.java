/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.inventory;

import net.minecraft.entity.player.EntityPlayer;

/**
 * ContainerWallet
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ContainerWallet extends ContainerBase
{
    private final EntityPlayer player;

    public ContainerWallet(final EntityPlayer player)
    {
        super(player.inventory);
        this.player = player;
    }
}
