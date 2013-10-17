package minecraft.phoenix.scienceExp.items;

import minecraft.phoenix.scienceExp.lib.ItemIds;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import net.minecraft.item.ItemArmor;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */
public class Items
{
	//Initialising Items
	public static final ItemArmor helmetHazmat = new ItemArmor(ItemIds.ItemID_helmetHazmat, CommonProxy.HAZMAT, RenderingRegistry.addNewArmourRendererPrefix("hazmat"), 0);
	public static final ItemArmor plateHazmat = new ItemArmor(ItemIds.ItemID_plateHazmat, CommonProxy.HAZMAT, RenderingRegistry.addNewArmourRendererPrefix("hazmat"), 1);
	public static final ItemArmor legsHazmat = new ItemArmor(ItemIds.ItemID_legsHazmat, CommonProxy.HAZMAT, RenderingRegistry.addNewArmourRendererPrefix("hazmat"), 2);
	public static final ItemArmor bootsHazmat = new ItemArmor(ItemIds.ItemID_bootsHazmat, CommonProxy.HAZMAT, RenderingRegistry.addNewArmourRendererPrefix("hazmat"), 3);
	
    /**
     * Adding all items to the game
     * 
     */
	public static void init()
	{
		GameRegistry.registerItem(helmetHazmat, Strings.HAZMAT_HELMET);
		GameRegistry.registerItem(plateHazmat, Strings.HAZMAT_PLATE);
		GameRegistry.registerItem(legsHazmat, Strings.HAZMAT_LEGS);
		GameRegistry.registerItem(bootsHazmat, Strings.HAZMAT_BOOTS);
	}
}
