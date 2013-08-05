/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.IPlayerTracker;

import ccm.trade_stuffs.utils.lib.Archive;

/**
 * Tracker
 * <p>
 * 
 * @author Captain_Shadows
 */
public class PlayerStalker implements IPlayerTracker
{
    public static final String PLAYER_NBT = ""

    @Override
    public void onPlayerLogin(final EntityPlayer player)
    {
        final NBTTagCompound tag = player.getEntityData();
        if(!tag.hasKey(Archive.MOD_ID)){
            tag.setCompoundTag(Archive.MOD_ID, new NBTTagCompound());
        }
    }

    @Override
    public void onPlayerLogout(final EntityPlayer player)
    {}

    @Override
    public void onPlayerChangedDimension(final EntityPlayer player)
    {}

    @Override
    public void onPlayerRespawn(final EntityPlayer player)
    {}
}