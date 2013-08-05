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

import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;

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
        final CoinType type = CoinTypes.getTypes().get(item.getItemDamage());
        return "item." + type.getModID() + ":" + type.getIconName();
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
        final CoinType current = CoinTypes.getTypes().get(item.getItemDamage());
        StringBuilder s = new StringBuilder();
        s.append("You have ");
        s.append(item.stackSize);
        s.append(" ");
        s.append(current.getTypeName());
        s.append(" Coin");
        if (item.stackSize > 1)
        {
            s.append("s");
        }
        list.add(s.toString());
        s = new StringBuilder();
        s.append("This is worth ");
        s.append(current.getValueStack(item));
        s.append(" coin");
        if (current.getValueStack(item) > 1)
        {
            s.append("s");
        }
        list.add(s.toString());
    }
}