package minecraft.phoenix.scienceExp.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minecraft.phoenix.scienceExp.items.Items;
import minecraft.phoenix.scienceExp.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class BlockPoison extends BlockFluidFinite
{

	public BlockPoison(int id, Fluid fluid, Material material)
	{
		super(id, fluid, material);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLivingBase)
		{
			EntityLivingBase el = (EntityLivingBase) entity;
			//This checks that they are wearing the armour, the nulls stop NullPointerExceptions
			if(!((el.getCurrentItemOrArmor(4) != null && el.getCurrentItemOrArmor(4).itemID == Items.helmetHazmat.itemID)
					|| (el.getCurrentItemOrArmor(3) != null && el.getCurrentItemOrArmor(3).itemID == Items.plateHazmat.itemID)
					|| (el.getCurrentItemOrArmor(2) != null && el.getCurrentItemOrArmor(2).itemID == Items.legsHazmat.itemID)
					|| (el.getCurrentItemOrArmor(1) != null && el.getCurrentItemOrArmor(1).itemID == Items.bootsHazmat.itemID)))
				el.addPotionEffect(new PotionEffect(Potion.poison.id, 300));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Reference.modid + ":" + (this.getUnlocalizedName().substring(11)));
	}
}
