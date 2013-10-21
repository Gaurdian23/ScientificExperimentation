package minecraft.phoenix.scienceExp.proxy;

import minecraft.phoenix.scienceExp.handler.ScienceGuiHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.network.IGuiHandler;


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
	public static final CreativeTabs temp = new CreativeTabs("temp");
	public static final CreativeTabs elements = new CreativeTabs("elements");
	public static final IGuiHandler scienceGuiHandler = new ScienceGuiHandler();
	
	public void registerThings()
	{
		
	}
}