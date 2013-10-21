package minecraft.phoenix.scienceExp.util;

import minecraft.phoenix.scienceExp.items.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReactionManager
{
	/** The static instance of this class */
    private static final ReactionManager instance = new ReactionManager();
	
	public static ReactionManager getInstance()
	{
		return instance;
	}

	public ItemStack calculateOutput(InventoryCrafting combineMatrix, World worldObj)
	{
		ItemStack output = new ItemStack(Items.compound, 1, 0);
		return output;
	}
}
