package ccm.trade_stuffs.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Guis;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int packetID = dat.readInt();
		World world = Minecraft.getMinecraft().theWorld;

		switch(packetID) {
		case 0:
			handleTileEntityBank(world, dat);
			break;
		case 1:
			handleTileEntitySafe(world, dat);
			break;
		// CLIENT TO SERVER
		case 10:
			handleBankTabUpdate(dat);
			break;
		case 11:
			handleSafeTabUpdate(dat);
			break;
		case 12:
			handleSafePassReset(dat);
			break;
		case 13:
			handleSafePassNew(dat);
			break;
		case 14: 
			handleSafePassGood(dat);
			break;
		}
	}

	private void handleTileEntityBank(World world, ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();

		TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntityBank();
			world.setBlockTileEntity(x, y, z, tile);
		}
		tile.bankName = dat.readUTF();
	}
	
	private void handleTileEntitySafe(World world, ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();

		TileEntitySafe tile = (TileEntitySafe) world.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntitySafe();
			world.setBlockTileEntity(x, y, z, tile);
		}
		tile.setPass(dat.readInt());
		tile.setHasPass(dat.readBoolean());
		tile.guiPassLock = dat.readBoolean();
	}

	private void handleBankTabUpdate(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int dim = dat.readInt();

		WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
		TileEntityBank tile = (TileEntityBank) worldServer.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntityBank();
			worldServer.setBlockTileEntity(x, y, z, tile);
		}
		tile.setSelectedTab(dat.readByte());
	}

	private void handleSafeTabUpdate(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int dim = dat.readInt();
		
		WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
		TileEntitySafe tile = (TileEntitySafe) worldServer.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntitySafe();
			worldServer.setBlockTileEntity(x, y, z, tile);
		}
		//tile.setSelectedTab(dat.readByte());
	}

	private void handleSafePassReset(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int dim = dat.readInt();
		
		WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
		TileEntitySafe tile = (TileEntitySafe) worldServer.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntitySafe();
			worldServer.setBlockTileEntity(x, y, z, tile);
		}
		tile.resetPass();
		worldServer.markBlockForUpdate(x, y, z);
	}
	
	private void handleSafePassNew(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int dim = dat.readInt();
		
		WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
		TileEntitySafe tile = (TileEntitySafe) worldServer.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntitySafe();
			worldServer.setBlockTileEntity(x, y, z, tile);
		}
		tile.setPass(dat.readInt());
		worldServer.markBlockForUpdate(x, y, z);
	}
	
	private void handleSafePassGood(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int dim = dat.readInt();
		String username = dat.readUTF();
		
		WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
		worldServer.getPlayerEntityByName(username).openGui(TradeStuffs.instance, Guis.GUI_SAFE_INVENTORY, worldServer, x, y, z);
	}
}