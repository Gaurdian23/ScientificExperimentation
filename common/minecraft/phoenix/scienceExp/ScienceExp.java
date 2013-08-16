package minecraft.phoenix.scienceExp;

import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
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
}
