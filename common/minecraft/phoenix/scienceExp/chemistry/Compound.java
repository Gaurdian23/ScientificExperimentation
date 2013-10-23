package minecraft.phoenix.scienceExp.chemistry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compound
{
	public HashMap<Object, Integer> components;
	public static HashMap<Integer, String> subscript;
	static
	{
		subscript = new HashMap<Integer, String>();
		subscript.put(1 ,"₁");
		subscript.put(2 ,"₂");
		subscript.put(3 ,"₃");
		subscript.put(4 ,"₄");
		subscript.put(5 ,"₅");
		subscript.put(6 ,"₆");
		subscript.put(7 ,"₇");
		subscript.put(8 ,"₈");
		subscript.put(9 ,"₉");
	}
	
	public Compound(HashMap<Object, Integer> components)
	{
		this.components = components;
	}
	
	@Override
	public String toString()
	{
		String compound = "";
		if(!components.isEmpty())
		{
			Iterator<Entry<Object, Integer>> it = components.entrySet().iterator();
		    while (it.hasNext())
		    {
		        Map.Entry<Object, Integer> pairs = it.next();
		        if(pairs.getKey() instanceof Element)
		        	compound += ((Element) pairs.getKey()).getSymbol() + subscript.get(pairs.getValue());
		        else if(pairs.getKey() instanceof Compound)
		        	compound += "(" + ((Compound) pairs.getKey()).toString() + ")" + subscript.get(pairs.getValue());
		        it.remove();
		    }
		}
		return compound;
	}
	
	public static void fromString(String compound, HashMap<Element, Integer> elements)
	{
		compound.replace("₁", "1");
		compound.replace("₂", "2");
		compound.replace("₃", "3");
		compound.replace("₄", "4");
		compound.replace("₅", "5");
		compound.replace("₆", "6");
		compound.replace("₇", "7");
		compound.replace("₈", "8");
		compound.replace("₉", "9");
		Pattern pattern = Pattern.compile("\\(\\w+\\)\\d|[A-Z]\\d|[A-Z][a-z]\\d|[A-Z][a-z]|[A-Z]");
		Matcher matcher = pattern.matcher(compound);
		while(matcher.find())
		{
			if(!matcher.group().startsWith("("))
			{
				getNumber(matcher.group(), elements, 1);
			}
			else
			{
				int multiplier = Integer.parseInt(matcher.group().substring(matcher.group().length()-2, matcher.group().length()-1));
				Pattern splitBracketsP = Pattern.compile("[A-Z]\\d|[A-Z][a-z]\\d|[A-Z][a-z]|[A-Z]");
				Matcher splitBracketsM = splitBracketsP.matcher(matcher.group());
				while(splitBracketsM.find())
					getNumber(splitBracketsM.group() , elements, multiplier);
			}
		}
		
	}
	
	private static void getNumber(String matcherGroup, HashMap<Element, Integer> elements, int multiplier)
	{
		Pattern elementPattern = Pattern.compile("[A-Z][a-z]|[A-Z]|\\d");
		Matcher elementMatcher = elementPattern.matcher(matcherGroup);
		elementMatcher.find();
		Element element = Element.symbols.get(elementMatcher.group());
		elementMatcher.find();
		elements.put(element, elements.get(element) == null ? Integer.parseInt(elementMatcher.group()) : elements.get(element) + Integer.parseInt(elementMatcher.group()));
	}
}
