package minecraft.phoenix.scienceExp.proxy;

import minecraft.phoenix.scienceExp.gases.BlockRenderGas;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */

public class ClientProxy extends CommonProxy
{
	public static BlockRenderGas blockRenderGas = new BlockRenderGas(RenderingRegistry.getNextAvailableRenderId());
	
	@Override
	public void registerThings()
	{
		RenderingRegistry.registerBlockHandler(blockRenderGas);
	}
}