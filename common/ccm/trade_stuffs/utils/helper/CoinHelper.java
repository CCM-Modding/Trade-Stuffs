/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper;

import ccm.nucleum.omnium.base.BaseNIC;
import ccm.trade_stuffs.api.coins.CoinType;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * FunctionHelper
 * <p>
 * 
 * @author Captain_Shadows
 */
public final class CoinHelper extends BaseNIC
{

    public static int getMaxPossibleValue()
    {
        int maxValue = 0;
        for (final CoinType type : CoinTypes.getTypes())
        {
            maxValue += (type.getValue() * Properties.WALLET_STACKS_PER_COIN) * 64;
        }
        return maxValue;
    }
}