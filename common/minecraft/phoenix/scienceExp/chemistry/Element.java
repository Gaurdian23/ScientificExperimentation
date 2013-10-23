package minecraft.phoenix.scienceExp.chemistry;

import java.util.HashMap;

public enum Element
{
	HYDROGEN ("H", 1), HELIUM ("He", 0),
	LITHIUM ("Li", 1), BERYLLIUM ("Be", 2), BORON ("B", 3), CARBON ("C", 4), NITROGEN ("N", 5), OXYGEN ("O", 6), FLUORINE ("F", 7), NEON ("Ne", 0),
	SODIUM ("Na", 1), MAGNESIUM ("Mg", 2), ALUMINIUM ("Al", 3), SILICON ("Si", 4), PHOSPHOROUS ("P", 5), SULPHUR ("S", 6), CHLORINE ("Cl", 7), ARGON ("Ar", 0);
	
	
	private String symbol;
	private int outerElectrons;
	public static HashMap<String, Element> symbols;
	static
	{
		symbols = new HashMap<String, Element>();
		for(Element e : Element.values())
		{
			symbols.put(e.symbol, e);
		}
	}
	
	private Element(String symbol, int outerElectrons)
	{
		this.outerElectrons = outerElectrons;
		this.symbol = symbol;
	}
	
	/**
	 * @return the outerElectrons
	 */
	public int getOuterElectrons()
	{
		return outerElectrons;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}
}
