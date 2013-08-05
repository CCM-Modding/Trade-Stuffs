/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.lib;

/**
 * Properties
 * <p>
 * 
 * @author Captain_Shadows
 */
public class Properties
{

    public static int tradeStationID;

    public static int tradeStationItemID;

    public static int coinsID;

    public static int walletID;

    public static int bankID;

    public static int safeID;
    
    public static int WALLET_STACKS_PER_COIN = 8;
   
    public static int BANK_STACKS_PER_COIN = ((Integer.MAX_VALUE + 1) / 64) - 64;
    public static int BANK_ITEMS_PER_ITEM = 256;
}