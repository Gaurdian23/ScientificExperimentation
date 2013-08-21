package minecraft.phoenix.scienceExp.util;

import minecraft.phoenix.scienceExp.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomOre extends Block
{
	public CustomOre(String name, int id)
	{
		super(id, Material.rock);
		this.setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Reference.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
