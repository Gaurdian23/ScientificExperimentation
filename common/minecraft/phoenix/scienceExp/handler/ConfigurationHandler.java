package minecraft.phoenix.scienceExp.handler;

import java.io.File;
import java.util.logging.Level;
import minecraft.phoenix.scienceExp.lib.BlockIds;
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
			
			BlockIds.BlockID_CopperOre = config.getBlock(Strings.COPPER_ORE, BlockIds.BlockID_CopperOre_Default).getInt(BlockIds.BlockID_CopperOre_Default);
			BlockIds.BlockID_LeadOre = config.getBlock(Strings.LEAD_ORE, BlockIds.BlockID_LeadOre_Default).getInt(BlockIds.BlockID_LeadOre_Default);
			BlockIds.BlockID_TungstenOre = config.getBlock(Strings.TUNGSTEN_ORE, BlockIds.BlockID_TungstenOre_Default).getInt(BlockIds.BlockID_TungstenOre_Default);
			BlockIds.BlockID_SiliconOre = config.getBlock(Strings.SILICON_ORE, BlockIds.BlockID_SiliconOre_Default).getInt(BlockIds.BlockID_SiliconOre_Default);
			BlockIds.BlockID_IridiumOre = config.getBlock(Strings.IRIDIUM_ORE, BlockIds.BlockID_IridiumOre_Default).getInt(BlockIds.BlockID_IridiumOre_Default);
			BlockIds.BlockID_MagnetiteOre = config.getBlock(Strings.MAGNETITE_ORE, BlockIds.BlockID_MagnetiteOre_Default).getInt(BlockIds.BlockID_MagnetiteOre_Default);
			BlockIds.BlockID_AluminiumOre = config.getBlock(Strings.ALUMINIUM_ORE, BlockIds.BlockID_AluminiumOre_Default).getInt(BlockIds.BlockID_AluminiumOre_Default);
			BlockIds.BlockID_TinOre = config.getBlock(Strings.TIN_ORE, BlockIds.BlockID_TinOre_Default).getInt(BlockIds.BlockID_TinOre_Default);
			BlockIds.BlockID_TitaniumOre = config.getBlock(Strings.TITANIUM_ORE, BlockIds.BlockID_TitaniumOre_Default).getInt(BlockIds.BlockID_TitaniumOre_Default);
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