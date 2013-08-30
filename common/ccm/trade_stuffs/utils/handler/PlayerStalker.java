/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_MOD_PLAYER;
import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_PLAYER;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.IPlayerTracker;

import ccm.trade_stuffs.items.ModItems;

/**
 * Tracker
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class PlayerStalker implements IPlayerTracker
{

    @Override
    public void onPlayerLogin(final EntityPlayer player)
    {
        final NBTTagCompound tag = player.getEntityData();
        if (!tag.hasKey(NBT_MOD_PLAYER))
        {
            tag.setCompoundTag(NBT_MOD_PLAYER, new NBTTagCompound());
        }
        if (!tag.getCompoundTag(NBT_MOD_PLAYER).getBoolean(NBT_PLAYER))
        {
            tag.getCompoundTag(NBT_MOD_PLAYER).setBoolean(NBT_PLAYER, true);
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