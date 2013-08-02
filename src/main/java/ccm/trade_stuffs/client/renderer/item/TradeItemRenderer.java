/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

/**
 * TradeItemRenderer
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeItemRenderer implements IItemRenderer
{

    @Override
    public boolean handleRenderType(final ItemStack item, final ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(final ItemRenderType type,
                                         final ItemStack item,
                                         final ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(final ItemRenderType type, final ItemStack item, final Object... data)
    {}
}