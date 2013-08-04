/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.Safe;

/**
 * UpdatePass
 * <p>
 * 
 * @author Captain_Shadows
 */
public class UpdatePass extends Packet
{
    /** The ID of the world. */
    public int  worldID;

    /** The X position of the tile entity to update. */
    public int  xPosition;

    /** The Y position of the tile entity to update. */
    public int  yPosition;

    /** The Z position of the tile entity to update. */
    public int  zPosition;
    /** The pass */
    public byte pass;

    /**
     * @param safe
     * @param pass
     */
    public UpdatePass(final int worldID, final Safe safe, final String pass)
    {
        this.worldID = worldID;
        xPosition = safe.xCoord;
        yPosition = safe.yCoord;
        zPosition = safe.zCoord;
        this.pass = Byte.valueOf(pass);
    }

    @Override
    public void readPacketData(final DataInput data) throws IOException
    {
        worldID = data.readInt();
        xPosition = data.readInt();
        yPosition = data.readShort();
        zPosition = data.readInt();
        pass = data.readByte();
    }

    @Override
    public void writePacketData(final DataOutput data) throws IOException
    {
        data.writeInt(worldID);
        data.writeInt(xPosition);
        data.writeShort(yPosition);
        data.writeInt(zPosition);
        data.writeByte(pass);
    }

    @Override
    public void processPacket(final NetHandler nethandler)
    {
        TradeStuffs.proxy.handlePassUpdate(worldID, xPosition, yPosition, zPosition, pass);
    }

    @Override
    public int getPacketSize()
    {
        return 20;
    }

}
