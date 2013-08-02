/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.lib;

import net.minecraft.util.ResourceLocation;

/**
 * Guis
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class Guis
{

    public static final int              GUI_TRADE          = 0;
    public static final ResourceLocation TEXTURE_GUI_TRADE  = new ResourceLocation(Archive.MOD_ID,
                                                                                   "guis/guiTrade.png");

    public static final int              GUI_WALLET         = 1;
    public static final ResourceLocation TEXTURE_GUI_WALLET = new ResourceLocation(Archive.MOD_ID,
                                                                                   "guis/guiWallet.png");

    public static final int              GUI_BANK           = 2;
    public static final ResourceLocation TEXTURE_GUI_BANK   = new ResourceLocation(Archive.MOD_ID,
                                                                                   "guis/guiBank.png");
}