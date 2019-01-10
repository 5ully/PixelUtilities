package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class RenderItems {
    public static void preInit() {
        registerItemRenderer(Items.itemcomponent[0], Items.stats.get(0).texture);
    }

    public static void init() {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler((stack, tintIndex) -> Items.stats.get(0).color, Items.itemcomponent);
    }

    private static void registerItemRenderer(Item item, ResourceLocation texture) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(texture, "inventory"));
    }
}
