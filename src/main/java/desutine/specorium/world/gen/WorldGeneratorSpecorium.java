package desutine.specorium.world.gen;

import desutine.specorium.registry.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorSpecorium implements IWorldGenerator {
    private final WorldGenMinable overworldOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(0), 6);
    private final WorldGenMinable netherOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(1), 32);
    private final WorldGenMinable endOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(2), 32);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        final int chunkAmount;
        switch (world.provider.getDimension()) {
            // overworld
            case 0:
                chunkAmount = 10 + random.nextInt(5);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            5 + random.nextInt(49),
                            z + random.nextInt(16)
                    );
                    this.overworldOreGen.generate(world, random, pos);
                }
                break;
            // nether
            case -1:
                chunkAmount = 2 + random.nextInt(1);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            90 + random.nextInt(30),
                            z + random.nextInt(16)
                    );
                    this.netherOreGen.generate(world, random, pos);
                }
                break;
            // end
            case 1:
                // only spawn in the outer lands
                if (x * x + z * z < 1000000) return;

                chunkAmount = 2 + random.nextInt(1);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            5 + random.nextInt(49),
                            z + random.nextInt(16)
                    );
                    this.endOreGen.generate(world, random, pos);
                }
                break;
            default:
                break;
        }
    }
}
