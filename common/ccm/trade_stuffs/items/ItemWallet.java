/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.nucleum.omnium.utils.helper.NBTItemHelper;
import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.api.coins.CoinTypes;
import ccm.trade_stuffs.inventory.InventoryWallet;
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.NBTConstants;
import ccm.trade_stuffs.utils.lib.Properties;

/**
 * WalletItem
 * <p>
 * 
 * @author Captain_Shadows
 */
public class ItemWallet extends ItemBase
{
    String[] types = new String[]
    { "wallet", "wallet_empty", "wallet_full" };
    Icon[] icons = new Icon[types.length];

    /**
     * @param id
     */
    public ItemWallet(final int id)
    {
        super(id);
        setMaxDamage(0);
        setMaxStackSize(1);
        setNoRepair();
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player)
    {
        if (!player.isSneaking())
        {
            if (!world.isRemote)
            {
                NBTItemHelper.setBoolean(stack, NBTConstants.NBT_OPENED_ITEM, true);
                player.openGui(TradeStuffs.instance, Guis.GUI_WALLET, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
        }

        return stack;
    }

    @Override
    public boolean onItemUse(final ItemStack item, final EntityPlayer player, final World world, final int x, final int y, final int z, final int wut, final float clickX,
            final float clickY, final float clickZ)
    {
        final TileEntity tile = world.getBlockTileEntity((int) clickX, (int) clickY, (int) clickZ);
        if (tile != null)
        {
            final InventoryWallet wallet = new InventoryWallet(item);
            if (tile instanceof TileEntityBank)
            {

            } else if (tile instanceof TileEntitySafe)
            {

            }
        }
        return false;
    }

    @Override
    public Icon getIcon(final ItemStack stack, final int pass)
    {
        if (NBTItemHelper.getBoolean(stack, NBTConstants.NBT_OPENED_ITEM))
        {
            if (NBTItemHelper.getBoolean(stack, NBTConstants.NBT_WALLET_OPEN_FULL))
            {
                setDamage(stack, 2);
                return icons[2];
            } else
            {
                setDamage(stack, 1);
                return icons[1];
            }
        } else
        {
            setDamage(stack, 0);
            return icons[0];
        }
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }

    @Override
    public String getUnlocalizedName(final ItemStack item)
    {
        return Archive.MOD_ID_ITEM + types[item.getItemDamage()];
    }

    @Override
    public void registerIcons(final IconRegister register)
    {
        for (int i = 0; i < types.length; i++)
        {
            icons[i] = register.registerIcon(Archive.MOD_ID + ":" + types[i]);
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(final int meta)
    {
        return icons[meta];
    }

    @Override
    public void addInformation(final ItemStack item, final EntityPlayer palyer, final List list, final boolean color)
    {
        final InventoryWallet wallet = new InventoryWallet(item);
        final StringBuilder sb = new StringBuilder();
        final int value = wallet.getCoinBalance();
        if (value != CoinTypes.getMaxPossibleValue(Properties.WALLET_STACKS_PER_COIN))
        {
            sb.append("You have a total of " + value + " coin");
            if (value != 1)
            {
                sb.append("s");
            }
            sb.append(" in this ");
            sb.append(list.get(0));

        } else
        {
            sb.append("You have a Sack Full o' Coins");
        }
        list.add(sb.toString());
    }
}