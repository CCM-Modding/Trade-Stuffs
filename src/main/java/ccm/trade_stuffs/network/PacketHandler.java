package ccm.trade_stuffs.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;

public class PacketHandler implements IPacketHandler
{

    @Override
    public void onPacketData(final INetworkManager manager,
                             final Packet250CustomPayload packet,
                             final Player player)
    {
        final ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
        final int packetID = dat.readInt();
        final World world = Minecraft.getMinecraft().theWorld;

        switch (packetID)
        {
            case 0:
                handleTileEntityBank(world, dat);
                break;
            // CLIENT TO SERVER
            case 10:
                handleBankTabUpdate(world, dat);
                break;
            case 11:
                handleSafeTabUpdate(world, dat);
                break;
            case 12:
                handleSafePassUpdate(world, dat);
                break;
        }
    }

    private void handleTileEntityBank(final World world, final ByteArrayDataInput dat)
    {
        final int x = dat.readInt();
        final int y = dat.readInt();
        final int z = dat.readInt();

        TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
        if (tile == null)
        {
            tile = new TileEntityBank();
            world.setBlockTileEntity(x, y, z, tile);
        }
        tile.bankName = dat.readUTF();
    }

    private void handleBankTabUpdate(final World world, final ByteArrayDataInput dat)
    {
        final int x = dat.readInt();
        final int y = dat.readInt();
        final int z = dat.readInt();

        TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
        if (tile == null)
        {
            tile = new TileEntityBank();
            world.setBlockTileEntity(x, y, z, tile);
        }
        tile.setSelectedTab(dat.readByte());
    }

    private void handleSafeTabUpdate(final World world, final ByteArrayDataInput dat)
    {
        final int x = dat.readInt();
        final int y = dat.readInt();
        final int z = dat.readInt();

        TileEntitySafe tile = (TileEntitySafe) world.getBlockTileEntity(x, y, z);
        if (tile == null)
        {
            tile = new TileEntitySafe();
            world.setBlockTileEntity(x, y, z, tile);
        }
        // tile.setSelectedTab(dat.readByte());
    }

    private void handleSafePassUpdate(final World world, final ByteArrayDataInput dat)
    {
        final int x = dat.readInt();
        final int y = dat.readInt();
        final int z = dat.readInt();

        TileEntitySafe tile = (TileEntitySafe) world.getBlockTileEntity(x, y, z);
        if (tile == null)
        {
            tile = new TileEntitySafe();
            world.setBlockTileEntity(x, y, z, tile);
        }
        tile.setPass(dat.readInt());
    }
}