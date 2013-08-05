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
import ccm.trade_stuffs.tileentity.TileEntityBank;
import ccm.trade_stuffs.tileentity.TileEntitySafe;
import ccm.trade_stuffs.utils.lib.Archive;
import ccm.trade_stuffs.utils.lib.Guis;

/**
 * SafeBlock
 * <p>
 * 
 * @author Captain_Shadows
 */
public class BlockSafe extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private Icon front;
	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private Icon bottom;

	/**
	 * @param id
	 */
	public BlockSafe(int id) {
		super(id, Material.iron);
		setCreativeTab(TradeStuffs.tradeStuffs);
		setUnlocalizedName(Archive.MOD_ID_BLOCK + "safe");
		setHardness(40);
		setResistance(1000);
		setStepSound(soundStoneFootstep);
	}

	@Override
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Archive.MOD_ID + ":safe_side");
		top = register.registerIcon(Archive.MOD_ID + ":safe_top");
		bottom = register.registerIcon(Archive.MOD_ID + ":safe_bottom");
	}

	@Override
	public Icon getIcon(int side, int meta) {
		if(side == ForgeDirection.UP.ordinal()) {
			return top;
		} else if(side == ForgeDirection.DOWN.ordinal()) {
			return top;
		} else {
			return blockIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySafe();
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if(!world.isRemote && stack.hasDisplayName()) {
			TileEntitySafe tile = (TileEntitySafe) world.getBlockTileEntity(x, y, z);
			if(tile == null) {
				tile = new TileEntitySafe();
				world.setBlockTileEntity(x, y, z, tile);
			}
			tile.safeName = stack.getDisplayName();
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int stuff, float clickX, float clickY, float clickZ) {
		if(world.isRemote) {
			return true;
		}
		if(player.isSneaking()) {
			return false;
		}
		TileEntitySafe tile = (TileEntitySafe) world.getBlockTileEntity(x, y, z);
		if(tile == null) {
			tile = new TileEntitySafe();
			world.setBlockTileEntity(x, y, z, tile);
		}
		tile.openChest();
		player.openGui(TradeStuffs.instance, Guis.GUI_SAFE, world, x, y, z);
		return true;
	}
}