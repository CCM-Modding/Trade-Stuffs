/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TradeStation;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStationBlock extends BlockContainer
{

    @SideOnly(Side.CLIENT)
    private Icon top;
    @SideOnly(Side.CLIENT)
    private Icon bottom;

    public TradeStationBlock(final int id)
    {
        super(id, Material.rock);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "tradeStation");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public void registerIcons(final IconRegister register)
    {
        blockIcon = register.registerIcon(Archive.MOD_ID + ":trade_side");
        top = register.registerIcon(Archive.MOD_ID + ":trade_top");
        bottom = register.registerIcon(Archive.MOD_ID + ":safe_bottom");
    }

    @Override
    public Icon getIcon(final int side, final int meta)
    {
        if (side == ForgeDirection.UP.ordinal())
        {
            return top;
        }
        else
            if (side == ForgeDirection.DOWN.ordinal())
            {
                return bottom;
            }
            else
            {
                return blockIcon;
            }
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TradeStation();
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
            player.openGui(TradeStuffs.instance, Guis.GUI_TRADE, world, x, y, z);
            return true;
        }
        return false;
    }
}