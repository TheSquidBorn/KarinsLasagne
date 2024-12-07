package io.github.thesquidborn.karinslasagne.fluid;

import io.github.thesquidborn.karinslasagne.KarinsLasagne;
import io.github.thesquidborn.karinslasagne.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_BECHAMEL_SAUCE;
    public static FlowableFluid FLOWING_BECHAMEL_SAUCE;
    public static Block BECHAMEL_SAUCE_BLOCK;
    public static Item BECHAMEL_SAUCE_BUCKET;

    public static FlowableFluid STILL_MEAT_SAUCE;
    public static FlowableFluid FLOWING_MEAT_SAUCE;
    public static Block MEAT_SAUCE_BLOCK;
    public static Item MEAT_SAUCE_BUCKET;

    public static boolean isBechamelSauce(FluidState state){
        return state.isOf(ModFluids.FLOWING_BECHAMEL_SAUCE) || state.isOf(ModFluids.STILL_BECHAMEL_SAUCE);
    }
    public static boolean isMeatSauce(FluidState state){
        return state.isOf(ModFluids.FLOWING_MEAT_SAUCE) || state.isOf(ModFluids.STILL_MEAT_SAUCE);
    }

    public static void initialize(){
        STILL_BECHAMEL_SAUCE = Registry.register(Registries.FLUID,
                new Identifier((KarinsLasagne.MOD_ID), "bechamel_sauce"), new BechamelSauceFluid.Still());
        FLOWING_BECHAMEL_SAUCE = Registry.register(Registries.FLUID,
                new Identifier((KarinsLasagne.MOD_ID), "flowing_bechamel_sauce"), new BechamelSauceFluid.Flowing());
        BECHAMEL_SAUCE_BLOCK = Registry.register(Registries.BLOCK,
                new Identifier((KarinsLasagne.MOD_ID), "bechamel_sauce_block"), new FluidBlock(ModFluids.STILL_BECHAMEL_SAUCE, FabricBlockSettings.copyOf(Blocks.WATER)){});
        BECHAMEL_SAUCE_BUCKET = Registry.register(Registries.ITEM,
                new Identifier((KarinsLasagne.MOD_ID), "bechamel_sauce_bucket"), new BucketItem(ModFluids.STILL_BECHAMEL_SAUCE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
        STILL_MEAT_SAUCE = Registry.register(Registries.FLUID,
                new Identifier((KarinsLasagne.MOD_ID), "meat_sauce"), new MeatSauceFluid.Still());
        FLOWING_MEAT_SAUCE = Registry.register(Registries.FLUID,
                new Identifier((KarinsLasagne.MOD_ID), "flowing_meat_sauce"), new MeatSauceFluid.Flowing());
        MEAT_SAUCE_BLOCK = Registry.register(Registries.BLOCK,
                new Identifier((KarinsLasagne.MOD_ID), "meat_sauce_block"), new FluidBlock(ModFluids.STILL_MEAT_SAUCE, FabricBlockSettings.copyOf(Blocks.WATER)){});
        MEAT_SAUCE_BUCKET = Registry.register(Registries.ITEM,
                new Identifier((KarinsLasagne.MOD_ID), "meat_sauce_bucket"), new BucketItem(ModFluids.STILL_MEAT_SAUCE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ItemGroupEvents.modifyEntriesEvent(ModItems.KARINS_LASAGNE_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModFluids.BECHAMEL_SAUCE_BUCKET);
            itemGroup.add(ModFluids.MEAT_SAUCE_BUCKET);
        });
    }
}
