package io.github.thesquidborn.karinslasagne.block;

import io.github.thesquidborn.karinslasagne.KarinsLasagne;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block register(Block block, String name) {
        Identifier id = new Identifier(KarinsLasagne.MOD_ID, name);

        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block KNIFE_BLOCK = register(
            new Block(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.METAL)),
            "knife_block"
    );

    public static void initialize() {}
}
