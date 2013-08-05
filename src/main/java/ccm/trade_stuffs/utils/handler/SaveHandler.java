package ccm.trade_stuffs.utils.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.ISaveHandler;
import ccm.trade_stuffs.bank.Bank;
import cpw.mods.fml.common.FMLCommonHandler;

public class SaveHandler {
	
	public ISaveHandler saveHandler;
	public World world;

	public SaveHandler(ISaveHandler saveHandler, World world) {
		this.saveHandler = saveHandler;
		this.world = world;
	}
	
	public void loadBank() {
		if ((world.provider.dimensionId == 0) && (!saveHandler.getWorldDirectoryName().equalsIgnoreCase("none"))) {
			try {
				File file = getSaveFile(saveHandler, world, "bank.dat");
				if (file != null) {
					try {
						loadBank(file);
					} catch (Exception e) {
						e.printStackTrace();
						File file2 = new File(new StringBuilder().append(file.getAbsolutePath()).append(".bak").toString());
						if(file2.exists()) {
							loadBank(file2);
						} else {
							file.createNewFile();
							saveBank();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void loadBank(File file) throws Exception {
		FileInputStream fileinputstream = new FileInputStream(file);
        NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(fileinputstream);
        fileinputstream.close();
        
        Bank.accounts.clear();
        Bank.readFromNBT(nbttagcompound.getCompoundTag("data"));
        
        FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[TradeStuffs] Loaded the bank");
	}

	public void saveBank() {
		if(world.provider.dimensionId == 0) {
			try {
				NBTTagCompound nbt = new NBTTagCompound();
				
		        Bank.writeToNBT(nbt);
				
		        NBTTagCompound nbttagcompound = new NBTTagCompound();
		        nbttagcompound.setCompoundTag("data", nbt);
		        FileOutputStream fileoutputstream = new FileOutputStream(getSaveFile(saveHandler, world, "bank.dat", false).getAbsolutePath());
		        CompressedStreamTools.writeCompressed(nbttagcompound, fileoutputstream);
		        fileoutputstream.close();
		        
				copyFile(getSaveFile(saveHandler, world, "bank.dat", false), getSaveFile(saveHandler, world, "bank.dat", true));
				
				FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[TradeStuffs] Saved the bank");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static File getSaveFile(ISaveHandler saveHandler, World world, String name) {
		File worldDir = new File(saveHandler.getWorldDirectoryName());
		IChunkLoader loader = saveHandler.getChunkLoader(world.provider);
		if ((loader instanceof AnvilChunkLoader)) {
			worldDir = ((AnvilChunkLoader) loader).chunkSaveLocation;
		}
		File file = new File(worldDir, name);
		return file;
	}

	public File getSaveFile(ISaveHandler saveHandler, World world, String name, boolean backup) throws Exception {
		File worldDir = new File(saveHandler.getWorldDirectoryName());
		IChunkLoader loader = saveHandler.getChunkLoader(world.provider);
		if ((loader instanceof AnvilChunkLoader)) {
			worldDir = ((AnvilChunkLoader) loader).chunkSaveLocation;
		}
		return new File(worldDir, new StringBuilder().append(name).append(backup ? ".bak" : "").toString());
	}

	public void copyFile(File sourceFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0L, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}
}
