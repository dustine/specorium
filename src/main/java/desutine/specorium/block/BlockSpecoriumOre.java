package desutine.specorium.block;

import desutine.specorium.registry.ModBlocks;
import desutine.specorium.registry.ModItems;
import net.minecraft.block.BlockOre;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockSpecoriumOre extends BlockOre {
    private static final PropertyEnum<EnumWorld> WORLD = PropertyEnum.create("world", EnumWorld.class);

    public BlockSpecoriumOre() {
        super();
        setLightLevel(9.0f / 15.0f);
        setHarvestLevel("pickaxe", 2);
        setHardness(5);
        setDefaultState(getDefaultState()
                .withProperty(WORLD, EnumWorld.OVERWORLD));
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
//        super.getSubBlocks(itemIn, tab, list);
        list.add(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 0)); // Overworld
        list.add(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 1)); // Nether
        list.add(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 2)); // End
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        final List<ItemStack> drops = super.getDrops(world, pos, state, fortune);
        final int baseMeta = damageDropped(state);
        if (baseMeta == 7 || baseMeta == 8)
            return drops;
        else {
            // randomize the colour values if in the overworld
            Random rand = world instanceof World ? ((World) world).rand : RANDOM;

            for (ItemStack drop : drops) {
                drop.setItemDamage(rand.nextInt(7));
            }

            return drops;
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(2) + 2;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.SPECORIUM_NUGGET;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, WORLD);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        switch (state.getValue(WORLD)) {
            default:
            case OVERWORLD:
                return 0;
            case NETHER:
                return 1;
            case END:
                return 2;
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        switch (meta) {
            default:
            case 0:
                return getDefaultState().withProperty(WORLD, EnumWorld.OVERWORLD);
            case 1:
                return getDefaultState().withProperty(WORLD, EnumWorld.NETHER);
            case 2:
                return getDefaultState().withProperty(WORLD, EnumWorld.END);
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        switch (state.getValue(WORLD)) {
            default:
            case OVERWORLD:
                return 0;
            case NETHER:
                return 7;
            case END:
                return 8;
        }
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        switch (meta) {
            default:
            case 0:
                return getStateFromMeta(0);
            case 1:
                return getStateFromMeta(1);
            case 2:
                return getStateFromMeta(2);
        }
    }
}
