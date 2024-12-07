package io.github.thesquidborn.karinslasagne;

import io.github.thesquidborn.karinslasagne.block.ModBlocks;
import io.github.thesquidborn.karinslasagne.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class KarinsLasagneClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BECHAMEL_SAUCE, ModFluids.FLOWING_BECHAMEL_SAUCE, new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xffefaf
		));

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MEAT_SAUCE, ModFluids.FLOWING_MEAT_SAUCE, new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x7a4417
		));
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KNIFE_BLOCK, RenderLayer.getCutout());
	}
}
