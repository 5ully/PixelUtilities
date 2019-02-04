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
    public static ResourceLocation POWDER = new ResourceLocation("pixelutils:powder");
    public static ResourceLocation DUST = new ResourceLocation("pixelutils:dust");
    public static ResourceLocation QUARTZ = new ResourceLocation("pixelutils:quartz");
    public static ResourceLocation GEM_DIAMOND = new ResourceLocation("pixelutils:gem_diamond");
    public static ResourceLocation PLATE = new ResourceLocation("pixelutils:plate");
    public static ResourceLocation WIRE = new ResourceLocation("pixelutils:wire");
    public static ResourceLocation CLAY = new ResourceLocation("pixelutils:clay_ball");
    public static ResourceLocation BRICK = new ResourceLocation("pixelutils:brick");
}