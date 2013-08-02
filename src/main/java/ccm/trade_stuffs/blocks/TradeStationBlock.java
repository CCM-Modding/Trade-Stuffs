/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ccm.trade_stuffs.tileentity.TradeStation;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStationBlock extends BlockContainer
{
    public TradeStationBlock(final int id)
    {
        super(id, Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TradeStation();
    }

}