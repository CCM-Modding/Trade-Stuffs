/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.lib;

import ccm.nucleum.omnium.base.BaseNIC;

/**
 * NBTConstants
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class NBTConstants extends BaseNIC
{

    public static final String NBT_FILE_BANK = "bank";

    public static final String NBT_PLAYER = "CCM.PLAYER.WALLET";

    public static final String NBT_OPENED_ITEM = "CCM.WALLET.OPEN";
    public static final String NBT_WALLET_OPEN_FULL = "CCM.WALLET.OPEN.FULL";

    public static final String NBT_BANK_NAME = "CCM.BANK.NAME";

    public static final String NBT_SAFE_NAME = "CCM.SAFE.NAME";
    public static final String NBT_SAFE_PASSWORD = "CCM.SAFE.PASSWORD";
    public static final String NBT_SAFE_HAS_PASSWORD = "CCM.SAFE.PASSWORD.HAS";

    public static final String NBT_MOD_PLAYER = "CCM." + Archive.MOD_ID.toUpperCase() + ".PLAYER";
}