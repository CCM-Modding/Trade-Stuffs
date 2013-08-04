/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * PacketHandler
 * <p>
 * 
 * @author Captain_Shadows
 */
public class PacketHandler implements IPacketHandler
{

    @Override
    public void onPacketData(final INetworkManager manager,
                             final Packet250CustomPayload packet,
                             final Player player)
    {}
}