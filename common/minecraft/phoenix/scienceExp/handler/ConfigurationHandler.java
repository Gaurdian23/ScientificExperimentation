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