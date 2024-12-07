package io.github.thesquidborn.karinslasagne.item;

import io.github.thesquidborn.karinslasagne.KarinsLasagne;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(KarinsLasagne.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }

    // COMPONENTS
    public static final FoodComponent KARINS_LASAGNE_COMPONENT = new FoodComponent.Builder()
            .hunger(12)
            .saturationModifier(20)
            .build();

    // ITEMS
    public static final Item LASAGNE_PLATE = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings()),
            "lasagne_plate"
    );

    public static final Item KARINS_LASAGNE = register(
            new Item(new Item.Settings().food(KARINS_LASAGNE_COMPONENT)),
                    "karins_lasagne"
    );

    // ITEM GROUP REGISTRATION
    public static final RegistryKey<ItemGroup> KARINS_LASAGNE_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            new Identifier(KarinsLasagne.MOD_ID,
                    "item_group"
            ));

    public static final ItemGroup KARINS_LASAGNE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.KARINS_LASAGNE))
            .displayName(Text.translatable("itemgroup.karinslasagne"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, KARINS_LASAGNE_GROUP_KEY,KARINS_LASAGNE_GROUP);

        ItemGroupEvents.modifyEntriesEvent(KARINS_LASAGNE_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.LASAGNE_PLATE);
            itemGroup.add(ModItems.KARINS_LASAGNE);
        });
    }
}