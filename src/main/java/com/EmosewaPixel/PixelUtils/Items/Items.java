package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;

import java.util.ArrayList;

public class Items {
    public static Item[] itemcomponent = new Item[43];
    protected static ArrayList<ItemStats> stats = new ArrayList<>();

    public static void init() {
        addStats("cast_iron", 0x494949, ItemStats.ROUGH_INGOT);
        addStats("silver_quartz", 0xa7a7a7, ItemStats.QUARTZ);
        addStats("boney_brass", 0xe1dcb6, ItemStats.INGOT);
        addStats("menril_alloy", 0xafd6e1, ItemStats.INGOT);
        addStats("nether_clay", 0xbd8585, ItemStats.CLAY);
        addStats("applied_steel", 0x5e5e5e, ItemStats.INGOT);
        addStats("ultimet", 0x21ccdd, ItemStats.INGOT);
        addStats("green_bronze", 0x1b8000, ItemStats.INGOT);
        addStats("slightly_refined_iron", 0xe1e1e1, ItemStats.INGOT);
        addStats("partially_refined_iron", 0xe7e7e7, ItemStats.INGOT);
        addStats("mostly_refined_iron", 0xf8f8f8, ItemStats.INGOT);
        addStats("thermal_steel", 0xa7a2a2, ItemStats.INGOT);
        addStats("thermal_iron", 0xc3c0c0, ItemStats.INGOT);
        addStats("iskallium", 0x71d52d, ItemStats.INGOT);
        addStats("resstone", 0xf80017, ItemStats.DUST);
        addStats("rose_gold", 0xf99da6, ItemStats.INGOT);
        addStats("electrine", 0xffdf2b, ItemStats.INGOT);
        addStats("redstone_alloy_plate", 0xa52c2c, ItemStats.PLATE);
        addStats("redstone_alloy_wire", 0xa52c2c, ItemStats.WIRE);
        addStats("meat", 0xefbcbc, ItemStats.ROUGH_INGOT);

        addStats("temite", 0xd2d2d2, ItemStats.ROUGH_INGOT);
        addStats("platin", 0x8da8c4, ItemStats.INGOT);
        addStats("leadstone", 0x8d82bc, ItemStats.INGOT);
        addStats("blazestone", 0xe02f26, ItemStats.POWDER);
        addStats("lapotron", 0xa8d4e8, ItemStats.GEM_DIAMOND);
        addStats("radiation-proof_steel", 0x787883, ItemStats.INGOT);
        addStats("chorus_alloy", 0xe8abe7, ItemStats.INGOT);
        addStats("angmallen", 0xd7d286, ItemStats.INGOT);
        addStats("ash_clay", 0xcfcfcf, ItemStats.CLAY);
        addStats("ash_clay_brick", 0xc4c4c4, ItemStats.BRICK);
        addStats("improperly_made_steel", 0x333333, ItemStats.ROUGH_INGOT);
        addStats("cold_tungsten", 0x313b58, ItemStats.INGOT);
        addStats("mana_blazestone", 0x2bcdde, ItemStats.POWDER);
        addStats("hearty", 0x98590f, ItemStats.ROUGH_INGOT);
        addStats("bloody", 0xc10101, ItemStats.ROUGH_INGOT);
        addStats("redstone_soul", 0xa52c2c, ItemStats.SOUL);
        addStats("bobmonium", 0x6b4431, ItemStats.INGOT);
        addStats("brown_clay", 0xd9b377, ItemStats.CLAY);
        addStats("crimstane", 0xa42421, ItemStats.INGOT);
        addStats("plangstin", 0x575f68, ItemStats.INGOT);
        addStats("depleted_iskallium", 0xb2c8a4, ItemStats.INGOT);
        addStats("urium", 0xf3d530, ItemStats.GEM_CUBIC);
        addStats("empowered_urium", 0xf3d530, ItemStats.GEM_CUBIC, true);

        for (int i = 0; i < itemcomponent.length; i++)
            itemcomponent[i] = registerItem(new ItemComponent(stats.get(i).name, stats.get(i).isGlowing));
    }

    private static Item registerItem(Item item) {
        GameData.register_impl(item);

        return item;
    }

    private static void addStats(String name, int color, ResourceLocation texture) {
        addStats(name, color, texture, false);
    }

    private static void addStats(String name, int color, ResourceLocation texture, boolean isGlowing) {
        if (texture == ItemStats.INGOT || texture == ItemStats.ROUGH_INGOT)
            stats.add(new ItemStats(name + "_ingot", color, texture, isGlowing));
        else
            stats.add(new ItemStats(name, color, texture, isGlowing));
    }
}
