package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;

import java.util.ArrayList;

public class Items {
    public static Item[] itemcomponent = new Item[1];
    public static ArrayList<ItemStats> stats = new ArrayList<>();

    public static void init() {
        addStats("cast_iron_ingot", 0x393939, ItemStats.ROUGH_INGOT);

        itemcomponent[0] = registerItem(stats.get(0).name);
    }

    private static Item registerItem(String name) {
        GameData.register_impl(new ItemComponent(name));

        return new ItemComponent(name);
    }

    private static void addStats(String name, int color, ResourceLocation texture) {
        stats.add(new ItemStats(name, color, texture));
    }
}
