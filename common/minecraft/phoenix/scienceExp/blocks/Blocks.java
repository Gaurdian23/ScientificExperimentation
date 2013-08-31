package minecraft.phoenix.scienceExp.blocks;

import java.util.Random;
import minecraft.phoenix.scienceExp.lib.BlockIds;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.util.CustomOre;
import minecraft.phoenix.scienceExp.util.WorldGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */
public class Blocks
{
	private static Random rand = new Random();
	
	//Initialising Blocks
	public static final Block copperOre = new CustomOre(Strings.COPPER_ORE, BlockIds.BlockID_CopperOre).setHardness(3.0F).setResistance(5.0F);
	
    /**
     * Adding all blocks to the game
     */
	public static void init()
	{
		GameRegistry.registerBlock(copperOre, Strings.COPPER_ORE);
		OreDictionary.registerOre("oreCopper", copperOre);
		WorldGenerator.ores.add(new int[]{copperOre.blockID, 8, 20 + rand.nextInt(2), 1, 64});
	}
}
