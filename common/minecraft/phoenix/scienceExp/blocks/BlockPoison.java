package minecraft.phoenix.scienceExp.blocks;

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
			el.addPotionEffect(new PotionEffect(Potion.poison.id, 300));
		}
	}
}
