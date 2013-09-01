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
import ccm.nucleum.omnium.block.sub.SubBlock;
import ccm.nucleum.omnium.block.texture.BasicTexture;
import ccm.nucleum.omnium.block.tile.NoTile;

/**
 * SubBlockSafe
 * <p>
 * 
 * @author Captain_Shadows
 */
public class SubBlockSafe extends SubBlock
{
    public SubBlockSafe(final Class<? extends MainBlock> block, final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        super(block, id, meta, material, texture, tile);
    }

    public SubBlockSafe(final Class<? extends MainBlock> block, final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(block, id, meta, Material.iron, texture, tile);
    }

    public SubBlockSafe(final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        this(MainBlock.class, id, meta, material, texture, tile);
    }

    public SubBlockSafe(final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(id, meta, Material.iron, texture, tile);
    }

    public SubBlockSafe(final int id, final int meta, final Material material, final String iconName)
    {
        this(id, meta, material, new BasicTexture(iconName), new NoTile());
    }

    public SubBlockSafe(final int id, final int meta, final String iconName)
    {
        this(id, meta, Material.iron, iconName);
    }

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int stuff, final float clickX, final float clickY,
            final float clickZ)
    {
        return super.onBlockActivated(world, x, y, z, player, stuff, clickX, clickY, clickZ);
        // tile.openChest();
        // return true;
    }
}