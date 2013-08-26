/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_WALLET_OPEN;
import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_WALLET_OPEN_FULL;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import ccm.nucleum.omnium.utils.helper.NBTHelper;

/**
 * ItemEventHandler
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class ItemHandler
{
    @ForgeSubscribe
    public void onItemPick(final EntityItemPickupEvent event)
    {
        if (NBTHelper.hasTag(event.item.getEntityItem(), NBT_WALLET_OPEN))
        {
            if (NBTHelper.hasTag(event.item.getEntityItem(), NBT_WALLET_OPEN_FULL))
            {
                NBTHelper.removeTag(event.item.getEntityItem(), NBT_WALLET_OPEN_FULL);
            }
            NBTHelper.removeTag(event.item.getEntityItem(), NBT_WALLET_OPEN);
        }
    }

    @ForgeSubscribe
    public void onItemDrop(final ItemTossEvent event)
    {
        if (NBTHelper.hasTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN))
        {
            if (NBTHelper.hasTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN_FULL))
            {
                NBTHelper.removeTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN_FULL);
            }
            NBTHelper.removeTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN);
        }
    }

    @ForgeSubscribe
    public void onPlayerDrop(final PlayerDropsEvent event)
    {
        for (final EntityItem item : event.drops)
        {
            if (NBTHelper.hasTag(item.getEntityItem(), NBT_WALLET_OPEN))
            {
                if (NBTHelper.hasTag(item.getEntityItem(), NBT_WALLET_OPEN_FULL))
                {
                    NBTHelper.removeTag(item.getEntityItem(), NBT_WALLET_OPEN_FULL);
                }
                NBTHelper.removeTag(item.getEntityItem(), NBT_WALLET_OPEN);
            }
        }
    }
}