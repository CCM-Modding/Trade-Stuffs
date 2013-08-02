/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * CommonProxy
 * <p>
 * 
 * @author Captain_Shadows
 */
public abstract class CommonProxy implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(final int ID,
                                      final EntityPlayer player,
                                      final World world,
                                      final int x,
                                      final int y,
                                      final int z)
    {
        return null;
    }
}