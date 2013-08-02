/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.utils.lib.Archive;

/**
 * WalletItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class WalletItem extends BaseItem
{

    String[] types = new String[] { "wallet_empty", "wallet_full" };
    Icon[]   icons = new Icon[types.length];

    /**
     * @param id
     */
    public WalletItem(final int id)
    {
        super(id);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(final ItemStack item)
    {
        return "item." + types[item.getItemDamage()];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(final int itemID, final CreativeTabs tab, final List items)
    {
        for (int i = 0; i < types.length; i++)
        {
            items.add(new ItemStack(itemID, 1, i));
        }
    }

    @Override
    public void registerIcons(final IconRegister register)
    {
        for (int i = 0; i < types.length; i++)
        {
            icons[i] = register.registerIcon(Archive.MOD_ID + ":" + types[i]);
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(final int meta)
    {
        return icons[meta];
    }
}