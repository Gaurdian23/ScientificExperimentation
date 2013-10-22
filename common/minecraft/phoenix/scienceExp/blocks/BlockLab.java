package minecraft.phoenix.scienceExp.blocks;

import minecraft.phoenix.scienceExp.ScienceExp;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLab extends BlockContainer
{	
	protected BlockLab(int id, String lab)
	{
		super(id, Material.iron);
		this.setUnlocalizedName(lab);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityLab();
	}
	
	/**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
	public void onBlockAdded(World par1World, int x, int y, int z)
	{
		super.onBlockAdded(par1World, x, y, z);
		par1World.markBlockForUpdate(x, y, z);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
	{
		if (!world.isRemote)
        {
			entityPlayer.openGui(ScienceExp.instance, 0, world, x, y, z);
            return true;
        }
		return false;
	}
}
