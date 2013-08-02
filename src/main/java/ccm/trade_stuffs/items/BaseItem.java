/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * BaseItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BaseItem extends Item
{

    /**
     * @param id
     */
    public BaseItem(final int id)
    {
        super(id - 256);
        setCreativeTab(CreativeTabs.tabDecorations);
    }
}