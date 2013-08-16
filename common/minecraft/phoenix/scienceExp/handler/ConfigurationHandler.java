package minecraft.phoenix.scienceExp.handler;

import java.io.File;
import java.util.logging.Level;
import minecraft.phoenix.scienceExp.lib.Reference;
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
			
			// Example - BlockIds.BlockID_Asphalt = config.getBlock(Strings.BLOCK_ASPHALT, BlockIds.BlockID_Asphalt_Default).getInt(BlockIds.BlockID_Asphalt_Default);
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