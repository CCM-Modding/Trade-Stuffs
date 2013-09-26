/**
 * CCM Modding, Steve's Trade
 */
package ccm.trade_stuffs.block.sub;

import net.minecraft.block.material.Material;

import ccm.nucleum.omnium.block.MainBlock;
import ccm.nucleum.omnium.block.interfaces.ITextureHelper;
import ccm.nucleum.omnium.block.interfaces.ITileHelper;
import ccm.nucleum.omnium.block.loader.texture.BasicTexture;
import ccm.nucleum.omnium.block.loader.tile.NoTile;
import ccm.nucleum.omnium.block.sub.SubBlock;

/**
 * SubBlockTradeStationTradeStation
 * <p>
 * 
 * @author Captain_Shadows
 */
public class SubBlockTradeStation extends SubBlock
{
    public SubBlockTradeStation(final Class<? extends MainBlock> block, final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        super(block, id, meta, material, texture, tile);
    }

    public SubBlockTradeStation(final Class<? extends MainBlock> block, final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(block, id, meta, Material.iron, texture, tile);
    }

    public SubBlockTradeStation(final int id, final int meta, final Material material, final ITextureHelper texture, final ITileHelper tile)
    {
        this(MainBlock.class, id, meta, material, texture, tile);
    }

    public SubBlockTradeStation(final int id, final int meta, final ITextureHelper texture, final ITileHelper tile)
    {
        this(id, meta, Material.iron, texture, tile);
    }

    public SubBlockTradeStation(final int id, final int meta, final Material material, final String iconName)
    {
        this(id, meta, material, new BasicTexture(iconName), new NoTile());
    }

    public SubBlockTradeStation(final int id, final int meta, final String iconName)
    {
        this(id, meta, Material.iron, iconName);
    }
}