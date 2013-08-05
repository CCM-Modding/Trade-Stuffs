/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.handler;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import ccm.trade_stuffs.items.ItemWallet;
import ccm.trade_stuffs.utils.helper.NBTHelper;

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
        if (NBTHelper.hasTag(event.item.getEntityItem(), ItemWallet.openedWallet))
        {
            if (NBTHelper.hasTag(event.item.getEntityItem(), ItemWallet.fullWallet))
            {
                NBTHelper.removeTag(event.item.getEntityItem(), ItemWallet.fullWallet);
            }
            NBTHelper.removeTag(event.item.getEntityItem(), ItemWallet.openedWallet);
        }
    }

    @ForgeSubscribe
    public void onItemDrop(final ItemTossEvent event)
    {
        if (NBTHelper.hasTag(event.entityItem.getEntityItem(), ItemWallet.openedWallet))
        {
            if (NBTHelper.hasTag(event.entityItem.getEntityItem(), ItemWallet.fullWallet))
            {
                NBTHelper.removeTag(event.entityItem.getEntityItem(), ItemWallet.fullWallet);
            }
            NBTHelper.removeTag(event.entityItem.getEntityItem(), ItemWallet.openedWallet);
        }
    }

    @ForgeSubscribe
    public void onPlayerDrop(final PlayerDropsEvent event)
    {
        for (final EntityItem item : event.drops)
        {
            if (NBTHelper.hasTag(item.getEntityItem(), ItemWallet.openedWallet))
            {
                if (NBTHelper.hasTag(item.getEntityItem(), ItemWallet.fullWallet))
                {
                    NBTHelper.removeTag(item.getEntityItem(), ItemWallet.fullWallet);
                }
                NBTHelper.removeTag(item.getEntityItem(), ItemWallet.openedWallet);
            }
        }
    }
}