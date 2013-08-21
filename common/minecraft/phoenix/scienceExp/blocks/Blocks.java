package minecraft.phoenix.scienceExp.blocks;

import java.util.Random;
import minecraft.phoenix.scienceExp.lib.BlockIds;
import minecraft.phoenix.scienceExp.util.CustomOre;
import minecraft.phoenix.scienceExp.util.OreGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

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
	public static final Block copperOre = new CustomOre("copperOre", BlockIds.BlockID_CopperOre).setHardness(3.0F).setResistance(5.0F);
	
    /**
     * Adding all blocks to the game
     * 
     */
	public static void init()
	{
		OreDictionary.registerOre("oreCopper", copperOre);
		OreGenerator.ores.add(new int[]{copperOre.blockID, 2 + rand.nextInt(2), 1, 64});
	}
}
