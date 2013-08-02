/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * WalletItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class WalletItem extends BaseItem
{

    /**
     * @param id
     */
    public WalletItem(final int id)
    {
        super(id);
        setUnlocalizedName("wallet");
        func_111206_d("wallet");
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(final int par1)
    {
        return itemIcon;
    }
}