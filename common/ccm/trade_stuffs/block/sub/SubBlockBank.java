/**
 * CCM Modding, Steve's Trade
 */
package ccm.trade_stuffs.block.sub;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import ccm.nucleum.omnium.block.MainBlock;
import ccm.nucleum.omnium.block.interfaces.ITextureHelper;
import ccm.nucleum.omnium.block.interfaces.ITileHelper;
import ccm.nucleum.omnium.block.loader.texture.BasicTexture;
import ccm.nucleum.omnium.block.loader.tile.NoTile;
import ccm.nucleum.omnium.block.sub.SubBlock;
import ccm.trade_stuffs.bank.Bank;
import ccm.trade_stuffs.bank.BankAccount;

/**
 * SubBlockBank
 * <p>
 * 
 * @author Captain_Shadows
 */
public class SubBlockBank extends SubBlock
{
    public SubBlockBank(final Class<? extends MainBlock> block, final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        super(block, id, meta, material, texture, tile);
    }

    public SubBlockBank(final Class<? extends MainBlock> block, final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(block, id, meta, Material.iron, texture, tile);
    }

    public SubBlockBank(final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        this(MainBlock.class, id, meta, material, texture, tile);
    }

    public SubBlockBank(final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(id, meta, Material.iron, texture, tile);
    }

    public SubBlockBank(final int id, final int meta, final Material material, final String iconName)
    {
        this(id, meta, material, new BasicTexture(iconName), new NoTile());
    }

    public SubBlockBank(final int id, final int meta, final String iconName)
    {
        this(id, meta, Material.iron, iconName);
    }

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int stuff, final float clickX, final float clickY,
            final float clickZ)
    {
        super.onBlockActivated(world, x, y, z, player, stuff, clickX, clickY, clickZ);
        if (!Bank.hasAccount(player.username))
        {
            Bank.addAcount(new BankAccount(player.username));
        }
        // world.getBlockTileEntity(x, y, z);
        // if (!tile.isInUse())
        // {
        // tile.setPlayerUsing(player.username);
        // tile.setInUse(true);
        // GuiHandler.openGui(FunctionHelper.getTEName(world, x, y, z), player, x, y, z);
        // }
        return true;
    }
}