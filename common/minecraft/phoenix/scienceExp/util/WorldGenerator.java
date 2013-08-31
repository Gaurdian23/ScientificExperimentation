package minecraft.phoenix.scienceExp.util;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator
{
	/**
	 * blockID, chancesToSpawn, minY, maxY
	 */
	public static ArrayList<int[]> ores = new ArrayList<int[]>(5);
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
    	if(world.provider.dimensionId == 0)
    		generateSurface(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateSurface(World world, Random random, int x, int z)
    {
    	
    	for(int[] ore: ores)
          this.addOreSpawn(ore[0], world, random, x, z, ore[1], ore[2], ore[3], ore[4]);
    }
    
    public void addOreSpawn(int blockID, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
          for(int x = 0; x < chancesToSpawn; x++)
          {
                 int posX = blockXPos + random.nextInt(16);
                 int posY = minY + random.nextInt(maxY - minY);
                 int posZ = blockZPos + random.nextInt(16);
                 (new WorldGenMinable(blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
          }
    }
}
