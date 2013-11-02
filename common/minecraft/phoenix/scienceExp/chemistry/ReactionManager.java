package minecraft.phoenix.scienceExp.chemistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
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
		HashMap<Element, Integer> elements = new HashMap<Element, Integer>();
		for (ItemStack stack : input)
		{
			if (stack != null)
			{
				if (stack.itemID == Items.element.itemID)
				{
					//TODO diatomic elements
					addToElements(elements, new Element(Elements.values()[stack.getItemDamage()]), stack.stackSize);
				}
				else
					Compound.fromString(stack.getDisplayName(), elements);
			}
		}
		HashMap<Object, Integer> compounds = calculateCompounds(elements);
		if (!compounds.isEmpty())
		{
			Iterator<Entry<Object, Integer>> it = compounds.entrySet().iterator();
			int i = 0;
			while (it.hasNext())
			{
				Entry<Object, Integer> pairs = it.next();
				if(pairs.getKey() instanceof Elements)
					output[i] = new ItemStack(Items.element, pairs.getValue(), ((Elements) pairs.getKey()).getProtonNumber()-1);
				else
				{
					output[i] = new ItemStack(Items.compound, pairs.getValue());
					output[i].setItemName(pairs.getKey().toString());
				}
				i++;
			}
		}
		return output;
	}
	
	private void addToElements(HashMap<Element, Integer> elements, Element elements2, int stackSize)
	{
		elements.put(elements2, elements.containsKey(elements2) ? elements.get(elements2)+stackSize : stackSize); 
	}

	private HashMap<Object, Integer> calculateCompounds(HashMap<Element, Integer> elements)
	{
		TreeMap<Element, Integer> input = new TreeMap<Element, Integer>(new Comparator<Element>()
		{
			public int compare(Element a, Element b)
			{
				return ((Integer)a.getElement().getReactivity()).compareTo(b.getElement().getReactivity());
			}
		});
		Iterator<Entry<Element, Integer>> it = elements.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Element, Integer> pairs = (Entry<Element, Integer>)it.next();
	        input.put(pairs.getKey(), pairs.getValue());
	        it.remove();
	    }
		return react(input);
	}

	private HashMap<Object, Integer> react(TreeMap<Element, Integer> input)
	{
		HashMap<Object, Integer> output = new HashMap<Object, Integer>();
		for(Element element : input)
		{
			if(element.getElement().isMetal())
			{
				Element nonMetal = null;
				for(Element loopNonMetal : input)
				{
					if(!loopNonMetal.getElement().isMetal())
					{
						nonMetal = loopNonMetal;
						break;
					}
				}
				if(nonMetal != null)
				{
					input.remove(nonMetal);
					LinkedHashMap<Object, Integer> compound = new LinkedHashMap<Object, Integer>();
					int numMetal = 1, numNonMetal = 1;
					while((element.getOuterElectrons()*numMetal + nonMetal.getOuterElectrons()*numNonMetal) % 8 != 0)
					{
						if((element.getOuterElectrons()*numMetal + nonMetal.getOuterElectrons()*numNonMetal) > 8)
							numNonMetal++;
						else if((element.getOuterElectrons()*numMetal + nonMetal.getOuterElectrons()*numNonMetal) < 8)
							numMetal++;
					}
					element.setOuterElectrons(0);
					nonMetal.setOuterElectrons(8);
					compound.put(element.getElement(), numMetal);
					compound.put(nonMetal.getElement(), numNonMetal);
					addToOutput(output, new Compound(compound));
				}
			}
			else
				addToOutput(output, element.getElement());
			input.remove(element);
		}
		return output;
	}
	
	private void addToOutput(HashMap<Object, Integer> output, Object object)
	{
		output.put(object, output.containsKey(object) ? output.get(object)+1 : 1); 
	}
}
