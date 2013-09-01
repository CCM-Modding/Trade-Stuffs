/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Archive;

/**
 * BankBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockBank extends BlockContainer
{

    public BlockBank(final int id)
    {
        super(id, Material.iron);
        setCreativeTab(TradeStuffs.tab);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "bank");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TileEntityBank();
    }
}