/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import java.io.File;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.DimensionManager;

import ccm.trade_stuffs.utils.lib.Archive;

/**
 * SaveHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class SaveHelper
{
    private static File root;

    public static void init()
    {
        root = new File(DimensionManager.getCurrentSaveRootDirectory(), "CCM-Modding");
        root.mkdirs();
    }

    public static File getFolder()
    {
        final File folder = new File(root, Archive.MOD_ID);
        folder.mkdirs();
        return folder;
    }

    public static NBTTagCompound readData(final String fileName)
    {
        try
        {
            final File folder = getFolder();

            final File file = new File(folder, fileName.trim() + ".dat");

            if (!file.exists())
            {
                return new NBTTagCompound();
            }
            else
            {
                return CompressedStreamTools.read(file);
            }
        } catch (final Exception e)
        {
            e.printStackTrace();
            return new NBTTagCompound();
        }
    }

    public static boolean saveData(final String fileName, final NBTTagCompound nbt)
    {
        try
        {
            final File folder = getFolder();

            final File tmpFile = new File(folder, fileName.trim() + "_tmp.dat");
            final File realFile = new File(folder, fileName.trim() + ".dat");

            CompressedStreamTools.write(nbt, tmpFile);

            if (realFile.exists())
            {
                realFile.delete();
            }

            tmpFile.renameTo(realFile);

            return true;
        } catch (final Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}