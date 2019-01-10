package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.util.ResourceLocation;

public class ItemStats {
    public String name;
    public int color;
    public ResourceLocation texture;

    public ItemStats(String name, int color, ResourceLocation texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public static ResourceLocation INGOT = new ResourceLocation("pixelutils:ingot");
    public static ResourceLocation ROUGH_INGOT = new ResourceLocation("pixelutils:rough_ingot");
}
