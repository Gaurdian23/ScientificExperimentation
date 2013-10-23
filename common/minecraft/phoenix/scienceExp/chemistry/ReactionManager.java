package minecraft.phoenix.scienceExp.chemistry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
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
		ItemStack[] input = labMatrix.getInput();
		ItemStack[] output = new ItemStack[labResultMatrix.getSizeInventory()];
		HashMap<Element, Integer> elements = new LinkedHashMap<Element, Integer>();
		for(ItemStack stack : input)
		{
			if(stack != null)
			{
				if(stack.itemID == Items.element.itemID)
				{
					if(!(stack.getItemDamage() == 0 ||
							stack.getItemDamage() == 7 ||
							stack.getItemDamage() == 8 ||
							stack.getItemDamage() == 9 ||
							stack.getItemDamage() == 17))
						elements.put(Element.values()[stack.getItemDamage()], elements.containsKey(Element.values()[stack.getItemDamage()]) ? elements.get(Element.values()[stack.getItemDamage()])+stack.stackSize: stack.stackSize);
					else
						elements.put(Element.values()[stack.getItemDamage()], elements.containsKey(Element.values()[stack.getItemDamage()]) ? elements.get(Element.values()[stack.getItemDamage()])+stack.stackSize*2: stack.stackSize*2);
				}
				else
					Compound.fromString(stack.getDisplayName(), elements);
			}
		}
		HashMap<Compound, Integer> compounds = calculateCompounds(elements);
		if(!compounds.isEmpty())
		{
			Iterator<Entry<Compound, Integer>> it = compounds.entrySet().iterator();
			int i = 0;
			while(it.hasNext())
			{
				Entry<Compound, Integer> pairs = it.next();
				output[i] = new ItemStack(Items.compound, pairs.getValue());
				output[i].setItemName(pairs.getKey().toString());
				i++;
			}
		}
		return output;
	}

	private HashMap<Compound, Integer> calculateCompounds(HashMap<Element, Integer> elements)
	{
		HashMap<Compound, Integer> output = new HashMap<Compound, Integer>();
		LinkedHashMap<Object, Integer> input = new LinkedHashMap<Object, Integer>();
		if(!elements.isEmpty())
		{
			Iterator<Entry<Element, Integer>> it = elements.entrySet().iterator();
			while(it.hasNext())
			{
				Entry<Element, Integer> pairs = it.next();
				input.put(pairs.getKey(), pairs.getValue());
			}
		}
		if(!input.isEmpty())
			output.put(new Compound(input), 1);
		return output;
	}
}
