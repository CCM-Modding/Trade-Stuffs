/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * Safe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TileEntitySafe extends BaseInventory {
	
	private int pass = 0;
	private boolean hasPass = false;
	public boolean guiPassLock = true;

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
		hasPass = true;
	}
	
	public void resetPass() {
		pass = 0;
		hasPass = false;
	}
	
	public boolean hasPass() {
		return hasPass;
	}
	
	public void setHasPass(boolean has) {
		hasPass = has;
	}

	@Override
	public Packet getDescriptionPacket() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeInt(1);
			dos.writeInt(xCoord);
			dos.writeInt(yCoord);
			dos.writeInt(zCoord);

			dos.writeInt(pass);
			dos.writeBoolean(hasPass);
			dos.writeBoolean(guiPassLock);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "TradeStuffs";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		packet.isChunkDataPacket = true;
		return packet;
	}
	
	@Override
	public void readFromNBT(final NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		pass = nbt.getInteger("Password");
		hasPass = nbt.getBoolean("HasPass");
	}

	@Override
	public void writeToNBT(final NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Password", pass);
		nbt.setBoolean("HasPass", hasPass);
	}
}