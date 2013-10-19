package minecraft.phoenix.scienceExp.items;

import minecraft.phoenix.scienceExp.lib.ItemIds;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
	public static final ItemArmor helmetHazmat = new ItemHazmat(ItemIds.ItemID_helmetHazmat, 0);
	public static final ItemArmor plateHazmat = new ItemHazmat(ItemIds.ItemID_plateHazmat, 1);
	public static final ItemArmor legsHazmat = new ItemHazmat(ItemIds.ItemID_legsHazmat, 2);
	public static final ItemArmor bootsHazmat = new ItemHazmat(ItemIds.ItemID_bootsHazmat, 3);
	
	//Elements
	public static final Item element = new ItemElement(ItemIds.ItemID_element);
	
    /**
     * Adding all items to the game
     * 
     */
	public static void init()
	{
		helmetHazmat.setCreativeTab(CommonProxy.temp).setUnlocalizedName(Strings.HAZMAT_HELMET);
		plateHazmat.setCreativeTab(CommonProxy.temp).setUnlocalizedName(Strings.HAZMAT_PLATE);
		legsHazmat.setCreativeTab(CommonProxy.temp).setUnlocalizedName(Strings.HAZMAT_LEGS);
		bootsHazmat.setCreativeTab(CommonProxy.temp).setUnlocalizedName(Strings.HAZMAT_BOOTS);
		
		GameRegistry.registerItem(helmetHazmat, Strings.HAZMAT_HELMET);
		GameRegistry.registerItem(plateHazmat, Strings.HAZMAT_PLATE);
		GameRegistry.registerItem(legsHazmat, Strings.HAZMAT_LEGS);
		GameRegistry.registerItem(bootsHazmat, Strings.HAZMAT_BOOTS);
		
		GameRegistry.registerItem(element, Strings.ELEMENT);
	}
}
