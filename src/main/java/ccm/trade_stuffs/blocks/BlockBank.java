/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.bank.Account;
import ccm.trade_stuffs.bank.Bank;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * BankBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockBank extends BlockContainer
{

    @SideOnly(Side.CLIENT)
    private Icon top;
    @SideOnly(Side.CLIENT)
    private Icon bottom;

    /**
     * @param id
     */
    public BlockBank(final int id)
    {
        super(id, Material.iron);
        setCreativeTab(TradeStuffs.tradeStuffs);
        setUnlocalizedName(Archive.MOD_ID_BLOCK + "bank");
        setResistance(6000000.0F);
        setStepSound(soundStoneFootstep);
        setBlockUnbreakable();
    }

    @Override
    public void registerIcons(final IconRegister register)
    {
        blockIcon = register.registerIcon(Archive.MOD_ID + ":bank_side");
        top = register.registerIcon(Archive.MOD_ID + ":bank_top");
        bottom = register.registerIcon(Archive.MOD_ID + ":bank_bottom");
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
        return new TileEntityBank();
    }

    @Override
    public void onBlockPlacedBy(final World world,
                                final int x,
                                final int y,
                                final int z,
                                final EntityLivingBase entity,
                                final ItemStack stack)
    {
        if (!world.isRemote && stack.hasDisplayName())
        {
            TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
            if (tile == null)
            {
                tile = new TileEntityBank();
                world.setBlockTileEntity(x, y, z, tile);
            }
            tile.bankName = stack.getDisplayName();
        }
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
        TileEntityBank tile = (TileEntityBank) world.getBlockTileEntity(x, y, z);
        if (tile == null)
        {
            tile = new TileEntityBank();
            world.setBlockTileEntity(x, y, z, tile);
        }
        if (!Bank.hasAccount(player.username))
        {
            Bank.addAcount(new Account(player.username));
        }
        if (!tile.isInUse())
        {
            tile.setPlayerUsing(player.username);
            tile.setInUse(true);
            player.openGui(TradeStuffs.instance, Guis.GUI_BANK_COINS, world, x, y, z);
        }
        return true;
    }
}