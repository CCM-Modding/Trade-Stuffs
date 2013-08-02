/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.Safe;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * SafeBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class SafeBlock extends BlockContainer
{

    /**
     * @param id
     */
    public SafeBlock(final int id)
    {
        super(id, Material.iron);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("safe");
        setHardness(40);
        setResistance(1000);
        setStepSound(soundStoneFootstep);
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new Safe();
    }

    @Override
    public boolean onBlockActivated(final World world,
                                    final int x,
                                    final int y,
                                    final int z,
                                    final EntityPlayer player,
                                    final int stuff,
                                    final float clickX,
                                    final float clickY,
                                    final float clickZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        if (player.isSneaking())
        {
            return false;
        }
        final TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (tile != null)
        {
            player.openGui(TradeStuffs.instance, Guis.GUI_SAFE, world, x, y, z);
            return true;
        }
        return false;
    }
}