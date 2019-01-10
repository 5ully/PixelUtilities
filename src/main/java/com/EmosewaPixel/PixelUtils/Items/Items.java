package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;

import java.util.ArrayList;

public class Items {
    public static Item[] itemcomponent = new Item[1];
    public static ArrayList<ItemStats> stats = new ArrayList<>();

    public static void init() {
        addStats("cast_iron_ingot", 0x444444, ItemStats.ROUGH_INGOT);

        itemcomponent[0] = registerItem(new ItemComponent(stats.get(0).name));
    }

    private static Item registerItem(Item item) {
        GameData.register_impl(item);

        return item;
    }

    private static void addStats(String name, int color, ResourceLocation texture) {
        stats.add(new ItemStats(name, color, texture));
    }
}
