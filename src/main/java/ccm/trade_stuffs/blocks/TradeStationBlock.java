/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.items.ModItems;
import ccm.trade_stuffs.tileentity.TradeStation;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class TradeStationBlock extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private Icon caildronInnerIcon;
    @SideOnly(Side.CLIENT)
    private Icon cauldronTopIcon;
    @SideOnly(Side.CLIENT)
    private Icon cauldronBottomIcon;

    public TradeStationBlock(final int id)
    {
        super(id, Material.rock);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("tradeStation");
        func_111022_d("tradeStation");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public TileEntity createNewTileEntity(final World world)
    {
        return new TradeStation();
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(final int par1, final int par2)
    {
        return par1 == 1 ? cauldronTopIcon : (par1 == 0 ? cauldronBottomIcon : blockIcon);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(final IconRegister par1IconRegister)
    {
        caildronInnerIcon = par1IconRegister.registerIcon(func_111023_E() + "_" + "inner");
        cauldronTopIcon = par1IconRegister.registerIcon(func_111023_E() + "_top");
        cauldronBottomIcon = par1IconRegister.registerIcon(func_111023_E() + "_" + "bottom");
        blockIcon = par1IconRegister.registerIcon(func_111023_E() + "_side");
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they
     * intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    @Override
    public void addCollisionBoxesToList(final World par1World,
                                        final int par2,
                                        final int par3,
                                        final int par4,
                                        final AxisAlignedBB par5AxisAlignedBB,
                                        final List par6List,
                                        final Entity par7Entity)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        final float f = 0.125F;
        setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        setBlockBoundsForItemRender();
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94375_b(final String par0Str)
    {
        return par0Str.equals("inner") ? ModBlocks.tradeStation.caildronInnerIcon
                                      : (par0Str.equals("bottom") ? ModBlocks.tradeStation.cauldronBottomIcon
                                                                 : null);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    @Override
    public void setBlockBoundsForItemRender()
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared
     * face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType()
    {
        return 24;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons,
     * stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
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
        return ModItems.tradeStation.itemID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(final World par1World, final int par2, final int par3, final int par4)
    {
        return ModItems.tradeStation.itemID;
    }
}