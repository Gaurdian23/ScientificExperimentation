package minecraft.phoenix.scienceExp.chemistry;

public class Element
{
	private Elements element;
	private int outerElectrons;
	private int charge;
	
	public Element(Elements element)
	{
		this.element = element;
		this.outerElectrons = element.getOuterElectrons();
	}

	/**
	 * @return the element
	 */
	public Elements getElement()
	{
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Elements element)
	{
		this.element = element;
	}

	/**
	 * @return the outerElectrons
	 */
	public int getOuterElectrons()
	{
		return outerElectrons;
	}

	/**
	 * @param outerElectrons the outerelectrons to set
	 */
	public void setOuterElectrons(int outerElectrons)
	{
		this.outerElectrons = outerElectrons;
		this.charge = this.element.getOuterElectrons()-outerElectrons;
	}
	

	/**
	 * @return the charge
	 */
	public int getCharge()
	{
		return charge;
	}

}
