package minecraft.phoenix.scienceExp.chemistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compound
{
	public LinkedHashMap<Object, Integer> components;
	public static HashMap<Integer, String> subscript;
	static
	{
		subscript = new HashMap<Integer, String>();
		subscript.put(1 ,"");
		subscript.put(2 ,"₂");
		subscript.put(3 ,"₃");
		subscript.put(4 ,"₄");
		subscript.put(5 ,"₅");
		subscript.put(6 ,"₆");
		subscript.put(7 ,"₇");
		subscript.put(8 ,"₈");
		subscript.put(9 ,"₉");
	}
	
	public Compound(LinkedHashMap<Object, Integer> components)
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
		        if(pairs.getKey() instanceof Elements)
		        	compound += ((Elements) pairs.getKey()).getSymbol() + subscript.get(pairs.getValue());
		        else if(pairs.getKey() instanceof Compound)
		        	compound += "(" + ((Compound) pairs.getKey()).toString() + ")" + subscript.get(pairs.getValue());
		        it.remove();
		    }
		}
		return compound;
	}
	
	public static void fromString(String compound, ArrayList<Elements> elements)
	{
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
				getNumber(matcher.group(), elements);
			}
			else
			{
				Pattern splitBracketsP = Pattern.compile("[A-Z]\\d|[A-Z][a-z]\\d|[A-Z][a-z]|[A-Z]");
				Matcher splitBracketsM = splitBracketsP.matcher(matcher.group());
				while(splitBracketsM.find())
					getNumber(splitBracketsM.group(), elements);
			}
		}
		
	}
	
	private static void getNumber(String matcherGroup, ArrayList<Elements> elements2)
	{
		if(!matcherGroup.matches("[A-Z][a-z]|[A-Z]"))
		{
			Pattern elementPattern = Pattern.compile("[A-Z][a-z]|[A-Z]|\\d");
			Matcher elementMatcher = elementPattern.matcher(matcherGroup);
			elementMatcher.find();
			Elements elements = Elements.symbols.get(elementMatcher.group());
			elementMatcher.find();
			elements2.add(elements);
		}
		else
			elements2.add(Elements.symbols.get(matcherGroup));
	}
}
