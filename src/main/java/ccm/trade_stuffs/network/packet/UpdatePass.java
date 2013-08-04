/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

import ccm.trade_stuffs.tileentity.Safe;

/**
 * UpdatePass
 * <p>
 * 
 * @author Captain_Shadows
 */
public class UpdatePass extends Packet
{
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
    public UpdatePass(final Safe safe, final String pass)
    {
        xPosition = safe.xCoord;
        yPosition = safe.yCoord;
        zPosition = safe.zCoord;
        this.pass = Byte.valueOf(pass);
    }

    @Override
    public void readPacketData(final DataInput data) throws IOException
    {
        xPosition = data.readInt();
        yPosition = data.readShort();
        zPosition = data.readInt();
        pass = data.readByte();
    }

    @Override
    public void writePacketData(final DataOutput data) throws IOException
    {
        data.writeInt(xPosition);
        data.writeShort(yPosition);
        data.writeInt(zPosition);
        data.writeByte(pass);
    }

    @Override
    public void processPacket(final NetHandler nethandler)
    {}

    @Override
    public int getPacketSize()
    {
        return 0;
    }

}
