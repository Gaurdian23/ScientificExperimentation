package minecraft.phoenix.scienceExp.handler;

import minecraft.phoenix.scienceExp.gui.ContainerLab;
import minecraft.phoenix.scienceExp.gui.GuiLab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ScienceGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity != null)
		{
			switch(ID)
			{
			case 0:
				return new ContainerLab(player.inventory, world, x, y, z);
			}	
		}
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity != null)
		{
			switch(ID)
			{
			case 0:
				return new GuiLab(player.inventory, world, x, y, z);
			}
		}
		return null;
	}
	
}
