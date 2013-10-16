package minecraft.phoenix.scienceExp.blocks;

import minecraft.phoenix.scienceExp.items.Items;
import net.minecraft.block.material.Material;
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
			if((el.getCurrentItemOrArmor(1) == null && el.getCurrentItemOrArmor(1).itemID != Items.helmetHazmat.itemID)
					|| (el.getCurrentItemOrArmor(2) == null && el.getCurrentItemOrArmor(2).itemID != Items.plateHazmat.itemID)
					|| (el.getCurrentItemOrArmor(3) == null && el.getCurrentItemOrArmor(3).itemID != Items.legsHazmat.itemID)
					|| (el.getCurrentItemOrArmor(4) == null && el.getCurrentItemOrArmor(4).itemID != Items.bootsHazmat.itemID))
				el.addPotionEffect(new PotionEffect(Potion.poison.id, 300));
		}
	}
}
