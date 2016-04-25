package desutine.specorium.registry;

import desutine.specorium.reference.EnumColors;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
    public static void init() {
        final ItemStack taintedIngot = new ItemStack(ModItems.SPECORIUM_TAINTED_INGOT);

//        OreDictionary.registerOre("oreSpecorium", new ItemStack(ModBlocks.SPECORIUM_ORE, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("ingotSpecorium", new ItemStack(ModItems.SPECORIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
//        OreDictionary.registerOre("nuggetSpecorium", new ItemStack(ModItems.SPECORIUM_NUGGET, 1, OreDictionary.WILDCARD_VALUE));

        // smelting ore = tainted ingot
        GameRegistry.addSmelting(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 0), taintedIngot, 1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 1), taintedIngot, 1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.SPECORIUM_ORE, 1, 2), taintedIngot, 1f);

        for (EnumColors color : EnumColors.values()) {
            final ItemStack coloredNugget = new ItemStack(ModItems.SPECORIUM_NUGGET, 1, color.ordinal());
            final ItemStack coloredIngot = new ItemStack(ModItems.SPECORIUM_INGOT, 1, color.ordinal());

            // nuggets -> ingot
            GameRegistry.addRecipe(new ShapelessOreRecipe(coloredIngot,
                    coloredNugget, coloredNugget, coloredNugget, coloredNugget, coloredNugget, coloredNugget,
                    coloredNugget, coloredNugget, coloredNugget
            ));

            // ingot -> nuggets
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.SPECORIUM_NUGGET, 9, color.ordinal()),
                    coloredIngot
            ));

            // ingot -> nuggets
            GameRegistry.addRecipe(new ShapedOreRecipe(coloredIngot, " n ", "ntn", " n ",
                    'n', coloredNugget,
                    't', taintedIngot
            ));
        }

        // all ingot flavours -> enriched block
        final ItemStack ascendedBlock = new ItemStack(ModBlocks.ASCENDED_SPECORIUM);
        GameRegistry.addRecipe(new ShapelessOreRecipe(ascendedBlock,
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 0),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 1),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 2),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 3),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 4),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 5),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 6),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 7),
                new ItemStack(ModItems.SPECORIUM_INGOT, 1, 8)
        ));

        // ascended block -> ingot
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.SPECORIUM_ASCENDED_INGOT, 9),
                ascendedBlock
        ));

        // ascended ingots -> block
        GameRegistry.addRecipe(new ShapedOreRecipe(ascendedBlock, "iii", "iii", "iii",
                'i', new ItemStack(ModItems.SPECORIUM_ASCENDED_INGOT)
        ));
    }
}
