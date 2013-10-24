package minecraft.phoenix.scienceExp.chemistry;

import java.util.HashMap;

public enum Elements
{
	HYDROGEN (1, "H", 1, false), HELIUM (2, "He", 0, false),
	LITHIUM (3, "Li", 1, true), BERYLLIUM (4, "Be", 2, true), BORON (5, "B", 3, false), CARBON (6, "C", 4, false), NITROGEN (7, "N", 5, false), OXYGEN (8, "O", 6, false), FLUORINE (9, "F", 7, false), NEON (10, "Ne", 0, false),
	SODIUM (11, "Na", 1, true), MAGNESIUM (12, "Mg", 2, true), ALUMINIUM (13, "Al", 3, true), SILICON (14, "Si", 4, false), PHOSPHOROUS (15, "P", 5, false), SULPHUR (16, "S", 6, false), CHLORINE (17, "Cl", 7, false), ARGON (18, "Ar", 0, false);
	
	private String symbol;
	private int outerElectrons;
	private int protonNumber;
	private boolean isMetal;
	private int reactivity;
	public static HashMap<String, Elements> symbols;
	static
	{
		symbols = new HashMap<String, Elements>();
		for(Elements e : Elements.values())
		{
			symbols.put(e.symbol, e);
		}
	}
	
	private Elements(int protonNumber, String symbol, int outerElectrons, boolean isMetal)
	{
		this.protonNumber = protonNumber;
		this.outerElectrons = outerElectrons;
		this.symbol = symbol;
		this.isMetal = isMetal;
		this.reactivity = 4*(Math.abs(protonNumber-4) + Math.abs(outerElectrons-4));
	}
	
	/**
	 * @return the outerElectrons
	 */
	public int getOuterElectrons()
	{
		return outerElectrons;
	}
	
	/**
	 * @return the protonNumber
	 */
	public int getProtonNumber()
	{
		return protonNumber;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}
	
	/**
	 * @return the reactivity
	 */
	public int getReactivity()
	{
		return reactivity;
	}
	
	/**
	 * @return is it a metal
	 */
	public boolean isMetal()
	{
		return isMetal;
	}
}
