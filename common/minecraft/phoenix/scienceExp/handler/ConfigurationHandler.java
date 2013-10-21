package minecraft.phoenix.scienceExp.handler;

import java.io.File;
import java.util.logging.Level;
import minecraft.phoenix.scienceExp.lib.BlockIds;
import minecraft.phoenix.scienceExp.lib.ItemIds;
import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.lib.Strings;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */

public class ConfigurationHandler
{
	public static Configuration config;
	
	public static void init(File file)
	{
		
		config = new Configuration(file);
		
		try
		{
			config.load();
			
			//Ores
			BlockIds.BlockID_CopperOre = config.getBlock(Strings.COPPER_ORE, BlockIds.BlockID_CopperOre_Default).getInt(BlockIds.BlockID_CopperOre_Default);
			BlockIds.BlockID_LeadOre = config.getBlock(Strings.LEAD_ORE, BlockIds.BlockID_LeadOre_Default).getInt(BlockIds.BlockID_LeadOre_Default);
			BlockIds.BlockID_TungstenOre = config.getBlock(Strings.TUNGSTEN_ORE, BlockIds.BlockID_TungstenOre_Default).getInt(BlockIds.BlockID_TungstenOre_Default);
			BlockIds.BlockID_SiliconOre = config.getBlock(Strings.SILICON_ORE, BlockIds.BlockID_SiliconOre_Default).getInt(BlockIds.BlockID_SiliconOre_Default);
			BlockIds.BlockID_IridiumOre = config.getBlock(Strings.IRIDIUM_ORE, BlockIds.BlockID_IridiumOre_Default).getInt(BlockIds.BlockID_IridiumOre_Default);
			BlockIds.BlockID_MagnetiteOre = config.getBlock(Strings.MAGNETITE_ORE, BlockIds.BlockID_MagnetiteOre_Default).getInt(BlockIds.BlockID_MagnetiteOre_Default);
			BlockIds.BlockID_AluminiumOre = config.getBlock(Strings.ALUMINIUM_ORE, BlockIds.BlockID_AluminiumOre_Default).getInt(BlockIds.BlockID_AluminiumOre_Default);
			BlockIds.BlockID_TinOre = config.getBlock(Strings.TIN_ORE, BlockIds.BlockID_TinOre_Default).getInt(BlockIds.BlockID_TinOre_Default);
			BlockIds.BlockID_TitaniumOre = config.getBlock(Strings.TITANIUM_ORE, BlockIds.BlockID_TitaniumOre_Default).getInt(BlockIds.BlockID_TitaniumOre_Default);
			BlockIds.BlockID_Lab = config.getBlock(Strings.LAB, BlockIds.BlockID_Lab_Default).getInt(BlockIds.BlockID_Lab_Default);
			
			//Fluids and gases
			BlockIds.BlockID_PoisonGas = config.getBlock(Strings.POISON_GAS, BlockIds.BlockID_PoisonGas_Default).getInt(BlockIds.BlockID_PoisonGas_Default);
			
			//Armour
			ItemIds.ItemID_helmetHazmat = config.getItem(Strings.HAZMAT_HELMET, ItemIds.ItemID_helmetHazmat_Default).getInt(ItemIds.ItemID_helmetHazmat_Default);
			ItemIds.ItemID_plateHazmat = config.getItem(Strings.HAZMAT_PLATE, ItemIds.ItemID_plateHazmat_Default).getInt(ItemIds.ItemID_plateHazmat_Default);
			ItemIds.ItemID_legsHazmat = config.getItem(Strings.HAZMAT_LEGS, ItemIds.ItemID_legsHazmat_Default).getInt(ItemIds.ItemID_legsHazmat_Default);
			ItemIds.ItemID_bootsHazmat = config.getItem(Strings.HAZMAT_BOOTS, ItemIds.ItemID_bootsHazmat_Default).getInt(ItemIds.ItemID_bootsHazmat_Default);

			//Science Items
			ItemIds.ItemID_element = config.getItem(Strings.ELEMENT, ItemIds.ItemID_element_Default).getInt(ItemIds.ItemID_element_Default);
			ItemIds.ItemID_compound = config.getItem(Strings.COMPOUND, ItemIds.ItemID_compound_Default).getInt(ItemIds.ItemID_compound_Default);
		}
		catch (Exception e)
		{
			
			FMLLog.log(Level.SEVERE, e, Reference.modid + "has a problem loading the config file");
		}
		finally
		{
			
			config.save();
		}
		
	}
}