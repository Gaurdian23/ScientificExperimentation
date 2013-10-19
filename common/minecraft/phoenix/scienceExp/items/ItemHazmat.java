package minecraft.phoenix.scienceExp.items;

import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHazmat extends ItemArmor
{
	public ItemHazmat(int par1, int par4)
	{
		super(par1, CommonProxy.HAZMAT, RenderingRegistry.addNewArmourRendererPrefix("hazmat"), par4);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		switch(slot)
		{
		case 2:
			return "scienceexp:textures/models/armor/hazmat_layer_2.png";
		default:
			return "scienceexp:textures/models/armor/hazmat_layer_1.png";
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
