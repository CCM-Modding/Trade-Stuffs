/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;
import ccm.trade_stuffs.utils.lib.Archive;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockTradeStation extends BlockContainer
{
    public BlockTradeStation(final int id)
    {
        super(id, Material.rock);
        setCreativeTab(TradeStuffs.tab);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "tradeStation");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TileEntityTradeStation();
    }
}