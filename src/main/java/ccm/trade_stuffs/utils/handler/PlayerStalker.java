/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.IPlayerTracker;

import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.utils.lib.Archive;

/**
 * Tracker
 * <p>
 * 
 * @author Captain_Shadows
 */
public class PlayerStalker implements IPlayerTracker
{
    public static final String PLAYER_NBT = "CCM.PLAYER.WALLET";

    @Override
    public void onPlayerLogin(final EntityPlayer player)
    {
        final NBTTagCompound tag = player.getEntityData();
        if (!tag.hasKey(Archive.MOD_ID))
        {
            tag.setCompoundTag(Archive.MOD_ID, new NBTTagCompound());
        }
        if (!tag.getCompoundTag(Archive.MOD_ID).getBoolean(PLAYER_NBT))
        {
            tag.setBoolean(PLAYER_NBT, true);
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.wallet));
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