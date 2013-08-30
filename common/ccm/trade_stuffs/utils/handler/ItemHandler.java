/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_OPENED_ITEM;
import static ccm.trade_stuffs.utils.lib.NBTConstants.NBT_WALLET_OPEN_FULL;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import ccm.nucleum.omnium.utils.helper.NBTItemHelper;

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
        if (NBTItemHelper.hasTag(event.item.getEntityItem(), NBT_OPENED_ITEM))
        {
            if (NBTItemHelper.hasTag(event.item.getEntityItem(), NBT_WALLET_OPEN_FULL))
            {
                NBTItemHelper.removeTag(event.item.getEntityItem(), NBT_WALLET_OPEN_FULL);
            }
            NBTItemHelper.removeTag(event.item.getEntityItem(), NBT_OPENED_ITEM);
        }
    }

    @ForgeSubscribe
    public void onItemDrop(final ItemTossEvent event)
    {
        if (NBTItemHelper.hasTag(event.entityItem.getEntityItem(), NBT_OPENED_ITEM))
        {
            if (NBTItemHelper.hasTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN_FULL))
            {
                NBTItemHelper.removeTag(event.entityItem.getEntityItem(), NBT_WALLET_OPEN_FULL);
            }
            NBTItemHelper.removeTag(event.entityItem.getEntityItem(), NBT_OPENED_ITEM);
        }
    }

    @ForgeSubscribe
    public void onPlayerDrop(final PlayerDropsEvent event)
    {
        for (final EntityItem item : event.drops)
        {
            if (NBTItemHelper.hasTag(item.getEntityItem(), NBT_OPENED_ITEM))
            {
                if (NBTItemHelper.hasTag(item.getEntityItem(), NBT_WALLET_OPEN_FULL))
                {
                    NBTItemHelper.removeTag(item.getEntityItem(), NBT_WALLET_OPEN_FULL);
                }
                NBTItemHelper.removeTag(item.getEntityItem(), NBT_OPENED_ITEM);
            }
        }
    }
}