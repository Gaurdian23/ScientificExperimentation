package minecraft.phoenix.scienceExp;

import java.io.File;
import minecraft.phoenix.scienceExp.blocks.Blocks;
import minecraft.phoenix.scienceExp.handler.ConfigurationHandler;
import minecraft.phoenix.scienceExp.handler.LocalizationHandler;
import minecraft.phoenix.scienceExp.items.Items;
import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 *
 */

@Mod(
		modid=Reference.modid, 
		name=Reference.name, 
		version=Reference.version)

@NetworkMod(
		clientSideRequired=true, 
		serverSideRequired=false)
public class ScienceExp
{
	// The instance of your mod that Forge uses.
    @Instance(Reference.modid)
    public static ScienceExp instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(
    		clientSide=Reference.ClientProxy, 
    		serverSide=Reference.CommonProxy)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	 //Loading language files
		LocalizationHandler.loadLanguages();
		
		//Registering things which dont have to be in the Main Mod file
		proxy.registerThings();
		
		//Loading the configuration Hanlder
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.modid + File.separator + Reference.modid + ".cfg"));
		
		//Initializing the Core Items
	    Items.init();   
	    
	    //Initializing the Core Blocks
	    Blocks.init();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
