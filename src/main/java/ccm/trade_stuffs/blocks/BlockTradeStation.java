/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import ccm.trade_stuffs.TradeStuffs;
import ccm.trade_stuffs.tileentity.TileEntityTradeStation;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * TradeStationBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockTradeStation extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private Icon bottom;

	public BlockTradeStation(int id) {
		super(id, Material.rock);
		setCreativeTab(TradeStuffs.tradeStuffs);
		setUnlocalizedName(Archive.MOD_ID_BLOCK + "tradeStation");
		setResistance(6000000.0F);
		setStepSound(soundStoneFootstep);
		setBlockUnbreakable();
	}

	@Override
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Archive.MOD_ID + ":trade_side");
		top = register.registerIcon(Archive.MOD_ID + ":trade_top");
		bottom = register.registerIcon(Archive.MOD_ID + ":safe_bottom");
	}

	@Override
	public Icon getIcon(int side, int meta) {
		if(side == ForgeDirection.UP.ordinal()) {
			return top;
		} else if(side == ForgeDirection.DOWN.ordinal()) {
			return bottom;
		} else {
			return blockIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTradeStation();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int stuff, float clickX, float clickY, float clickZ) {
		if(world.isRemote) {
			return true;
		}
		if(player.isSneaking()) {
			return false;
		}
		TileEntityTradeStation tile = (TileEntityTradeStation) world.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntityTradeStation();
			world.setBlockTileEntity(x, y, z, tile);
		}
		player.openGui(TradeStuffs.instance, Guis.GUI_TRADE, world, x, y, z);
		return true;
	}
}