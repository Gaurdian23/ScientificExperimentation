package minecraft.phoenix.scienceExp.blocks;

import minecraft.phoenix.scienceExp.lib.Strings;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLab extends TileEntity
{
	/**
     * Returns the name of the inventory.
     */
	public String getInvName()
	{
		return "container." + Strings.LAB;
	}
}