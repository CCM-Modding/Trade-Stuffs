/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.api.CoinType;
import ccm.trade_stuffs.api.CoinTypes;

/**
 * CoinItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class CoinItem extends BaseItem
{

    /**
     * @param id
     */
    public CoinItem(final int id)
    {
        super(id);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(final ItemStack item)
    {
        return "item." + CoinTypes.getTypes().get(item.getItemDamage()).getIconName();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(final int itemID, final CreativeTabs tab, final List items)
    {
        for (int i = 0; i < CoinTypes.getTypes().size(); i++)
        {
            items.add(new ItemStack(itemID, 1, i));
        }
    }

    @Override
    public void registerIcons(final IconRegister register)
    {
        for (final CoinType coin : CoinTypes.getTypes())
        {
            coin.registerIcon(register);
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(final int meta)
    {
        return CoinTypes.getTypes().get(meta).getIcon();
    }

    @Override
    public void addInformation(final ItemStack item,
                               final EntityPlayer palyer,
                               final List list,
                               final boolean color)
    {
        CoinTypes.getTypes().get(item.getItemDamage()).getName();
        list.add(palyer);
    }
}