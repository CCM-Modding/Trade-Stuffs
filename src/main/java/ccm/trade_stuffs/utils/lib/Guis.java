/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.lib;

import static ccm.trade_stuffs.utils.lib.Locations.GUI_LOC;

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
                                                                                   GUI_LOC + "guiTrade.png");

    public static final int              GUI_WALLET         = 1;
    public static final ResourceLocation TEXTURE_GUI_WALLET = new ResourceLocation(Archive.MOD_ID,
                                                                                   GUI_LOC + "guiWallet.png");

    public static final int              GUI_BANK_COINS     = 2;
    public static final int              GUI_BANK_ITEMS     = 3;
    public static final ResourceLocation TEXTURE_GUI_BANK   = new ResourceLocation(Archive.MOD_ID,
                                                                                   GUI_LOC + "guiBank.png");

    public static final int              GUI_SAFE           = 4;
    public static final int              GUI_SAFE_INVENTORY = 5;
    public static final ResourceLocation TEXTURE_GUI_SAFE   = new ResourceLocation(Archive.MOD_ID,
                                                                                   GUI_LOC + "guiSafe.png");
}