/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.tileentity.TradeStation;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStationBlock extends BlockContainer
{
    public static int renderID;

    public TradeStationBlock(final int id)
    {
        super(id, Material.rock);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("tradeStation");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TradeStation();
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(final World par1World,
                                    final int par2,
                                    final int par3,
                                    final int par4,
                                    final EntityPlayer par5EntityPlayer,
                                    final int par6,
                                    final float par7,
                                    final float par8,
                                    final float par9)
    {
        return false;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(final int par1, final Random par2Random, final int par3)
    {
        return blockID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(final World par1World, final int par2, final int par3, final int par4)
    {
        return blockID;
    }
}