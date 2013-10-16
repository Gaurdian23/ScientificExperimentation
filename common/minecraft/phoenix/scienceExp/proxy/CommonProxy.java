package minecraft.phoenix.scienceExp.proxy;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;


/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 *
 */

public class CommonProxy
{
	/**
	 * Registers things which don't have a specific place.
	 */
	public static final EnumArmorMaterial HAZMAT = EnumHelper.addArmorMaterial("HAZMAT", 2, new int[]{1, 1, 1, 1}, 0);
	
	public void registerThings()
	{
		
	}
}