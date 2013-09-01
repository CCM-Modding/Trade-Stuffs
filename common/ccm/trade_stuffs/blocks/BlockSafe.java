/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Archive;

/**
 * SafeBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockSafe extends BlockContainer
{

    public BlockSafe(final int id)
    {
        super(id, Material.iron);
        setCreativeTab(TradeStuffs.tab);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "safe");
        setHardness(40);
        setResistance(1000);
        setStepSound(soundStoneFootstep);
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TileEntitySafe();
    }
}