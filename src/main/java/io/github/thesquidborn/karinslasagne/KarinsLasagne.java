package io.github.thesquidborn.karinslasagne;

import io.github.thesquidborn.karinslasagne.block.ModBlocks;
import io.github.thesquidborn.karinslasagne.fluid.ModFluids;
import io.github.thesquidborn.karinslasagne.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KarinsLasagne implements ModInitializer {
	public static final String MOD_ID = "karinslasagne";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("I knews i smelt some lasagna down the road");

		ModItems.initialize();
		ModBlocks.initialize();
		ModFluids.initialize();
	}
}