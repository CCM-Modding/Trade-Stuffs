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
import ccm.trade_stuffs.tileentity.Bank;
import ccm.trade_stuffs.tileentity.TradeStation;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * BankBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BankBlock extends BlockContainer
{

    /**
     * @param id
     */
    public BankBlock(final int id)
    {
        super(id, Material.iron);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("bank");
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new Bank();
    }

    /**
     * Called upon block activation (right click on the block.)
     */
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
        final TradeStation tile = (TradeStation) world.getBlockTileEntity(x, y, z);
        if (tile != null)
        {
            player.openGui(TradeStuffs.instance, Guis.GUI_BANK, world, x, y, z);
            return true;
        }
        return false;
    }
}