package desutine.specorium.world.gen;

import desutine.specorium.registry.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorSpecorium implements IWorldGenerator {
    private static final WorldGenMinable overworldOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(0), 6);
    private static final WorldGenMinable netherOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(1), 12, BlockMatcher.forBlock(Blocks.NETHERRACK));
    private static final WorldGenMinable endOreGen = new WorldGenMinable(ModBlocks.SPECORIUM_ORE.getStateFromMeta(2), 12, BlockMatcher.forBlock(Blocks.END_STONE));

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        final int chunkAmount;

        switch (world.provider.getDimension()) {
            // overworld
            case 0:
                chunkAmount = 8 + random.nextInt(4);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            5 + random.nextInt(48),
                            z + random.nextInt(16)
                    );
                    overworldOreGen.generate(world, random, pos);
                }
                break;
            // nether
            case -1:
                chunkAmount = 4 + random.nextInt(2);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            108 + random.nextInt(16),
                            z + random.nextInt(16)
                    );
                    netherOreGen.generate(world, random, pos);
                }
                break;
            // end
            case 1:
                // only spawn in the outer lands
                if (x * x + z * z < 1000000) return;

                chunkAmount = 4 + random.nextInt(2);
                for (int i = 0; i < chunkAmount; i++) {
                    final BlockPos pos = new BlockPos(
                            x + random.nextInt(16),
                            5 + random.nextInt(48),
                            z + random.nextInt(16)
                    );
                    endOreGen.generate(world, random, pos);
                }
                break;
            default:
                break;
        }
    }
}
