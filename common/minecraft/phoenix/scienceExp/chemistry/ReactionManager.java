package minecraft.phoenix.scienceExp.chemistry;

import java.util.LinkedHashMap;
import minecraft.phoenix.scienceExp.items.Items;
import minecraft.phoenix.scienceExp.util.InventoryReact;
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

	public ItemStack[] calculateOutput(InventoryReact labMatrix, InventoryReact labResultMatrix, World worldObj)
	{
		ItemStack[] output = new ItemStack[labResultMatrix.getSizeInventory()];
		Compound ammoniumSulphate = new Compound(new LinkedHashMap<Object, Integer>());
		Compound ammonia = new Compound(new LinkedHashMap<Object, Integer>());
		ammonia.components.put(Element.NITROGEN, 1);
		ammonia.components.put(Element.HYDROGEN, 4);
		
		ammoniumSulphate.components.put(ammonia, 2);
		ammoniumSulphate.components.put(Element.SULPHUR, 1);
		ammoniumSulphate.components.put(Element.OXYGEN, 4);
		output[0] = new ItemStack(Items.compound);
		output[0].setItemName(ammoniumSulphate.toString());
		
		return output;
	}
}
